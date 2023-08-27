package org.andi.dani.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class ScsConfig {
    @Bean
    public Function<Flux<?>, Mono<Void>> receiverData() {
        return flux -> flux.log().then();
    }
}