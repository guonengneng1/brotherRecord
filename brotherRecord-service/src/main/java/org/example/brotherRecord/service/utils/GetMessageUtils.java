package org.example.brotherRecord.service.utils;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import darabonba.core.client.ClientOverrideConfiguration;
import org.example.brotherRecord.service.constant.BrotherRecordConstant;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class GetMessageUtils {
    public static String getShortMessage(String phoneNumber) throws ExecutionException, InterruptedException {
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(BrotherRecordConstant.ACCESS_KEY_ID)
                .accessKeySecret(BrotherRecordConstant.ACCESS_KEY_SECRET).build());

        // Configure the Client
        AsyncClient client = AsyncClient.builder()
                .region("undefined") // Region ID
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers(phoneNumber)
                .signName("郭一洋个人博客")
                .build();


        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);

        SendSmsResponse resp = response.get();

        client.close();

        return new Gson().toJson(resp);
    }
}
