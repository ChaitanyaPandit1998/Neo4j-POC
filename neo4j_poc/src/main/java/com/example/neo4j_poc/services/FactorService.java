package com.example.neo4j_poc.services;

import com.example.neo4j_poc.model.ComboFactor;
import com.example.neo4j_poc.model.IRFactor;
import com.example.neo4j_poc.repository.ComboFactorRepository;
import com.example.neo4j_poc.repository.IRFactorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactorService {
    private final ComboFactorRepository comboFactorRepository;
    private final IRFactorRepository irFactorRepository;

    public FactorService(ComboFactorRepository comboFactorRepository,
                         IRFactorRepository irFactorRepository)
    {
        this.comboFactorRepository = comboFactorRepository;
        this.irFactorRepository = irFactorRepository;
    }

    public List<ComboFactor> getComboFactorsBasedOnUpStreamData(String name) {
        return comboFactorRepository.findAllComboFactorsFromUpstream(name);
    }

    public List<ComboFactor> getComboFactorsBasedOnCurveTable(String name) {
        return comboFactorRepository.findAllComboFactorsFromCurveTable(name);
    }

    public List<IRFactor> getIRFactorsBasedOnUpStreamData(String name) {
        return irFactorRepository.findAllIRFactorsFromUpstream(name);
    }

    public List<IRFactor> getIRFactorsBasedOnCurveTable(String name) {
        return irFactorRepository.findAllIRFactorsFromCurveTable(name);
    }
}
