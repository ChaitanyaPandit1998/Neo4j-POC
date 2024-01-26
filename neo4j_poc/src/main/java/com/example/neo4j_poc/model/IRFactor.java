package com.example.neo4j_poc.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class IRFactor {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    public IRFactor(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
