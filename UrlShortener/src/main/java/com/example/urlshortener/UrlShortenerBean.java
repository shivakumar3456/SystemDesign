package com.example.urlshortener;

import com.example.urlshortener.algorithm.DefaultUrlShortener;
import com.example.urlshortener.algorithm.IUrlShortener;
import com.example.urlshortener.algorithm.TokenUrlShortener;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlShortenerBean {

    @Value("${url-shortener.algorithm}")
    private @NotNull String urlShortenerAlgorithm;


    @Bean
    @NotNull
    public IUrlShortener getUrlShortener(){
        if (urlShortenerAlgorithm.equalsIgnoreCase("token-service")){
            return new TokenUrlShortener();
        }else{
            return new DefaultUrlShortener();
        }
    }
}
