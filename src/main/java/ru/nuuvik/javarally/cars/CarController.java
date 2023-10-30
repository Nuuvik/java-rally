package ru.nuuvik.javarally.cars;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
@Validated
@Slf4j

public class CarController {

    private static final String USER_ID_HEADER = "X-Sharer-User-Id";

    private static final String CAR_ID_FIELD_NAME = "id";
    @Autowired
    private CarService carService;


    @GetMapping("/{carId}")
    public CarDto getCarById(@PathVariable Long carId) {
        log.info("request received GET /cars/id");
        return carService.getCarById(carId);
    }

    @PostMapping
    public CarDto addCar(@RequestBody @Valid CarDto car) {
        log.info("request received POST /cars");
        return carService.createCar(car);
    }

    @DeleteMapping("/{carId}")
    public CarDto deleteCar(@PathVariable Long carId) {
        log.info("request received DELETE /cars");
        return carService.deleteCar(carId);
    }

    @PatchMapping("/{carId}")
    public CarDto updateCar(@Valid @PathVariable Long carId, @RequestBody CarDto newCar) {
        log.info("request received PATCH /cars/id");
        return carService.updateCar(carId, newCar);
    }
//
//    @GetMapping("/search")
//    public List<CarDto> search(@RequestParam(required = false) @PositiveOrZero Integer from,
//                                @RequestParam(required = false) @Positive Integer size,
//                                @RequestParam String text) {
//        log.info("request received GET /cars/search");
//        return carService.searchCar(text, from, size);
//    }

}
