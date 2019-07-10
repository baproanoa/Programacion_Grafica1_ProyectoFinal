/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author Abigail Proaño
 */
public class Baranda {
    
    GL gl;
    float x,y,z,rx,ry,rz,alto,ancho,r,g,b;
    Cubo baranda;
    Cubo pasamanos;

    public Baranda(GL gl, float x, float y, float z, float rx, float ry, float rz, float alto, float ancho, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.alto = alto;
        this.ancho = ancho;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(int num){
        
        baranda = new Cubo(gl,x,y,z,ancho,alto,ancho/2,rx,ry,rz,r,g,b);
        pasamanos = new Cubo(gl,x,y,z,num*ancho,ancho,ancho/2,rx,ry,rz,r,g,b);
        
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        for (int i = 1; i < num+1; i++) {
            
            gl.glTranslatef(3*ancho,0,0);
            baranda.display();
            gl.glPushMatrix();
            gl.glTranslatef(0,y+alto/2,0);
            pasamanos.display();
            gl.glPopMatrix();
            
        }    
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
