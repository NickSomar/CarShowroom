package carshowroom.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "surename", nullable = false)
    private String surename;

    @Basic
    @Column(name = "pasport", nullable = false)
    private String pasport;

    @Basic
    @Column(name = "tepephone", nullable = false)
    private String tepephone;

    @OneToMany(targetEntity=Rent.class, mappedBy = "client", cascade = {CascadeType.ALL})
    private Collection<Rent> rents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public String getTepephone() {
        return tepephone;
    }

    public void setTepephone(String tepephone) {
        this.tepephone = tepephone;
    }

    public Collection<Rent> getRents() {
        return rents;
    }

    public void setRents(Collection<Rent> rents) {
        this.rents = rents;
    }
}
