/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.util.Date;

/**
 *
 * @author gabriel
 */
public class Historico {
    private float total;
    private String data;
    private String id;

    public Historico(float t, String data, String idd) {
        this.data = data;
        this.total = t;
        this.id = idd;
    }

    public Historico() {
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
