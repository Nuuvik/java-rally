package ru.nuuvik.javarally.cars;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import static ru.nuuvik.javarally.cars.CarMapper.carMapper;

@Slf4j
@RequiredArgsConstructor
@Primary
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarDto getCarById(Long carId) {
       Car car = carRepository.findById(carId).get();
       CarDto carDto = carMapper.toCarDto(car);
       return carDto;
    }
}
