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
public class Chimenea {
    
    GL gl;
    float x,y,z,ancho, alto,prof,r,g,b;
    Cubo lado1,lado2,lado3,lado4;
    Quad2 ladoposterior,ladrillos;
    
    public Chimenea(GL gl, float x, float y, float z, float ancho, float alto,float prof, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.prof = prof;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(){
        lado1 = new Cubo(gl,x-(ancho/2),y,z,ancho/4,alto,prof,0,0,0,r,g,b);
        lado2 = new Cubo(gl,x+(ancho/2),y,z,ancho/4,alto,prof,0,0,0,r,g,b);
        lado3 = new Cubo(gl,x,y+(alto/2),z,(1.25f)*ancho,alto/2,prof,0,0,0,r,g,b);
        lado4 = new Cubo(gl,x,y-(alto/1.35f),z,(1.25f)*ancho,alto/2,prof,0,0,0,r,g,b);
        ladoposterior = new Quad2(gl,x,y,z+(prof/2),ancho/2, alto/2,0,0,0,r/2,g/2,b/2,r/3,g/3,b/3);
        ladrillos = new Quad2(gl,x,y,z,ancho/10,ancho/10,0,0,0,r,g,b,r/2,g/2,b/2);
        
        
        lado1.display();
        lado2.display();
        lado3.display();
        lado4.display();
        ladoposterior.dibuja();
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

