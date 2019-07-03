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
public class Sillas {
    
    GLUT glut = new GLUT();
    GL gl;
    float x,y,z,rx,ry,rz,ancho,alto,r,g,b;
    Cubo patas1,patas2,espaldar,base,resp,posabrazo;
    public Sillas(GL gl, float x, float y, float z, float rx, float ry, float rz, float ancho, float alto, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.ancho = ancho;
        this.alto = alto;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void silla(){
        
        base = new Cubo(gl,x,y,z,ancho,alto/10,ancho,rx,ry,rz,r,g,b);
        patas1 = new Cubo(gl,x,y,z,ancho/6,alto/2,ancho/10,rx,ry,rz,r,g,b);
        patas2 = new Cubo(gl,x,y,z,ancho/6,alto,ancho/10,rx,ry,rz,r,g,b);
        espaldar = new Cubo(gl,x,y,z,ancho/6,alto/3,ancho,rx,ry,rz,r,g,b);
        
        base.display();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/2.3f,y-alto/4,z-ancho/2.5f);
        patas1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/2.3f,y-alto/4,z+ancho/2.5f);
        patas1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/2.2f,y-alto/60,z-ancho/2.5f);
        patas2.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/2.2f,y-alto/60,z+ancho/2.5f);
        patas2.display();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(x-ancho/2.3f,y+alto/2,z-ancho/40);
        espaldar.display();
        gl.glPopMatrix();
        
    }
    
    public void sillon(){
        espaldar = new Cubo(gl,x,y,z,ancho,alto/3,ancho/10,rx,ry,rz,r,g,b);
        posabrazo = new Cubo(gl,x,y,z,ancho/10,alto/7,ancho/3,rx,ry,rz,r,g,b);
        base = new Cubo(gl,x,y,z,ancho,alto/4,ancho/3,rx,ry,rz,r,g,b);
        
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(rx,1,0,0);
        gl.glRotatef(ry,0,1,0);
        gl.glRotatef(rz,0,0,1);
        
        gl.glPushMatrix();
        base.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,alto/4,-ancho/8.5f);
        espaldar.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(ancho/2.22f,alto/6,0);
        posabrazo.display();
        gl.glPopMatrix();
        
        
         gl.glPushMatrix();
        gl.glTranslatef(-ancho/2.22f,alto/6,0);
        posabrazo.display();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
}
