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
public class Alfombras {
    
    GL gl;
    float x,y,z,tamaño,r,g,b;
    Circulo base1, borde1, borde2;
    
    public Alfombras(GL gl, float x, float y, float z, float tamaño, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.tamaño = tamaño;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void alfombraRedonda(){
        base1 = new Circulo(gl,x,y,z,tamaño,tamaño,0,0,0,r,g,b);
        borde1 = new Circulo(gl,x,y,z,tamaño/1.1f,tamaño/1.1f,0,0,0,0f,0f,0f);
        borde2 = new Circulo(gl,x,y,z,tamaño/1.3f,tamaño/1.3f,0,0,0,0f,0f,0f);
        
        gl.glTranslatef(x,y,z);
        
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        base1.display();
        borde1.dibujarcirculoBorde();
        borde2.dibujarcirculoBorde();
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
