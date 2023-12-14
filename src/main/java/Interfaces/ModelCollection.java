/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author arfanxn
 */
public interface ModelCollection {
    
    public ModelCollection setCollection(ResultSet resultSet) throws SQLException;

    public List<Model> getCollection();

    public Object[][] getCollectionAsRowData();

}
