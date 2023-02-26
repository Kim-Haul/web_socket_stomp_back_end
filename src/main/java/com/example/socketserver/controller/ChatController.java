package com.example.socketserver.controller;

import com.example.socketserver.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달

    @MessageMapping("/chat")
    public void handleChatMessage(ChatMessageDto message) {
        this.template.convertAndSend("/topic/messages/" +  message.getRoomId(), message);
    }

    @MessageMapping("/enter")
    public void sendMessage(ChatMessageDto message) {
        this.template.convertAndSend("/topic/messages/" +  message.getRoomId(), message);
    }
}
