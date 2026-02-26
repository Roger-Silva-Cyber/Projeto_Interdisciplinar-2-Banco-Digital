    package DAO;

import DTO.ClienteFisicaDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author thiag
 */
public class ClienteFisicaDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsuario(ClienteFisicaDTO cliente){
        conn = new ConexaoDAO().Conexao();
        
        try{
            String sql = "select * from pessoa_fisica where Cpf = ? and Senha = ?";
            // O PreparedStatement prepara a conexão.
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cliente.getCpf_usuario());
            pstm.setString(2,cliente.senha_usuario());
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ClienteFisicaDAO: " + e);
            return null;
        }
    }
}
