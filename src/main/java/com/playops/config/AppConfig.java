package com.playops.config;

import com.playops.repository.GameParamsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean public GameParamsRepository gameParamsRepository() { return new GameParamsRepository(); }
}