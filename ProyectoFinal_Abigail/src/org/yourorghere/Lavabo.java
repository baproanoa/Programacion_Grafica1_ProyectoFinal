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
 * @author Abigail Proa�o
 */
public class Lavabo {
 
    GL gl;
    GLUT glut;
    float x,y,z,ancho,alto;
    Cubo lavabo;
    Circulo base;

    public Lavabo(GL gl, float x, float y, float z, float ancho, float alto) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public void lavaboba�o(GLUT glut){
        
        base = new Circulo(gl,x,y+alto/14,z,ancho/2,ancho/2,90,0,0,0.99f,0.99f,0.99f);
        //base del lavabo
        gl.glPushMatrix();
        gl.glColor3f(0.9f,0.9f,0.9f);
        gl.glTranslatef(x,y,z);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/4, alto, 20, 20);
        gl.glPopMatrix();
        
        //lavabo
        gl.glPushMatrix();
         gl.glColor3f(1,1,1);
        gl.glTranslatef(x,y+alto/5,z);
          gl.glRotatef(90,1,0,0);
          gl.glScalef(1f,1f,1f);
        glut.glutSolidCone(ancho, alto/2, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
         gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glTranslatef(x,y+alto/4.5f,z);
          gl.glRotatef(90,1,0,0);
          gl.glScalef(0.3f,0.3f,0.3f);
          glut.glutSolidTorus(ancho/4, 3*ancho, 40, 40);
        gl.glPopMatrix();
        
        //base
        gl.glPushMatrix();
        base.display();
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
