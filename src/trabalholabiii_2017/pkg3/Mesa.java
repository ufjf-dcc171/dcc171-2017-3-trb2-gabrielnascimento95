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
public class Mesa {
    private Integer id;
    private String nomeMesa;

    public Mesa(Integer id, String descricao) {
        this.id = id;
        this.nomeMesa = descricao;
    }

    public Mesa() {
    }
    
    public String getNomeMesa() {
        return nomeMesa;
    }

    public void setNomeMesa(String nomeMesa) {
        this.nomeMesa = nomeMesa;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
       return id + "  " + nomeMesa; 
    }
}
