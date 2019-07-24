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
public class Espejo {
    
    GL gl;
    float x,y,z,ancho,alto,r,g,b;
    Circulo vidrio;
    
    public Espejo(GL gl, float x, float y, float z, float ancho, float alto, float r, float g, float b) {
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
    
    
    public void espejoredondo(GLUT glut){
     
        vidrio = new Circulo(gl,x,y,z,ancho*1.4f,alto-0.1f,0,0,0,0.8f,0.9f,1);
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x,y,z);
//        gl.glRotatef(90,1,0,0);
        glut.glutSolidTorus(ancho/4, ancho*4, 40, 40);
        gl.glPopMatrix();
        
        vidrio.display();
    }
}
