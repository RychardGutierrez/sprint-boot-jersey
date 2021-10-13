package com.jalasoft.evaluation.config;

import com.jalasoft.evaluation.evaluationtest.controllers.EvaluationController;
import com.jalasoft.evaluation.home.controller.HomeController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(HomeController.class);
        register(EvaluationController.class);
    }
}
