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
public class Mesa {
    
    GL gl;
    GLUT glut;
   float x,y,z,rx,ry,rz,ancho,alto,prof,r,g,b;
   Cubo mesa,tablero, patas;
   Espejo esp;
   
    public Mesa(GL gl, float x, float y, float z, float rx, float ry, float rz, float ancho, float alto, float prof, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.ancho = ancho;
        this.alto = alto;
        this.prof = prof;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void mesadenoche(GLUT glut){
        
        mesa = new Cubo(gl,x,y,z,ancho,alto,prof,rx,ry,rz,r,g,b);
        
        mesa.display();
        
        gl.glPushMatrix();
        gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x+(ancho/(2)), y, z-(prof/1.9f));
        gl.glVertex3f(x-(ancho/(2)), y, z-(prof/1.9f));
        gl.glEnd();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glTranslatef(x, y + alto/4, z-(prof/2));
        glut.glutSolidSphere(0.2f, 20, 20);
        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glTranslatef(x, y - alto/4, z-(prof/2));
        glut.glutSolidSphere(0.2f, 20, 20);
        gl.glPopMatrix();
        
    }


    public void cocina(GLUT glut){
        
        tablero = new Cubo(gl,x,y+(alto/2),z,ancho+0.2f,alto/9,prof+0.2f,rx,ry,rz,1,1,1);
        mesa = new Cubo(gl,x,y,z,ancho,alto,prof,rx,ry,rz,r,g,b);
        
        mesa.display();
        tablero.display();
        
          gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x+(ancho/(2)), y+(alto/2), z-(prof/1.9f));
        gl.glVertex3f(x+(ancho/(2)), y-(alto/2), z-(prof/1.9f));
        gl.glEnd();
        gl.glPopMatrix();
        
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x+(ancho/(6.5f)), y+(alto/2), z-(prof/1.9f));
        gl.glVertex3f(x+(ancho/(6.5f)), y-(alto/2), z-(prof/1.9f));
        gl.glEnd();
        gl.glPopMatrix();
        
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x + (ancho/4), y, z-(prof/2));
        glut.glutSolidSphere(0.1f, 20, 20);
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x-(ancho/(5)), y+(alto/2), z-(prof/1.9f));
        gl.glVertex3f(x-(ancho/(5f)), y-(alto/2), z-(prof/1.9f));
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x - (ancho/2.5f), y, z-(prof/2));
        glut.glutSolidSphere(0.1f, 20, 20);
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x-(ancho/(2)), y+(alto/2), z-(prof/1.9f));
        gl.glVertex3f(x-(ancho/(2)), y-(alto/2), z-(prof/1.9f));
        gl.glEnd();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x-(ancho/8f), y, z-(prof/2));
        glut.glutSolidSphere(0.1f, 20, 20);
        gl.glPopMatrix();      
    }
    
    public void isla(){
        
        tablero = new Cubo(gl,x,y+(alto/2),z,ancho+0.5f,alto/9,prof+0.5f,rx,ry,rz,1,1,1);
        mesa = new Cubo(gl,x,y,z,ancho,alto,prof,rx,ry,rz,r,g,b);
        
        
        mesa.display();
        tablero.display();
    }
    
    public void mesaredonda(GLUT glut){
        
    //tablero
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y,z);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho, ancho/5, 40, 40);
        gl.glPopMatrix();
        
        
        
        //pata 1
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x-(ancho/2),y-0.2f,z-(ancho/2));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/15, alto, 20, 20);
        gl.glPopMatrix();
        
        //pata 2
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x-(ancho/2),y-0.2f,z+(ancho/2));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/15, alto, 20, 20);
        gl.glPopMatrix();
        
        //pata 3
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x+(ancho/2),y-0.2f,z-(ancho/2));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/15, alto, 20, 20);
        gl.glPopMatrix();
        
        //pata 4
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x+(ancho/2),y-0.2f,z+(ancho/2));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/15, alto, 20, 20);
        gl.glPopMatrix();
        
    }
    
    public void comedor(){
        
       
        tablero = new Cubo(gl,x,y,z,ancho,alto/25,prof,rx,ry,rz,r,g,b);
        patas = new Cubo(gl,x,y,z,ancho/15,alto/4,prof/10,rx,ry,rz,r,g,b);
        
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        tablero.display();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/3,y-alto/8,z-prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/3,y-alto/8,z+prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/3,y-alto/8,z-prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/3,y-alto/8,z+prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    
    }
    
    public void peinadora(GLUT glut){
        
         tablero = new Cubo(gl,x,y,z,ancho,alto/10,prof,rx,ry,rz,r,g,b);
        patas = new Cubo(gl,x,y,z,ancho/15,alto/4,prof/10,rx,ry,rz,r,g,b);
        esp = new Espejo(gl,x,y+alto*3,z+prof*3,2,3,r,g,b);
                
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        tablero.display();
        
        gl.glPushMatrix();
        gl.glScalef(0.05f,0.07f,0.07f);
        esp.espejoredondo(glut);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/3,y-alto/8,z-prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/3,y-alto/8,z+prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/3,y-alto/8,z-prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/3,y-alto/8,z+prof/3);
        patas.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x, y+(alto/10)/2, z-(prof/1.9f));
        gl.glVertex3f(x, y-(alto/10)/2, z-(prof/1.9f));
        gl.glEnd();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glTranslatef(x+ancho/4, y, z-(prof/2));
        glut.glutSolidSphere(0.02f, 20, 20);
        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glColor3f(0.8f,0.8f,0.8f);
        gl.glTranslatef(x-ancho/4, y, z-(prof/2));
        glut.glutSolidSphere(0.02f, 20, 20);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
        public void mesaSala(GLUT glut){
       
        tablero = new Cubo(gl,x,y,z,ancho,alto,prof,rx,ry,rz,r,g,b);
        patas = new Cubo(gl,x,y,z,ancho/15,alto/7,prof/10,rx,ry,rz,r,g,b);
        
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        tablero.display();
        
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x-ancho/2.5f,y+alto/3,z+prof/2.5f);
        gl.glVertex3f(x+ancho/2.5f,y+alto/3,z+prof/2.5f);
        gl.glEnd();
        gl.glPopMatrix();
        
         //patas
         gl.glPushMatrix();
         gl.glTranslatef(x-ancho/2.5f,y-alto/1.5f,z-prof/2.5f);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.2f, 20, 20);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(x-ancho/2.5f,y-alto/1.5f,z+prof/2.5f);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.2f, 20, 20);
         gl.glPopMatrix();
         
          gl.glPushMatrix();
         gl.glTranslatef(x+ancho/2.5f,y-alto/1.5f,z-prof/2.5f);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.2f, 20, 20);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(x+ancho/2.5f,y-alto/1.5f,z+prof/2.5f);
         gl.glColor3f(1,1,0.6f);
         glut.glutSolidSphere(0.2f, 20, 20);
         gl.glPopMatrix();
         gl.glPopMatrix();
    }
    
    
}
