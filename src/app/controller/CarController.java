package app.controller;

import app.model.Car;
import app.service.CarService;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class CarController {

    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    public Car getById(Long id) throws FileNotFoundException {
        return service.getById(id);
    }
}
