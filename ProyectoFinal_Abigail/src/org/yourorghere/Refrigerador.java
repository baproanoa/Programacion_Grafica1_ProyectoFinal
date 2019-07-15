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
public class Refrigerador {
    GL gl;
    GLUT glut;
    float x,y,z,ancho,alto,prof,r,g,b;
    Cubo refri;

    public Refrigerador(GL gl, float x, float y, float z, float ancho, float alto, float prof, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.prof = prof;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(GLUT glut){
    
        refri = new Cubo(gl, x,y,z,ancho,alto,prof,0,0,0,r/2,g/2,b/2);
        
        
        refri.display();
                
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glBegin(gl.GL_LINES);
        gl.glVertex3f(x,y-(alto/1.98f),z-(prof/1.98f));
        gl.glVertex3f(x,y+(alto/1.98f),z-(prof/1.98f));
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x-(ancho/6),y+(alto/10),z-(prof/1.98f));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.1f, alto/5, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(1,1,1);
        gl.glTranslatef(x+(ancho/6),y+(alto/10),z-(prof/1.98f));
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(0.1f, alto/5, 20, 20);
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
