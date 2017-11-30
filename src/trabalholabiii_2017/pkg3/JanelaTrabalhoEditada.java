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
import java.text.SimpleDateFormat;
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
public class JanelaTrabalhoEditada extends JFrame{
    
    private ArrayList<Cardapio> lstCardapio; 
    private ArrayList<Mesa> lstMesa; 
    private ArrayList<Pedido> lstPedido;
    //private ArrayList<Comanda> lstHistorico;
    
    private final JPanel pd = new JPanel();
    private final JPanel pe = new JPanel();
    private final JPanel pp = new JPanel();
    private final JPanel pb = new JPanel();
    private final JPanel pc = new JPanel(); 
    private final JPanel pbp = new JPanel(); 
    private final JPanel pdb = new JPanel(); 
    
    private final JButton btnNovoPedido = new JButton("Novo Pedido");
    private final JButton btnRelatorio = new JButton("Relatório Gerencial");
    private final JButton btnAlteraPedido = new JButton("Adicionar Itens");
    private final JButton btnExcluirPedido = new JButton("Excluir Pedido");
    private final JButton btnFecharMesa = new JButton("Fechar Mesa");
    
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
    
    private final JList<Mesa> jltMesas = new JList<Mesa>(new DefaultListModel<>());
    private final JList<Cardapio> jltCardapio = new JList<Cardapio>(new DefaultListModel<>());
    private final JList<Pedido> jltPedidos = new JList<Pedido>(new DefaultListModel<>());
    
    private Date data;
    private String dataString;

    public JanelaTrabalhoEditada(ArrayList<Cardapio> leCardapio, ArrayList<Pedido> lePedido, ArrayList<Mesa> leMesa) throws HeadlessException, IOException{
        
        this.lstCardapio = leCardapio;
        this.lstMesa = leMesa;
        this.lstPedido = lePedido;
        
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
       jltMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       jltPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
       txtIdItem.setEnabled(false);
       txtTotal.setEnabled(false); 
       btnFecharMesa.setEnabled(false);
       btnAlteraPedido.setEnabled(false);
       btnExcluirPedido.setEnabled(false);
       txtTotalComanda.setEditable(false);
       data = new Date(System.currentTimeMillis());
       dataString = new String(data.toString());
       
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
       pdb.add(lblTotalComanda, BorderLayout.CENTER);
       pdb.add(txtTotalComanda, BorderLayout.SOUTH);
        
       pd.add(pdb, BorderLayout.EAST);
       pe.add(new JScrollPane(jltPedidos));  
        
       pb.add(btnNovoPedido);
       pb.add(btnRelatorio);
        
       pp.add(pd, BorderLayout.CENTER);
       pp.add(pe, BorderLayout.NORTH);
       pp.add(pb, BorderLayout.SOUTH);
         
       add(pp);
       
       btnNovoPedido.addActionListener(new acaoBotao());
       btnRelatorio.addActionListener(new acaoBotao());
       btnAlteraPedido.addActionListener(new acaoBotao());
       btnExcluirPedido.addActionListener(new acaoBotao());
       btnFecharMesa.addActionListener(new acaoBotao());
       
       jltPedidos.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1){                    
                    btnExcluirPedido.setEnabled(true);
                    btnFecharMesa.setEnabled(true);
                    txtTotalComanda.setText("R$ " + calculadora());
                }
             } 
           
       
       });
       
       jltCardapio.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1){
                    btnAlteraPedido.setEnabled(true);
                    txtQnt.grabFocus();
                    Cardapio itemSelecionado = jltCardapio.getSelectedValue();                    
                    txtIdItem.setText(itemSelecionado.getCodigo() + ""); 
                    txtItem.setText(itemSelecionado.getNome()); 
                    txtPreco.setText(itemSelecionado.getPreco()+ "");
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
                            txtQnt.grabFocus();
                            jltCardapio.setSelectedIndex(i); 
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
                btnAlteraPedido.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Selecione a mesa e o item do cardápio.");
            }else if(e.getSource() == btnAlteraPedido){
               Pedido pedidoExistente = jltPedidos.getSelectedValue();
               Mesa mesaAtual = jltMesas.getSelectedValue();
               Pedido pedidoNovo;
               float valorTotal = 0;
               String numeroPedido  = String.valueOf(verificaUltimoPedido());
               if(pedidoExistente == null){
                 valorTotal = Float.parseFloat(txtQnt.getText()) * (Float.parseFloat(txtPreco.getText()));
                 pedidoNovo = new Pedido(numeroPedido,dataString, txtItem.getText(), valorTotal, mesaAtual.getNomeMesa());
                 lstPedido.add(pedidoNovo);
                   try {
                       gravacaoArqPedido(lstPedido);
                       gravacaoArqHistorico(lstPedido);
                       limpaCampos();
                       JOptionPane.showMessageDialog(null, "Item adicionado com sucesso a mesa " + mesaAtual.getId());
                       txtTotalComanda.setText("R$ " + calculadora());
                       jltPedidos.updateUI();
                   } catch (IOException ex) {
                       Logger.getLogger(JanelaTrabalhoEditada.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } 
               
            }else if(e.getSource() == btnExcluirPedido){
                 if (!jltPedidos.isSelectionEmpty()){ 
                    lstPedido.remove(jltPedidos.getSelectedValue());
                    txtTotalComanda.setText("R$ 0,00");
                    jltPedidos.updateUI();
                    jltPedidos.clearSelection();
                    limpaCampos();      
                }
                 
            }
            else if(e.getSource() == btnFecharMesa){
                float auxTotal = 0;
                if(!jltPedidos.isSelectionEmpty()){
                    Pedido pedidoAux = jltPedidos.getSelectedValue();
                    auxTotal = calculadora();
                    String mesa = pedidoAux.getMesa();
                    JOptionPane.showMessageDialog(null, mesa + "\nTotal: R$ " + auxTotal);
                    JOptionPane.showMessageDialog(null, "Mesa Fechada!");
                    lstPedido.remove(pedidoAux);
                    txtTotalComanda.setText("R$ 0,00");
                    jltPedidos.updateUI();
                 } 
            }
        }
        
        private float retornaPreco(Pedido aux){
            float auxPreco = 0;
            auxPreco = aux.getTotal();
            return auxPreco;
        }
        
        
        private int verificaUltimoPedido() {
            int aux = lstPedido.size();
            return aux+1;
        }
        
    }
    
    private float calculadora(){
        float auxTotal = 0;
        if(!jltPedidos.isSelectionEmpty()){
            Pedido pedidoAux = jltPedidos.getSelectedValue();
            for(int i = 0; i <lstPedido.size(); i++){
                if(lstPedido.get(i).getMesa().equals(pedidoAux.getMesa())){
                    auxTotal = auxTotal + lstPedido.get(i).getTotal();
                }              
            }
        }else if(!jltMesas.isSelectionEmpty()){
            Mesa mesaAux = jltMesas.getSelectedValue();
            for(int i = 0; i <lstPedido.size(); i++){
                if(lstPedido.get(i).getMesa().equals(mesaAux.getNomeMesa())){
                    auxTotal = auxTotal + lstPedido.get(i).getTotal();
                }              
            }
        }
        return auxTotal;
    }
    
    
    private void gravacaoArqPedido(List<Pedido> lstPedidos) throws IOException{
        File file = new File("pedidos.txt");
        file.delete();
        FileWriter arq = new FileWriter("pedidos.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
     
        for (int i=0; i < lstPedidos.size(); i++) {
            gravarArq.println(
                lstPedidos.get(i).getNumero() + "," + lstPedidos.get(i).getData() + "," + 
                lstPedidos.get(i).getTotal()+ "," + lstPedidos.get(i).getMesa() + "," + lstPedidos.get(i).getProduto()); 
        }
        arq.close();
    }
    
    private void gravacaoArqHistorico(List<Pedido> lstPedidos) throws IOException{
        FileWriter arq = new FileWriter("historico.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        float totalDiario = 0;
        for (int i=0; i < lstPedidos.size(); i++) {
            totalDiario += lstPedidos.get(i).getTotal();
            gravarArq.println(
                    "Total Acumulado: R$ " + "," + totalDiario + ", " + lstPedidos.get(i).getData()
            ); 
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
