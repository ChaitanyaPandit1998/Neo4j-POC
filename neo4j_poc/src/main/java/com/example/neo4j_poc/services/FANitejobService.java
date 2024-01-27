package com.example.neo4j_poc.services;

import com.example.neo4j_poc.model.Nitejob;
import com.example.neo4j_poc.repository.FANiteJobRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FANitejobService {
    private final FANiteJobRepository faNiteJobRepository;

    public FANitejobService(FANiteJobRepository faNiteJobRepository) {
        this.faNiteJobRepository = faNiteJobRepository;
    }

    public List<Nitejob> getDependentNitejobs(String name) {
        return faNiteJobRepository.findAllDependentNiteJobsByFANitejob(name);
    }

    public List<Nitejob> getNiteJobById(Long id) {
        return faNiteJobRepository.findAllById(Collections.singletonList(id));
    }

    public List<Nitejob> getAllNiteJobs() {
        return faNiteJobRepository.findAll();
    }
}
