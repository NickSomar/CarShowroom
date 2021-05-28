package carshowroom.repo;

import carshowroom.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tariff", path = "tariff")
public interface TariffRepo extends JpaRepository<Tariff, Long> {
    Tariff findTariffById(Long id);
    Tariff findTariffByTariffName(String tariffName);
}
