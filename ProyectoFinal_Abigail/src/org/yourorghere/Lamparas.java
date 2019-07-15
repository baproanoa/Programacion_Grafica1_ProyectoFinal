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
public class Lamparas {
    GLUT glut = new GLUT();
    GL gl;
    float x,y,z,alto,r,g,b;

    public Lamparas(GL gl, float x, float y, float z, float alto, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.alto = alto;
        this.r = r;
        this.g = g;
        this.b = b;
    }

   
    
    public void colgante(GLUT glut){
       
        //cable
        gl.glPushMatrix();
         gl.glTranslatef(x,y+(alto/2.3f),z);
         gl.glRotatef(90,1,0,0);
         gl.glColor3f(0.7f,0.7f,0.9f);
         glut.glutSolidCylinder(0.02f, 1.5f, 5, 5);
         gl.glPopMatrix();
         
         
         //lampara
         gl.glPushMatrix();
         gl.glTranslatef(x,y-alto/5,z);
         gl.glRotatef(-90,1,0,0);
         gl.glColor3f(r,g,b);
         glut.glutWireCone(0.5f, 0.5f, 20, 20);
         gl.glPopMatrix();
         
         
         //foco
         gl.glPushMatrix();
         gl.glTranslatef(x,y-(alto/5.5f),z);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.2f, 20, 20);
         gl.glPopMatrix();
        
    }
    
    public void colgante2(GLUT glut){
       
        //cable
        gl.glPushMatrix();
         gl.glTranslatef(x,y+(alto/2f),z);
         gl.glRotatef(90,1,0,0);
         gl.glColor3f(0.7f,0.7f,0.9f);
         glut.glutSolidCylinder(0.05f, 4f, 5, 5);
         gl.glPopMatrix();
         
         
         //lampara
         gl.glPushMatrix();
         gl.glTranslatef(x,y-(alto/0.9f),z);
         gl.glRotatef(-90,1,0,0);
         gl.glColor3f(r,g,b);
         glut.glutWireIcosahedron();
         gl.glPopMatrix();
         
         
         //foco
         gl.glPushMatrix();
         gl.glTranslatef(x,y-(alto/0.9f),z);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.3f, 20, 20);
         gl.glPopMatrix();
        
    }
        
    public void dePiso(GLUT glut){
       
        //cable
        gl.glPushMatrix();
         gl.glTranslatef(x,y+alto,z);
         gl.glRotatef(90,1,0,0);
         gl.glColor3f(0.7f,0.7f,0.9f);
         glut.glutSolidCylinder(0.1f, 3f, 20, 20);
         gl.glPopMatrix();
         
          gl.glPushMatrix();
         gl.glTranslatef(x,y+alto+0.1f,z-alto/7);
         gl.glRotatef(45,1,0,0);
         gl.glColor3f(0.7f,0.7f,0.9f);
         glut.glutSolidCylinder(0.1f, 0.8f, 20, 20);
         gl.glPopMatrix();
         
         
         //lampara
         gl.glPushMatrix();
         gl.glTranslatef(x,y+alto-0.2f,z-alto/3.5f);
         gl.glRotatef(-45,1,0,0);
         gl.glColor3f(r,g,b);
         glut.glutSolidCone(0.7f, 0.7f, 20, 20);
         gl.glPopMatrix();
         
         
         //foco
         gl.glPushMatrix();
         gl.glTranslatef(x,y+alto-0.25f,z-alto/3.5f);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.2f, 20, 20);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(x,y+alto/4,z);
         gl.glRotatef(90,1,0,0);
         gl.glColor3f(0.7f,0.7f,0.9f);
         glut.glutSolidCylinder(0.5f, 0.1f, 20, 20);
         gl.glPopMatrix();
        
    }
    
    public void deTecho(GLUT glut){
        
        gl.glPushMatrix();
         gl.glTranslatef(x,y,z);
         gl.glRotatef(90,1,0,0);
         gl.glColor3f(r,g,b);
         glut.glutSolidCone(alto,alto/2,20, 20);
         gl.glPopMatrix();
        
                 //foco
         gl.glPushMatrix();
         gl.glTranslatef(x,y-alto/3,z);
         gl.glRotatef(90,1,0,0);
          gl.glColor3f(r,g,b);
         glut.glutSolidCylinder(alto/3,alto/3, 20, 20);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(x,y-alto,z);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(alto/2, 20, 20);
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
