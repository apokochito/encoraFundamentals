package com.encora.controller;

import com.encora.model.Wine;
import com.encora.service.WineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WineController {

    private WineService service;

    public WineController(WineService service) {
        this.service = service;
    }

    @GetMapping(value = "/wines", produces = { "application/json" })
    public List<Wine> getWines() throws IOException {
        return service.retrieveWines();
    }

    @GetMapping(value = "/wines/{kind}", produces = { "application/json" })
    public ResponseEntity<List<Wine>> getWinesByKind(@PathVariable String kind) throws IOException {
        List<Wine> wines =service.retrieveWineByKind(kind);
        if (wines.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(wines);
    }

}
