package org.andi.dani.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Configuration
public class ScsConfig {
    @Bean
    public EmitterProcessor<Message<?>> scsProcesssor() {
        return EmitterProcessor.create();
    }
    @Bean
    public Supplier<Flux<Message<?>>> send() {
        return () -> scsProcesssor();
    }
}
