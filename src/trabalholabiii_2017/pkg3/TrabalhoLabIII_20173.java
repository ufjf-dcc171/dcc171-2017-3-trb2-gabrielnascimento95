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
            JanelaTrabalhoEditada janela = new JanelaTrabalhoEditada(leCardapio(), lePedido(), leMesas());
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
    
    public static ArrayList<Comanda> leComanda(List<Cardapio> cardapio) throws FileNotFoundException, IOException {
        ArrayList<Comanda> lstComanda = new ArrayList<>();
        FileReader arq = new FileReader("comanda.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); 
        while (linha != null) {
            String[] tag = linha.split(",");
            String numPedido =  tag[0];
            String codCardapio =  tag[1];
            Integer qnt = Integer.parseInt(tag[2]);
            Float preco = Float.parseFloat(tag[3]);
            Float precoF = Float.parseFloat(tag[4]);
            Cardapio produtoPedido = null;
            for (int i = 0; i < cardapio.size(); i++) {
                if (cardapio.get(i).getCodigo() == Integer.parseInt(codCardapio)){
                    produtoPedido = cardapio.get(i);
                }                
            }         
            Comanda aux = new Comanda(produtoPedido, qnt, preco, precoF);
            aux.setIdPedido(numPedido);
            lstComanda.add(aux);
            linha = lerArq.readLine(); 
        }
        return lstComanda;
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
