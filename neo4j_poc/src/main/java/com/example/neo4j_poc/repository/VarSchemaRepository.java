package com.example.neo4j_poc.repository;


import com.example.neo4j_poc.model.VarSchema;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface VarSchemaRepository extends Neo4jRepository<VarSchema, Long> {

    @Query("""
            MATCH (:VarSource {name: $name})-[r:BELONGS_TO]->(block:VarBlock)
            MATCH((block)-[:BELONGS_TO]->(schema:VarSchema))
            RETURN DISTINCT schema""")
    List<VarSchema> findAllVarSchemas(String name);
}
