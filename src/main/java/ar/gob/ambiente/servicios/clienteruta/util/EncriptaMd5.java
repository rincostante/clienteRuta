/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.clienteruta.util;

import java.security.MessageDigest;

/**
 * http://escribojava.blogspot.com.ar/2011/02/encriptar-texto-con-md5-en-java.html
 * encriptador online: http://www.md5online.es/cifrar-md5.html
 * @author rincostante
 */
public class EncriptaMd5 {
    public static String encriptar(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());
        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        
        //algoritmo y arreglo md5
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
                if (u < 16) {
                    h.append("0" + Integer.toHexString(u));
                }
                else {
                    h.append(Integer.toHexString(u));
                }
        }      
      //clave encriptada
      return h.toString();
    }
    
    /*
    //para llamar la  funcion md5 
    try{
        System.out.println(md5(jtfPalabra.getText()));
    }catch (Exception ex){}
    
    
    **************************
    *** Para los servicios ***
    **************************
    
    http://www.arquitecturajava.com/jax-rs-client-y-servicios-rest/
    
    */
}
