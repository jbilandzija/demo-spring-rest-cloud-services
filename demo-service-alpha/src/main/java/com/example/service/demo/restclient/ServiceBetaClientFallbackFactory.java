package com.example.service.demo.restclient;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceBetaClientFallbackFactory implements FallbackFactory<ServiceBetaClient> {

    @Override
    public ServiceBetaClient create(Throwable throwable) {
        return new ServiceBetaClientFallback(throwable);
    }
}
