/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author gabrielsantos
 */
public class ComandaListModel implements ListModel<Comanda> {
    private final List<Comanda> comanda;
    private final List<ListDataListener> dataListeners;   
    
    public ComandaListModel(List<Comanda> moviPedidos) {
        this.comanda = moviPedidos;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return comanda.size();
    }

    @Override
    public Comanda getElementAt(int index) {
        return comanda.get(index);
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
