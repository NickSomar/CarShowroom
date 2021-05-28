package carshowroom.service.impl;

import carshowroom.model.Tariff;
import carshowroom.repo.TariffRepo;
import carshowroom.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements GeneralService<Tariff> {
    @Autowired
    TariffRepo tariffRepo;

    @Override
    public void save(Tariff tariff) {
        tariffRepo.save(tariff);
    }

    @Override
    public List<Tariff> findAll() {
        return tariffRepo.findAll();
    }

    @Override
    public Tariff findById(Long id) {
        return tariffRepo.findTariffById(id);
    }

    @Override
    public void delete(Long id) {
        tariffRepo.deleteById(id);
    }

    @Override
    public Tariff update(Tariff tariff, Long id) {
        return tariffRepo.save(tariff);
    }
}
