/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


/**
 *
 * @author Gabriel_Nascimento
 */
public class JanelaTrabalho extends JFrame{
    
    private ArrayList<Cardapio> lstCardapio; 
    private ArrayList<Mesa> lstMesa; 
    private ArrayList<Pedido> lstPedido;
    private ArrayList<Comanda> lstComanda;
    private ArrayList<Comanda> lstHistorico;
    
    private final JPanel pd = new JPanel();
    private final JPanel pe = new JPanel();
    private final JPanel pp = new JPanel();
    private final JPanel pb = new JPanel();
    private final JPanel pc = new JPanel(); 
    private final JPanel pbp = new JPanel(); 
    private final JPanel pdb = new JPanel(); 
    
    private final JButton btnNovoPedido = new JButton("Novo Pedido");
    private final JButton btnSalvarPedido = new JButton("Gravar Pedido");
    private final JButton btnCancelar = new JButton("Cancelar Pedido");
    private final JButton btnAlteraPedido = new JButton("Adicionar Itens");
    private final JButton btnExcluirPedido = new JButton("Excluir Pedido");
    private final JButton btnFecharMesa = new JButton("Fechar Mesa");
    
    //private JComboBox cbListaMesa = new JComboBox(); 
    
    private final JTextField txtIdItem = new JTextField();
    private final JTextField txtItem = new JTextField();
    private final JLabel lblItem = new JLabel("Item");    
    private final JTextField txtPreco = new JTextField();
    private final JLabel lblPreco = new JLabel("Preço");    
    private final JTextField txtQnt = new JTextField();
    private final JLabel lblQnt = new JLabel("Quantidade");
    private final JTextField txtMesa = new JTextField();
    private final JLabel lblMesa = new JLabel("Mesa");    
    private final JTextField txtTotal = new JTextField();
    private final JLabel lblTotal = new JLabel("Total");
    private final JTextField txtTotalComanda = new JTextField();
    private final JLabel lblTotalComanda = new JLabel("Total Comanda:");
    private final JTextField txtData = new JTextField();
    
    private final JList<Mesa> jltMesas = new JList<Mesa>(new DefaultListModel<>());
    private final JList<Cardapio> jltCardapio = new JList<Cardapio>(new DefaultListModel<>());
    private final JList<Pedido> jltPedidos = new JList<Pedido>(new DefaultListModel<>());
    private final JList<Comanda> jltComanda = new JList<Comanda>(new DefaultListModel<>());
    private final JList<Balanco> jltHistorico = new JList<Balanco>(new DefaultListModel<>());
    
    private boolean retornaMesa = false;
    private boolean verificaNovoPedido = false;
    private boolean verificaNovoItem = false;
    private Date data;

    public JanelaTrabalho(ArrayList<Comanda> leComanda, ArrayList<Cardapio> leCardapio, ArrayList<Pedido> lePedido, ArrayList<Mesa> leMesa) throws HeadlessException, IOException{
        
        this.lstCardapio = leCardapio;
        this.lstMesa = leMesa;
        this.lstPedido = lePedido;
        this.lstComanda = leComanda;
        
        setLayout(new BorderLayout());
        pd.setLayout(new BorderLayout());
        pe.setLayout(new GridLayout(1, 3));
        pp.setLayout(new BorderLayout());
        pb.setLayout(new GridLayout(1, 2));
        pc.setLayout(new GridLayout(12, 2));
        pb.setLayout(new GridLayout(1, 1));
        pdb.setLayout(new BorderLayout());
        
       jltMesas.setModel(new MesaListModel(lstMesa));
       jltCardapio.setModel(new CardapioListModel(lstCardapio));
       jltPedidos.setModel(new PedidoListModel(lstPedido));
       
       jltCardapio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       jltComanda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       jltHistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       jltMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       jltPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
       txtIdItem.setEnabled(false);
       txtTotal.setEnabled(false); 
       btnFecharMesa.setEnabled(false);
       btnSalvarPedido.setEnabled(false);
       btnAlteraPedido.setEnabled(false);
       btnCancelar.setEnabled(false);
       btnExcluirPedido.setEnabled(false);
       txtTotalComanda.setEditable(false);
       
       
       //pc.add(cbListaMesa);
          
       pc.add(lblMesa);
       pc.add(txtMesa);   
       pc.add(lblItem);
       pc.add(txtItem);
       pc.add(lblPreco);
       pc.add(txtPreco);
       pc.add(lblQnt);
       pc.add(txtQnt);
       pc.add(lblTotal);
       pc.add(txtTotal);
       pbp.add(btnAlteraPedido);
       pbp.add(btnExcluirPedido);            
       pbp.add(btnFecharMesa);            
       pc.add(pbp);
       
       pd.add(pc, BorderLayout.WEST);
       pd.add(new JScrollPane(jltCardapio), BorderLayout.SOUTH);
        
       pdb.add(new JScrollPane(jltMesas), BorderLayout.NORTH);
       //pdb.add(new JScrollPane(jltComanda), BorderLayout.SOUTH);
       pdb.add(lblTotalComanda, BorderLayout.CENTER);
       pdb.add(txtTotalComanda, BorderLayout.SOUTH);
        
       pd.add(pdb, BorderLayout.EAST);
       pe.add(new JScrollPane(jltPedidos));  
        
       pb.add(btnNovoPedido);
       pb.add(btnSalvarPedido);
       pb.add(btnCancelar);
        
       pp.add(pd, BorderLayout.CENTER);
       pp.add(pe, BorderLayout.NORTH);
       pp.add(pb, BorderLayout.SOUTH);
         
       add(pp);
       
       btnNovoPedido.addActionListener(new acaoBotao());
       btnSalvarPedido.addActionListener(new acaoBotao());
       btnCancelar.addActionListener(new acaoBotao());
       btnAlteraPedido.addActionListener(new acaoBotao());
       btnExcluirPedido.addActionListener(new acaoBotao());
       btnFecharMesa.addActionListener(new acaoBotao());
       
       jltPedidos.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1){
                    Pedido pedidoAberto = jltPedidos.getSelectedValue();                    
                    if(pedidoAberto.getComanda() != null){
                        jltComanda.setModel(new ComandaListModel(pedidoAberto.getComanda()));
                    }            
                    //cbListaMesa.setEnabled(false);
                    txtMesa.setEnabled(false);
                    jltPedidos.setEnabled(false);
                    btnFecharMesa.setEnabled(true);
                    btnSalvarPedido.setEnabled(true);
                    btnFecharMesa.setEnabled(true);
                    txtTotalComanda.setText("R$ " + calculadora());
                }
             } 
           
       
       });
       
       jltCardapio.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1){
                    btnSalvarPedido.setEnabled(true);
                    btnAlteraPedido.setEnabled(true);
                    btnCancelar.setEnabled(true);
                    txtIdItem.setText("");
                    txtItem.setText("");
                    txtTotal.setText("");
                    txtQnt.setText("");
                    txtQnt.grabFocus();
                    Cardapio itemSelecionado = jltCardapio.getSelectedValue();                    
                    txtIdItem.setText(itemSelecionado.getCodigo() + ""); 
                    txtItem.setText(itemSelecionado.getNome()); 
                    txtPreco.setText(itemSelecionado.getPreco()+ ""); 
                    verificaNovoItem = true;
                }
             }
       
       
       });
       
       txtItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                if (!txtItem.getText().isEmpty()){
                    id = Integer.parseInt(txtItem.getText());
                    for (int i = 0; i < lstCardapio.size(); i++){
                        if (id == lstCardapio.get(i).getCodigo()) {
                            txtIdItem.setText(id + ""); 
                            txtItem.setText(lstCardapio.get(i).getNome()); 
                            txtPreco.setText(lstCardapio.get(i).getPreco() + ""); 
                            //txtQnt.setText("");
                            //txtTotal.setText("");
                            txtQnt.grabFocus();
                            jltCardapio.setSelectedIndex(i); 
                            verificaNovoItem = true;
                        }
                    }
                }                
            }
        });
       
       txtQnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((!txtPreco.getText().isEmpty()) && (!txtQnt.getText().isEmpty())) {
                    txtTotal.setText(Float.parseFloat(txtPreco.getText()) * Float.parseFloat(txtQnt.getText()) + "");
                }
            }
        });
       
       jltMesas.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1){
                    Mesa mesaSelecionada = jltMesas.getSelectedValue();
                    txtMesa.setText(mesaSelecionada.getNomeMesa());
                }
            }
       });
 
    }

    private class acaoBotao implements ActionListener {

        public acaoBotao() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            float auxTotalMesa = 0;
            
            if(e.getSource() == btnNovoPedido){
                txtMesa.setEnabled(true);
                //cbListaMesa.setEnabled(true);
                btnNovoPedido.setEnabled(true);
                btnSalvarPedido.setEnabled(true);
                verificaNovoPedido = true;
                txtItem.grabFocus();
                Pedido pedido = new Pedido();
                pedido.setData(txtData + "");
                pedido.setNumero(String.valueOf(verificaUltimoPedido()));
                pedido.setTotal(0);
                pedido.setIdMesa(procuraMesa());
                lstPedido.add(pedido);
                jltPedidos.updateUI();
                jltPedidos.setSelectedIndex(verificaUltimoPedido());
            }else if(e.getSource() == btnSalvarPedido){
                try {
                    btnNovoPedido.setEnabled(true);
                    jltPedidos.setEnabled(true);
                    Pedido aux  = jltPedidos.getSelectedValue();
                    aux.setTotal(retornaPreco(aux));
                    //if(verificaNovoPedido){
                    //    atualizaListaMesa();
                    //}
                    jltPedidos.updateUI();
                    jltPedidos.clearSelection();
                    btnSalvarPedido.setEnabled(true);
                    verificaNovoPedido = false;
                    gravacaoArqPedido(lstPedido);
                    gravacaoArqComanda(lstPedido);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaTrabalho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource() == btnCancelar){
                if(verificaNovoPedido == true){
                    Pedido pedido = jltPedidos.getSelectedValue();
                    jltComanda.setModel(new DefaultListModel());
                    lstPedido.remove(pedido);
                    jltPedidos.updateUI();
                    jltPedidos.setEnabled(verificaNovoPedido);
                    btnSalvarPedido.setEnabled(false);
                    //cbListaMesa.setEnabled(true);
                    txtMesa.setEnabled(true);
                }
                limpaCampos();
                btnNovoPedido.setEnabled(true);
                jltPedidos.setEnabled(true);
                jltComanda.setModel(new DefaultListModel());
                verificaNovoPedido = false;
                btnFecharMesa.setEnabled(false);
            }else if(e.getSource() == btnAlteraPedido){
               Pedido pedido = jltPedidos.getSelectedValue();
               float vTotal = 0;
                    if (verificaNovoPedido == true){
                        Comanda comanda = jltComanda.getSelectedValue();
                        comanda.setIdPedido(comanda.getIdPedido());
                        comanda.setQnt(Integer.parseInt(txtQnt.getText()));
                        comanda.setPreco(Float.parseFloat(txtPreco.getText()));
                        comanda.setPrecoTotal(Float.parseFloat(txtQnt.getText()) * (Float.parseFloat(txtPreco.getText())));
                    }else{                        
                        vTotal = Float.parseFloat(txtQnt.getText()) * (Float.parseFloat(txtPreco.getText()));
                        Comanda comanda = new Comanda(jltCardapio.getSelectedValue(), Integer.parseInt(txtQnt.getText()), Float.parseFloat(txtPreco.getText()), vTotal);
                        comanda.setIdPedido(comanda.getIdPedido());
                        if (verificaNovoPedido == false){                            
                            lstComanda.add(comanda);
                            pedido.setComanda(lstComanda);
                        }else{
                            pedido.getComanda().add(comanda);
                        }
                    }
                    txtTotalComanda.setText("R$ " + calculadora());
                    txtTotal.setText("R$ 0,00");
                    jltComanda.setModel(new ComandaListModel(pedido.getComanda()));
                    jltComanda.updateUI();
                    jltComanda.setEnabled(true);
                    limpaCampos(); 
            
            }else if(e.getSource() == btnExcluirPedido){
                 if (!jltComanda.isEnabled() == false){ 
                    Pedido pedido = jltPedidos.getSelectedValue();
                    pedido.getComanda().remove(jltComanda.getSelectedValue());
                    jltComanda.updateUI();                   
                    txtTotalComanda.setText("R$ " + calculadora());
                    limpaCampos();      
                }           
            }else if(e.getSource() == btnFecharMesa){
                if(!jltPedidos.isSelectionEmpty()){
                    limpaCampos();
                    Pedido aux = jltPedidos.getSelectedValue();
                    int index = jltPedidos.getSelectedIndex();
                    if(lstHistorico.size()>0){
                        lstHistorico.remove(lstHistorico.get(0));
                    }
                    while(aux.getComanda().size() > 0){
                        lstHistorico.add(aux.getComanda().get(0));
                        aux.getComanda().remove(aux.getComanda().get(0));
                    }
                    JOptionPane.showMessageDialog(null, "Mesa Fechada \n Total: " + aux.getTotal());
                    lstPedido.remove(aux);
                    jltPedidos.updateUI();
                    jltPedidos.setEnabled(true);
                    txtMesa.setEnabled(true);
                    //cbListaMesa.setEnabled(true);
                    btnSalvarPedido.setEnabled(false);
                    //atualizaListaMesa();
                    jltComanda.setModel(new DefaultListModel());
                    try {
                        gravacaoArqComanda(lstPedido);
                        gravacaoArqPedido(lstPedido);
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaTrabalho.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } 
        }
        
        private float retornaPreco(Pedido aux){
            float auxPreco = 0;
            for(int i = 0; i < aux.getComanda().size(); i++){
                auxPreco = auxPreco + aux.getComanda().get(i).getPreco();
            }
            return auxPreco;
        }
        
        private int verificaUltimoPedido() {
            int aux =0;
            String id = "";
            for(int i = 0; i < lstPedido.size(); i++){
                id = lstPedido.get(i).getNumero();
            }
            aux = Integer.parseInt(id) + 1;
            return aux;
        }
        
        private Mesa procuraMesa(){
             Mesa auxMesa = new Mesa();
             for(int i=0; i < lstMesa.size(); i++){
                 if(lstMesa.get(i).getNomeMesa() == txtMesa.getText()){//cbListaMesa.getSelectedItem().toString()){
                     auxMesa = lstMesa.get(i);
                 }
             }
             return auxMesa;
        }
    }
   
    private float calculadora(){
        float total = 0;
        Pedido pedido = jltPedidos.getSelectedValue();                
        for(int i = 0; i < pedido.getComanda().size(); i++){
            total = total + pedido.getComanda().get(i).getPrecoTotal();
        }
        return total;
    }
    
    /*
    private void atualizaListaMesa(){
        cbListaMesa.removeAllItems();
        for(int i = 0; i < lstMesa.size(); i++){
            for(int j = 0; j < lstPedido.size(); j++){
                if (lstPedido.get(j).verificaId(lstMesa.get(i))){
                    retornaMesa = true;
                }    
            } 
            if (retornaMesa == false){
                cbListaMesa.addItem(lstMesa.get(i).getNomeMesa());
            }
           retornaMesa = false;
        }
    }
    */
    
    private void gravacaoArqPedido(List<Pedido> lstPedidos) throws IOException{
        File file = new File("pedidos.txt");
        file.delete();
        FileWriter arq = new FileWriter("pedidos.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
     
        for (int i=0; i < lstPedidos.size(); i++) {
            gravarArq.println(
                lstPedidos.get(i).getNumero() + "," + lstPedidos.get(i).getData() + "," + 
                lstPedidos.get(i).getTotal()+ "," + lstPedidos.get(i).getIdMesa().getNomeMesa() + ","); 
        }
        arq.close();
    }
    
    private void gravacaoArqComanda(List<Pedido> comanda) throws IOException{
        File file = new File("moviPedidos.txt");
        file.delete();
        
        FileWriter arq = new FileWriter("moviPedidos.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        
        for (int i=0; i < comanda.size(); i++) {
            for(int j = 0; j < comanda.get(i).getComanda().size(); j++){
                gravarArq.println(
                    comanda.get(i).getComanda().get(j).getIdPedido()+ "," + comanda.get(i).getComanda().get(j).getCodCardapio().getCodigo() + "," + 
                    comanda.get(i).getComanda().get(j).getQnt()+ "," + comanda.get(i).getComanda().get(j).getPreco()+ "," + 
                    comanda.get(i).getComanda().get(j).getPrecoTotal());    
            }
        }
        arq.close();
    }
    
    private void limpaCampos(){
        txtIdItem.setText("");
        txtItem.setText("");
        txtPreco.setText("");
        txtQnt.setText("");
        txtTotal.setText("");
    }

}
