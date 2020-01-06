package pl.pawel.devicerent.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "id_client")
    private Long id;
    private String firstname;
    private String lastname;
    private Long pesel;


    @ManyToMany(mappedBy = "clients", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Device> devices = new ArrayList<Device>();

    public Client() {
    }

    public Client(String firstname, String lastname, Long pesel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
    }

    public Client(String firstname, String lastname, Long pesel, Device device) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.devices.add(device);
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

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pesel=" + pesel +
                ", devices=" + devices.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstname, client.firstname) &&
                Objects.equals(lastname, client.lastname) &&
                Objects.equals(pesel, client.pesel) &&
                Objects.equals(devices, client.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, pesel, devices);
    }
}
