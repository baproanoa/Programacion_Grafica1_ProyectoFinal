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
public class Pergola {
    
    GL gl;
    float x,y,z,ancho,alto,altura,r,g,b;
    Cubo viga1,viga2,viga3;
    Quad2 vidrio;
    float r2 =0.7f,g2=0.8f,b2=1;

    public Pergola(GL gl, float x, float y, float z, float ancho, float alto, float altura, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.altura = altura;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(GLUT glut){
        
       
        viga1 = new Cubo(gl,x+ancho/2.1f,y,z,ancho/40,alto,ancho/30,0,0,0,r,g,b);
        viga2 = new Cubo(gl,x,y,z,ancho/40,alto,ancho/30,0,0,0,r,g,b);
        viga3 = new Cubo(gl,x-ancho/2.1f,y,z,ancho/40,alto,ancho/30,0,0,0,r,g,b);
        vidrio = new Quad2(gl,x,y,z,ancho/2.1f,alto/2.1f,0,0,0,r2,g2,b2,r2/2,g2/2,b2/2);
        
        //viga 1 extremo
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        viga1.display();
        gl.glPopMatrix();
        
          //viga 2 extremo
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        viga2.display();
        gl.glPopMatrix();
        
        //viga mitad
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        viga3.display();
        gl.glPopMatrix();
        
        //vigas
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/4,y,z);
        gl.glRotatef(90,1,0,0);
        viga3.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/8,y,z);
        gl.glRotatef(90,1,0,0);
        viga3.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/4,y,z);
        gl.glRotatef(90,1,0,0);
        viga2.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x+ancho/8,y,z);
        gl.glRotatef(90,1,0,0);
        viga2.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/8,y,z);
        gl.glRotatef(90,1,0,0);
        viga1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(x-ancho/1.7f,y,z);
        gl.glRotatef(90,1,0,0);
        viga1.display();
        gl.glPopMatrix();
        
        //vidrio
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        vidrio.dibuja();
        gl.glPopMatrix();
        
        //COLUMNAS
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x-ancho/2.1f,y-alto/18,z+alto/3);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/100, altura, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(r,g,b);
        gl.glTranslatef(x+ancho/2.1f,y-alto/18,z+alto/3);
        gl.glRotatef(90,1,0,0);
        glut.glutSolidCylinder(ancho/100, altura, 20, 20);
        gl.glPopMatrix();
        
       
    }
}
