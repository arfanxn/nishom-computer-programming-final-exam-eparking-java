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
    id CHAR(36) NOT NULL,
    plate_number VARCHAR(11) NOT NULL,
    entered_at DATETIME NOT NULL,
    left_at DATETIME,   
    updated_at DATETIME,   

    CONSTRAINT parked_vehicles PRIMARY KEY (id)
);

