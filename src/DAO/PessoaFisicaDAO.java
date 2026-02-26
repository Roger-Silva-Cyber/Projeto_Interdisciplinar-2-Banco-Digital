
package DAO;

import DTO.PessoaFisicaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;



public class PessoaFisicaDAO {

    Connection conn;
    PreparedStatement pstm; 
    ResultSet rs;
    ArrayList<PessoaFisicaDTO> lista = new ArrayList<>();
        
    public static void gerarContaAgencia(PessoaFisicaDTO cadastrardto){
        // Gerador de numero aleatório para Conta
        Random random = new Random();
        int contaAleatorio = random.nextInt(999999) + 100000;
        
        // Gerado de numero aleatório para Agência
        Random ran = new Random();
        int agenciaAleatorio = ran.nextInt(9999) + 1000;
        int conta = contaAleatorio;
        int agencia = agenciaAleatorio;
        cadastrardto.setConta(conta);
        cadastrardto.setAgencia(agencia);
      }

        // Método para cadastrar uma pessoa fisica
        public void cadastrarFisicaConta(PessoaFisicaDTO cadastrardto){
        conn = new ConexaoDAO().Conexao();
        String sql = 
                "insert into pessoa_fisica (Nome, Sobrenome, Endereco, "
                + "Numero, Telefone, Data_Nascimento, Cpf, Senha, Numero_conta, Agencia) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        String sqlConta = "Insert into conta (Cpf_titular, Numero_conta, Agencia, Saldo)"
                + "values (?,?,?, 0.0)";
        
        gerarContaAgencia(cadastrardto);
       
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastrardto.getNome());
            pstm.setString(2, cadastrardto.getSobrenome());
            pstm.setString(3, cadastrardto.getEndereco());
            pstm.setString(4, cadastrardto.getNumero());
            pstm.setString(5, cadastrardto.getTelefone());
            pstm.setString(6, cadastrardto.getDatanascimento());
            pstm.setString(7, cadastrardto.getCpf());
            pstm.setString(8, cadastrardto.getSenha());           
            pstm.setInt(9, cadastrardto.getConta());
            pstm.setInt(10, cadastrardto.getAgencia());
            
            
            pstm.execute();
            pstm.close();
            
            PreparedStatement pstmConta = conn.prepareStatement(sqlConta);
            pstmConta.setString(1, cadastrardto.getCpf());
            pstmConta.setInt(2, cadastrardto.getConta());
            pstmConta.setInt(3, cadastrardto.getAgencia());
            
            pstmConta.execute();
            pstmConta.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CadastrarFisicaDAO: " + e);
        }
        
        
    }
    

    
        // Método para autenticar um usuario com base no CPF e SENHA
    public ResultSet autenticacaoUsuario(PessoaFisicaDTO cadastradto){
        conn = new ConexaoDAO().Conexao();
        
        try{
            String sql = "select * from pessoa_fisica where Cpf = ? and Senha = ?";
            // O PreparedStatement prepara a conexão.
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastradto.getCpf());
            pstm.setString(2,cadastradto.getSenha());
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ClienteFisicaDAO: " + e);
            return null;
        }
}
        // Método para buscar informações de uma pessoa fisica por cpf
    public PessoaFisicaDTO BuscarPorCpf(){
        conn = new ConexaoDAO().Conexao();
        PessoaFisicaDTO cadastrarFisica =  new PessoaFisicaDTO();
        String sql = "Select * from pessoa_fisica where Cpf = " + cadastrarFisica.getCpf();
        
        try {
            pstm =  conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                cadastrarFisica.setNome(rs.getString("Nome"));
                cadastrarFisica.setSobrenome(rs.getString("Sobrenome"));
                cadastrarFisica.setCpf(rs.getString("Cpf"));
                cadastrarFisica.setConta(rs.getInt("Numero_conta"));
                cadastrarFisica.setAgencia(rs.getInt("Agencia"));
                return cadastrarFisica;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BuscarPorCpf " + e);
        }
        
        return null;
    }
    
      
    public String Depositar(PessoaFisicaDTO cadastradto){
        conn = new ConexaoDAO().Conexao();
        String sql = "Update conta SET Saldo = ?  WHERE Cpf_titular = ?";
        
        try {
            
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastradto.getSaldo());
            pstm.setString(2, cadastradto.getCpf_titular());
           
            pstm.execute();
            pstm.close();
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Depositar " + e);
        }
        return null;
        
    }
       // Método para verificar se um CPF existe na tabela
        public boolean verficarCpf(PessoaFisicaDTO cadastradto){
        conn = new ConexaoDAO().Conexao();
        String sql = "Select Cpf_titular from conta WHERE Cpf_titular = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastradto.getCpf_titular());
            return pstm.executeQuery().next();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "verificarCpf " + e);
        }
        return false;
    }

    // Método para verificar o saldo da tabela pra fazer um novo depósito
    public String verificarSaldoParaDeposito(PessoaFisicaDTO cadastradto){
    conn = new ConexaoDAO().Conexao();
    String sql = "Select Saldo FROM conta WHERE Cpf_titular = ?";
     
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastradto.getCpf_titular());
            String saldo = null; // variavel para armazenar o saldo
           rs = pstm.executeQuery();
           
           if (rs.next()) {
            saldo = rs.getString("saldo");
        }

        rs.close();
        pstm.close();

           
        return saldo;    
        
        } catch (Exception e) {
            
           JOptionPane.showMessageDialog(null, "verificarCpf " + e);
        }
        return null;
    
    }
    
    
    
    public void realizarPix(){
    
    PessoaFisicaDTO objpdto = new PessoaFisicaDTO();
    String sqlAtualizacao = "UPDATE conta SET Saldo = CASE WHEN Cpf_titular = ? THEN Saldo - ? WHEN Cpf_titular = ? THEN Saldo + ? ELSE Saldo END WHERE Cpf_titular IN (?,?);";
    
    String consultaSaldo = "Select Saldo From conta Where Cpf_titular = ?";
    
    conn = new ConexaoDAO().Conexao();
    
        try {
            pstm = conn.prepareStatement(consultaSaldo);
            pstm.setString(1, objpdto.getCpf());
            pstm.execute();
            
            ResultSet resultadoConsulta = pstm.executeQuery();
            float saldo = 0.0f;
            if(resultadoConsulta.next()){
                saldo = resultadoConsulta.getFloat("Saldo");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao consultar o saldo");
            }
            resultadoConsulta.close();
            
            float valorPix = objpdto.getValorPix();
            
            // Verifica se o saldo é menor ou igual ao investimento
            if(saldo >= valorPix){
                
                
                pstm = conn.prepareStatement(sqlAtualizacao);
                pstm.setString(1, objpdto.getCpf());
                pstm.setFloat(2, valorPix);
                
                pstm.setString(3, objpdto.getCpf_titular());
                pstm.setFloat(4, valorPix);
                
                pstm.setString(5, objpdto.getCpf());
                pstm.setString(6, objpdto.getCpf_titular());
                pstm.execute();
                pstm.close();
                
                conn.close();
                ImprimeBDPIX(objpdto);
                JOptionPane.showMessageDialog(null, "Pix realizado com sucesso");
                
            }else{
                JOptionPane.showMessageDialog(null, "Saldo Insuficiente ");
            }
            
        } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null, "realizarPixDAO " + e);
        }
    
        
    }
    
    public void ImprimeBDPIX(PessoaFisicaDTO objPessoaFisicaDTO){
        String sqlArmazena = "INSERT INTO `transferencia` (Tipo_T, CertP_R, valor, "
                + "CertP_D, Data_T) VALUES (?, ?, ?, ?, ? );";
        conn = new ConexaoDAO().Conexao();
        RegistraData();
        try{
            PreparedStatement pstmArmazenaDados = conn.prepareStatement(sqlArmazena);
            pstmArmazenaDados.setString(1, "PIX");
            pstmArmazenaDados.setString(2, objPessoaFisicaDTO.getCpf());                
            pstmArmazenaDados.setFloat(3, objPessoaFisicaDTO.getValorPix());
            pstmArmazenaDados.setString(4, objPessoaFisicaDTO.getCpf_titular());
            pstmArmazenaDados.setString(5, objPessoaFisicaDTO.getData_System());

            pstmArmazenaDados.execute();
            pstmArmazenaDados.close();
            
            System.out.println(objPessoaFisicaDTO.getData_System());
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar dados: " + erro.getMessage());
        }
    }
    
     public ArrayList<PessoaFisicaDTO> HistoricoPIX(String cpf){ 
        conn = new ConexaoDAO().Conexao();
        String sql = "SELECT * FROM transferencia WHERE CertP_R =" + cpf + " AND Tipo_T = 'PIX' ";
        try{        
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                PessoaFisicaDTO pessoaDTO = new PessoaFisicaDTO();
                pessoaDTO.setCpfPixTabela(rs.getString("CertP_R"));
                pessoaDTO.setValorPixTabela(rs.getFloat("valor"));
                pessoaDTO.setCpfPixDestTabela(rs.getString("CertP_D"));
                pessoaDTO.setDataPixTabela(rs.getString("Data_T"));                
                lista.add(pessoaDTO);
                System.out.println(pessoaDTO.getCpfPixTabela() + " / " +
                         pessoaDTO.getCpfPixDestTabela()+ " / " +  pessoaDTO.getDataPixTabela());
            }
        }catch(SQLException erro){            
            JOptionPane.showMessageDialog(null, "Erro pesquisar Historico" + erro);
        }
        return lista;
    }
    
    public void realizarTedDoc(PessoaFisicaDTO cadastrardto) {
        
        String sqlAtualizacao = "UPDATE conta SET Saldo = CASE WHEN Cpf_titular = ? THEN Saldo - ? WHEN Numero_conta = ? and Agencia = ? THEN Saldo + ? ELSE Saldo END WHERE Cpf_titular IN (?) OR (Numero_conta = ? AND Agencia = ?)";
        String consultarSaldo = "Select Saldo FROM conta WHERE Cpf_titular = ?";
        PessoaFisicaDTO objpdto = new PessoaFisicaDTO();
       
        conn = new ConexaoDAO().Conexao();
        
        try {
            pstm = conn.prepareStatement(consultarSaldo);
            pstm.setString(1, objpdto.getCpf());
            pstm.execute();
            
            ResultSet resultadoConsulta = pstm.executeQuery();
            float saldo = 0f;
            if(resultadoConsulta.next()){
                saldo = resultadoConsulta.getFloat("Saldo");
                
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao consultar o saldo");
                }
            resultadoConsulta.close();
            pstm.close();
            float valorTed_Doc = objpdto.getValorTed_Doc();
            
            if(saldo >= valorTed_Doc){
                
                pstm = conn.prepareStatement(sqlAtualizacao);
                pstm.setString(1, objpdto.getCpf());
                pstm.setFloat(2, valorTed_Doc);
                
                pstm.setInt(3, objpdto.getConta());
                pstm.setInt(4, objpdto.getAgencia());
                pstm.setFloat(5, valorTed_Doc);
                
                pstm.setString(6, objpdto.getCpf());
                pstm.setInt(7, objpdto.getConta());
                pstm.setInt(8, objpdto.getAgencia());
                
                pstm.execute();
                pstm.close();
                
                System.out.println("Conta " + objpdto.getConta());
                System.out.println("Agencia " + objpdto.getAgencia());
                System.out.println("ValorTed " + objpdto.getValorTed_Doc());
                
                JOptionPane.showMessageDialog(null, "Ted/Doc realizado com sucesso ");
            }else{
                JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
            }
            
           
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "realizarTed_DocDAO " + e);
        }
    }
    
    public void RegistraData (){
        
        PessoaFisicaDTO pessoaDTO = new PessoaFisicaDTO();
        
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        //Formata a data pra ser recebida no banco de dados
        String dataFormatadaString = now.format(dataFormatada);
        
        pessoaDTO.setData_System(dataFormatadaString);
        pessoaDTO.setData_transferencia(dataFormatadaString);
                
    }
}