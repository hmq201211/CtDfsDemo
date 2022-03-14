package com.example.demo.controller;

import com.example.demo.model.ResultVO;
import com.example.demo.service.CtDfsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    final CtDfsService ctDfsService;

    @GetMapping ("test")
    public ResultVO test() {
        return ctDfsService.checkFileExistence("ctdfs", "gcglxt", null);
    }
}