package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class ArbolPir {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;

    Cilindro2 tallo;
    Piramide hoja1, hoja2, hoja3, hoja4;

    public ArbolPir(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz) {
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
        this.tallo = new Cilindro2(gl, 0, -0.15f, 0, 0.08f, 0.08f, 0.45f, -90, 0, 0, 0.8f, 0.5f, 0.1f, 50, 50, 0.5f, 0.5f);
        this.hoja1 = new Piramide(gl, 0, 0.2f, 0, 0.15f, 0.15f, 0.15f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
        this.hoja2 = new Piramide(gl, 0, 0.3f, 0, 0.12f, 0.12f, 0.12f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
        this.hoja3 = new Piramide(gl, 0, 0.4f, 0, 0.09f, 0.09f, 0.09f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
        this.hoja4 = new Piramide(gl, 0, 0.5f, 0, 0.06f, 0.06f, 0.06f, 0, 0, 0, 0f, 1f, 0.3f, 0.1f, 0.9f, 0.5f);
    }

    public void dibujararbol() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, d);
        this.tallo.dibujarcilindro();
        this.hoja1.dibuja();
        this.hoja2.dibuja();
        this.hoja3.dibuja();
        this.hoja4.dibuja();
//        this.rx = rx + 0.8f;
        //this.ry = ry + 0.9f;
       
//        this.h = h + 0.01f;
        //        this.w = w + 0.01f;
        //        this.rz = rz + 0.8f;
        gl.glPopMatrix();
    }
}
