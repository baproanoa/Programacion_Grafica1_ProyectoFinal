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
public class Cuadros {
    
    GL gl;
    float x,y,z,rx,ry,rz,ancho,alto;
    Cubo2 marco;
    Quad2 cuadro;
    Circulo q1,q2,q3,q4,q5,q6;
    
    public Cuadros(GL gl, float x, float y, float z, float rx,float ry, float rz, float ancho, float alto) {
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
            
        marco = new Cubo2(gl, x,y,z,ancho,alto,ancho/15,0,0,90,0.6f,0.4f,0.2f,0.5f,0.3f,0.1f);
        cuadro = new Quad2(gl,x,y,z+ancho/14,alto-0.8f,ancho-0.8f,0,0,0,1,1,1,0.9f,0.9f,0.9f);
        q1 = new Circulo(gl,x,y,z+ancho/12.5f,ancho/5,ancho/5,0,0,0,1f,1f,0.6f);
        q2 = new Circulo(gl,x-ancho/4,y,z+ancho/13,ancho/4,ancho/4,0,0,0,0.9f,0.2f,0.5f);
        q3 = new Circulo(gl,x-ancho/3,y+alto/5,z+ancho/13,ancho/5,ancho/5,0,0,0,0.8f,0.1f,0.4f);
        
        gl.glPushMatrix();
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        
        marco.dibuja();
        cuadro.dibuja();
        q1.display();
        q2.display();
        q3.display();
        gl.glPopMatrix();
        
        
        
    }
}
