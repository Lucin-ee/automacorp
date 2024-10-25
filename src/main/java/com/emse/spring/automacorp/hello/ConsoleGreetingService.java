package com.emse.spring.automacorp.hello;

import org.springframework.stereotype.Service;

@Service
public class ConsoleGreetingService implements GreetingService {
    @Override
    public void greet(String m){

        System.out.println("Hello, " + m + "!");
    }
}
