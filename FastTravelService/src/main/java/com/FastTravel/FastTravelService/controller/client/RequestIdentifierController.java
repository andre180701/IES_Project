package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.FastTravel.FastTravelService.controller.CreditCardController;
import com.FastTravel.FastTravelService.controller.IdentifierController;
import com.FastTravel.FastTravelService.inputsForms.InputRequestIdentifier;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Controller
public class RequestIdentifierController {
  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @Autowired
  private ClientService clientService;

  @Autowired
  private IdentifierController identifierController;

  @Autowired
  private CreditCardController creditCardController;

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
    public String requestIdentifierSubmit(@Valid @ModelAttribute InputRequestIdentifier inputRequestIdentifier,BindingResult result, Model model) {
      HttpSession session = httpSessionFactory.getObject();
      String email = (String) session.getAttribute("email");
      Client client = clientService.getClientByEmail(email);

      if (result.hasErrors()) {
        return "client/requestIdentifier";
      }  

      //Preguica de validar os inputs, mas é necessario dps fazer,...
      //Faz sentido criar um cartao de credito quando alguem faz um pedido ou devia verificar se existe na base de dados???
      CreditCard creditCard = new CreditCard(Integer.parseInt(inputRequestIdentifier.getCardNumber()), inputRequestIdentifier.getCardName(),  Date.valueOf(inputRequestIdentifier.getCardExpirationDate()), inputRequestIdentifier.getCardCountry(), Integer.parseInt(inputRequestIdentifier.getCardCvv()));
      Identifier identifier = new Identifier(inputRequestIdentifier.getRegistration(), Integer.parseInt(inputRequestIdentifier.getVehicleClass()), client, creditCard );

      //creditCardService.saveCreditCard(creditCard);   assim n é RESTFUL
      creditCardController.addCreditCard(creditCard);
      //identifierService.saveIdentifier(identifier);   assim n é RESTFUL
      identifierController.addIdentifier(identifier);

      model.addAttribute("msg", "Identifier requested successfully! You can already see it in the \"Vehicles and identifiers\" tab.");
      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));
      return "client/requestIdentifier";
    }
}
