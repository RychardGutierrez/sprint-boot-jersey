package com.jalasoft.evaluation.evaluationtest.datafake;

import com.jalasoft.evaluation.evaluationtest.datatypes.Evaluation;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataEvaluation implements CrudRepository<Evaluation> {
    public List<Evaluation> getAll() {
        Evaluation evaluation1 = new Evaluation();
        evaluation1.setId(1);
        evaluation1.setTitle("Evaluation practice Java I");
        evaluation1.setDescription("Java Level2 evaluation - solving exercises");
        evaluation1.setUser("Juan Pablo");
        evaluation1.setScore(70);

        Evaluation evaluation2 = new Evaluation();
        evaluation2.setId(2);
        evaluation2.setTitle("Web programming exam");
        evaluation2.setDescription("Level 1 web programming test");
        evaluation2.setUser("Ana montenegro");
        evaluation2.setScore(90);

        Evaluation evaluation3 = new Evaluation();
        evaluation3.setId(3);
        evaluation3.setTitle("Evaluation programing data sciences");
        evaluation3.setDescription("Basic level evaluation for Data Science");
        evaluation3.setUser("Ada Lovelace");
        evaluation3.setScore(100);

        return Arrays.asList(evaluation1, evaluation2, evaluation3);
    }
}
