/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author arfanxn
 */
public class Database {

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (Exception e) {
            /* Ignored */ }
        try {
            preparedStatement.close();
        } catch (Exception e) {
            /* Ignored */ }
        try {
            connection.close();
        } catch (Exception e) {
            /* Ignored */ }
    }

}
