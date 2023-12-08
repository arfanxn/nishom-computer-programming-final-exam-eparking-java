/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author arfanxn
 * @param <M>
 * @param <MC>
 */
public interface Repository<M extends Model, MC extends ModelCollection> {
    public M getModel();
    
    public MC getModelCollection();
}
