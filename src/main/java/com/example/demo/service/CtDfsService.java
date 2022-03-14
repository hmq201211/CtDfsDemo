package com.example.demo.service;

import com.example.demo.model.ConnectionInfo;
import com.example.demo.model.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CtDfsService {
    final ConnectionInfo connectionInfo;
    final RestTemplate restTemplate;

    public ResultVO checkFileExistence(String schema, String point, String path) {
        String url = "http://" + connectionInfo.getIp() + ":" + connectionInfo.getPort() + "/webctdfs/existence/";
        String requestUrl = url + schema + "/" + point +  ((path == null) ? "" : "/" + path);
        System.out.println(requestUrl);
        ResponseEntity<ResultVO> forEntity = restTemplate.getForEntity(requestUrl, ResultVO.class);
        return forEntity.getBody();
    }
}
