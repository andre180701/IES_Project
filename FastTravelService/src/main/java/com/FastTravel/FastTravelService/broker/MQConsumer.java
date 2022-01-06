package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.service.IdentifierService;
import com.FastTravel.FastTravelService.service.PassageService;
import com.FastTravel.FastTravelService.service.ScutService;

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

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(String input) {
        Object obj=JSONValue.parse(input);  
        JSONObject jo = (JSONObject) obj; 
        
        String method = (String) jo.get("method");  

        if (method.equals("NEW_PASSAGE")) {
            System.out.println("OLAAAA ENTREI NO CONSUMER");
            Date date = Date.valueOf((String) jo.get("date")); 
            Time time = Time.valueOf((String) jo.get("time"));
            Identifier identifier = identifierService.getIdentifierById(Long.parseLong((String) jo.get("identifier")));
            Scut scut = scutService.getScutById(Long.parseLong((String) jo.get("scut")));
            Passage passage = new Passage(date, time, identifier, scut);
            System.out.println("PASSAGE CRIADA: " + passage);
            passageService.savePassage(passage);

        }
    }

}