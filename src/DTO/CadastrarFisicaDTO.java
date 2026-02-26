package DTO;


public class CadastrarFisicaDTO {

    private String nome;
    private String sobrenome;
    private String endereco;
    private String numero;  
    private String telefone;
    private String dataNascimento;
    private String cpf;
    private String senha;
    private static int conta;
    
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getSobrenome(){
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getDatanascimento(){
        return dataNascimento;
    }
    
    public void setDatanascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    public boolean next() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
}
