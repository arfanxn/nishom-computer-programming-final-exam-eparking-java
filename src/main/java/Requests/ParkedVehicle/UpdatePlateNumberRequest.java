/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Requests.ParkedVehicle;

import Exceptions.Validation;

/**
 *
 * @author arfanxn
 */
public class UpdatePlateNumberRequest {

    private String id;
    private String plateNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void validate() throws Validation {
        if (this.id.length() == 36) {
            throw new Exceptions.Validation("Invalid id");
        }
        
        if (this.plateNumber.length() < 9 || this.plateNumber.length() > 12) {
            throw new Exceptions.Validation("Invalid plate number");
        }
    }

}
