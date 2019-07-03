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
public class Tetera {
    GL gl;
    GLUT glut;
    double scale;
    float x,y,z,rx,ry,rz,r,g,b;

    public Tetera(GL gl, double scale, float x, float y, float z, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
//        this.glut = glut;
        this.scale = scale;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
    }


    
    public void drawSolid(GLUT glut){
        
    gl.glPushMatrix();
    
    gl.glTranslatef(x,y,z);     //Traslacion
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    gl.glRotatef(rz,0,0,1);
    gl.glColor3f(r, g, b);
    glut.glutSolidTeapot(scale);
    gl.glPopMatrix();
    }
    
  public void drawWire(GLUT glut){
        
    gl.glPushMatrix();
    
    gl.glTranslatef(x,y,z);     //Traslacion
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    gl.glRotatef(rz,0,0,1);
    gl.glColor3f(r, g, b);
    glut.glutWireTeapot(scale);
    gl.glPopMatrix();
    }
    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
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

    public float getRx() {
        return rx;
    }

    public void setRx(float rx) {
        this.rx = rx;
    }

    public float getRy() {
        return ry;
    }

    public void setRy(float ry) {
        this.ry = ry;
    }

    public float getRz() {
        return rz;
    }

    public void setRz(float rz) {
        this.rz = rz;
    }
    
    
    
}
