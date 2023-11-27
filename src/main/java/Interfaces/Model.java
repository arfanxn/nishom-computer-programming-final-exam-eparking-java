/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author arfanxn
 * @param <T>
 */
public interface Model<T extends Model> {

    public String getTableName();

    public ArrayList<T> fromResultSet(ResultSet resultSet) throws SQLException;
}
