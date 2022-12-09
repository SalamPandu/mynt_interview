package com.mynt.mynttest.service;

import com.mynt.mynttest.entity.Rule;
import com.mynt.mynttest.repository.RuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
@Slf4j
public class RuleService{

    private final RuleRepository repo;

    @Autowired
    public RuleService(RuleRepository repo) {
        this.repo = repo;
    }


    public Rule create(Rule rule) {
        return repo.save(rule);
    }


    public List<Rule> retrieveAll() {
        return stream(repo.findAll().spliterator(), false).collect(toList());
    }

    public List<Rule> retrieveAll(Pageable paging) {
        return stream(repo.findAll(paging)
                .spliterator(), false)
                .collect(toList());
    }


    public Optional<Rule> retrieve(long id) {
        return repo.findById(id);
    }
}
