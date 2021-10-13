package com.jalasoft.evaluation.evaluationtest.datatypes;

import lombok.Data;

@Data
public class Evaluation {
    private int Id;

    private String User;

    private String Title;

    private String Description;

    private int score;
}
