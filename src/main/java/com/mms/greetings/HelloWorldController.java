package com.mms.greetings;

//import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @Value("${mms.greeting.message}")
    private String greetingMessage;

    @RequestMapping("/")
    @ResponseBody
    public String HelloWorld(){
        //byte[] decodedBytes = Base64.getDecoder().decode(greetingMessage);
        //String decodedGreeetingsMessage = new String(decodedBytes);
        return greetingMessage;
    }
}
