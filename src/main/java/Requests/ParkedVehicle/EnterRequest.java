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
public class EnterRequest {

    private String plateNumber;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void validate() throws Validation {
        if (this.plateNumber.length() < 9 || this.plateNumber.length() > 12) {
            throw new Exceptions.Validation("Invalid plate number");
        }
    }

}
