package com.example.demo.interceptor;

import com.example.demo.model.TokenInfo;
import com.example.demo.util.AuthInfoGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthInfoInterceptor implements ClientHttpRequestInterceptor {
    final TokenInfo tokenInfo;
    final AuthInfoGenerator authInfoGenerator;


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(tokenInfo.getUsername(), authInfoGenerator.getAuthUsername());
        headers.add(tokenInfo.getTimestamp(), authInfoGenerator.getAuthTimestamp());
        headers.add(tokenInfo.getToken(), authInfoGenerator.getAuthMd5());
        return execution.execute(request, body);
    }
}
