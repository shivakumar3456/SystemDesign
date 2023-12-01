package com.example.urlshortener;

import com.example.urlshortener.algorithm.IUrlShortener;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UrlShortenerController {

    @Autowired
    private @NotNull IUrlShortener shortener;

    @GetMapping("urlshorten")
    @NotNull
    public String convertToShortURL(@RequestParam("longUrl") @NotNull String longUrl){
        return shortener.convert(longUrl);
    }
}
