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
public class Cubo {

    GL gl;
    float x,y,z,ancho,alto,prof,rx,ry,rz,r,g,b;

    public Cubo(GL gl, float x, float y, float z, float ancho, float alto, float prof, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.prof = prof;
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
        float pr = prof/2;
        //CUBO
        //cara 1
        gl.glPushMatrix();
        
//       gl.glColor3f(r,g,b);
       gl.glColor3f(r/2,g/2,b/2);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y + al,z-pr);
        gl.glVertex3f(x - an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z-pr);
        gl.glVertex3f(x + an,y + al,z-pr);
        gl.glEnd();
        
       //cara 2
//       gl.glColor3f(r/2,g/2,b/2);
        gl.glColor3f(r,g,b);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x + an,y + al,z-pr);
        gl.glVertex3f(x + an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z + pr);
        gl.glVertex3f(x + an,y + al,z+pr);
        gl.glEnd();
        
//        //cara 3
//        gl.glColor3f(r/3,g/3,b/3);
//        gl.glColor3f(r,g,b);
        gl.glColor3f(r/2,g/2,b/2);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x + an,y - al,z + pr);
        gl.glVertex3f(x + an,y + al,z + pr);
        gl.glVertex3f(x-an,y + al,z + pr);
        gl.glVertex3f(x-an,y - al,z+pr);
        gl.glEnd();
        
//        //cara 4
//        gl.glColor3f(r/2,g/3,b);
//        gl.glColor3f(r,g,b);
        gl.glColor3f(r/2,g/2,b/2);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y + al,z-pr);
        gl.glVertex3f(x - an,y - al,z-pr);
        gl.glVertex3f(x - an,y - al,z + pr);
        gl.glVertex3f(x - an,y + al,z+pr);
        gl.glEnd();
//          
//        //cara superior
//         gl.glColor3f(r/2,g/3,b/2);
        gl.glColor3f(r,g,b);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y + al,z - pr);
        gl.glVertex3f(x + an,y + al,z - pr);
        gl.glVertex3f(x + an,y + al,z + pr);
        gl.glVertex3f(x - an,y + al,z + pr);
        gl.glEnd();
//        
//        //cara 6
//        gl.glColor3f(r,g,b);
        gl.glColor3f(r/2,g/2,b/2);
//        gl.glColor3f(r,g,b);
         gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z + pr);
        gl.glVertex3f(x - an,y - al,z + pr);
        gl.glEnd();
        
        gl.glPopMatrix();
   
    }
    
    public void hueco(){
        
        float an = ancho/2;
        float al = alto/2;
        float pr = prof/2;
        //CUBO
        //cara 1
        gl.glPushMatrix();
        
       gl.glColor3f(r/2,g/2,b/2);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y + al,z-pr);
        gl.glVertex3f(x - an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z-pr);
        gl.glVertex3f(x + an,y + al,z-pr);
        gl.glEnd();
        
       //cara 2
        
       gl.glColor3f(r,g,b);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x + an,y + al,z-pr);
        gl.glVertex3f(x + an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z + pr);
        gl.glVertex3f(x + an,y + al,z+pr);
        gl.glEnd();
        
//        //cara 3
//        gl.glBegin(gl.GL_QUADS);
//        gl.glVertex3f(x + an,y - al,z + pr);
//        gl.glVertex3f(x + an,y + al,z + pr);
//        gl.glVertex3f(x-an,y + al,z + pr);
//        gl.glVertex3f(x-an,y - al,z+pr);
//        gl.glEnd();
        
//        //cara 4
        gl.glColor3f(r/2,g/2,b/2);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y + al,z-pr);
        gl.glVertex3f(x - an,y - al,z-pr);
        gl.glVertex3f(x - an,y - al,z + pr);
        gl.glVertex3f(x - an,y + al,z+pr);
        gl.glEnd();
//          
//        //cara 5
        gl.glColor3f(r,g,b); 
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y + al,z - pr);
        gl.glVertex3f(x + an,y + al,z - pr);
        gl.glVertex3f(x + an,y + al,z + pr);
        gl.glVertex3f(x - an,y + al,z + pr);
        gl.glEnd();
//        
//        //cara 6
        gl.glColor3f(r/2,g/2,b/2);
         gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x - an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z-pr);
        gl.glVertex3f(x + an,y - al,z + pr);
        gl.glVertex3f(x - an,y - al,z + pr);
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

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    


    
    
}
