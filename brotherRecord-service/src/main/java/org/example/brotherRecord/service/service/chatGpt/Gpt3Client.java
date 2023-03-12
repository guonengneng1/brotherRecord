package org.example.brotherRecord.service.service.chatGpt;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Gpt3Client {
    private static final String API_URL = "https://api.openai.com/v1/";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final String apiKey;
    private final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
    private final Gson gson = new Gson();

    public Gpt3Client(String apiKey) {
        this.apiKey = apiKey;
    }

    public String generateText(String prompt) throws IOException {
        RequestBody requestBody = RequestBody.create(JSON, gson.toJson(Collections.singletonMap("prompt", prompt)));
        Request request = new Request.Builder()
                .url(API_URL + "completions")
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }

            String responseBody = response.body().string();
            CompletionResponse completionResponse = gson.fromJson(responseBody, CompletionResponse.class);
            return completionResponse.getChoices().get(0).getText();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class CompletionResponse {
        private String id;
        private long created;
        private String model;
        private List<Choice> choices;

        private  class Choice {
            private String text;
            private float score;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public float getScore() {
                return score;
            }

            public void setScore(float score) {
                this.score = score;
            }
        }
    }
}
