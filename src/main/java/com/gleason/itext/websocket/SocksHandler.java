package com.gleason.itext.websocket;

import com.gleason.itext.model.HelloMessage;
import com.google.gson.Gson;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created with IntelliJ IDEA.
 * User: jgleason
 * Date: 6/30/14
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocksHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("Testing Socks "+message.getPayload());
        Gson gson = new Gson();
        HelloMessage helloMessage = gson.fromJson(message.getPayload(), HelloMessage.class);
        System.out.println(helloMessage.getName());
    }

}
