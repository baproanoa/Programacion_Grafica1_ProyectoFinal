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
public class Cocina {
    
    GL gl;
    GLUT glut;
    
    float x,y,z,rx,ry,rz,ancho,alto,prof,r,g,b;
    Cubo placa,base;
    QuadLines horno;
    Quad2 horno2;
    Circulo botones1,botones2;
    
    public Cocina(GL gl, float x, float y, float z, float rx, float ry, float rz, float ancho,float alto, float prof, float r, float g, float b) {
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


    
    public void display(GLUT glut){
        
        placa = new Cubo(gl,x,y+(alto/1.9f),z,ancho,ancho/10,prof,rx,ry,rz,r,g,b);
        base = new Cubo(gl,x,y,z,ancho,alto,prof,rx,ry,rz,r/2,g/2,b/2);
        horno = new QuadLines(gl,x,y,z-(prof/1.98f),ancho/4,alto/4,rx,ry,rz,1,1,1);
        horno2 = new Quad2(gl,x,y,z-(prof/1.98f),ancho/5,alto/5,rx,ry,rz,0,0,0,1,1,1);
        
        base.display();
        placa.display();
        horno.dibujarcuadradolineas();
        horno2.dibuja();
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x-(ancho/2),y+(alto/3),z-(prof/1.98f));
        gl.glRotatef(90,0,1,0);
        glut.glutSolidCylinder(0.1f, ancho-0.2f, 10, 10);
        gl.glPopMatrix();
        
        //hornillas cocina
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x+(ancho/4),y+(alto/1.7f),z-(prof/4));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.5f, ancho/30, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x-(ancho/4),y+(alto/1.7f),z-(prof/4));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.5f, ancho/30, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x+(ancho/4),y+(alto/1.7f),z+(prof/4));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.5f, ancho/30, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0,0,0);
        gl.glTranslatef(x-(ancho/4),y+(alto/1.7f),z+(prof/4));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.5f, ancho/30, 20, 20);
        gl.glPopMatrix();
        ///////////////////////////////////////////////////////
    }
    
    
    public void dibujaMicro(GLUT glut){
        
        
        base = new Cubo(gl,x,y,z,ancho,alto,prof,rx,ry,rz,r/2,g/2,b/2);
        horno = new QuadLines(gl,x,y,z-(prof/1.98f),ancho/3,alto/3,rx,ry,rz,1,1,1);
        horno2 = new Quad2(gl,x,y,z-(prof/1.98f),ancho/4,alto/4,rx,ry,rz,0,0,0,1,1,1);
        botones1 = new Circulo(gl,x+(ancho/2.5f),y+(alto/10),z-(prof/1.98f),0.3f,0.3f,0,0,0,1,0,0);
        botones2 = new Circulo(gl,x+(ancho/2.5f),y-(alto/15),z-(prof/1.98f),0.3f,0.3f,0,0,0,0,1,0);
        
        base.display();
        horno.dibujarcuadradolineas();
        horno2.dibuja();
        botones1.dibujarcirculo();
        botones2.dibujarcirculo();
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x-(ancho/2.5f),y+(alto/15),z-(prof/1.98f));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.1f, alto/3, 10, 10);
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
//        gl.glColor3f(1,1,1);
//        gl.glBegin(gl.GL_POINTS);
//        gl.glVertex3f(x+(ancho/2.5f),y+(alto/10),z-(prof/1.98f));
//        gl.glEnd();
//        gl.glPopMatrix();
        
    } 
}
