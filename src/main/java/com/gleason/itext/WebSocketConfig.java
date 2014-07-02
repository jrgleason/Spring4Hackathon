package com.gleason.itext;

import com.gleason.itext.websocket.MyHandler;
import com.gleason.itext.websocket.SocksHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.WebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(myHandler(), "/myHandler");
//        registry.addHandler(socksHandler(), "/socksHandler");
    }

    @Bean
    public WebSocketHandler socksHandler() {
        return new SocksHandler();
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

}