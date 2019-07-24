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
public class Television {
    
    GL gl;
    float x,y,z, rx,ry,rz, ancho,alto,girarx,girary,girarz;
    Cubo2 tele; 
    Quad2 pantalla;
    Circulo c1,c2,c3;
    Quad2 q1,q2,q3;
    QuadLines ql1,ql2,ql3;
    

    public Television(GL gl, float x, float y, float z, float rx, float ry, float rz, float ancho, float alto) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.ancho = ancho;
        this.alto = alto;
       
    }
          
    public void display(){
        tele = new Cubo2(gl, x,y,z,ancho,alto,ancho/15,0,0,90,0.2f,0.2f,0.2f,0.4f,0.4f,0.4f);
        pantalla = new Quad2(gl,x,y,z+ancho/14,alto-0.8f,ancho-0.8f,0,0,0,0,0,0,1,1,1);
        c1 = new Circulo(gl,x+ancho/4,y,z+ancho/13,ancho/5,ancho/5,0,0,0,1,0,0);
        c2 = new Circulo(gl,x+ancho/8,y+alto/4,z+ancho/13,ancho/5,ancho/5,0,0,0,0,1,0);
        c3 = new Circulo(gl,x-ancho/2,y,z+ancho/13,ancho/5,ancho/5,0,0,0,0,0,1);
        
        gl.glPushMatrix();
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        
        tele.dibuja();
        pantalla.dibuja();
        
        gl.glPushMatrix();
//        girarx+= 1f;
//        gl.glScalef(girarx,girarx,girarx);
        c1.display();
        gl.glPopMatrix();
        
        c2.display();
        c3.display();
        gl.glPopMatrix();
        
        
        
    }
}
