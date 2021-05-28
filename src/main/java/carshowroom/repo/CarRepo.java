package carshowroom.repo;

import carshowroom.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepo extends JpaRepository<Car, Long> {
    Car findCarById(Long id);
    Car findCarByTitle(String title);
}
