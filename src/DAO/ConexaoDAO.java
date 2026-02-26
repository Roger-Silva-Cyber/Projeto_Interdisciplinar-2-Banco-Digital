package DAO;



import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;   

/**
 *
 * @author thiag
 */
public class ConexaoDAO {

    public Connection Conexao() {   
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/finup";
            String user = "root";
            String password = "root";
            
            conn = DriverManager.getConnection(url, user, password);
            
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ConexaoDAO: " + e.getMessage());
        }  
        return conn;
       
    }
  
    public static void main(String[] args) {
        ConexaoDAO telaMenu = new ConexaoDAO();
        
        telaMenu.Conexao();
        
        
    }
    
}
