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
public class Quad {
    
    GL gl;
    float x,y,ancho,alto,rx,ry,rz,r,g,b;

    public Quad(GL gl, float x, float y, float ancho, float alto, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
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
        
        float an = ancho/2;
        float al = alto/2;
            gl.glPushMatrix();
    
        gl.glTranslatef(x,y,0);     //Traslacion
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        gl.glColor3f(r,g,b);
        
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex2f(x-an, y+al);
        gl.glVertex2f(x-an, y-al);
        gl.glVertex2f(x+an, y-al);
        gl.glVertex2f(x+an, y+al);
        gl.glEnd();
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

    
    
    
 
}
