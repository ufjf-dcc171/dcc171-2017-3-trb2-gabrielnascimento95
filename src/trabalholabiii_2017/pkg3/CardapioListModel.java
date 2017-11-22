package trabalholabiii_2017.pkg3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class CardapioListModel implements ListModel<Cardapio>{
    private final List<Cardapio> cardapio;
    private final List<ListDataListener> dataListeners;   
    
    public CardapioListModel(List<Cardapio> produtos) {
        this.cardapio = produtos;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return cardapio.size();
    }

    @Override
    public Cardapio getElementAt(int index) {
        return cardapio.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }    
}
