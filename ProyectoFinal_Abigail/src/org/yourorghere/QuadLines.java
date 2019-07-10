package org.yourorghere;

import javax.media.opengl.GL;

public class QuadLines {

    GL gl;
    float x, y, z;
    float w, h;
    float ax, ay, az;
    float r, g, b;

    public QuadLines(GL gl, float x, float y, float z, float w, float h, float ax, float ay, float az, float r, float g, float b) {
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
    }

    public void dibujarcuadradolineas() {

        gl.glPushMatrix();

        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(ax, 1, 0, 0);
        gl.glRotatef(ay, 0, 1, 0);
        gl.glRotatef(az, 0, 0, 1);
        gl.glScaled(w, h, 0);

        gl.glBegin(gl.GL_LINES);
        gl.glColor3f(r, g, b);
        gl.glVertex2d(1, 1);
        gl.glVertex2d(1, -1);
        gl.glVertex2d(1, -1);
        gl.glVertex2d(-1, -1);
        gl.glVertex2d(-1, -1);
        gl.glVertex2d(-1, 1);
        gl.glVertex2d(-1, 1);
        gl.glVertex2d(1, 1);
        gl.glEnd();
        gl.glPopMatrix();

    }
}
