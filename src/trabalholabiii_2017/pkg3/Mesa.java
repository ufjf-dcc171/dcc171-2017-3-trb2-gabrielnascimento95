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
    private String descricao;

    public Mesa(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Mesa() {
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
       return id + "  " + descricao; 
    }
}
