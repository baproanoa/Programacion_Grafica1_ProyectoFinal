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
public class Baldosa {
    
    GL gl;
    float x,y,z,ancho,alto,r,g,b,r2,g2,b2;
    Quad2 baldosas1;

    public Baldosa(GL gl, float x, float y, float z, float ancho, float alto, float r, float g, float b) {
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
    
    public void display(int num){
        
        baldosas1 = new Quad2(gl,x,y,z,ancho/10,ancho/10,270,0,0,r,g,b,r/2,g/2,b/2);

                
        gl.glPushMatrix();
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();
            
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(2*(ancho/10),0,2*(ancho/10));
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(4*(ancho/10),0,0);
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(6*(ancho/10),0,2*(ancho/10));
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-2*(ancho/10),0,2*(ancho/10));
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-4*(ancho/10),0,0);
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-6*(ancho/10),0,2*(ancho/10));
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-8*(ancho/10),0,0);
        for (int i = 2; i < num+1; i++) {
            
            gl.glTranslatef(0,0,4*(ancho/10));
            baldosas1.dibuja();    
        }
        gl.glPopMatrix();
        
    }
}
