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
public class Cardapio {
    private Integer id;
    private String nome;
    private float preco;

    public Cardapio() {
    }

    public Cardapio(int codigo, String nome, float preco) {
        this.id = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return id;
    }

    public void setCodigo(int codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return  id + ". " + nome + " R$ " + preco;
    }
}
