package carshowroom.service.impl;

import carshowroom.model.Provider;
import carshowroom.repo.ProviderRepo;
import carshowroom.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements GeneralService<Provider> {
    @Autowired
    ProviderRepo providerRepo;

    @Override
    public void save(Provider provider) {
        providerRepo.save(provider);
    }

    @Override
    public List<Provider> findAll() {
        return providerRepo.findAll();
    }

    @Override
    public Provider findById(Long id) {
        return providerRepo.findProviderById(id);
    }

    @Override
    public void delete(Long id) {
        providerRepo.deleteById(id);
    }

    @Override
    public Provider update(Provider provider, Long id) {
        return providerRepo.save(provider);
    }
}
