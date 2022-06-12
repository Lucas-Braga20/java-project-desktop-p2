/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.restaurante.app.util;

import br.unigran.restaurante.app.models.Funcionario;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Lucas
 */
public class Util {
    private static Funcionario logado;
    
    public static Funcionario getLogado() {
        return logado;
    }
    
    public static void setLogado(Funcionario logado) {
        Util.logado = logado;
    }
    
    public static String geraSenha(char[] password) throws NoSuchAlgorithmException {
        String senha = "";
        for (char c : password) {
            senha += c;
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes(Charset.forName("UTF-8")));
        byte[] digest = md.digest();
        StringBuffer retorno = new StringBuffer();
        for (byte b : digest) {
            retorno.append(Integer.toHexString(b));
        }
        return retorno.toString();
    }
}
