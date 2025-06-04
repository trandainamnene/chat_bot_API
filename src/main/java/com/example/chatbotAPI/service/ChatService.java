package com.example.chatbotAPI.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.awt.*;

@Service
public class ChatService {
    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);
    private final WebClient webClient;

    public ChatService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<String> callFastApiStream(Long idChat, String question , String base64Url, String imageType) {
        Image image = (base64Url != null && imageType != null) ? new Image(base64Url, imageType) : null;
        logger.info("Gửi request tới FastAPI: idChat={}, question={}, image={}",
                idChat, question, image != null ? "Có hình ảnh" : "Không có hình ảnh");
        var requestBody = new QuestionRequest(question , image);

        return webClient.post()
                .uri("/generative_ai/{idChat}", idChat)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToFlux(String.class)
                .doOnNext(chunk -> logger.info("Nhận chunk: {}", chunk.substring(0, Math.min(chunk.length(), 50))))
                .doOnError(e -> logger.error("Lỗi khi gọi FastAPI: {}", e.getMessage()))
                .onErrorResume(e -> Flux.just("Lỗi: " + e.getMessage()));
    }
    public record QuestionRequest(
            @JsonProperty("question") String question,
            @JsonProperty("image") Image image
    ) {}
    public record Image(
            @JsonProperty("url") String url,
            @JsonProperty("type") String type
    ) {}
}


