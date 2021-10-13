package com.jalasoft.evaluation.home.serivices.mappers;

import com.jalasoft.evaluation.home.datatypes.Home;
import com.jalasoft.evaluation.home.dtos.HomeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface HomeDtoMapper {
    @Mapping(target = "message", source = "messageToUser")
    HomeDto mapToHomeDto(Home home);
}
