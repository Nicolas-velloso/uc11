/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO pro){
        
        
        conn = new conectaDAO().connectDB();
        
      
        try{
            st=conn.prepareStatement("INSERT INTO produtos (nome,valor,status) VALUES(?,?,?)");
            st.setString(1,pro.getNome());
            st.setInt(2, pro.getValor());
            st.setString(3, pro.getStatus());
            st.executeUpdate();
           JOptionPane.showMessageDialog(null, "Dados cadatros com sucesso");
        }catch ( Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            
        }
        
    
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

