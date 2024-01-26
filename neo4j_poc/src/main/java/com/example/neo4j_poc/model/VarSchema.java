package com.example.neo4j_poc.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class VarSchema {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    public VarSchema(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
