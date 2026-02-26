package DTO;

import java.time.LocalDate;


public class PessoaFisicaDTO {

    private String nome;
    private String sobrenome;
    private String endereco;
    private String numero;  
    private String telefone;
    private String dataNascimento;
    private static String cpf; // Tabela pessoa_fisica
    private static String cpf_titular; // Tabela conta
    private static String cpf_r; // Tabela transferencia referente ao remetente
    private static String cpf_d; // Tabela transferencia referente ao destinatario
    private String senha; 
    private static int conta;
    private static int agencia;
    private static String saldo; 
    private static float valorPix;
    private static float valorTed_Doc;
    private LocalDate data_abertura;
    private static String data_transferencia;
    private static String data_System;
    private static String tipo_transferencia;
    ////
    private float valorPixTabela;
    private String cpfPixTabela;
    private String cpfPixDestTabela;
    private String dataPixTabela;
    
    
    
    
    
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
    
    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
       
        return agencia;
        
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public LocalDate getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(LocalDate data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getCpf_titular() {
        return cpf_titular;
    }

    public void setCpf_titular(String cpf_titular) {
        this.cpf_titular = cpf_titular;
    }
    
    public float getValorPix() {
        return valorPix;
    }

    public void setValorPix(float valorPix) {
        this.valorPix = valorPix;
    }

    public String getTipo_transferencia() {
        return tipo_transferencia;
    }

    public void setTipo_transferencia(String aTipo_transferencia) {
        tipo_transferencia = aTipo_transferencia;
    }

    public static String getCpf_r() {
        return cpf_r;
    }

    public static void setCpf_r(String aCpf_r) {
        cpf_r = aCpf_r;
    }

    public static String getCpf_d() {
        return cpf_d;
    }

    public static void setCpf_d(String aCpf_d) {
        cpf_d = aCpf_d;
    }

    public int setConta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public float getValorTed_Doc() {
        return valorTed_Doc;
    }

    public void setValorTed_Doc(float valorTed_Doc) {
        this.valorTed_Doc = valorTed_Doc;
    }

    public static String getData_transferencia() {
        return data_transferencia;
    }

    public static void setData_transferencia(String aData_transferencia) {
        data_transferencia = aData_transferencia;
    }

    public static String getData_System() {
        return data_System;
    }

    public static void setData_System(String aData_System) {
        data_System = aData_System;
    }

    public float getValorPixTabela() {
        return valorPixTabela;
    }

    public void setValorPixTabela(float valorPixTabela) {
        this.valorPixTabela = valorPixTabela;
    }

    public String getCpfPixTabela() {
        return cpfPixTabela;
    }

    public void setCpfPixTabela(String cpfPixTabela) {
        this.cpfPixTabela = cpfPixTabela;
    }

    public String getCpfPixDestTabela() {
        return cpfPixDestTabela;
    }

    public void setCpfPixDestTabela(String cpfPixDestTabela) {
        this.cpfPixDestTabela = cpfPixDestTabela;
    }

    public String getDataPixTabela() {
        return dataPixTabela;
    }

    public void setDataPixTabela(String dataPixTabela) {
        this.dataPixTabela = dataPixTabela;
    }

}
