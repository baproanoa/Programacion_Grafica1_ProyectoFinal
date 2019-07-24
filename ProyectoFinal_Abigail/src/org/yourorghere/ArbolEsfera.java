package org.yourorghere;

import javax.media.opengl.GL;

public class ArbolEsfera {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;

    Cilindro2 tallo;
    Esfera2 hoja;

    public ArbolEsfera(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz) {
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
        this.tallo = new Cilindro2(gl, 0, -0.15f, 0, 0.095f, 0.095f, 0.75f, -90, 0, 0, 0.8f, 0.5f, 0.1f, 50, 50, 0.5f, 0.5f);
        this.hoja = new Esfera2(gl, 0, 0.4f, 0, 0.35f, 0.5f, 0.35f, 0, 0, 0, 0.3f, 1, 0.2f, 60, 60);

    }

    public void dibujararbol() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, d);
        this.tallo.dibujarcilindro();
        this.hoja.dibujaresfera();

        gl.glEnd();
        gl.glPopMatrix();
    }
}
