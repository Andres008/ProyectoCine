/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.utilitarios;

/**
 *
 * @author acardenas
 */
public class Utilitarios {
     public void validarSoloNumeros(String cadena) throws Exception{
        if ( ! cadena.matches("[0-9]*"))
            throw new Exception("Cadena contiene caracter no numerico.");
    }
    
    public void validarSoloLetrasMinusculas(String cadena) throws Exception{
        if ( ! cadena.matches("[a-z]*"))
            throw new Exception("Cadena contiene caracter no numerico.");
    }
    
    public void validarSoloLetrasMayusculas(String cadena) throws Exception{
        if ( ! cadena.matches("[A-Z]*"))
            throw new Exception("Cadena contiene caracter no numerico.");
    }
    
     public void validarCorreoValido(String cadena) throws Exception{
         if (!cadena.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
             throw new Exception("Correo no válido.");
     }
}