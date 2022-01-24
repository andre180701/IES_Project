package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.model.StateIdentifier;
import com.FastTravel.FastTravelService.service.IdentifierService;
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
    private IdentifierService identifierService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(String input) {
        Object obj=JSONValue.parse(input);  
        JSONObject jo = (JSONObject) obj; 
        
        String method = (String) jo.get("method");  

        if (method.equals("NEW_PASSAGE")) {
            Date date = Date.valueOf((String) jo.get("date")); 
            Time time = Time.valueOf((String) jo.get("time"));
            Long id_long = Long.parseLong(String.valueOf(jo.get("identifier")));
            Identifier identifier = identifierController.findIdentifierById(id_long);
            Long scut_long = Long.parseLong(String.valueOf(jo.get("scut")));
            Scut scut = scutController.findScutById(scut_long);
            Passage passage = new Passage(date, time, identifier, scut);
            passageController.addPassage(passage);

        }
        if (method.equals("UPDATE_IDENTIFIER")) {
            System.out.println("WHERE HAVE YOU BEEN LOCA");
            Identifier existing_identifier = identifierService.getIdentifierById(Long.parseLong(String.valueOf(jo.get("id_identifier"))));
            String new_state = String.valueOf(jo.get("new_state"));
            System.out.println("OLHA AQUI BURRO DO CARALHO " + new_state);
            existing_identifier.setState(StateIdentifier.valueOf(new_state));
            identifierService.updateIdentifier(existing_identifier);
        }
    }

}