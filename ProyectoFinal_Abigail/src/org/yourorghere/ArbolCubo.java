
package org.yourorghere;

import javax.media.opengl.GL;

public class ArbolCubo {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;

    Cilindro2 tallo;
    Cubo2 h1,h2,h3;

    public ArbolCubo(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz) {
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
        this.tallo = new Cilindro2(gl, 0, -0.15f, 0, 0.095f, 0.095f, 0.35f, -90, 0, 0, 0.8f, 0.5f, 0.1f, 50, 50, 0.5f, 0.5f);
        this.h1 = new Cubo2(gl, 0, 0.1f, 0, 0.10f, 0.10f, 0.1f, 0, 0, 0, 0.3f, 0.9f, 0.4f, 0.3f,0.7f,0);
        this.h2 = new Cubo2(gl, 0, 0.25f, 0, 0.08f, 0.08f, 0.08f, 0, 0, 0,0.3f,0.7f,0, 0.3f, 0.9f, 0.4f);
        this.h3 = new Cubo2(gl, 0, 0.38f, 0, 0.06f, 0.06f, 0.06f, 0, 0, 0, 0.3f, 0.9f, 0.4f, 0.3f,0.7f,0);
    }

    public void dibujararbol() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, d);
        this.tallo.dibujarcilindro();
        this.h1.dibuja();
        this.h2.dibuja();
        this.h3.dibuja();
        
        gl.glEnd();
        gl.glPopMatrix();
    }
}
