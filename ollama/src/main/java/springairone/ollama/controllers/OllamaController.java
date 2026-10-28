package springairone.ollama.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OllamaController {

    private ChatClient chatClient;

    public OllamaController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> OllamaChat(
            @RequestParam(value = "q", required = true) String query
    ){
        String chatContent = this.chatClient.prompt(query).call().content();

        return ResponseEntity.ok(chatContent);
    }

}
