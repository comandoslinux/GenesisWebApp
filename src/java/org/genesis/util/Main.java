/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.util;

/**
 *
 * @author orlando
 */
public class Main {

    public static void main(String[] args) {
        String mensaje = "Mensaje secreto";
        System.out.println("Mensaje = " + mensaje);
        System.out.println("MD2 = " + Encriptar.getStringMessageDigest(mensaje, Encriptar.MD2));
        System.out.println("MD5 = " + Encriptar.getStringMessageDigest(mensaje, Encriptar.MD5));
        System.out.println("SHA-1 = " + Encriptar.getStringMessageDigest(mensaje, Encriptar.SHA1));
        System.out.println("SHA-256 = " + Encriptar.getStringMessageDigest(mensaje, Encriptar.SHA256));
        System.out.println("SHA-384 = " + Encriptar.getStringMessageDigest(mensaje, Encriptar.SHA384));
        System.out.println("SHA-512 = " + Encriptar.getStringMessageDigest(mensaje, Encriptar.SHA512));
        System.out.println("mensaje: "+mensaje.length());

    }
}
