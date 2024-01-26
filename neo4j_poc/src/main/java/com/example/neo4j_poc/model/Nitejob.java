package com.example.neo4j_poc.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Nitejob {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String status;

    private String date;

    public Nitejob(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
