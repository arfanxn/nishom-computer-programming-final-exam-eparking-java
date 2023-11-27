/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  arfanxn
 * Created: Nov 22, 2023
 */

CREATE DATABASE e-parking;

USE e-parking;

CREATE TABLE parked_vehicles
(
    id VARCHAR(16) NOT NULL,
    vehicle_plate_number VARCHAR(16) NOT NULL,
    entered_at DATETIME NOT NULL,
    left_at DATETIME,   

    CONSTRAINT parked_vehicles PRIMARY KEY (id)
);

