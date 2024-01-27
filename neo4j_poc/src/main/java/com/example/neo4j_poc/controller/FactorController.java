package com.example.neo4j_poc.controller;

import com.example.neo4j_poc.model.ComboFactor;
import com.example.neo4j_poc.model.IRFactor;
import com.example.neo4j_poc.services.FactorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/factors")
public class FactorController {
    private final FactorService factorService;

    public FactorController(FactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping("upstream/combo/{name}")
    public ResponseEntity<List<ComboFactor>> getComboFactorFromUpstream(@PathVariable String name) {
        List<ComboFactor> response = factorService.getComboFactorsBasedOnUpStreamData(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("curve/combo/{name}")
    public ResponseEntity<List<ComboFactor>> getComboFactorsFromCurveTable(@PathVariable String name) {
        List<ComboFactor> response = factorService.getComboFactorsBasedOnCurveTable(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("curve/combo/id/{id}")
    public ResponseEntity<List<ComboFactor>> getComboFactorsById(@PathVariable Long id) {
        List<ComboFactor> response = factorService.getComboFactorById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("curve/combo/all")
    public ResponseEntity<List<ComboFactor>> getAllComboFactors() {
        List<ComboFactor> response = factorService.getAllComboFactors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("upstream/ir/{name}")
    public ResponseEntity<List<IRFactor>> getIRFactorsFromUpstream(@PathVariable String name) {
        List<IRFactor> response = factorService.getIRFactorsBasedOnUpStreamData(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("curve/ir/{name}")
    public ResponseEntity<List<IRFactor>> getIRFactorsFromCurves(@PathVariable String name) {
        List<IRFactor> response = factorService.getIRFactorsBasedOnCurveTable(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("curve/ir/all")
    public ResponseEntity<List<IRFactor>> getAllIRFactors() {
        List<IRFactor> response = factorService.getAllIRFactors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
