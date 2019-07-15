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
public class ParedLineas {
    GL gl;
    Quad2 linea;
    float x,y,z,ancho,alto,r,g,b;

    public ParedLineas(GL gl, float x, float y, float z, float ancho, float alto, float r, float g, float b) {
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
    
    public void display(int num){
        
        linea = new Quad2(gl,x,y,z,ancho,alto,0,0,0,r,g,b,r/2,g/2,b/2);
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        for (int i = 0; i < num; i++) {
            gl.glTranslatef(4*ancho,0,0);
            linea.dibuja();
        }
        gl.glPopMatrix();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    
    
}
