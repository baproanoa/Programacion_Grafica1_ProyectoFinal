package org.yourorghere;

import javax.media.opengl.GL;

public class ArbolEsferas {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;

    Cilindro2 tallo;
    Esfera2 h1, h2, h3, h4, h5, h6, h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21;
    //Piramide 

    public ArbolEsferas(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.tallo = new Cilindro2(gl, 0, -0.15f, 0, 0.095f, 0.095f, 0.75f, -90, 0, 0, 0.8f, 0.5f, 0.1f, 30, 30, 0.5f, 0.5f);
        this.h1 = new Esfera2(gl, 0, 0.3f, 0, 0.3f, 0.3f, 0.3f, 10, 10, 10, 0.2f, 1, 0.1f, 30, 30);
        this.h2 = new Esfera2(gl, 0, 0.15f, 0, 0.3f, 0.3f, 0.3f, 10, 10, 10, 0.0f, 0.6f, 0.1f, 30, 30);
        this.h3 = new Esfera2(gl, 0, 0.225f, 0.13f, 0.28f, 0.28f, 0.28f, 10, 10, 10, 0.0f, 0.5f, 0.1f, 30, 30);
        this.h4 = new Esfera2(gl, 0, 0.225f, -0.13f, 0.28f, 0.28f, 0.28f, 10, 10, 10, 0.0f, 0.9f, 0.3f, 30, 30);
        this.h5 = new Esfera2(gl, 0, 0.35f, 0.13f, 0.28f, 0.28f, 0.28f, 10, 10, 10, 0f, 1, 0.4f, 30, 30);
        this.h6 = new Esfera2(gl, 0, 0.35f, -0.13f, 0.28f, 0.28f, 0.28f, 10, 10, 10, 0.1f, 0.5f, 0f, 30, 30);
        this.h7 = new Esfera2(gl, 0, 0.43f, 0, 0.3f, 0.3f, 0.3f, 10, 10, 10, 0.4f, 1, 0.5f, 30, 30);
        this.h8 = new Esfera2(gl, 0.08f, 0.37f, 0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 0.6f, 0.2f, 30, 30);
        this.h9 = new Esfera2(gl, 0.08f, 0.37f, -0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 0.9f, 0.2f, 30, 30);
        this.h10 = new Esfera2(gl, 0.08f, 0.2f, 0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 0.7f, 0.0f, 30, 30);
        this.h11= new Esfera2(gl, 0.08f, 0.2f, -0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 1f, 0.4f, 30, 30);
        this.h12= new Esfera2(gl, 0.08f, 0.28f, 0.075f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.7f, 0.9f, 0f, 30, 30);
        this.h13= new Esfera2(gl, 0.08f, 0.28f, -0.075f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.5f, 0.6f, 0.2f, 30, 30);
        this.h14= new Esfera2(gl, 0.098f, 0.28f, 0f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.7f, 1f, 0.3f, 30, 30);
        
        this.h15 = new Esfera2(gl, -0.08f, 0.37f, 0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 0.6f, 0.2f, 30, 30);
        this.h16 = new Esfera2(gl, -0.08f, 0.37f, -0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 0.9f, 0.2f, 30, 30);
        this.h17 = new Esfera2(gl, -0.08f, 0.2f, 0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 0.7f, 0.0f, 30, 30);
        this.h18= new Esfera2(gl, -0.08f, 0.2f, -0.04f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.4f, 1f, 0.4f, 30, 30);
        this.h19= new Esfera2(gl, -0.08f, 0.28f, 0.075f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.7f, 0.9f, 0f, 30, 30);
        this.h20= new Esfera2(gl, -0.08f, 0.28f, -0.075f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.5f, 0.6f, 0.2f, 30, 30);
        this.h21= new Esfera2(gl, -0.098f, 0.28f, 0f, 0.22f, 0.22f, 0.22f, 10, 10, 10, 0.7f, 1f, 0.3f, 30, 30);
//        this.h2 = new Piramide(gl, 0, 0.3f, 0, 0.12f, 0.12f, 0.12f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
//        this.h3 = new Piramide(gl, 0, 0.4f, 0, 0.09f, 0.09f, 0.09f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
//        this.h4 = new Piramide(gl, 0, 0.5f, 0, 0.06f, 0.06f, 0.06f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
    }

    public void dibujararbol() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, d);
        this.tallo.dibujarcilindro();
        this.h1.dibujaresfera();
        this.h2.dibujaresfera();
        this.h3.dibujaresfera();
        this.h4.dibujaresfera();
        this.h5.dibujaresfera();
        this.h6.dibujaresfera();
        this.h7.dibujaresfera();
        this.h8.dibujaresfera();
        this.h9.dibujaresfera();
        this.h10.dibujaresfera();
        this.h11.dibujaresfera();
        this.h12.dibujaresfera();
        this.h13.dibujaresfera();
        this.h14.dibujaresfera();
        this.h15.dibujaresfera();
        this.h16.dibujaresfera();
        this.h17.dibujaresfera();
        this.h18.dibujaresfera();
        this.h19.dibujaresfera();
        this.h20.dibujaresfera();
        this.h21.dibujaresfera();
//        this.h2.dibuja();
//        this.h3.dibuja();
//        this.h4.dibuja();
//        this.rx = rx + 0.8f;
//        this.ry = ry + 0.9f;
//        this.h = h + 0.01f;

//this.w = w + 0.01f;
        //        this.rz = rz + 0.8f;
        gl.glEnd();
        gl.glPopMatrix();
    }
}
