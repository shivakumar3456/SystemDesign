package com.example.pastebin.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class PasteBinController {

    @NotNull
    @GetMapping("")
    public ResponseEntity getPaste(@PathVariable @NotNull String pasteId){

        return ResponseEntity.status(200).build();
    }

    @PostMapping("createPaste")
    public @NotNull ResponseEntity createPaste(@RequestBody @NotNull PastePOJO pastePOJO){

        return ResponseEntity.created(URI.create("")).build();
    }

}
