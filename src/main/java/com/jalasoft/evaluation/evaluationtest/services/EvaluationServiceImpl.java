package com.jalasoft.evaluation.evaluationtest.services;

import com.jalasoft.evaluation.config.Properties;
import com.jalasoft.evaluation.evaluationtest.datafake.CrudRepository;
import com.jalasoft.evaluation.evaluationtest.datatypes.Evaluation;
import com.jalasoft.evaluation.evaluationtest.dtos.EvaluationDto;
import com.jalasoft.evaluation.evaluationtest.services.mappers.EvaluationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private Properties properties;

    @Autowired
    CrudRepository<Evaluation> crudRepository;

    @Autowired
    private EvaluationDtoMapper evaluationDtoMapper;

    @Override
    public List<EvaluationDto> getEvaluation() {
        return crudRepository.getAll().stream()
                .map(evaluation -> evaluationDtoMapper.mapToEvaluacionDto(evaluation))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isActiveEndPoint() {
        return properties.getSystemProperty();
    }
}
