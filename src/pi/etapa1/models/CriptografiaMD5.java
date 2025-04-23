package pi.etapa1.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaMD5 {
    public static String criptografar(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mensagemDigest = md.digest(senha.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : mensagemDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar senha MD5", e);
        }
    }
}
