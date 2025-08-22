package app.service;

import app.model.Car;
import app.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car getById(Long id) throws FileNotFoundException {

        return repository.getById(id);
    }
}
