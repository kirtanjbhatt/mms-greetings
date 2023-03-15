package com.mms.greetings;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;

@Controller
public class HelloWorldController {

    @Value("${mms.greeting.message}")
    private String greetingMessage;

    @Value("${mms.greeting.message.location}")
    private String messagePath;

    @Value("${mms.repo.greeting.message}")
    private String messageFromRepo;

    @Value("${user.role}")
    private String role;


    @RequestMapping("/")
    @ResponseBody
    public String HelloWorld(){        
        return greetingMessage;
    }

    @RequestMapping("/greetfromrepo")
    @ResponseBody
    public String HelloWorldFromRepo(){        
        return messageFromRepo;
    }

    @GetMapping(value = "/whoami/{username}")
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s...\n", username, role);
    }

    @RequestMapping("/greet")
    @ResponseBody
    public String greet(){        
        try {
        // pass the path to the file as a parameter
        File file = new File(messagePath);
        try (Scanner sc = new Scanner(file)) {
            StringBuilder greetingMessage = new StringBuilder();
            while (sc.hasNextLine())
                greetingMessage.append(sc.nextLine());
                return greetingMessage.toString();
            }
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
}
