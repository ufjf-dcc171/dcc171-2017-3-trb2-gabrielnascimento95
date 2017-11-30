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
 * @author gabriel
 */
public class HistoricoListModel implements ListModel<Historico>{
    private final List<Historico> historico;
    private final List<ListDataListener> dataListeners;   
    
    public HistoricoListModel(List<Historico> produtos) {
        this.historico = produtos;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return historico.size();
    }

    @Override
    public Historico getElementAt(int index) {
        return historico.get(index);
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
