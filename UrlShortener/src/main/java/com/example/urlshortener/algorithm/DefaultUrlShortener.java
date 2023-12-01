package com.example.urlshortener.algorithm;

import org.jetbrains.annotations.NotNull;


public class DefaultUrlShortener implements IUrlShortener{
    @Override
    public @NotNull String convert(@NotNull String longUrl) {
        return longUrl;
    }
}
