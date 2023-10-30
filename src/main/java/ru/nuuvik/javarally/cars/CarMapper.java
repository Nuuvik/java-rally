package ru.nuuvik.javarally.cars;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CarMapper {
    CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    Car toCar(CarDto carDto);

    CarDto toCarDto(Car car);
}
