package DAO;


import Telas.FuncionariosView;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import pi.etapa1.models.Cargos;
import pi.etapa1.models.CriptografiaMD5;

public class LoginDAO {
    
    
    public boolean autenticarFuncionario(String login, String senha) {
        ConectaDAO conecta = new ConectaDAO();
        Connection conn = conecta.connectDB();
        

        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, CriptografiaMD5.criptografar(senha));
            
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }
    
    public int idUsuario(String login){
        ConectaDAO conecta = new ConectaDAO();
        Connection conn = conecta.connectDB();
        

        String sql = "SELECT * FROM usuarios WHERE login = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            
            ResultSet rs = stmt.executeQuery();
            
            int idDoUsuario = rs.getInt("id");
            
            return idDoUsuario;
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao identificar o id do usuário: " + e.getMessage());
            return 0;
        }
    }
    
    public int idCargo(int idDoUsuario){
        ConectaDAO conecta = new ConectaDAO();
        Connection conn = conecta.connectDB();
        

        String sql = "SELECT * FROM funcionarios WHERE usuarios_id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idDoUsuario);
            
            ResultSet rs = stmt.executeQuery();
            
            int idDoCargo = rs.getInt("cargos_id");
            
            return idDoCargo;
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao identificar o id do cargo do funcionário: " + e.getMessage());
            return 0;
        }
    }
    
    public String cargoDoFuncionario(int idDoCargo){
        ConectaDAO conecta = new ConectaDAO();
        Connection conn = conecta.connectDB();
        

        String sql = "SELECT * FROM cargos WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idDoCargo);
            
            ResultSet rs = stmt.executeQuery();
            
            return rs.getString("cargo");
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao identificar o id do cargo do funcionário: " + e.getMessage());
            return "";
        }
    }
}
