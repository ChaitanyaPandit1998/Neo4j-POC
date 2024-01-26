package com.example.neo4j_poc.repository;

import com.example.neo4j_poc.model.VarBlock;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface VarBlockRepository extends Neo4jRepository<VarBlock, Long> {
    @Query("MATCH (:VarSource {name: $name})-[:BELONGS_TO]->(block:VarBlock) RETURN block")
    List<VarBlock> findAllVarBlocks(String name);

}
