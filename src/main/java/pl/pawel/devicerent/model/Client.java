package pl.pawel.devicerent.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private Integer pesel;


    @ManyToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private List<Device> devices;

    public Client() {
    }

    public Client(String firstname, String lastname, Integer pesel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pesel=" + pesel +
//                ", devices=" + devices +
                '}';
    }
}
