/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel_Nascimento
 */
public class Pedido {
    private String numero;
    private String data;
    private String produto;
    private Float total;
    private String mesa;

    public Pedido() {
    }

    public Pedido(String numero, String data, String item, float total, String idMesa) {
        this.numero = numero;
        this.data = data;
        this.produto = item;
        this.total = total;
        this.mesa = idMesa;
       // this.comanda = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  "Mesa " +mesa + " - " + produto + " - " + "R$ " + total + " "+ data + " - ";
    }   

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
   
    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
    /*
    public boolean verificaId (Mesa codMesa){
        if (codMesa.getId() != this.mesa.getId()){
            return false;
        }else{
            return true;
        }        
    }
    */
    void setTotal(float total) {
        this.total= total;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

   
}
