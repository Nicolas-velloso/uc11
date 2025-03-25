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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
         JOptionPane.showMessageDialog(null, "Erro ao cadatrar os daods");
            
        }
        
    
        
    }
    
    public List<ProdutosDTO> listar(){
        conn = new conectaDAO().connectDB();
       List<ProdutosDTO> lista = new ArrayList<>(); // Garante que a lista nunca será nula

    try {
        if (conn == null) {
            System.out.println(" Conexão com o banco de dados é nula.");
            return lista; // Retorna lista vazia em vez de `null`
        }

        String sql = "SELECT * FROM produtos ";
       st = conn.prepareStatement(sql);
        resultset  = st.executeQuery();

        while (resultset .next()) {
            ProdutosDTO p = new ProdutosDTO();
            p.setId(resultset .getInt("id"));
            p.setNome(resultset .getString("nome"));
            p.setValor(resultset .getInt("valor"));
            p.setStatus(resultset.getString("status"));
            lista.add(p);
        }

       
    } catch (SQLException e) {
        System.out.println( e.getMessage());
    }

    return lista; // Retorna lista vazia se der erro, evitando `null`
}

    
    public void venderProduto(int id){
              conn = new conectaDAO().connectDB();
       

    try {
        if (conn == null) {
            System.out.println(" Conexão com o banco de dados é nula.");
       
        }

        st= conn.prepareStatement("UPDATE produtos set status='Vendido' where id=?");
        st.setInt(1, id);
        st.executeUpdate();
     
    }
     catch (SQLException e) {
        System.out.println( e.getMessage());
    }
    
    
        
<<<<<<< HEAD
}}
=======
<<<<<<< HEAD
}}
=======
}
    
    
}
>>>>>>> 54a8145 (Tela de vendas adicionada)
>>>>>>> 62f4c2a (Tela de vendas adicionada)

