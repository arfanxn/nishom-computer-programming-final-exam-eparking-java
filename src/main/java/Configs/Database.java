/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Configs;

/**
 *
 * @author arfanxn
 */
public class Database {

    // Static variable reference of instance type Singleton
    private static Database instance;

    // Static method to create instance of Singleton class
    public static synchronized Database getInstance() {
        instance = instance == null ? new Database() : instance;
        return instance;
    }

    private String jdbcUrlString;
    private String username, password;

    private Database() {
        this.setJdbcUrlString("jdbc:mysql://localhost:3306/e-parking?serverTimezone=UTC");
        this.setUsername("root");
        this.setPassword("");
    }

    private void setJdbcUrlString(String urlString) {
        this.jdbcUrlString = urlString;
    }

    public String getJdbcUrlString() {
        return this.jdbcUrlString;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
