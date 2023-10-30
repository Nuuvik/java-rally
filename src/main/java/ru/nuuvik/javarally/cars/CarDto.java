package ru.nuuvik.javarally.cars;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.nuuvik.javarally.config.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CarDto {

    private Long id;

    @NotBlank(groups = {Create.class})
    private String model;

    @NotNull(groups = {Create.class})
    private Group groups; //TODO изменить дто при необходимости


}
