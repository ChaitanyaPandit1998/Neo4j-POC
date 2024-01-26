package com.example.neo4j_poc.repository;


import com.example.neo4j_poc.model.Nitejob;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface FANiteJobRepository extends Neo4jRepository<Nitejob, Long> {
    @Query("MATCH (:FANitejob {name: $name})-[:DEPENDS_ON]->(nitejobs:Nitejob) RETURN nitejobs")
    List<Nitejob> findAllDependentNiteJobsByFANitejob(String name);
}
