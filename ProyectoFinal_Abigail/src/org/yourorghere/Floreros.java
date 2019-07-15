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
public class Floreros {
    
    GL gl;
    GLUT glut;
    float x,y,z,tamaño,r,g,b;

    public Floreros(GL gl, float x, float y, float z, float tamaño, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.tamaño = tamaño;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void tipo1(GLUT glut){
        
        //florero
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y,z);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(tamaño/4, tamaño, 20, 20);
        gl.glPopMatrix();
        
        
        //flores
        
        //flor 1 tallo
        gl.glPushMatrix();
        gl.glColor3f(0f,0.7f,0f);
        gl.glTranslatef(x,y+tamaño/2,z-(tamaño/5));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidCylinder(tamaño/30, tamaño, 20, 20);
        gl.glPopMatrix();
        
        //flor 1 petalos
        gl.glPushMatrix();
        gl.glColor3f(0.9f,0.2f,0.6f);
        gl.glTranslatef(x,y+tamaño/2,z-(tamaño/3.5f));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidSphere(tamaño/8, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.9f,0.2f,0.6f);
        gl.glTranslatef(x,y+(tamaño/1.9f),z-(tamaño/9));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidSphere(tamaño/8, 20, 20);
        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glColor3f(0.9f,0.2f,0.6f);
        gl.glTranslatef(x,y+tamaño/1.5f,z-(tamaño/5));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidSphere(tamaño/8, 20, 20);
        gl.glPopMatrix();
        
        //flor 2 tallo
        gl.glPushMatrix();
        gl.glRotatef(120, 0, 1, 0);
        
        gl.glPushMatrix();
        gl.glColor3f(0f,0.7f,0f);
        gl.glTranslatef(x,y+tamaño/2,z-(tamaño/5));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidCylinder(tamaño/30, tamaño, 20, 20);
        gl.glPopMatrix();
        
        //flor 2 petalos
        gl.glPushMatrix();
        gl.glColor3f(1,0.7f,1);
        gl.glTranslatef(x,y+tamaño/2,z-(tamaño/3.5f));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidSphere(tamaño/8, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1,0.7f,1);
        gl.glTranslatef(x,y+(tamaño/1.9f),z-(tamaño/9));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidSphere(tamaño/8, 20, 20);
        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glColor3f(1,0.7f,1);
        gl.glTranslatef(x,y+tamaño/1.5f,z-(tamaño/5));
        gl.glRotatef(70,1,0,0);
        glut.glutSolidSphere(tamaño/8, 20, 20);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
    public void tipo2(GLUT glut){
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y,z);
        glut.glutSolidSphere(tamaño, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y-tamaño,z);
        gl.glRotatef(-90,1,0,0);
        glut.glutSolidCone(tamaño, tamaño, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y+tamaño/1.5f,z);
        gl.glRotatef(-90,1,0,0);
        glut.glutSolidCylinder(tamaño-0.8f, tamaño, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y+tamaño*2,z);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCone(tamaño, tamaño, 20, 20);
        gl.glPopMatrix();
    }
}
