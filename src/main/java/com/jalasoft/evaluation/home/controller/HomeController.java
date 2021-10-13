package com.jalasoft.evaluation.home.controller;


import com.jalasoft.evaluation.home.dtos.HomeDto;
import com.jalasoft.evaluation.home.serivices.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URISyntaxException;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "home")
@Component
@Path("/")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GET
    @Produces("application/json")
    public Response home() throws URISyntaxException {
        List<HomeDto> response = homeService.getWelcomeHome();
        return Response.status(200).entity(response).build();
    }

    @GET
    @Path("/profile")
    @Produces("application/text")
    public Response profile() throws URISyntaxException {
        String response = homeService.getProfile();
        return Response.status(200).entity(response).build();
    }
}
