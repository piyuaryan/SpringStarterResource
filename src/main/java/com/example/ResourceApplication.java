package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class ResourceApplication {

    /**
     * CORS Negotiation
     * The browser tries to negotiate with our resource server to find out if it is allowed to access it according to the Cross Origin Resource Sharing protocol.
     * It’s not an Angular JS responsibility, so just like the cookie contract it will work like this with all JavaScript in the browser.
     * The two servers do not declare that they have a common origin, so the browser declines to send the request and the UI is broken.
     * <p/>
     * To fix that we need to support the CORS protocol which involves a "pre-flight" OPTIONS request and some headers to list the allowed behaviour of the caller.
     * Spring 4.2 has some nice fine-grained CORS support, so we can just add an annotation to our controller mapping
     *
     * @return
     */
    @RequestMapping("/")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public Message home() {
        return new Message("Hello World");
    }


    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}

class Message {
    private String id = UUID.randomUUID().toString();
    private String content;

    Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
