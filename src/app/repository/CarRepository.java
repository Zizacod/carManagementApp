package app.repository;

import app.model.Car;

import java.io.FileNotFoundException;

public interface CarRepository {

    Car getById(Long id) throws FileNotFoundException;
}
