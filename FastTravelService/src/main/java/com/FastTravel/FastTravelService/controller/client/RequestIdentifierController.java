package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;

import com.FastTravel.FastTravelService.inputsForms.InputRequestIdentifier;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.service.ClientService;
import com.FastTravel.FastTravelService.service.CreditCardService;
import com.FastTravel.FastTravelService.service.IdentifierService;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Controller
public class RequestIdentifierController {
  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @Autowired
  private IdentifierService  identifierService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private CreditCardService creditCardService;

  @ModelAttribute("inputRequestIdentifier")
  public InputRequestIdentifier getGreetingObject() {
    return new InputRequestIdentifier();
  }

  @GetMapping("client/requestIdentifier")
  public String getRequestIdentifier(Model model) {
    HttpSession session = httpSessionFactory.getObject();

    model.addAttribute("firstName", session.getAttribute("firstName"));
    model.addAttribute("lastName", session.getAttribute("lastName"));
    model.addAttribute("email", session.getAttribute("email"));
    return "client/requestIdentifier";
  }

  @PostMapping("/client/requestIdentifier/check")
    public String requestIdentifierSubmit(@ModelAttribute InputRequestIdentifier inputRequestIdentifier, Model model) {
      HttpSession session = httpSessionFactory.getObject();
      String email = (String) session.getAttribute("email");
      Client client = clientService.getClientByEmail(email);
      System.out.println(client);

      if(inputRequestIdentifier.getCardNumber() != null){
        System.out.println(inputRequestIdentifier.getCardNumber());
      }
      if(inputRequestIdentifier.getCardName() != null){
        System.out.println(inputRequestIdentifier.getCardName());
      }
      if (inputRequestIdentifier.getCardExpirationDate() != null){
        System.out.println(inputRequestIdentifier.getCardExpirationDate());
      }
      if(inputRequestIdentifier.getCardCountry() != null){
        System.out.println(inputRequestIdentifier.getCardCountry());
      }
      if (inputRequestIdentifier.getCardCvv() != null) {
        System.out.println(inputRequestIdentifier.getCardCvv());
      }

      //Preguica de validar os inputs, mas é necessario dps fazer,...
      //Faz sentido criar um cartao de credito quando alguem faz um pedido ou devia verificar se existe na base de dados???
      CreditCard creditCard = new CreditCard(Integer.parseInt(inputRequestIdentifier.getCardNumber()), inputRequestIdentifier.getCardName(),  Date.valueOf(inputRequestIdentifier.getCardExpirationDate()), inputRequestIdentifier.getCardCountry(), Integer.parseInt(inputRequestIdentifier.getCardCvv()));
      System.out.println(creditCard);
      Identifier identifier = new Identifier(inputRequestIdentifier.getRegistration(), Integer.parseInt(inputRequestIdentifier.getVehicleClass()), client, creditCard );
      System.out.println(identifier);

      creditCardService.saveCreditCard(creditCard);
      identifierService.saveIdentifier(identifier);
      System.out.println("Lista de identificadores na base de dados:");
      (identifierService.getIdentifiers()).forEach(System.out::println);

      model.addAttribute("msg", "Identifier requested successfully! You can already see it in the \"Vehicles and identifiers\" tab.");
      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));
      return "client/requestIdentifier";
    }
}