package com.playops.components;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

record LiveEvent<T>(
        T data,
        String eventId,
        long ts
) {
}

@Component
public class LiveBroadcaster {
    private final SimpMessagingTemplate template;

    public LiveBroadcaster(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void broadcast(Object payload) {
        LiveEvent<Object> enriched = new LiveEvent<>(
                payload,
                UUID.randomUUID().toString(),
                System.currentTimeMillis()
        );
        template.convertAndSend("/topic/live", enriched);
    }
}
