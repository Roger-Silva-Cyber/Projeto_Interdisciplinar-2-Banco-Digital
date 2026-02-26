package br.com.finup.banco.Model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)

    private String nomeCompleto;

    private String email;

    private String cpf;

    private String telefone;

    private LocalDate dataNascimento;
    
    private String agencia;
    private String conta;
    
    private String username;

    private String password;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public  String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }  

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }  

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }
    // Em cima é Agencia e em baixo é Conta 
    public String getConta() { return conta; }
    public void setConta(String conta) { this.conta = conta; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
}