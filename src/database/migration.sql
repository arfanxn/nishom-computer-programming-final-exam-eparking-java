/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  arfanxn
 * Created: Oct 9, 2023
 */


CREATE TABLE parked_vehicles
(
    id VARCHAR(16),
    vehicle_id VARCHAR(16),
    vehicle_color VARCHAR(32),
    vehicle_type VARCHAR(32),
    vehicle_owner_id VARCHAR(16),
    rate FLOAT,
    entered_at DATETIME,
    left_at DATETIME,
    updated_at DATETIME
);