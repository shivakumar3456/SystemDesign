package com.example.keygenerationservice.Service;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KGSBean {

    @Bean
    public @NotNull KeyGenerationService getKGS(){
        return new KeyGenerationService();
    }
}
