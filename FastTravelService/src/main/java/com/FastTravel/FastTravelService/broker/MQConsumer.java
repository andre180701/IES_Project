package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.model.StateIdentifier;
import com.FastTravel.FastTravelService.controller.*;
import com.FastTravel.FastTravelService.modelMessages.MsgNewPassageAdmin;

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
    SimpMessagingTemplate template;

    @Autowired
    private ScutController scutController;

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
            
            MsgNewPassageAdmin message = new MsgNewPassageAdmin(method, identifier.getClient().getEmail(), identifier.getRegistration(), String.valueOf(jo.get("identifier")), ((String) jo.get("date")), ((String) jo.get("time")), String.valueOf(scut.getLongitude()), String.valueOf(scut.getLatitude()), scut.getDescription(), String.valueOf(passage.getPrice()), String.valueOf(passage.getPaymentState()));
            this.template.convertAndSend("/topic/messages", message);
        }
        if (method.equals("UPDATE_IDENTIFIER")) {
            Identifier existing_identifier = identifierController.findIdentifierById(Long.parseLong(String.valueOf(jo.get("id_identifier"))));
            String new_state = String.valueOf(jo.get("new_state"));
            System.out.println("OLHA AQUI BURRO DO CARALHO " + new_state);
            existing_identifier.setState(StateIdentifier.getEnum(new_state));
            identifierController.updateIdentifier(existing_identifier);
        }
        if (method.equals("UPDATE_PASSAGE")) {
            System.out.println("UPDATE_PASSAGE");
            /*
            System.out.println(String.valueOf(jo.get("id_passage")));
            System.out.println((Long.parseLong(String.valueOf(jo.get("id_passage")))));
            Passage passage = passageController.findPassageById(Long.parseLong(String.valueOf(jo.get("id_passage"))));
            System.out.println(passage);

            String new_state = String.valueOf(jo.get("new_state"));
            System.out.println(new_state);

            passage.setPaymentState(PaymentState.getEnum(new_state));
            System.out.println(passage);
            passageController.updatePassage(passage);*/
        }
    }

}