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
public class PiramideQuad {
    
     GL gl;
     float x0;
     float y0;
     float z0;
     float ancho;
     float alto;
     float prof;
     float r;
     float g;
     float b;

    public PiramideQuad(GL gl, float x0, float y0, float z0, float ancho, float alto, float prof, float r, float g, float b) {
        this.gl = gl;
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.ancho = ancho;
        this.alto = alto;
        this.prof = prof;
        this.r = r;
        this.g = g;
        this.b = b;
    }
     
     
   
       public void drawPiramide(){
            
           float an = ancho/2;
           float al = alto/2;
           float pr = prof/2;
           
          
        //Base piramide
         gl.glColor3f(r,g,b);
         
         gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x0 - an,y0 + al,z0-pr);
        gl.glVertex3f(x0+an,y0 + al,z0-pr);
        gl.glVertex3f(x0 + an,y0 + al,z0 + pr);
        gl.glVertex3f(x0 - an,y0 + al,z0 + pr);
        gl.glEnd();
        
        //lado1
       gl.glColor3f(r/2,g/2,b/2);
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(x0-an,y0+al,z0-pr);
        gl.glVertex3f(x0+an, y0+al, z0-pr);
        gl.glVertex3f(x0,y0+alto,z0);
        gl.glEnd();
        
                //lado2
       gl.glColor3f(r,g,b);
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(x0+an,y0+al,z0-pr);
        gl.glVertex3f(x0+an, y0+al, z0+pr);
        gl.glVertex3f(x0,y0+alto,z0);
        gl.glEnd();
        
                //lado3
       gl.glColor3f(r,g,b);
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(x0-an,y0+al,z0-pr);
        gl.glVertex3f(x0-an, y0+al, z0+pr);
        gl.glVertex3f(x0,y0+alto,z0);
        gl.glEnd();
        
                 //lado4
        gl.glColor3f(r,g,b);
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(x0-an,y0+al,z0+pr);
        gl.glVertex3f(x0+an, y0+al, z0+pr);
        gl.glVertex3f(x0,y0+alto,z0);
        gl.glEnd();      
            
}

    public float getX0() {
        return x0;
    }

    public void setX0(float x0) {
        this.x0 = x0;
    }

    public float getY0() {
        return y0;
    }

    public void setY0(float y0) {
        this.y0 = y0;
    }

    public float getZ0() {
        return z0;
    }

    public void setZ0(float z0) {
        this.z0 = z0;
    }


       
}