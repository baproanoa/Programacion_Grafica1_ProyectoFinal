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
public class Calle {
    
    GL gl;
    float x,y,z, ancho,largo;
    Quad2 calle, raya1,raya2, guiones;
    public Calle(GL gl, float x, float y, float z, float largo, float ancho) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.largo = largo;
    }
    
    public void display(){
        
        calle = new Quad2(gl,x,y,z,largo,ancho,90,0,0,0,0,0,0.3f,0.3f,0.3f);
        raya1 = new Quad2(gl,x,y+0.1f,z+ancho/1.3f,largo,ancho/20,90,0,0,0.9f,0.9f,0.9f,1,1,1);
        raya2 = new Quad2(gl,x,y+0.1f,z-ancho/1.3f,largo,ancho/20,90,0,0,0.9f,0.9f,0.9f,1,1,1);
        guiones = new Quad2(gl,x,y+0.1f,z,largo/100,ancho/20,90,0,0,0.9f,0.9f,0.9f,1,1,1);
        
        calle.dibuja();
        raya1.dibuja();
        raya2.dibuja();
        
        guiones.dibuja();
        
        gl.glPushMatrix();
        for (int i = 0; i < largo; i++) {
            gl.glTranslatef(x+4*(largo/100),y,z);
            guiones.dibuja();    
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        for (int i = 0; i < largo; i++) {
            gl.glTranslatef(x-4*(largo/100),y,z);
            guiones.dibuja();    
        }
        gl.glPopMatrix();
    }
    
    
}
