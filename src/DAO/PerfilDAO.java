/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PerfilDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author thiag
 */
public class PerfilDAO {
    Connection conn;
    PreparedStatement psmv;
    PerfilDTO perfil = new PerfilDTO();
    public void Perfil(PerfilDAO perfildao){
        String sql = "select Cpf, Nome, Sobrenome, Endereco from pessoa_fisica WHERE =" + perfil.getCpf() + "";
        
    }
}
        
