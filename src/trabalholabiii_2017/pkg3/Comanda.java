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
    private String idPedido;
    private Cardapio codCardapio;
    private int qnt;
    private float preco;
    private float precoTotal;

    public Comanda() {
    }

    public Comanda(Cardapio codProduto, int quatidade, float preco, float precoTotal) {
        this.codCardapio = codProduto;
        this.qnt = quatidade;
        this.preco = preco;
        this.precoTotal = precoTotal;
    }

    public Cardapio getCodCardapio() {
        return codCardapio;
    }

    public void setCodCardapio(Cardapio codCardapio) {
        this.codCardapio = codCardapio;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }    

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    
    @Override
    public String toString() {
        return  codCardapio.getNome() + " ------- " + qnt + " X " + preco + " = " + precoTotal;
    }
}
