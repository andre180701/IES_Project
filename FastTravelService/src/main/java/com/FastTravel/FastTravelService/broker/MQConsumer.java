package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.controller.*;

import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;  
import java.sql.Date;
import java.sql.Time;

public class MQConsumer {
    @Autowired
    private PassageController passageController;

    @Autowired
    private IdentifierController identifierController;

    @Autowired
    private ScutController scutController;

    @Autowired
    private ClientController clientController;

    @Autowired
    private CreditCardController creditCardController;

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
            Identifier identifier = identifierController.findIdentifierById(id_long);
            Long scut_long = Long.parseLong(String.valueOf(jo.get("scut")));
            Scut scut = scutController.findScutById(scut_long);
            Passage passage = new Passage(date, time, identifier, scut);
            passageController.addPassage(passage);

        }
        if (method.equals("NEW_IDENTIFIER")) {
            System.out.println("OLAAAA ENTREI NO CONSUMER SOU O IDENTIFIER");
            String registration = (String) jo.get("registration");
            Integer classe = (int) (long) (Long.parseLong(String.valueOf(jo.get("classe"))));
            Long id_client = Long.parseLong(String.valueOf(jo.get("client")));
            Long id_cerdit_card = Long.parseLong(String.valueOf(jo.get("credit_card")));
            Client client = clientController.findClientById(id_client);
            CreditCard credit_card = creditCardController.findCreditCardById(id_cerdit_card);
            Identifier identifier = new Identifier(registration, classe, client, credit_card);
            System.out.println("IDENTIFIER CARALHO" + identifier);
            identifierController.addIdentifier(identifier);

        }
    }

}