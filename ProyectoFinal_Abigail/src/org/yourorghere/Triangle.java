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
public class Triangle{

    GL gl;
    float x,y, rx,ry,base, alto,r,g,b;

    public Triangle(GL gl, float x, float y, float rx, float ry, float base, float alto, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.rx = rx;
        this.ry = ry;
        this.base = base;
        this.alto = alto;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
//    public static void drawTriangle(GL gl, float x, float y0, float base, float alto) {
//        float ba = base/2;
//        float al = alto/2;
//        
//        gl.glColor3f(r,g,b);
//        gl.glBegin(gl.GL_TRIANGLES);
//        gl.glVertex2d(x0-ba, y0-al); //vertice inicial o posicion inicial
//        gl.glVertex2d(x0 + ba, y0-al);
//        gl.glVertex2d(x0, y0 + al);
//        
//        gl.glEnd();
//    }

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
    
    
}
