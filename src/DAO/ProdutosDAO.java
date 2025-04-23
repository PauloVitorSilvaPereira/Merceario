/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import pi.etapa1.models.Produtos;

/**
 *
 * @author pvito
 */
public class ProdutosDAO { 
    
    public void cadastrarProdutos(Produtos produtos) {
    ConectaDAO conecta = new ConectaDAO();
    Connection conn = conecta.connectDB();

    String sql = "INSERT INTO produtos (nome, dataDeVencimento, peso, marca, fornecedor, estoque, valor) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, produtos.getNome());
        stmt.setString(2, produtos.getDataDeVencimento());
        stmt.setString(3, produtos.getPeso());
        stmt.setString(4, produtos.getMarca());
        stmt.setString(5, produtos.getFornecedor());
        stmt.setInt(6, produtos.getEstoque());
        stmt.setDouble(7, produtos.getValor());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cargo: " + e.getMessage());
    }
}
}
