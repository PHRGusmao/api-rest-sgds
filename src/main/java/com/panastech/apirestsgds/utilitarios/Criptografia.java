package com.panastech.apirestsgds.utilitarios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public String cripto(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(senha.getBytes());
            BigInteger hash = new BigInteger(1, digest);
            return hash.toString(16); // Converte para uma representação hexadecimal
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo de criptografia não suportado", e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }
}
