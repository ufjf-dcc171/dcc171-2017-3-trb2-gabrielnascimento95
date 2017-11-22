/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

/**
 *
 * @author Gabriel
 */
public class Comanda {
    private String numPedido;
    private Cardapio codProduto;
    private int quatidade;
    private float vlrUnitario;
    private float vlrTotal;

    public Comanda() {
    }

    public Comanda(Cardapio codProduto, int quatidade, float vlrUnitario, float vlrTotal) {
        this.codProduto = codProduto;
        this.quatidade = quatidade;
        this.vlrUnitario = vlrUnitario;
        this.vlrTotal = vlrTotal;
    }

    public Cardapio getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Cardapio codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    public float getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(float vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public float getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(float vlrTotal) {
        this.vlrTotal = vlrTotal;
    }    

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }
    
    @Override
    public String toString() {
        return  codProduto.getDescricao() + " | " + quatidade + " * " + vlrUnitario + " = " + vlrTotal;
    }
}
