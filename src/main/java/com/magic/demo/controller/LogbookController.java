package com.magic.demo.controller;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("logbook")
public class LogbookController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("test_get/{p1}")
    public String testGet(@PathVariable Integer p1){
        return String.valueOf(p1);
    }

    @SneakyThrows
    @PostMapping("test_post")
    public String testPost(@RequestBody Map<String,Object> p2){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://127.0.0.1:8080/logbook/test_get/2", String.class);
        String body = forEntity.getBody();
        log.info(body);
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(p2);
    }


}
