package com.jalasoft.evaluation.evaluationtest.services;

import com.jalasoft.evaluation.evaluationtest.dtos.EvaluationDto;

import java.util.List;

public interface EvaluationService {
    List<EvaluationDto> getEvaluation();

    boolean isActiveEndPoint();
}
