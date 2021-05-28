package carshowroom.service.impl;

import carshowroom.model.Car;
import carshowroom.repo.CarRepo;
import carshowroom.service.CarService;
import carshowroom.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Override
    public void save(Car car) {
        carRepo.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepo.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepo.findCarById(id);
    }

    @Override
    public void delete(Long id) {
        carRepo.deleteById(id);
    }

    @Override
    public Car findCarByTitle(String title) {
        return carRepo.findCarByTitle(title);
    }

    @Override
    public Car update(Car car, Long id) {
        return carRepo.save(car);
    }
}
