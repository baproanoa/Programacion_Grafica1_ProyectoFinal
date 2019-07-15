package org.yourorghere;

import javax.media.opengl.GL;
import static javax.media.opengl.GL.GL_POINTS;

public class Circulo {

    GL gl;
    float x, y, z;
    float w, h;
    float ax, ay, az;
    float r, g, b;

    public Circulo(GL gl, float x, float y, float z, float w, float h, float ax, float ay, float az, float r, float g, float b) {
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

    public void dibujarcirculo() {
        gl.glPushMatrix();
        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(ax, 1, 0, 0);
        gl.glRotatef(ay, 0, 1, 0);
        gl.glRotatef(az, 0, 0, 1);
        gl.glScaled(w, h, 0);

        gl.glBegin(GL_POINTS);
        gl.glColor3f(r, g, b);
        for (int i = 0; i < 100; i++) {
            float x = ((float) Math.cos(i * 2 * 3.14159265358979323846 / 100));
            float y = ((float) Math.sin(i * 2 * 3.14159265358979323846 / 100));
            gl.glVertex2f(w * (x), h * (y));
         
        }

        gl.glEnd();
        gl.glPopMatrix();

    }
    
        public void display() {
        gl.glPushMatrix();
        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(ax, 1, 0, 0);
        gl.glRotatef(ay, 0, 1, 0);
        gl.glRotatef(az, 0, 0, 1);
        gl.glScaled(w, h, 0);

        gl.glBegin(gl.GL_POLYGON);
        gl.glColor3f(r, g, b);
        for (int i = 0; i < 100; i++) {
            float x = ((float) Math.cos(i * 2 * 3.14159265358979323846 / 100));
            float y = ((float) Math.sin(i * 2 * 3.14159265358979323846 / 100));
            gl.glVertex2f(w * (x), h * (y));
         
        }

        gl.glEnd();
        gl.glPopMatrix();

    }
    
    public void dibujarcirculoBorde() {
        gl.glPushMatrix();
        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(ax, 1, 0, 0);
        gl.glRotatef(ay, 0, 1, 0);
        gl.glRotatef(az, 0, 0, 1);
        gl.glScaled(w, h, 0);
       
        gl.glBegin(gl.GL_LINES);
        gl.glColor3f(r, g, b);
        for (int i = 0; i < 100; i++) {
            float x = ((float) Math.cos(i * 2 * 3.14159265358979323846 / 100));
            float y = ((float) Math.sin(i * 2 * 3.14159265358979323846 / 100));
            gl.glVertex2f(w * (x), h * (y));
            gl.glColor3f(r, g, b);
        }

        gl.glEnd();
        gl.glPopMatrix();

    }


    public void dibujarsemicirculo() {
        gl.glPushMatrix();
        gl.glTranslated(this.x, this.y, this.z);
        gl.glRotatef(ax, 1, 0, 0);
        gl.glRotatef(ay, 0, 1, 0);
        gl.glRotatef(az, 0, 0, 1);
        gl.glScaled(w, h, 0);

        gl.glBegin(GL_POINTS);
        gl.glColor3f(r, g, b);
        for (int i = 0; i < 100; i++) {
            float x = ((float) Math.cos(i * 3.14159265358979323846 / 100));
            float y = ((float) Math.sin(i * 3.14159265358979323846 / 100));
            gl.glVertex2f(w * (x), h * (y));
            gl.glColor3f(r, g, b);
        }

        gl.glEnd();
        gl.glPopMatrix();

    }
}
