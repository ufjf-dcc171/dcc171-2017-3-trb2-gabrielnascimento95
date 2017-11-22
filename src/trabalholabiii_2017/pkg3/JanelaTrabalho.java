/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel_Nascimento
 */
public class JanelaTrabalho extends JFrame{
    
    private ArrayList<Cardapio> lstCardapio; 
    private ArrayList<Mesa> lstMesa; 
    private ArrayList<Pedido> lstPedido;
    private ArrayList<Comanda> lstComanda;
    
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
    
    private JComboBox cbListaMesa = new JComboBox(); 
    
    private final JTextField txtIdItem = new JTextField();
    private final JTextField txtItem = new JTextField();
    private final JLabel lblItem = new JLabel("Item");    
    private final JTextField txxPreco = new JTextField();
    private final JLabel lblPreco = new JLabel("Preço");    
    private final JTextField txtQnt = new JTextField();
    private final JLabel lblQnt = new JLabel("Quantidade");    
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
    
    private boolean achouMesa = false;
    private boolean vNovoPedido = false;
    private boolean vNovoProduto = false;
    private Date dataAtaual;

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
        pc.setLayout(new GridLayout(10, 1));
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
       txtTotalComanda.setEditable(false);
       pc.add(cbListaMesa);
       btnFecharMesa.setEnabled(false);    
       pc.add(lblItem);
       pc.add(txtItem);
       pc.add(lblPreco);
       pc.add(txxPreco);
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
        
       pdb.add(new JScrollPane(jltComanda), BorderLayout.NORTH);
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
    
    }

    private static class acaoBotao implements ActionListener {

        public acaoBotao() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
   
    
    
    

}
