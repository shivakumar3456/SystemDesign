package com.example.pastebin.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/")
public class PasteBinController {

    @Value("${KGSUrl}")
    private @NotNull String kgsURL;

    @Value("${pastebin-html-path}")
    private @NotNull String pasteBinHTMLPath;

    @NotNull
    @GetMapping("")
    public ResponseEntity getPaste(@PathVariable @NotNull String pasteId){

        return ResponseEntity.status(200).build();
    }

    @GetMapping("/pastebin")
    public @NotNull String getPasteBinHTMLPage() throws IOException {
        return Files.readString(Path.of(pasteBinHTMLPath));
    }

    @PostMapping("createtext")
    public @NotNull ResponseEntity<String> createPaste(@RequestBody @NotNull PastePOJO pastePOJO){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(kgsURL, String.class);
        if (response.getStatusCode().value() == 200 && response.getBody() != null){
            pastePOJO.setPasteURL(response.getBody());
            addRecordInDataBase(pastePOJO);
            return ResponseEntity.created(URI.create(response.getBody())).build();
        }else {
            return ResponseEntity.created(URI.create("")).build();
        }
    }

    private void addRecordInDataBase(@NotNull PastePOJO pastePOJO) {
        System.out.println(pastePOJO);
    }

}
