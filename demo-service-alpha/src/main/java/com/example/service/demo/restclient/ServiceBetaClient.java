package com.example.service.demo.restclient;

import com.example.service.demo.model.UserBetaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// If Config Server is not running, use name from Eureka Dashboard, i.e. demo-service-beta
@FeignClient(name = "microservice-beta", fallbackFactory = ServiceBetaClientFallbackFactory.class)
public interface ServiceBetaClient {

    @GetMapping("/v1/student")
    List<UserBetaDto> getAllStudentsFromServiceBeta();

}
