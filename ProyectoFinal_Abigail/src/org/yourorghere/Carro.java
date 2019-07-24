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
public class Carro {
    
    GL gl;
    float x,y,z,rx,ry,rz,ancho,alto, prof,r,g,b, girar, traslada=0;
    Cubo2 base,partearriba, c1;
    Quad2 ventana, parabrisas;
    Esfera2 luz1,luz2,luz3,luz4;
    Cilindro2 cil,cil2,cil3;
    Cilindro2 rueda1,rueda2,rueda3,rueda4;

    public Carro(GL gl, float x, float y, float z, float rx, float ry, float rz, float ancho, float alto, float prof, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.ancho = ancho;
        this.alto = alto;
        this.prof = prof;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public void display(GLUT glut){
        
        base = new Cubo2(gl,x,y-alto/3,z,ancho/3,alto/4,prof,0,0,0,r/2,g/2,b/2,r,g,b);
        partearriba = new Cubo2(gl,x,y+alto,z+prof/4,ancho/2,alto/1.5f,prof*1.25f,0,0,-10,r/2,g/2,b/2,r,g,b);
        c1 = new Cubo2(gl,x+ancho/8,y+alto,z+prof/4,ancho/2,alto/1.5f,prof*1.25f,0,0,10,r/2,g/2,b/2,r,g,b);
        cil = new Cilindro2(gl,x+ancho/2,y,z-prof,ancho/6,alto/8,prof/2,0,0,-5,r/2,g/2,b/2,20,20,ancho/2,alto);
        cil2 = new Cilindro2(gl,x-ancho/2,y,z-prof,ancho/6,alto/8,prof/2,0,0,5,r/2,g/2,b/2,20,20,ancho/2,alto);
        cil3 = new Cilindro2(gl,x+ancho/14,y+alto*1.8f,z-prof,ancho/9,alto/20,prof/2,0,0,0,r/2,g/2,b/2,20,20,ancho/2,alto);
        rueda1 = new Cilindro2(gl,x-ancho,y-alto/2,z-prof-0.5f,ancho/15,ancho/15,prof/15,0,0,0,0.3f,0.3f,0.3f,20,20,ancho/3,ancho/3);
        rueda2 = new Cilindro2(gl,x+ancho,y-alto/2,z-prof-0.5f,ancho/15,ancho/15,prof/15,0,0,0,0.3f,0.3f,0.3f,20,20,ancho/3,ancho/3);
        rueda3 = new Cilindro2(gl,x+ancho,y-alto/2,z+prof+0.5f,ancho/15,ancho/15,prof/15,0,0,0,0.3f,0.3f,0.3f,20,20,ancho/3,ancho/3);
        rueda4 = new Cilindro2(gl,x-ancho,y-alto/2,z+prof+0.5f,ancho/15,ancho/15,prof/15,0,0,0,0.3f,0.3f,0.3f,20,20,ancho/3,ancho/3);
//        luz1= new Esfera2(gl,x-ancho,y-alto,z+prof/2,ancho/10,ancho/10,ancho/8,0,0,0,1,0,1,20,20);
//        ventana = new Quad2(gl,x-ancho/1.95f,y+alto+0.3f,z+prof/4,prof-0.5f,alto/2,10,90,0,0.7f,0.8f,1,0.7f/2,0.8f/2,1/2);

        
        gl.glPushMatrix();
        

         
             gl.glTranslatef(this.x, this.y, traslada+=2);
             gl.glPushMatrix();
              gl.glRotatef(90, 0, 1, 0);
              base.dibuja();
              partearriba.dibuja();
              c1.dibuja();
              cil.dibujarcilindro();
              cil2.dibujarcilindro();
              cil3.dibujarcilindro();
              rueda1.dibujarcilindro();
              rueda2.dibujarcilindro();
              rueda3.dibujarcilindro();
              rueda4.dibujarcilindro();
              gl.glPopMatrix();
        
             

       
        
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
//        gl.glColor3f(1,0,1);
//        gl.glTranslatef(x,y,z+ancho/10);
//        glut.glutSolidSphere(prof, 20, 20);
//        gl.glPopMatrix();
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

    public float getTraslada() {
        return traslada;
    }

    public void setTraslada(float traslada) {
        this.traslada = traslada;
    }
    

    
}
