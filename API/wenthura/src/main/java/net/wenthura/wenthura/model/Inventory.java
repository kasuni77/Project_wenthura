package net.wenthura.wenthura.model;

import javax.persistence.*;

@Entity
@Table(name = "inventory")

public class Inventory {
    private long id;
    private String invenName;
    private String invenPrice;
    private String invenCategory;
    private String invenAvailability;
    private int invenQuantity;

       public Inventory() {}


     public Inventory(long id, String invenName, String invenPrice, String invenCategory, String invenAvailability, int invenQuantity) {
        this.id = id;
        this.invenName = invenName;
        this.invenPrice = invenPrice;
        this.invenCategory = invenCategory;
        this.invenAvailability = invenAvailability;
        this.invenQuantity = invenQuantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "inven_name", nullable = false)
    public String getInvenName() {
        return invenName;
    }

    public void setInvenName(String invenName) {
        this.invenName = invenName;
    }

    @Column(name = "inven_price", nullable = false)
    public String getInvenPrice() {
        return invenPrice;
    }

    public void setInvenPrice(String invenPrice) {
        this.invenPrice = invenPrice;
    }

    @Column(name = "inven_category", nullable = false)
    public String getInvenCategory() {
        return invenCategory;
    }

    public void setInvenCategory(String invenCategory) {
        this.invenCategory = invenCategory;
    }

    @Column(name = "inven_availability", nullable = true)
    public String getInvenAvailability() {
        return invenAvailability;
    }

    public void setInvenAvailability(String invenAvailability) {
        this.invenAvailability = invenAvailability;
    }

    @Column(name = "inven_quantity", nullable = false)
    public int getInvenQuantity() {
        return invenQuantity;
    }

    public void setInvenQuantity(int invenQuantity) {
        this.invenQuantity = invenQuantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", invenName='" + invenName + '\'' +
                ", invenPrice='" + invenPrice + '\'' +
                ", invenCategory='" + invenCategory + '\'' +
                ", invenAvailability='" + invenAvailability + '\'' +
                ", invenQuantity=" + invenQuantity +
                '}';
    }
}












