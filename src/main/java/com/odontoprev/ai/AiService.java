package com.odontoprev.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String suggestHorario(String contexto) {
        // usa prompt().user() em vez de ChatMessage.ofUser()
        return chatClient
                .prompt()
                .user(contexto)
                .call()
                .content();
    }
}
