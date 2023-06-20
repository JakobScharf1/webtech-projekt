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

    public InventoryObject(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public InventoryObject() {}

    public Long getId(){return id; }

    public void setId(Long id){this.id = id; }

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
}
