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

    public <M extends Model> M getModel();

    public <M extends Model> void setModel(M model);

    public <R extends Repository> R getRepository();

    public <R extends Repository> void setRepository(R repository);

    public <V> V getView();

    public <V extends View> void setView(V view);

}
