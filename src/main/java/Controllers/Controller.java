/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author arfanxn
 * @param <M>
 * @param <R>
 * @param <V>
 */
public class Controller<M extends Interfaces.Model, R extends Interfaces.Repository, V extends Interfaces.View> implements Interfaces.Controller {

    private M model;
    private R repository;
    private V view;
    
    public Controller(M model, R repository, V view) {
        this.model = model;
        this.repository = repository;
        this.view = view;
    }

    @Override
    public M getModel() {
        return this.model;
    }

    /**
     *
     * @param <T>
     * @param model
     */
    @Override
    public <T extends Interfaces.Model> void setModel(T model) {
        this.model = (M) model;
    }

    @Override
    public R getRepository() {
        return this.repository;
    }

    /**
     *
     * @param <T>
     * @param repository
     */
    @Override
    public <T extends Interfaces.Repository> void setRepository(T repository) {
        this.repository = (R) repository;
    }
    
    @Override
    public V getView() {
        return this.view;
    }

    /**
     *
     * @param <T>
     * @param view
     */
    @Override
    public <T extends Interfaces.View> void setView(T view) {
        this.view = (V) view;
    }
}
