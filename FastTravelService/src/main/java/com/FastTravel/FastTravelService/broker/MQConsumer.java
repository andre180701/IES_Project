package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.service.IdentifierService;
import com.FastTravel.FastTravelService.service.PassageService;
import com.FastTravel.FastTravelService.service.ScutService;
import com.FastTravel.FastTravelService.service.ClientService;
import com.FastTravel.FastTravelService.service.CreditCardService;

import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;  
import java.sql.Date;
import java.sql.Time;

public class MQConsumer {
    @Autowired
    private PassageService passageService;

    @Autowired
    private IdentifierService identifierService;

    @Autowired
    private ScutService scutService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CreditCardService creditCardService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(String input) {
        Object obj=JSONValue.parse(input);  
        JSONObject jo = (JSONObject) obj; 
        
        String method = (String) jo.get("method");  

        if (method.equals("NEW_PASSAGE")) {
            System.out.println("OLAAAA ENTREI NO CONSUMER");
            Date date = Date.valueOf((String) jo.get("date")); 
            Time time = Time.valueOf((String) jo.get("time"));
            Long id_long = Long.parseLong(String.valueOf(jo.get("identifier")));
            Identifier identifier = identifierService.getIdentifierById(id_long);
            Long scut_long = Long.parseLong(String.valueOf(jo.get("scut")));
            Scut scut = scutService.getScutById(scut_long);
            Passage passage = new Passage(date, time, identifier, scut);
            passageService.savePassage(passage);

        }
        if (method.equals("NEW_IDENTIFIER")) {
            System.out.println("OLAAAA ENTREI NO CONSUMER SOU O IDENTIFIER");
            String registration = (String) jo.get("registration");
            System.out.println("MATRÍCULA CARALHO");
            Integer classe = (int) (long) (Long.parseLong(String.valueOf(jo.get("classe"))));
            System.out.println("CLASSE CARALHO");
            Long id_client = Long.parseLong(String.valueOf(jo.get("client")));
            System.out.println("ID_CLIENT CARALHO");
            Long id_cerdit_card = Long.parseLong(String.valueOf(jo.get("credit_card")));
            System.out.println("CREDITCARDID CARALHO");
            Client client = clientService.getClientById(id_client);
            CreditCard credit_card = creditCardService.getCreditCardById(id_cerdit_card);
            Identifier identifier = new Identifier(registration, classe, client, credit_card);
            System.out.println("IDENTIFIER CARALHO" + identifier);
            identifierService.saveIdentifier(identifier);

        }
    }

}