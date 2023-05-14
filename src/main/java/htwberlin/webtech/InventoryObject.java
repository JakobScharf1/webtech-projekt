package htwberlin.webtech;

import jakarta.persistence.*;

@Entity
public class InventoryObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OBJECT_NAME")
    private String name;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "LOCATION")
    private String location;

    public InventoryObject(String name, int amount, String location) {
        this.name = name;
        this.amount = amount;
        this.location = location;
    }

    public InventoryObject() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
