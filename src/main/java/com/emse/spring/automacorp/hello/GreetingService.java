package com.emse.spring.automacorp.hello;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {

    void greet(String name);
}
