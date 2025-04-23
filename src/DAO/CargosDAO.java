/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pi.etapa1.models.Cargos;
import pi.etapa1.models.CriptografiaMD5;

/**
 *
 * @author pvito
 */
public class CargosDAO {
    
    public void cadastrarCargo(Cargos cargo) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String sql = "INSERT INTO cargos (cargo, descricao, salario) VALUES (?, ?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cargo.getCargo());
        stmt.setString(2, cargo.getDescricao());
        stmt.setDouble(3, cargo.getSalario());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cargo: " + e.getMessage());
    }
}
}
