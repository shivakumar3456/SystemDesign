package com.example.keygenerationservice.Controller;

import com.example.keygenerationservice.Service.KeyGenerationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/KGS")
public class KGSController {

    @Autowired
    @NotNull
    KeyGenerationService kgs;

    @GetMapping("/id")
    public @NotNull ResponseEntity<String> createUniqueKey(){
        String uniqueKey = kgs.getUniqueKey();
        return ResponseEntity.ok().body(uniqueKey);
    }
}
