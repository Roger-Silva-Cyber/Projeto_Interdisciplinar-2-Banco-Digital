
package DAO;

import DTO.ClienteJuridicaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteJuridicaDAO {
    Connection conn;
    
    public ResultSet autenticacaoJuridica(ClienteJuridicaDTO clientedto){
        conn = new ConexaoDAO().Conexao();
        
        try {
             String sql = "select * from pessoa_juridica where Cnpj = ? and Senha = ?";
            // O PreparedStatement prepara a conexão.
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, clientedto.getCnpj());
            pstm.setString(2,clientedto.getSenha());
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteJuridicaDAO " + e);
            return null;
        }
    }
}
