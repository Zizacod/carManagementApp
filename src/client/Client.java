package client;

import app.controller.CarController;
import app.model.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {

        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext("app");

        CarController controller = context.getBean(CarController.class);

        Car car = controller.getById(2L);
        System.out.println(car);
    }
}
