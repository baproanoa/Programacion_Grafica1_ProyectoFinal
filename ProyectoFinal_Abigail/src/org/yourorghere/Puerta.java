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
public class Puerta {
    
    GL gl;
    float x,y,z,ancho,alto,r,g,b;
    Cubo puerta;
    Quad2 ventana1,ventana2,ventana3,ventana4;
    float r2 =0.7f,g2=0.8f,b2=1;
    
    public Puerta(GL gl, float x, float y, float z, float ancho, float alto, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(GLUT glut){
        
        puerta = new Cubo(gl,x,y,z,ancho,alto,ancho/5,0,0,0,r,g,b);
        ventana1 = new Quad2(gl,x,y+alto/5,z-(ancho/5)/1.98f,ancho/3,ancho/2.5f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana2 = new Quad2(gl,x,y+alto/5,z+(ancho/5)/1.98f,ancho/3,ancho/2.5f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        puerta.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        ventana1.dibuja();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        ventana2.dibuja();
        gl.glPopMatrix();
        
        //chapa de la puerta
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/10,0);
        gl.glColor3f(1f,0.9f,0.5f);
        
          gl.glPushMatrix();
        gl.glTranslatef(x-ancho/8,y,z-(ancho/3));
        gl.glRotatef(-90,0,1,0);
        glut.glutSolidCylinder(ancho/30,ancho/20, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/5,y,z-(ancho/3));
        glut.glutSolidSphere(ancho/20, 20, 20);
        gl.glPopMatrix();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/10,0);
        gl.glColor3f(1f,0.9f,0.5f);
        
          gl.glPushMatrix();
        gl.glTranslatef(x+ancho/8,y,z-(ancho/3));
        gl.glRotatef(-90,0,1,0);
        glut.glutSolidCylinder(ancho/30,ancho/20, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/5,y,z-(ancho/3));
        glut.glutSolidSphere(ancho/20, 20, 20);
        gl.glPopMatrix();
        gl.glPopMatrix();
        ////////////////////////7
    
    }
    
      public void puertadoble(GLUT glut){
        
        puerta = new Cubo(gl,x,y,z,2*ancho,alto,ancho/5,0,0,0,r,g,b);
        ventana1 = new Quad2(gl,x-(2*ancho)/3.8f,y,z-(ancho/5)/1.98f,ancho/2.5f,alto/2.3f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana2 = new Quad2(gl,x+(2*ancho)/3.8f,y,z-(ancho/5)/1.98f,ancho/2.5f,alto/2.3f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana3 = new Quad2(gl,x-(2*ancho)/3.8f,y,z+(ancho/5)/1.98f,ancho/2.5f,alto/2.3f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana4 = new Quad2(gl,x+(2*ancho)/3.8f,y,z+(ancho/5)/1.98f,ancho/2.5f,alto/2.3f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        puerta.display();
        gl.glPopMatrix();
        
        //ventanas delanteras
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        ventana1.dibuja();
        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        ventana2.dibuja();
        gl.glPopMatrix();
        
        //ventanas traseras
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        ventana3.dibuja();
        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        ventana4.dibuja();
        gl.glPopMatrix();
        
        //chapas delanteras
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/10,0);
        
          gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x-ancho/8,y,z-(ancho/8));
        gl.glRotatef(-90,0,1,0);
        glut.glutSolidCylinder(ancho/30,ancho/20, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x-ancho/5,y,z-(ancho/8));
        glut.glutSolidSphere(ancho/20, 20, 20);
        gl.glPopMatrix();
        gl.glPopMatrix();
        
        //chapa de la puerta
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/10,0);
        
          gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x-ancho/8,y,z+(ancho/10));
        gl.glRotatef(-90,0,1,0);
        glut.glutSolidCylinder(ancho/30,ancho/20, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x-ancho/5,y,z+(ancho/10));
        glut.glutSolidSphere(ancho/20, 20, 20);
        gl.glPopMatrix();
        gl.glPopMatrix();
        
         //chapas traseras
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/10,0);
        
          gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x+ancho/8,y,z-(ancho/8));
        gl.glRotatef(-90,0,1,0);
        glut.glutSolidCylinder(ancho/30,ancho/20, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x+ancho/5,y,z-(ancho/8));
        glut.glutSolidSphere(ancho/20, 20, 20);
        gl.glPopMatrix();
        gl.glPopMatrix();
        
        //chapa de la puerta
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/10,0);
        
          gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x+ancho/8,y,z+(ancho/10));
        gl.glRotatef(-90,0,1,0);
        glut.glutSolidCylinder(ancho/30,ancho/20, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1f,0.9f,0.5f);
        gl.glTranslatef(x+ancho/5,y,z+(ancho/10));
        glut.glutSolidSphere(ancho/20, 20, 20);
        gl.glPopMatrix();
        gl.glPopMatrix();
        
        //separacion puertas
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x,y-alto/2,z-(ancho/5)/1.98f);
        gl.glVertex3f(x,y+alto/2,z-(ancho/5)/1.98f);
        gl.glEnd();
        gl.glPopMatrix();
        ////////////////////////
    
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
