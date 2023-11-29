/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

import java.util.ArrayList;

/**
 *
 * @author arfanxn
 * @param <T>
 */
public class Pagination<T extends Interfaces.Model> {
    
    private int total;
    private int perPage;
    private int currentPage;
    private int lastPage;
    private String prevPageUrlString;
    private String nextPageUrlString;
    private ArrayList<T> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getPrevPageUrlString() {
        return prevPageUrlString;
    }

    public void setPrevPageUrlString(String prevPageUrlString) {
        this.prevPageUrlString = prevPageUrlString;
    }

    public String getNextPageUrlString() {
        return nextPageUrlString;
    }

    public void setNextPageUrlString(String nextPageUrlString) {
        this.nextPageUrlString = nextPageUrlString;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
    


}
