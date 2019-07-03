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
public class Arbol3D {

    GL gl;
    float x,y,z,alto,ancho,rx,ry,rz;
    Cubo tronco;
    PiramideQuad hojas;

    public Arbol3D(GL gl, float x, float y, float z, float alto, float ancho, float rx, float ry, float rz) {
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


 
    
   
    
    public void display(){
        tronco = new Cubo (gl, x, y, z, ancho/4, alto/2, alto/4, rx,ry,rz,0.6f, 0.3f, 0);
        hojas = new PiramideQuad(gl, x, y, z, ancho, alto/2, alto/2, 0.6f, 0.7f, 0.1f);
        
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);     //Traslacion
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        
        tronco.display();
        hojas.drawPiramide();
        gl.glTranslatef(0,alto-0.4f,0);
        hojas.drawPiramide();
          gl.glTranslatef(0,alto-0.39f,0);
        hojas.drawPiramide();
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
////        gl.glTranslatef(0,-0.2f,0);
//    
//        gl.glPopMatrix();
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
