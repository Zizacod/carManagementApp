package app.repository;

import app.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.nio.charset.StandardCharsets;

@PropertySource("classpath:application.properties")
@Repository
public class CarRepositoryFile implements CarRepository {

    @Value("${app.data.file.path:data/cars.txt}")
    private String filePath;


    @Override
    public Car getById(Long id) throws FileNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("ID не может быть null");
        }
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Car car = parseCarFromLine(line);
                    if (car != null && car.getId().equals(id)) {
                        return car;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + filePath, e);
        }

        return null;
    }

    private Car parseCarFromLine(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                Long id = Long.parseLong(parts[0].trim());
                String brand = parts[1].trim();
                String model = parts[2].trim();
                int year = Integer.parseInt(parts[3].trim());
                String color = parts[4].trim();
                double price = Double.parseDouble(parts[5].trim());
                
                return new Car(id, brand, model, year, color, price);
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка парсинга строки: " + line + ". " + e.getMessage());
        }
        return null;
    }
}
