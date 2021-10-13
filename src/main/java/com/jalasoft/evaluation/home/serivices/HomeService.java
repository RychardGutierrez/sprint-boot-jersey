package com.jalasoft.evaluation.home.serivices;

import com.jalasoft.evaluation.home.dtos.HomeDto;

import java.util.List;

public interface HomeService {
    List<HomeDto> getWelcomeHome();

    String getProfile();
}
