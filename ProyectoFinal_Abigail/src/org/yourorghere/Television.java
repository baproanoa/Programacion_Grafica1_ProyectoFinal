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
public class Television {
    
    GL gl;
    float x,y,z, rx,ry,rz, ancho,alto;
    Cubo tele, pantalla;
    

    public Television(GL gl, float x, float y, float z, float rx, float ry, float rz, float ancho, float alto) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.ancho = ancho;
        this.alto = alto;
       
    }
          
    public void display(){
        tele = new Cubo(gl, x,y,z,rx,ry,rz,ancho,alto,ancho/15,0,0,0);
        pantalla = new Cubo(gl,x,y,z,rx,ry,rz,ancho-0.1f,alto-0.1f,ancho/20,0.4f,0.4f,0.4f);
        
        tele.display();
        
//        gl.glPushMatrix();
//        gl.glTranslatef(x,y,z-ancho/20);
//        pantalla.display();
//        gl.glPopMatrix();
        
    }
}
