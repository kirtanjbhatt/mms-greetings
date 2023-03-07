package com.mms.greetings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @Value("${mms.greeting.message}")
    private String greetingMessage;

    @Value("${mms.greetings-message}")
    private String greetingMessageFromVolume;

    @RequestMapping("/greet")
    @ResponseBody
    public String HelloWorld(){        
        return greetingMessage + " -- " + greetingMessageFromVolume;
    }
}
