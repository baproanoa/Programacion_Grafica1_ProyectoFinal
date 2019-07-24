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
public class Baño {
    
    GL gl;
    float x,y,z,ancho,alto;
    Cubo tanque;
    Circulo agua;

    public Baño(GL gl, float x, float y, float z, float ancho, float alto) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public void display(GLUT glut){
        
        tanque = new Cubo(gl,x,y+alto/2,z+ancho/1.5f,1.1f*ancho,alto/2,ancho/2,0,0,0,1.8f,1.8f,1.8f);
        agua = new Circulo(gl,x,y+alto/8,z,ancho/2.5f,alto/4,90,0,0,0.8f,0.9f,1);
        //base del baño
        gl.glPushMatrix();
        gl.glColor3f(0.9f,0.9f,0.9f);
        gl.glTranslatef(x,y,z);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/2, alto/3, 20, 20);
        gl.glPopMatrix();
        
        //taza del baño
        gl.glPushMatrix();
         gl.glColor3f(1,1,1);
        gl.glTranslatef(x,y+alto/5,z);
          gl.glRotatef(90,1,0,0);
          gl.glScalef(1f,0.6f,1f);
        glut.glutSolidCone(ancho, alto/2, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
         gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glTranslatef(x,y+alto/4.5f,z);
          gl.glRotatef(90,1,0,0);
          gl.glScalef(0.3f,0.2f,0.3f);
          glut.glutSolidTorus(ancho/4, 3*ancho, 40, 40);
        gl.glPopMatrix();
        
        //agua
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        agua.display();
        gl.glPopMatrix();
        
        //tanque 
        gl.glPushMatrix();
          gl.glRotatef(90,0,1,0);
            tanque.display();
        gl.glPopMatrix();
        
        
    }
}
