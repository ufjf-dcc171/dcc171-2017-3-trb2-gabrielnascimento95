/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author gabrielsantos
 */
public class TrabalhoLabIII_20173 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            JanelaTrabalhoEditada janela = new JanelaTrabalhoEditada(leHistorico(), leCardapio(), lePedido(), leMesas());
            janela.setSize(600, 650);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
            
            /*
            for(int i=0; i < lePedido(leMesas(), leComanda(leCardapio())).size() ; i++){
            System.out.println(lePedido(leMesas(), leComanda(leCardapio())).get(i).toString());
            }
            */
        } catch (IOException ex) {
            Logger.getLogger(TrabalhoLabIII_20173.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<Historico> leHistorico() throws FileNotFoundException, IOException {
        ArrayList<Historico> lstHistorico = new ArrayList<>();
        FileReader arq = new FileReader("historico.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); 
        while (linha != null) {
            String[] tag = linha.split(",");
            String info =  tag[0];
            Float total = Float.parseFloat(tag[1]);
            String data = tag[2];
            String id = tag[3];
            Historico history = new Historico(total, data, id);
            lstHistorico.add(history);
            linha = lerArq.readLine(); 
        }
        return lstHistorico;
    }
    
     public static ArrayList<Cardapio> leCardapio() throws FileNotFoundException, IOException {
        ArrayList<Cardapio> lstProdutos = new ArrayList<>();
        
        FileReader arq = new FileReader("cardapio.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); 
        while (linha != null) {
            String[] tag = linha.split(",");
            Integer cod =  Integer.parseInt(tag[0]);
            String  nome = tag[1];
            String preco = tag[2];
            
            float vlrUnitProd = Float.parseFloat(preco);
            
            Cardapio produto = new Cardapio(cod, nome, vlrUnitProd);
            lstProdutos.add(produto);
            linha = lerArq.readLine(); 
        }

        return lstProdutos;
    }
     
    public static ArrayList<Pedido> lePedido() throws FileNotFoundException, IOException {
        ArrayList<Pedido> lstPedido = new ArrayList<>();
        Pedido pedidoLista;
        FileReader arq = new FileReader("pedidos.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine();
        while (linha != null) {
            String[] tag = linha.split(",");
            String id =  tag[0];
            String data = tag[1];
            Float total = Float.parseFloat(tag[2]);
            String mesa = tag[3];
            String prod = tag[4];
            pedidoLista = new Pedido(id,data,prod,total,mesa); 
            lstPedido.add(pedidoLista);
            linha = lerArq.readLine(); 
        }
        return lstPedido;
    }
    
    public static ArrayList<Mesa> leMesas() throws FileNotFoundException, IOException {
        ArrayList<Mesa> lstMesa = new ArrayList<>(); 
        
        FileReader arq = new FileReader("testeMesa.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); 
        while (linha != null) {
            String[] tag = linha.split(",");
            Integer id =  Integer.parseInt(tag[0]);
            String  nome = tag[1];
            
            Mesa mesa = new Mesa(id, nome);
            lstMesa.add(mesa);
            linha = lerArq.readLine(); 
        }
        return lstMesa;
    }

}
