package org.yourorghere;

import javax.media.opengl.GL;

public class Piramide {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;
    float r2, g2, b2;

    public Piramide(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, float r, float g, float b, float r2, float g2, float b2) {
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
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    

    public void dibuja() {

        gl.glPushMatrix();

        
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);

        gl.glScalef(this.w, this.h, this.d);

        gl.glBegin(GL.GL_QUADS);
        //BASE
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(-1, -1, 1);

        gl.glEnd();

        gl.glBegin(GL.GL_TRIANGLES);
        //Cara Lateral Derecha
        //gl.glColor3f(0f, 1f, 0.3f);
        gl.glColor3f(this.r2, this.g2, this.b2);        
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(-1, -1, -1);

        //Cara Lateral Izquierda
        //gl.glColor3f(0.1f, 0.9f, 0.5f);
        gl.glColor3f(this.r2, this.g2, this.b2);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(1, -1, -1);

        //Cara  atras
        //gl.glColor3f(0f, 1f, 0.3f);
        gl.glColor3f(this.r, this.g, this.b);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(-1, -1, -1);

        //Cara  delante
        //gl.glColor3f(0.1f, 0.9f, 0.5f);
        gl.glColor3f(this.r, this.g, this.b);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(-1, -1, 1);
//        this.rx = rx + 0.8f;
//        this.ry = ry + 0.8f;
//        this.rz = rz + 0.8f;
        gl.glEnd();

        gl.glPopMatrix();
    }

}
