package DTO;


public class ClienteFisicaDTO {
    private String id;
    private static String cpf_usuario;
    private String senha_usuario;
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getCpf_usuario(){
        return cpf_usuario;
    }
    
    public void setCpf_usuario(String cpf_usuario){
        this.cpf_usuario = cpf_usuario;
    }
    
    public String senha_usuario(){
        return senha_usuario;
    }
    
    public void setSenha_usuario(String senha_usuario){
        this.senha_usuario = senha_usuario;
    }
        
        
}
