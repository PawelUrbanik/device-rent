package pl.pawel.devicerent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Device {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "client_devices",
            joinColumns = {@JoinColumn(name="device_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="client_id", referencedColumnName="id_client")}
    )
    private List<Client> clients = new ArrayList<Client>();

    public Device() {
    }

    public Device(String name, String description, Double price, Integer amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Device(String name, String description, Double price, Integer amount, Category category, List<Client> clients) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.clients = clients;
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

    public void addClients(Client client) {
        this.clients.add(client);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", category=" + category.getName() +
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
                Objects.equals(price, device.price) &&
                Objects.equals(amount, device.amount) &&
                Objects.equals(category, device.category) &&
                Objects.equals(clients, device.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, amount, category, clients);
    }
}
