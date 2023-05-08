package htwberlin.webtech;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String addressStreet;
    private String addressNumber;
    private String addressPLZ; //String, da auch PLZ mit 0 am Anfang existieren
    private String addressCity;
    private String additionalInfo;

    public Location(String name, String addressStreet, String addressNumber, String addressPLZ, String addressCity) {
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressPLZ = addressPLZ;
        this.addressCity = addressCity;
    }

    public Location() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressPLZ() {
        return addressPLZ;
    }

    public void setAddressPLZ(String addressPLZ) {
        this.addressPLZ = addressPLZ;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
