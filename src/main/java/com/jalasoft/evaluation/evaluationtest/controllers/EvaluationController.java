package com.jalasoft.evaluation.evaluationtest.controllers;

import com.jalasoft.evaluation.evaluationtest.dtos.EvaluationDto;
import com.jalasoft.evaluation.evaluationtest.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Component
@Path("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvaluation() throws URISyntaxException {
        if (!evaluationService.isActiveEndPoint()) {
            return Response.status(404).type(MediaType.TEXT_PLAIN).entity("Do not found").build();
        }
        List<EvaluationDto> response = evaluationService.getEvaluation();
        return Response.status(200).entity(response).build();
    }
}
