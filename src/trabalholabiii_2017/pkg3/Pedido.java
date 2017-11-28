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
    private List<Comanda> comanda;
    private Float total;
    private Mesa idMesa;

    public Pedido() {
    }

    public Pedido(String numero, String data, String Produto, float total, Mesa idMesa) {
        this.numero = numero;
        this.data = data;
        this.produto = produto;
        this.total = total;
        this.idMesa = idMesa;
        this.comanda = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  idMesa.getNomeMesa() + " - " + total;
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

    public List<Comanda> getComanda() {
        return comanda;
    }

    public void setComanda(List<Comanda> movimento) {
        this.comanda = movimento;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Mesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.idMesa = idMesa;
    }
    
    public boolean verificaId (Mesa codMesa){
        if (codMesa.getId() != this.idMesa.getId()){
            return false;
        }else{
            return true;
        }        
    }

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
