package com.jalasoft.evaluation.evaluation.services;

import com.jalasoft.evaluation.config.Properties;
import com.jalasoft.evaluation.evaluationtest.datatypes.Evaluation;
import com.jalasoft.evaluation.evaluationtest.dtos.EvaluationDto;
import com.jalasoft.evaluation.evaluationtest.services.EvaluationServiceImpl;
import com.jalasoft.evaluation.evaluationtest.services.mappers.EvaluationDtoMapper;
import com.jalasoft.evaluation.evaluationtest.datafake.CrudRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EvaluationTest {
    @InjectMocks
    EvaluationServiceImpl evaluationService;

    @Mock
    EvaluationDtoMapper evaluationDtoMapper;

    @Mock
    CrudRepository<Evaluation> crudRepository;

    @Mock
    private Properties properties;

    @Test
    public void shouldGetListOfTheEvaluation() throws Exception {
        Evaluation evaluationTest = new Evaluation();
        evaluationTest.setId(1);
        evaluationTest.setTitle("Evaluation practice Java I");
        evaluationTest.setDescription("Java Level2 evaluation - solving exercises");
        evaluationTest.setUser("Juan Pablo");
        evaluationTest.setScore(70);

        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setTitle("Evaluation practice Java I");
        evaluationDto.setDescription("Java Level2 evaluation - solving exercises");
        evaluationDto.setApplicant("Juan Pablo");
        evaluationDto.setEvaluationScore(70);

        Mockito.when(evaluationDtoMapper.mapToEvaluacionDto(evaluationTest))
                .thenReturn(evaluationDto);

        Mockito.when(crudRepository.getAll())
                .thenReturn(Collections.singletonList(evaluationTest));

        List<EvaluationDto> result = evaluationService.getEvaluation();

        Assert.assertEquals(evaluationDto, result.stream().findFirst().get());

    }

    @Test
    public void shouldGetIsActiveEndPoint() throws Exception {
        Mockito.when(properties.getSystemProperty())
                .thenReturn(true);

        boolean result = evaluationService.isActiveEndPoint();
        boolean expected = true;
        Assert.assertEquals(expected, result);
    }
}
