package com.example.urlshortener.algorithm;

import org.jetbrains.annotations.NotNull;

public interface IUrlShortener {
    @NotNull String convert(String longUrl);
}
