package com.mms.greetings;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloWorldController {

    @Value("${mms.greeting.message}")
    private String greetingMessage;

    @Value("${mms.greeting.message.location}")
    private String messagePath;

    @RequestMapping("/")
    @ResponseBody
    public String HelloWorld(){        
        return greetingMessage;
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
