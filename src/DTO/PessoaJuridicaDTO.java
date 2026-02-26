
package DTO;


public class PessoaJuridicaDTO {
    
    private String nomeEmpresa;
    private String nomeFantasia;
    private String endereco;
    private String numero;
    private String telefone;
    private static String cnpj;
    private String senha;
    private static int num_conta;
    private static int num_agencia;
    

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
      this.num_conta = num_conta;
    }

    public int getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(int num_agencia) {
        this.num_agencia = num_agencia;
    }

    
    
    
   
    
}
