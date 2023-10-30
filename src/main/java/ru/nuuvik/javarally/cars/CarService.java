package ru.nuuvik.javarally.cars;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static ru.nuuvik.javarally.cars.CarMapper.carMapper;

@Slf4j
@RequiredArgsConstructor
@Primary
@Service
public class CarService {

    @Autowired
    private final CarRepository carRepository;

    public CarDto getCarById(Long carId) {
       Car car = carRepository.findById(carId).get();
       CarDto carDto = carMapper.toCarDto(car);
       return carDto;
    }
    @Transactional
    public CarDto createCar(CarDto carDto) {
        log.info("Create request for carDto={} ", carDto);
        //checkCarIsAvailable(itemDto); TODO добавить проверки
        //checkUserExists(userId);
        //Optional<User> user = userRepository.findById(userId);
        Car car = carRepository.save(carMapper.toCar(carDto));
        log.info("Car created");
        return carMapper.toCarDto(car);
    }

    @Transactional
    public CarDto deleteCar(Long carId) {
        log.info("Delete request for carId={} ", carId);
        //checkCarExists(id); TODO добавить проверки
        Car car = carRepository.findById(carId).orElseGet(Car::new);
        CarDto carDto = carMapper.toCarDto(car);
        carRepository.delete(car);
        log.info("Car deleted");
        return carDto;
    }
    @Transactional
    public CarDto updateCar(Long carId, CarDto newCar) {
        log.info("Delete request for carId={} ", carId);
        //checkCarExists(id); TODO добавить проверки
        Car oldCar = carRepository.findById(carId).orElseGet(Car::new);
        oldCar.setModel(newCar.getModel());
        oldCar.setGroups(newCar.getGroups());
        carRepository.save(oldCar);
        log.info("Car patched");
        return carMapper.toCarDto(oldCar);
    }
}
