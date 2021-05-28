package carshowroom.service.impl;

import carshowroom.model.Rent;
import carshowroom.repo.RentRepo;
import carshowroom.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements GeneralService<Rent> {
    @Autowired
    RentRepo rentRepo;

    @Override
    public void save(Rent rent) {
        rentRepo.save(rent);
    }

    @Override
    public List<Rent> findAll() {
        return rentRepo.findAll();
    }

    @Override
    public Rent findById(Long id) {
        return rentRepo.findRentById(id);
    }

    @Override
    public void delete(Long id) {
        rentRepo.deleteById(id);
    }

    @Override
    public Rent update(Rent rent, Long id) {
        return rentRepo.save(rent);
    }
}
