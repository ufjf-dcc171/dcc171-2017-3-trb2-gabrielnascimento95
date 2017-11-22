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
    private Integer codigo;
    private String descricao;
    private float vlrUunitario;

    public Cardapio() {
    }

    public Cardapio(int codigo, String descricao, float vlrUunitario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.vlrUunitario = vlrUunitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getVlrUunitario() {
        return vlrUunitario;
    }

    public void setVlrUunitario(float vlrUunitario) {
        this.vlrUunitario = vlrUunitario;
    }

    @Override
    public String toString() {
        return  codigo + " - " + descricao + " - " + vlrUunitario;
    }
}
