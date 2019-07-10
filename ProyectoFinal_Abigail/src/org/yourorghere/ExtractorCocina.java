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
public class ExtractorCocina {
    
    GL gl;
    GLUT glut;
    
    float x,y,z,rx,ry,rz,ancho,alto, prof,r,g,b;
    PiramideQuad campana;

    public ExtractorCocina(GL gl, float x, float y, float z, float ancho, float alto, float prof, float r, float g, float b) {
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
        
        campana = new PiramideQuad(gl,x,y-(alto/2),z,ancho,alto/1.5f,prof,r,g,b);
        
        campana.drawPiramide();
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y+(alto/2),z);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/10f, alto/2, 10, 10);
        gl.glPopMatrix();
    }      
    
    
}
