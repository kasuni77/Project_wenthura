package net.wenthura.wenthura.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")

public class Vehicle {
    private long id;
    private String vehNumber;
    private String vehType;
    private String vehModel;
    private String vehPrice;
    private String vehAvailability;

       public Vehicle() {}


     public Vehicle(long id, String vehNumber, String vehType, String vehModel, String vehPrice, String vehAvailability) {
        this.id = id;
        this.vehNumber = vehNumber;
        this.vehType = vehType;
        this.vehModel = vehModel;
        this.vehPrice = vehPrice;
        this.vehAvailability = vehAvailability;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "veh_number", nullable = false)
    public String getVehNumber() {
        return vehNumber;
    }

    public void setVehNumber(String vehNumber) {
        this.vehNumber = vehNumber;
    }

    @Column(name = "veh_type", nullable = false)
    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    @Column(name = "veh_model", nullable = false)
    public String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel;
    }

    @Column(name = "veh_price", nullable = false)
    public String getVehPrice() {
        return vehPrice;
    }

    public void setVehPrice(String vehPrice) {
        this.vehPrice = vehPrice;
    }

    @Column(name = "veh_availability", nullable = false)
    public String getvehAvailability() {
        return vehAvailability;
    }

    public void setvehAvailability(String vehAvailability) {
        this.vehAvailability = vehAvailability;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehNumber='" + vehNumber + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vehModel='" + vehModel + '\'' +
                ", vehPrice='" + vehPrice + '\'' +
                ", vehQuantity=" + vehAvailability +
                '}';
    }
}








































