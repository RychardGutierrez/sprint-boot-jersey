package com.jalasoft.evaluation.home.services;

import com.jalasoft.evaluation.config.Properties;
import com.jalasoft.evaluation.home.datafake.CrudRepository;
import com.jalasoft.evaluation.home.datatypes.Home;
import com.jalasoft.evaluation.home.dtos.HomeDto;
import com.jalasoft.evaluation.home.serivices.HomeServiceImpl;
import com.jalasoft.evaluation.home.serivices.mappers.HomeDtoMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class HomeServiceTest {
    @InjectMocks
    HomeServiceImpl homeService;

    @Mock
    HomeDtoMapper homeDtoMapper;

    @Mock
    CrudRepository<Home> crudRepository;

    @Mock
    private Properties properties;

    Random randomNumberMock = Mockito.mock(Random.class);

    @Test
    public void shouldGetWelcomeMessage() throws Exception {

        Home messageWelcome = new Home();
        messageWelcome.setId(1);
        messageWelcome.setTitle("Home Test");
        messageWelcome.setDescription("This section is Home - Test");
        messageWelcome.setMessageToUser("Welcome! Test :)");
        HomeDto messageWelcomeDto = new HomeDto();
        messageWelcomeDto.setTitle("Home Test");
        messageWelcomeDto.setDescription("This section is Home - Test");
        messageWelcomeDto.setMessage("Welcome! Test :)");

        Mockito.when(homeDtoMapper.mapToHomeDto(messageWelcome))
                .thenReturn(messageWelcomeDto);
        Mockito.when(crudRepository.getAll())
                .thenReturn(Collections.singletonList(messageWelcome));

        List<HomeDto> result = homeService.getWelcomeHome();
        Assert.assertEquals(messageWelcomeDto, result.stream().findFirst().get());
    }

    @Test
    public void shouldGetCurrentProfile() throws Exception {
        Mockito.when(properties.getProfileActive())
                .thenReturn("dev");

        String result = homeService.getProfile();
        String expected = "Now we are in the profile: DEV";

        Assert.assertEquals(expected, result);
    }
}
