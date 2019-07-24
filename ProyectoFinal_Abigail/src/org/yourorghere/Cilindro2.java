
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Cilindro2 {
    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;
    int slices, stacks;
    double rs, ri;
    
     public Cilindro2(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, float r, float g, float b, int slices, int stacks, double rs, double ri) {
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
        this.slices = slices;
        this.stacks = stacks;
        this.rs = rs;
        this.ri = ri;
    }
public void dibujarcilindro(){
        GLUT glut = new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
//        gl.glTranslatef(this.x, this.y, this.z);
        gl.glScalef(this.w, this.h, this.d);
        glut.glutSolidCylinder(rs, ri, slices, stacks);
        gl.glPopMatrix();
        gl.glEnd();
    }
    
}
