/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author arfanxn
 */
public interface Controller {

    public <T extends Model> T getModel();

    public <T extends Model> void setModel(T model);

    public <T extends Repository> T getRepository();

    public <T extends Repository> void setRepository(T repository);

    public <T> T getView();

    public <T> void setView(T view);

}
