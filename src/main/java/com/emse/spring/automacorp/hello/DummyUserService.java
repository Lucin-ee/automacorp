package com.emse.spring.automacorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marking this as a Spring service
public class DummyUserService implements UserService {

    private final ConsoleGreetingService consoleGreetingService;

    // Constructor-based dependency injection for GreetingService
    public DummyUserService(ConsoleGreetingService consoleGreetingService) {
        this.consoleGreetingService = consoleGreetingService;
    }

    @Override
    public void greetAll(List<String> name) {
        // Call the greet method of GreetingService for each name
        for (String s : name) {
            consoleGreetingService.greet(s);
        }
    }
}

