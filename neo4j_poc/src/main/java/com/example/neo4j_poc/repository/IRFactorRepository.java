package com.example.neo4j_poc.repository;

import com.example.neo4j_poc.model.IRFactor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface IRFactorRepository extends Neo4jRepository<IRFactor, Long> {

    @Query("""
            MATCH (:UpstreamData {name: $name})-[r:DATA_USED_IN]->(table:CurveTable)
            MATCH((table)-[:DATA_USED_IN]->(factor:IRFactor))
            RETURN factor""")
    List<IRFactor> findAllIRFactorsFromUpstream(String name);

    @Query("""
            MATCH (:CurveTable {name: $name})-[r:DATA_USED_IN]->(factor:IRFactor)
            RETURN factor""")
    List<IRFactor> findAllIRFactorsFromCurveTable(String name);
}
