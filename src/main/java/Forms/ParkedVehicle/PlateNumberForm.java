/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms.ParkedVehicle;

import Exceptions.Validation;

/**
 *
 * @author arfanxn
 */
public class PlateNumberForm {

    private String city;
    private String number;
    private String region;

    public String getCity() {
        return city.trim();
    }

    public void setCity(String city) {
        this.city = city.trim();
    }

    public String getNumber() {
        return number.trim();
    }

    public void setNumber(String number) {
        this.number = number.trim();
    }

    public String getRegion() {
        return region.trim();
    }

    public void setRegion(String region) {
        this.region = region.trim();
    }

    public String getPlateNumber() {
        return ""
                .concat(this.getCity())
                .concat(" ")
                .concat(this.getNumber())
                .concat(" ")
                .concat(this.getRegion())
                .trim();
    }

    public void validate() throws Validation {
        if (this.getCity().length() < 1 || this.getCity().length() > 2) {
            throw new Exceptions.Validation("Invalid city");
        }
        if (this.getNumber().length() < 2 || this.getNumber().length() > 4) {
            throw new Exceptions.Validation("Invalid number");
        }
        if (this.getRegion().length() < 1 || this.getRegion().length() > 3) {
            throw new Exceptions.Validation("Invalid region");
        }
    }

}
