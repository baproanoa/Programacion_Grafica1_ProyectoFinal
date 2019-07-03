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
public class Casa3D {
    
    GL gl;
    float x,y,z,alto,ancho, rx,ry,rz;
    Cubo paredes, puerta,chimenea;
    PiramideQuad techo;
    Quad ventanas;

    public Casa3D(GL gl, float x, float y, float z, float alto, float ancho, float rx, float ry, float rz) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.alto = alto;
        this.ancho = ancho;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
    }
    
   
    public void drawCasa(){
        
        paredes = new Cubo(gl, x, y, z, ancho, alto/2,ancho,rx,ry,rz,1f,0.8f,0f);
        techo = new PiramideQuad(gl, x, y, z, ancho, alto/2, ancho,0.5f , 0.2f, 0.2f);
       chimenea = new Cubo(gl,x,y,z,ancho/5,alto/4,ancho/5,rx,ry,rz,1,0,0);
       puerta = new Cubo(gl,x,y,z,ancho/5,alto/3,ancho/15,rx,ry,rz,0.7f,0.4f,0.1f);
       ventanas = new Quad(gl,x,y,ancho/5,alto/4,rx,ry,rz,0.7f,1,1);
    //paredes
         gl.glPushMatrix();
    
        gl.glTranslatef(x,y,z);     //Traslacion
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        paredes.display();
//        Cubo.drawCube(gl, x0, y0, z0, ancho, alto/2,ancho,1f,0.8f,0f);
        
//techo
        techo.drawPiramide();
        gl.glPushMatrix();
        gl.glTranslatef(ancho/5,alto-2.1f,ancho-0.9f);
        puerta.display();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(ancho/7,alto/3,ancho/5);
        chimenea.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(ancho/-5,alto-2f,ancho+1f);
       ventanas.display();
        gl.glPopMatrix();
        
        //ventanas    
//        gl.glPushMatrix();
//   gl.glTranslatef(x0-0.8f,y0,z0+1.5f);
//     Cubo.drawCube(gl, x0, y0, z0, ancho/5, alto/5, ancho/7, 0.7f, 0.9f, 1f);
//        gl.glPopMatrix();
//         
//        gl.glColor3f(0.7f,0.9f,1f);
//        gl.glTranslatef(ancho/5 +0.15f,0,0);
//         Quad.Quad2D(gl, x0, y0, ancho/4, alto/4,0,1,1);
        
      
         //puerta
//         gl.glTranslatef(-0.12f,-0.062f,-0.05f);
//         Cubo.drawCube(gl, x0, y0, z0, ancho/5, alto/4,ancho/27, 0.7f, 0.4f, 0.3f);
         
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
