package carshowroom.repo;

import carshowroom.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "provider", path = "provider")
public interface ProviderRepo extends JpaRepository<Provider, Long> {
    Provider findProviderById(Long id);
    Provider findProviderByProviderName(String providerName);
}
