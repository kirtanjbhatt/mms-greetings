package com.mms.greetings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    
    private String greetingMessage = "Guten Tag. Wilkommen bei Infosys!!";

    @RequestMapping("/")
    @ResponseBody
    public String HelloWorld(){
        return greetingMessage.isEmpty() ? "Guten Tag. Wilkommen bei Infosys!!" : greetingMessage;
    }
}
