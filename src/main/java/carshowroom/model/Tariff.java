package carshowroom.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "tariffName", nullable = false)
    private String tariffName;

    @Basic
    @Column(name = "price_per_day", nullable = false)
    private String pricePerDay;

    @OneToMany(targetEntity=Rent.class, mappedBy = "tariff", cascade = {CascadeType.ALL})
    private Collection<Rent> rents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tarifName) {
        this.tariffName = tarifName;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Collection<Rent> getRents() {
        return rents;
    }

    public void setRents(Collection<Rent> rents) {
        this.rents = rents;
    }
}
