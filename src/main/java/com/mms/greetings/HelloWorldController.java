package com.mms.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    
    @Autowired
    private Environment environment;

    private String greetingMessage = "Guten Tag. Wilkommen bei Infosys!!";

    private String propertyKey = "mms.greeting.message";

    @RequestMapping("/")
    @ResponseBody
    public String HelloWorld(){
        greetingMessage = environment.containsProperty(propertyKey) ? environment.getProperty(propertyKey) : "";
        return greetingMessage.isEmpty() ? "Guten Tag. Wilkommen bei Infosys!!" : greetingMessage;
    }
}
