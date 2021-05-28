package carshowroom.service.impl;

import carshowroom.model.Client;
import carshowroom.repo.ClientRepo;
import carshowroom.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements GeneralService<Client> {
    @Autowired
    ClientRepo clientRepo;

    @Override
    public void save(Client client) {
        clientRepo.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepo.findClientById(id);
    }

    @Override
    public void delete(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client update(Client client, Long id) {
        return clientRepo.save(client);
    }
}
