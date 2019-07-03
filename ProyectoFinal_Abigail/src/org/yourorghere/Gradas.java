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
public class Gradas {
    GL gl;
    float x,y,z,ancho,rx,ry,rz,r,g,b;
    Cubo grada;
    float alto = 1/3;

    public Gradas(GL gl, float x, float y, float z, float ancho, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
    }

   
    
    public void display(int num){
        grada = new Cubo(gl,x,y,z,ancho,ancho/3,ancho,0,0,0,r,g,b);
        
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        for (int i = 1; i < num+1; i++) {
            gl.glTranslatef(ancho/3,ancho/3,0);
            grada.display();
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
