package com.mynt.mynttest.ruledata;


import com.mynt.mynttest.entity.Rule;
import com.mynt.mynttest.repository.RuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RuleDataDB implements CommandLineRunner {

    @Autowired
    RuleRepository repo;

    @Override
    public void run(String... args) {
        loadRuleData();
    }

    private void loadRuleData() {
        log.info("Creating 5 base rules");
        if (repo.count() == 0) {
            Rule rejectRule = Rule.builder()
                    .priority(1)
                    .name("reject")
                    .param("weight")
                    .condition("exceeds")
                    .threshold(50)
                    .rate(0.0)
                    .factor("weight")
                    .build();
            repo.save(rejectRule);
            log.info("Created rule with : "+rejectRule.getName());
            Rule heavyParcelRule = Rule.builder()
                    .priority(2)
                    .name("heavy parcel")
                    .param("weight")
                    .condition("exceeds")
                    .threshold(10)
                    .rate(20.0)
                    .factor("weight")
                    .build();
            repo.save(heavyParcelRule);
            log.info("Created rule with : "+heavyParcelRule.getName());
            Rule smallParcelRule = Rule.builder()
                    .priority(3)
                    .name("small parcel")
                    .param("volume")
                    .condition("below")
                    .threshold(1500)
                    .rate(0.03)
                    .factor("volume")
                    .build();
            repo.save(smallParcelRule);
            log.info("Created rule with : "+smallParcelRule.getName());
            Rule mediumParcelRule = Rule.builder()
                    .priority(4)
                    .name("small parcel")
                    .param("volume")
                    .condition("below")
                    .threshold(2500)
                    .rate(0.04)
                    .factor("volume")
                    .build();
            repo.save(mediumParcelRule);
            log.info("Created rule with : "+mediumParcelRule.getName());
            Rule largeParcelRule = Rule.builder()
                    .priority(4)
                    .name("small parcel")
                    .param("volume")
                    .condition("exceeds")
                    .threshold(2499)
                    .rate(0.05)
                    .factor("volume")
                    .build();
            repo.save(largeParcelRule);
            log.info("Created rule with : "+largeParcelRule.getName());
        }

        log.info("total rule count is = "+repo.count());
    }
}
