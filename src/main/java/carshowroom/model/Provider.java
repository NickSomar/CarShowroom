package carshowroom.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "provider_name", nullable = false)
    private String providerName;

    @Basic
    @Column(name = "country", nullable = false)
    private String country;

    @Basic
    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(targetEntity=Car.class, mappedBy = "provider", cascade = {CascadeType.ALL})
    private Collection<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String name) {
        this.providerName = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }
}
