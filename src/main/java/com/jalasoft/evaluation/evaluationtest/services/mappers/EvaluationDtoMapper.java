package com.jalasoft.evaluation.evaluationtest.services.mappers;

import com.jalasoft.evaluation.evaluationtest.datatypes.Evaluation;
import com.jalasoft.evaluation.evaluationtest.dtos.EvaluationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EvaluationDtoMapper {
    @Mapping(source = "user", target = "applicant")
    @Mapping(source = "score", target = "evaluationScore")
    EvaluationDto mapToEvaluacionDto(Evaluation evaluation);
}
