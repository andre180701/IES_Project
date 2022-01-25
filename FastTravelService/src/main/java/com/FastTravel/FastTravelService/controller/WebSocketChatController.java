
package com.FastTravel.FastTravelService.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.FastTravel.FastTravelService.modelMessages.Message;
import com.FastTravel.FastTravelService.modelMessages.OutputMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getMethod(), message.getIdentifier(), message.getScut(), message.getDate(), message.getTime(), time);
    }
}   