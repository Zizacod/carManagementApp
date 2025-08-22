package app.service;

import app.model.Car;

import java.io.FileNotFoundException;

public interface CarService {

    Car getById(Long id) throws FileNotFoundException;
}
