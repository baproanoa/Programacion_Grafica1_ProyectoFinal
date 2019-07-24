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
public class Computador {
    
    GL gl;
    float x,y,z,rx,ry,rz,tamaño,girarz;
    Cubo2 cpu,monitor;
    Quad2 pantalla,c1,c2,c3,c4,c5;
    Circulo boton1,boton2;
    

    public Computador(GL gl, float x, float y, float z, float rx, float ry, float rz, float tamaño) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.tamaño = tamaño;
    }
    
    public void display(GLUT glut){
        
        girarz += 3f;
        
        monitor = new Cubo2(gl, x,y,z,tamaño/2,tamaño,tamaño/15,0,0,90,0.2f,0.2f,0.2f,0.4f,0.4f,0.4f);
        pantalla = new Quad2(gl,x,y,z+tamaño/14,tamaño-0.3f,tamaño-1.2f,0,0,0,0,0,0,1,1,1);
        cpu = new Cubo2(gl, x+tamaño*2,y,z,tamaño,tamaño/2,tamaño-0.5f,0,0,90,0f,0f,0f,0.2f,0.2f,0.2f);
        c1 = new Quad2(gl,x+tamaño/10,y,z+tamaño/13,tamaño/10,tamaño/10,0,0,0,0,1,0,0,1,0);
        c2 = new Quad2(gl,x-tamaño/7,y-tamaño/4,z+tamaño/13,tamaño/10,tamaño/10,0,0,0,0.2f,0.5f,1f,0.2f,0.5f,1);
        c3 = new Quad2(gl,x+tamaño/10,y-tamaño/4,z+tamaño/13,tamaño/10,tamaño/10,0,0,0,1,1,0,1,1,0);
        c4 = new Quad2(gl,x-tamaño/7,y,z+tamaño/13,tamaño/10,tamaño/10,0,0,0,1f,0.7f,0.1f,1f,0.7f,0.1f);
        boton1 = new Circulo(gl,x+tamaño*2,y,z+tamaño/1.3f,tamaño/7,tamaño/7,0,0,0,1,0,0);
        boton2 = new Circulo(gl,x+tamaño*2.3f,y,z+tamaño/1.3f,tamaño/7,tamaño/7,0,0,0,0,1,0);
        c5 = new Quad2(gl,x+tamaño*2,y+tamaño/2,z+tamaño/1.3f,tamaño/3,tamaño/4,0,0,0,0f,0f,0f,0.8f,0.8f,0.8f);
        
        
        gl.glPushMatrix();
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        
        gl.glPushMatrix();
        monitor.dibuja();
        pantalla.dibuja();
        cpu.dibuja();
        c5.dibuja();
        boton1.display();
        boton2.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(girarz,0,0,1);
        c1.dibuja();
        c2.dibuja();
        c3.dibuja();
        c4.dibuja();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.3f,0.3f,0.3f);
        gl.glTranslatef(x,y-tamaño,z);
        gl.glRotatef(-90,1,0,0);
        glut.glutSolidCylinder(tamaño/6, tamaño/2, 20, 20);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.2f,0.2f,0.2f);
        gl.glTranslatef(x,y-tamaño,z);
        gl.glRotatef(-90,1,0,0);
        glut.glutSolidCone(tamaño/2, tamaño/2, 20, 20);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
}
