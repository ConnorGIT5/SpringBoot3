package com.connor.runnerz;

import org.springframework.stereotype.Component;

// the below annotation means that this class is available to spring
@Component
public class WelcomeMessage {

    public String getWelcomeMessage() {
        return "Welcome to my Spring Boot Application!";
    }

}
