package com.example.neo4j_poc.repository;

import com.example.neo4j_poc.model.ComboFactor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface ComboFactorRepository extends Neo4jRepository<ComboFactor, Long> {
    @Query("""
            MATCH (:UpstreamData {name: $name})-[r:DATA_USED_IN]->(table:CurveTable)
            MATCH((table)-[:DATA_USED_IN]->(factor:IRFactor))
            MATCH((factor)-[:FACTOR_USED_IN]->(combo:ComboFactor))
            RETURN combo""")
    List<ComboFactor> findAllComboFactorsFromUpstream(String name);

    @Query("""
            MATCH (:CurveTable {name: $name})-[r:DATA_USED_IN]->(factor:IRFactor)
            MATCH((factor)-[:FACTOR_USED_IN]->(combo:ComboFactor))
            RETURN combo""")
    List<ComboFactor> findAllComboFactorsFromCurveTable(String name);
}
