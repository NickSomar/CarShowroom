package carshowroom.service;

import carshowroom.model.Car;

public interface CarService extends GeneralService<Car> {
    Car findCarByTitle(String title);
}
