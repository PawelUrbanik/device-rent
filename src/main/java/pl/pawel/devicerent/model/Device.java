package pl.pawel.devicerent.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Device {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Client> clients;

    public Device() {
    }

    public Device(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Device(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
//                ", category=" + category +
//                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id) &&
                Objects.equals(name, device.name) &&
                Objects.equals(description, device.description) &&
                Objects.equals(category, device.category) &&
                Objects.equals(clients, device.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, clients);
    }
}
