package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;  
 
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.FastTravel.FastTravelService.controller.admin.PassageController;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.repository.PassageRepository;

public class MQConsumer {
    @Autowired
    private PassageRepository passageRepository;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(String input) {
        Map<String, String> methodMap = new HashMap<String, String>();
        Map<String, Long> scutMap = new HashMap<String, Long>();
        Map<String, Long> client_deviceIdMap = new HashMap<String, Long>();

        Object obj=JSONValue.parse(input);  
        JSONObject jo = (JSONObject) obj; 
        
        String method = (String) jo.get("method");  
        //methodMap.put("method: ", method);

  //      PassageController pc = new PassageController();
        if (method.equals("NEW_PASSAGE")) {
            //Passage p = new Passage((String) jo.get("registration"), (String) jo.get("date"), (String) jo.get("time"), Integer.parseInt((String) jo.get("client_deviceId") ),  Integer.parseInt((String) jo.get("scut") ) );
            //Passage p = new Passage((String) jo.get("registration"), (String) jo.get("date"), (String) jo.get("time"), (Long) jo.get("client_deviceId"), (Long) jo.get("scut"));
            //Passage p = new Passage("QQ", "12-12", "9:00", 1, 1);
            //passageRepository.save(p);
            //System.out.println("-----------------------");
            //System.out.println( p.getRegistration());
            //System.out.println( p.getDate());
            //System.out.println( p.getTime());
            //System.out.println( p.getDeviceId());
            //System.out.println( p.getIdScut());
            //System.out.println("-----------------------");
//            pc.createPassage(new Passage((String) jo.get("registration"), (String) jo.get("date"), (String) jo.get("time"), Integer.parseInt((String) jo.get("client_deviceId") ),  Integer.parseInt((String) jo.get("scut") ) ));
        }


        //long client_deviceId = (long) jo.get("client_deviceId");  
        //client_deviceIdMap.put("client_deviceI: ", client_deviceId);


        //long scut = (Long) jo.get("scut"); 
        //scutMap.put("scut: ", scut);
 

        

    }

}