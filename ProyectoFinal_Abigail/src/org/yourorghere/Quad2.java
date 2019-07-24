package org.yourorghere;

import javax.media.opengl.GL;

public class Quad2 {

    GL gl;
    float x, y, z;
    float w, h;
    float ax, ay, az;
    float r, g, b;
    float r2, g2, b2;

    public Quad2(GL gl, float x, float y, float z, float w, float h, float ax, float ay, float az, float r, float g, float b, float r2, float g2, float b2) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    public void dibuja() {

        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(ax, 1, 0, 0);
        gl.glRotatef(ay, 0, 1, 0);
        gl.glRotatef(az, 0, 0, 1);
        gl.glScaled(w, h, 0);

        //Color 
        gl.glBegin(gl.GL_QUADS);//Inicio de la creacion//Tipo 
        gl.glColor3f(r2, g2, b2);
        gl.glVertex2d(1, 1);
        gl.glColor3f(r, g, b);
        gl.glVertex2d(1, -1);
        gl.glColor3f(r, g, b);
        gl.glVertex2d(-1, -1);
        gl.glColor3f(r, g, b);
        gl.glVertex2d(-1, 1);

        gl.glEnd();
        gl.glPopMatrix();

    }

}
