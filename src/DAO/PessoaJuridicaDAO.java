
package DAO;

import DTO.PessoaJuridicaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;

public class PessoaJuridicaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void CadastrarJuridica(PessoaJuridicaDTO cadastrarjdto){
        String sql = 
        " insert into pessoa_juridica (Razao_social, Nome_fantasia, Endereco, Numero, Telefone, Cnpj, "
                + "Senha, Numero_conta, Agencia)"
                + "values (?,?,?,?,?,?,?,?,?)";
        
        conn = new ConexaoDAO().Conexao();
        
        
         GerarConta();
        
        PessoaJuridicaDTO objJDTO = new PessoaJuridicaDTO();
        
        int[] numeroConta = GerarConta();
        
        int contaGerada = numeroConta[0];
        
        objJDTO.setNum_conta(contaGerada);
        
        GerarAge();
        
        int[] numeroAgencia = GerarAge();
        int agenciaGerada = numeroAgencia[0];
        objJDTO.setNum_agencia(agenciaGerada);
        
        try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, cadastrarjdto.getNomeEmpresa());
                pstm.setString(2, cadastrarjdto.getNomeFantasia());
                pstm.setString(3, cadastrarjdto.getEndereco());
                pstm.setString(4, cadastrarjdto.getNumero());
                pstm.setString(5, cadastrarjdto.getTelefone());
                pstm.setString(6, cadastrarjdto.getCnpj());
                pstm.setString(7, cadastrarjdto.getSenha());
                pstm.setInt(8, contaGerada);
                pstm.setInt(9, agenciaGerada);  
                
                pstm.execute();
                pstm.close();
                
        } catch (Exception e) {
        }
        
       
       
    }
    
     public int[] GerarConta(){
        Random random = new Random();
        var conta = 100000+ random.nextInt(900000);
        
        int[] numeroConta = {conta};
        return numeroConta;
    }
    
    public int[] GerarAge(){
        Random random = new Random();
        var agencia = 1000 + random.nextInt(9999);
        
        int [] numeroAgencia = {agencia};
        return numeroAgencia;
        
    } 
    
    public ResultSet autenticacaoJuridica(PessoaJuridicaDTO cjdto){
        conn = new ConexaoDAO().Conexao();
        
        try {
             String sql = "select * from pessoa_juridica where Cnpj = ? and Senha = ?";
            // O PreparedStatement prepara a conexão.
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cjdto.getCnpj());
            pstm.setString(2,cjdto.getSenha());
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteJuridicaDAO " + e);
            return null;
        }
    }
    
    public PessoaJuridicaDTO BuscarPorCnpj(){
           
        conn =  new ConexaoDAO().Conexao();
        PessoaJuridicaDTO objdto = new PessoaJuridicaDTO();
        String sql = "Select * from pessoa_juridica where Cnpj = " + objdto.getCnpj();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                objdto.setNomeEmpresa(rs.getString("Razao_social"));
                objdto.setNomeFantasia(rs.getString("Nome_fantasia"));
                objdto.setCnpj(rs.getString("Cnpj"));
                objdto.setNum_conta(rs.getInt("Numero_conta"));
                objdto.setNum_agencia(rs.getInt("Agencia"));
                return objdto;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BuscarPorCnpj " + e);
        }
        return null;
    
    }
        
        
}
    

