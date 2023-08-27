package org.andi.dani.controllers;

import lombok.AllArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.EmitterProcessor;

@RequestMapping("/send")
@AllArgsConstructor
@RestController
public class Producer {

    private final EmitterProcessor<Message<?>> scsProcesssor;

    @PostMapping
    public void sendTomiddleware(@RequestBody String data) {
        var msg = MessageBuilder.withPayload(data)
                .setHeader("partitionKey", data.length())
                .build();

        scsProcesssor.onNext(msg);
    }
}
