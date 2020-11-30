package com.weldnor.spms.security.oauth;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VkAuthService {
    private final Logger logger = LoggerFactory.getLogger(VkAuthService.class);
    private final RestTemplate restTemplate;
    @Value("${vk.app-id}")
    private Integer APP_ID;
    @Value("${vk.client-secret}")
    private String CLIENT_SECRET;
    @Value("${vk.redirect-uri}")
    private String REDIRECT_URI;


    public VkAuthService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getEmail(String code) throws Exception {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                .unsafeParam("scope", "email")
                .execute();

        return authResponse.getEmail();
    }
}
