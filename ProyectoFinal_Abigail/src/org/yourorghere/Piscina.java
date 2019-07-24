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
public class Piscina {
    
    GL gl;
    float x,y,z,ancho,alto;
    Quad2 agua;
    Cubo borde1,borde2,borde3,borde4;

    public Piscina(GL gl, float x, float y, float z, float ancho, float alto) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public void display(){
        
        borde1 = new Cubo(gl,x,y+alto/2,z,ancho,alto/15,ancho/15,0,0,0,1.8f,1.8f,1.8f);
        borde2 = new Cubo(gl,x+ancho/2.1f,y,z,ancho/15,alto,ancho/15,0,0,0,1.8f,1.8f,1.8f);
        borde3 = new Cubo(gl,x,y-alto/2,z,ancho,alto/15,ancho/15,0,0,0,1.8f,1.8f,1.8f);
        borde4 = new Cubo(gl,x-ancho/2.1f,y,z,ancho/15,alto,ancho/15,0,0,0,1.8f,1.8f,1.8f);
        agua = new Quad2(gl,x,y,z-(ancho/50),ancho/2.1f,alto/2.1f,0,0,0,0,0.9f,1,1,1,1);
        
        
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        borde1.display();
        borde2.display();
        borde3.display();
        borde4.display();      
        agua.dibuja();
      
        gl.glPopMatrix();
    }
}
