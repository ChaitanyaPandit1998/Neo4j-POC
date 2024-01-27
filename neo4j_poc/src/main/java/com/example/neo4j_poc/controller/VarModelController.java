package com.example.neo4j_poc.controller;

import com.example.neo4j_poc.model.VarBlock;
import com.example.neo4j_poc.model.VarSchema;
import com.example.neo4j_poc.services.VarModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/var")
public class VarModelController {
    private final VarModelService varModelService;

    public VarModelController(VarModelService varModelService) {
        this.varModelService = varModelService;
    }

    @GetMapping("/vb/{name}")
    public ResponseEntity<List<VarBlock>> getVarBlocks(@PathVariable String name) {
        List<VarBlock> response = varModelService.getVarBlocks(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vb/id/{id}")
    public ResponseEntity<List<VarBlock>> getVarBlockById(@PathVariable Long id) {
        List<VarBlock> response = varModelService.getVarBlockById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vb/all")
    public ResponseEntity<List<VarBlock>> getAllVarBlocks() {
        List<VarBlock> response = varModelService.getAllVarBlocks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vs/{name}")
    public ResponseEntity<List<VarSchema>> getVarSchemas(@PathVariable String name) {
        List<VarSchema> response = varModelService.getVarSchemas(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vs/id/{id}")
    public ResponseEntity<List<VarSchema>> getVarSchemaById(@PathVariable Long id) {
        List<VarSchema> response = varModelService.getVarSchemaById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vs/all")
    public ResponseEntity<List<VarSchema>> getAllVarSchemas() {
        List<VarSchema> response = varModelService.getAllVarSchemas();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
