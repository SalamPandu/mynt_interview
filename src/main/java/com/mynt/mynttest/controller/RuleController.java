package com.mynt.mynttest.controller;

import com.mynt.mynttest.dto.RuleRequest;
import com.mynt.mynttest.entity.Rule;
import com.mynt.mynttest.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/rules")
@RestController
public class RuleController {
    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
         this.ruleService = ruleService;
    }

    @PostMapping
    public ResponseEntity<?> addRule(@Valid @NonNull @RequestBody RuleRequest request) {
        Rule data = ruleService.create(Rule.builder()
                .priority(request.getPriority())
                .name(request.getName())
                .param(request.getParam())
                .condition(request.getCondition())
                .threshold(request.getThreshold())
                .rate(request.getRate())
                .factor(request.getFactor())
                .build());
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
