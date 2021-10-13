package com.jalasoft.evaluation.home.serivices;

import com.jalasoft.evaluation.config.Properties;
import com.jalasoft.evaluation.home.datafake.CrudRepository;
import com.jalasoft.evaluation.home.datatypes.Home;
import com.jalasoft.evaluation.home.dtos.HomeDto;
import com.jalasoft.evaluation.home.serivices.mappers.HomeDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDtoMapper homeDtoMapper;

    @Autowired
    private CrudRepository<Home> crudRepository;

    @Autowired
    private Properties properties;

    Random numberRandom = new Random();
    int low = 1;
    int high = 4;

    private int getIdRandom() {
        return numberRandom.nextInt(high - low) + low;
    }

    @Override
    public List<HomeDto> getWelcomeHome() {
        int getId = getIdRandom();
        return crudRepository.getAll().stream().
                filter(welcome -> welcome.getId() == getId).map(welcome -> homeDtoMapper.mapToHomeDto(welcome))
                .collect(Collectors.toList());
    }

    @Override
    public String getProfile() {
        String profileActive = properties.getProfileActive();
        return "Now we are in the profile: " + profileActive.toUpperCase(Locale.ROOT);
    }
}
