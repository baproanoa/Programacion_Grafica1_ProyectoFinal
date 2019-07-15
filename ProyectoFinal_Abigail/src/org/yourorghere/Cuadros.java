/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Abigail Proaño
 */
public class Cuadros {
    
    GL gl;
    float x,y,z,ancho,alto,r,g,b;

    public Cuadros(GL gl, float x, float y, float z, float ancho, float alto, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    
}
