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
 * @author Gabriel
 */
public class MesaListModel implements ListModel<Mesa>{
    private final List<Mesa> mesa;
    private final List<ListDataListener> dataListeners;   
    
    public MesaListModel(List<Mesa> mesas) {
        this.mesa = mesas;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return mesa.size();
    }

    @Override
    public Mesa getElementAt(int id) {
        return mesa.get(id);
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
