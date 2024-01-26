package com.example.neo4j_poc.services;


import com.example.neo4j_poc.model.VarBlock;
import com.example.neo4j_poc.model.VarSchema;
import com.example.neo4j_poc.repository.VarBlockRepository;
import com.example.neo4j_poc.repository.VarSchemaRepository;
import org.springframework.stereotype.Service;

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

    public List<VarSchema> getVarSchemas(String name) {
        return varSchemaRepository.findAllVarSchemas(name);
    }
}
