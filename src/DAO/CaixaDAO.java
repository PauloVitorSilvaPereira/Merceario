/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author pvito
 */
public class CaixaDAO {
    
    public void cadastrarVenda(String dataDeCompra, Double valor, int idFuncionario) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String sql = "INSERT INTO vendas (dataDeCompra, valorTotal, funcionarios_id) VALUES (?, ?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dataDeCompra);
        stmt.setDouble(2, valor);
        stmt.setInt(3, idFuncionario);

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionario: " + e.getMessage());
    }
}
    
    public void atualizarEstoque(String idsTexto, String quantidadesTexto) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String[] ids = idsTexto.split(",");
    String[] quantidades = quantidadesTexto.split(",");

    if (ids.length != quantidades.length) {
        JOptionPane.showMessageDialog(null, "A quantidade de IDs e a quantidade de produtos não é igual.");
        return;
    }

    try {
        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i].trim());
            int quantidadeVendida = Integer.parseInt(quantidades[i].trim());

            
            String sql = "UPDATE produtos SET estoque = estoque - ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantidadeVendida);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque: " + e.getMessage());
    }
}
}
