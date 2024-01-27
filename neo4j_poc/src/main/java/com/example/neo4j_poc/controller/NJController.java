package com.example.neo4j_poc.controller;

import com.example.neo4j_poc.model.Nitejob;
import com.example.neo4j_poc.services.FANitejobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nj")
public class NJController {
    private final FANitejobService faNitejobService;

    public NJController(FANitejobService faNitejobService) {
        this.faNitejobService = faNitejobService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Nitejob>> getDependentNitejobs(@PathVariable String name) {
        List<Nitejob> response = faNitejobService.getDependentNitejobs(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Nitejob>> getNiteJobById(@PathVariable Long id) {
        List<Nitejob> response = faNitejobService.getNiteJobById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Nitejob>> getAllNiteJobs() {
        List<Nitejob> response = faNitejobService.getAllNiteJobs();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
