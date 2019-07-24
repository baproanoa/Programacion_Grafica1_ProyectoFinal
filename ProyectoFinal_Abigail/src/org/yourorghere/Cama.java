/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import org.yourorghere.Cubo;

/**
 *
 * @author Abigail Proaño
 */
public class Cama {
    
    GL gl;
    GLUT glut;
    float x,y,z,rx,ry,rz,r,g,b,ancho;
    Cubo cabecera, base, colchon, almohadas;

    public Cama(GL gl, float x, float y, float z, float rx, float ry, float rz, float r, float g, float b, float ancho) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
        this.ancho = ancho;
    }
    
    public void display(){
        base = new Cubo(gl,x,y,z,ancho,ancho/4,ancho*2,rx,ry,rz,1f,0.8f,0.6f);
        colchon = new Cubo(gl,x,y+0.1f,z,ancho-0.1f,ancho/4,ancho*2-0.1f,rx,ry,rz,r,g,b);
        cabecera = new Cubo(gl,x,y+ancho/4,z-(ancho*2-0.1f)/2,ancho,ancho-0.2f,ancho/5,rx,ry,rz,1f,0.8f,0.6f);
        almohadas = new Cubo(gl,x,y+0.2f,z-(ancho/2)-0.1f,ancho-0.1f,ancho/6,ancho/4,rx,ry,rz,1,1,0.9f);
        cabecera.display();
        base.display();
        colchon.display();
        almohadas.display();
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

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
    
    
}
