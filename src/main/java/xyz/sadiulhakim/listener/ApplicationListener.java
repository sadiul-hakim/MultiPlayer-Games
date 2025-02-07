package xyz.sadiulhakim.listener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListener {

    @EventListener
    void serverStarted(WebServerInitializedEvent event) {
        System.out.printf("Server is running on port : %s\n", event.getWebServer().getPort());
    }
}
