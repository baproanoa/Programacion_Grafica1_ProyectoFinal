package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.media.opengl.GL;

public class Esfera2 {

    GL gl;
    float x, y, z;
    float l, a, e;
    float rx, ry, rz;
    float r, g, b;
    int slices, stacks;


    public Esfera2(GL gl, float x, float y, float z, float l, float a, float e, float rx, float ry, float rz, float r, float g, float b, int slices, int stacks) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.l = l;
        this.a = a;
        this.e = e;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
        this.slices = slices;
        this.stacks = stacks;
    }

    public void dibujaresfera() {
        GLUT glut = new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(this.l, this.a, this.e);
        glut.glutSolidSphere(a, slices, stacks);
        gl.glEnd();
        gl.glPopMatrix();

    }
}
