
package DAO;

import DTO.CadastrarJuridicaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CadastrarJuridicaDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void CadastrarJuridica(CadastrarJuridicaDTO cadastrarjdto){
        String sql = 
        " insert into pessoa_juridica (Razao_social, Nome_fantasia, Endereco, Numero, Telefone, Cnpj, Senha)values (?,?,?,?,?,?,?)";
        
        conn = new ConexaoDAO().Conexao();
        
        try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, cadastrarjdto.getNomeEmpresa());
                pstm.setString(2, cadastrarjdto.getNomeFantasia());
                pstm.setString(3, cadastrarjdto.getEndereco());
                pstm.setString(4, cadastrarjdto.getNumero());
                pstm.setString(5, cadastrarjdto.getTelefone());
                pstm.setString(6, cadastrarjdto.getCnpj());
                pstm.setString(7, cadastrarjdto.getSenha());
                
                pstm.execute();
                pstm.close();
                
        } catch (Exception e) {
        }
       
    }
    
}
