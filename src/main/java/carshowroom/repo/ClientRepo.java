package carshowroom.repo;

import carshowroom.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
    Client findClientByName(String name);
}
