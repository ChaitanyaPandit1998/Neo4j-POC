package com.example.neo4j_poc.services;


import com.example.neo4j_poc.model.VarBlock;
import com.example.neo4j_poc.model.VarSchema;
import com.example.neo4j_poc.repository.VarBlockRepository;
import com.example.neo4j_poc.repository.VarSchemaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VarModelService {
    private final VarBlockRepository varBlockRepository;
    private final VarSchemaRepository varSchemaRepository;

    public VarModelService(VarBlockRepository varBlockRepository, VarSchemaRepository varSchemaRepository)
    {
        this.varBlockRepository = varBlockRepository;
        this.varSchemaRepository = varSchemaRepository;
    }

    public List<VarBlock> getVarBlocks(String name) {
        return varBlockRepository.findAllVarBlocks(name);
    }

    public List<VarBlock> getVarBlockById(Long id) {
        return varBlockRepository.findAllById(Collections.singletonList(id));
    }

    public List<VarBlock> getAllVarBlocks() {
        return varBlockRepository.findAll();
    }

    public List<VarSchema> getVarSchemas(String name) {
        return varSchemaRepository.findAllVarSchemas(name);
    }

    public List<VarSchema> getVarSchemaById(Long id) {
        return varSchemaRepository.findAllById(Collections.singletonList(id));
    }

    public List<VarSchema> getAllVarSchemas() {
        return varSchemaRepository.findAll();
    }
}
