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
public class Ventanas {
    GL gl;
    float x,y,z,ancho,alto,r,g,b;
    Cubo lado1,lado2,lado3,lado4;
    Quad2 ventana1,ventana2;
    float r2 =0.7f,g2=0.8f,b2=1;
    
    public Ventanas(GL gl, float x, float y, float z, float ancho, float alto,float r,float g,float b) {
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
    
    public void ventana1(){
        
        lado1 = new Cubo(gl,x,y+alto/2,z,ancho,alto/20,ancho/15,0,0,0,r,g,b);
        lado2 = new Cubo(gl,x+ancho/2.1f,y,z,ancho/20,alto,ancho/15,0,0,0,r,g,b);
        lado3 = new Cubo(gl,x,y-alto/2,z,ancho,alto/20,ancho/15,0,0,0,r,g,b);
        lado4 = new Cubo(gl,x-ancho/2.1f,y,z,ancho/20,alto,ancho/15,0,0,0,r,g,b);
        ventana1 = new Quad2(gl,x,y,z-(ancho/40),ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana2 = new Quad2(gl,x,y,z+(ancho/40),ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        lado1.display();
        lado2.display();
        lado3.display();
        lado4.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        ventana1.dibuja();
        ventana2.dibuja();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/3,0);
        gl.glRotatef(90,0,1,0);
        lado1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/1.5f,0);
        gl.glRotatef(90,0,1,0);
        lado1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,z+ancho/2);
        gl.glRotatef(90,0,1,0);
        lado2.display();
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
//        gl.glTranslatef(0,0,z+ancho/1.5f);
//        gl.glRotatef(90,0,1,0);
//        lado2.display();
//        gl.glPopMatrix();
    }
    
        public void ventana2(){
        
        lado1 = new Cubo(gl,x,y+alto/2,z,ancho,alto/20,ancho/15,0,0,0,r,g,b);
        lado2 = new Cubo(gl,x+ancho/2.1f,y,z,ancho/20,alto,ancho/15,0,0,0,r,g,b);
        lado3 = new Cubo(gl,x,y-alto/2,z,ancho,alto/20,ancho/15,0,0,0,r,g,b);
        lado4 = new Cubo(gl,x-ancho/2.1f,y,z,ancho/20,alto,ancho/15,0,0,0,r,g,b);
        ventana1 = new Quad2(gl,x,y,z-(ancho/40),ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana2 = new Quad2(gl,x,y,z+(ancho/40),ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        lado1.display();
        lado2.display();
        lado3.display();
        lado4.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        ventana1.dibuja();
        ventana2.dibuja();
        gl.glPopMatrix();
        
    }
        
        public void ventana3(){
        
        lado1 = new Cubo(gl,x,y+alto/2,z,ancho,alto/20,ancho/15,0,0,0,r,g,b);
        lado2 = new Cubo(gl,x+ancho/2.1f,y,z,ancho/20,alto,ancho/15,0,0,0,r,g,b);
        lado3 = new Cubo(gl,x,y-alto/2,z,ancho,alto/20,ancho/15,0,0,0,r,g,b);
        lado4 = new Cubo(gl,x-ancho/2.1f,y,z,ancho/20,alto,ancho/15,0,0,0,r,g,b);
        ventana1 = new Quad2(gl,x,y,z-(ancho/40),ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        ventana2 = new Quad2(gl,x,y,z+(ancho/40),ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        lado1.display();
        lado2.display();
        lado3.display();
        lado4.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90,0,1,0);
        ventana1.dibuja();
        ventana2.dibuja();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/3,0);
        gl.glRotatef(90,0,1,0);
        lado1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,y-alto/1.5f,0);
        gl.glRotatef(90,0,1,0);
        lado1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,z+ancho/3);
        gl.glRotatef(90,0,1,0);
        lado2.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,z+ancho/1.5f);
        gl.glRotatef(90,0,1,0);
        lado2.display();
        gl.glPopMatrix();
    }
}
