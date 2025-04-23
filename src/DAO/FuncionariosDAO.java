/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import pi.etapa1.models.CriptografiaMD5;
import pi.etapa1.models.Funcionarios;

/**
 *
 * @author pvito
 */
public class FuncionariosDAO {
    
    public void cadastrarFuncionarios(Funcionarios funcionarios) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String sql = "INSERT INTO funcionarios (nome, cpf, telefone) VALUES (?, ?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, funcionarios.getNome());
        stmt.setString(2, funcionarios.getCpf());
        stmt.setString(3, funcionarios.getTelefone());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionario: " + e.getMessage());
    }
}
    
    public void cadastrarUsuario(String login, String senha) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, CriptografiaMD5.criptografar(senha));

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionario: " + e.getMessage());
    }
}
}
