package org.example.brotherRecord.service.service;


import org.example.brotherRecord.common.BrotherRecordResponse;
import org.example.brotherRecord.api.controller.ChatGptController;
import org.example.brotherRecord.api.vo.ChatGPTVO;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.RequestBody;

@Service
public class chatGPTService implements ChatGptController {

    @Override
    public BrotherRecordResponse chatGPTGetModel(){
        BrotherRecordResponse responseResult = new BrotherRecordResponse();
        StringBuffer response =new StringBuffer();

        try {
        int responseCode=0;

            String apiKey = "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";
            URL url = new URL("https://api.openai.com/v1/models");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            responseCode = connection.getResponseCode();

        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
         response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        }catch (Exception e){
            responseResult.setCode(0);
            responseResult.setMsg("成功");
            responseResult.setData(e.getMessage());
            return responseResult;
        }
        responseResult.setCode(0);
        responseResult.setMsg("成功");
        responseResult.setData(response);
        return responseResult;
    }

    private static final String OPENAI_API_KEY = "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";
    private static final String OPENAI_COMPLETIONS_ENDPOINT = "https://api.openai.com/v1/chat/completions";
    @Override
    public  BrotherRecordResponse chatGPT(@RequestBody ChatGPTVO request) {
        BrotherRecordResponse brotherRecordResponse =new BrotherRecordResponse();
        String response="初始化";
        try {

            URL url = new URL(OPENAI_COMPLETIONS_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + OPENAI_API_KEY);

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {

                StringBuilder responseBuilder = new StringBuilder();
                String responseLine;

                while ((responseLine = reader.readLine()) != null) {
                    responseBuilder.append(responseLine.trim());
                }

                 response = responseBuilder.toString();
                System.out.println(response);
            }
            brotherRecordResponse.setCode(0);
            brotherRecordResponse.setMsg("成功");
            brotherRecordResponse.setData(response);
        }catch (Exception e){
            brotherRecordResponse.setCode(1);
            brotherRecordResponse.setMsg("失败");
            brotherRecordResponse.setData(e);
        }
        return brotherRecordResponse;
    }



}
