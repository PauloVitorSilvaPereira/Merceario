/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import pi.etapa1.models.Entregas;

/**
 *
 * @author pvito
 */
public class EntregasDAO {
    
    public void cadastrarCliente(Entregas entregas) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String sql = "INSERT INTO entregas (nomeCliente, ruaCliente, numeroCliente, bairroCliente, telefoneCliente) VALUES (?, ?, ?, ?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, entregas.getNome());
        stmt.setString(2, entregas.getRua());
        stmt.setInt(3, entregas.getNumeroDaCasa());
        stmt.setString(4, entregas.getBairro());
        stmt.setString(5, entregas.getTelefone());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cargo: " + e.getMessage());
    }
}
}
