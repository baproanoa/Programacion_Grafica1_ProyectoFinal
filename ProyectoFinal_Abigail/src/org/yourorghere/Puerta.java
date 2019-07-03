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
public class Puerta {
    
    GL gl;
    float x,y,z,ancho,alto,rx,ry,rz,r,g,b;
    Esfera perilla;
    Cubo puerta;

    public Puerta(GL gl, float x, float y, float z, float ancho, float alto, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(){
        
        puerta = new Cubo(gl,x,y,z,ancho,alto,ancho/5,rx,ry,rz,r,g,b);
        perilla = new Esfera(x-ancho,y,z+0.5f,0.5f,0.5f,0.5f,rx,ry,rz,r,g,b,gl,2f,20,20);
        
        puerta.display();
        perilla.display();
        
    
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
