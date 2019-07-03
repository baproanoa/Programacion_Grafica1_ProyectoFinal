/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author 
 */
public class Cilindro {
    
     public int slices, stacks;//son los cortes horizontales y verticales realizamos para hacer una esfera
     public float x,y,z,w,h,d,rx,ry,rz,r,g,b,ra,rb,ha;
     public GL gl;
//sol = new ESFERA(gl,0.9f,100,100,-2,10f,25,1f,1f,0,1,1,1,0,0,0);
    ///sol = new ESFERA(1f,1f,0,-2,10,25,1,1,1,0,0,0,gl,0.9f,100,100);
    public Cilindro( float x, float y, float z,float w, float h, float d,float rx, float ry, float rz, float r, float g, float b,GL gl, float ra, float rb, float ha,int slices, int stacks) {
         
        this.x=x;
        this.y=y;
        this.z=z;
        this.r=r;
        this.g=g;
        this.b=b;
        this.w=w;
        this.h=h;
        this.d=d;
        this.rx=rx;
        this.ry=ry;
        this.rz=rz;
        this.gl=gl;
        
        this.ha=ha;
        
        
//        this.gl = gl;
        this.ra=ra;
        this.rb=rb;
        this.slices = slices;
        this.stacks = stacks;
    
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.r=r;
//        this.g = g;
//        this.b = b;
//        this.rx=rx;
//        this.ry=ry;
//        this.rz=rz;
        
              
    }    

    
    public void display(){
     

    gl.glPushMatrix();
    
    gl.glTranslatef(x,y,z);     //Traslacion
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    gl.glRotatef(rz,0,0,1);
    gl.glColor3f(r, g, b);
    GLU glu=new GLU();

    GLUquadric cilin = glu.gluNewQuadric(); //renderizar conos, cilindros, y todo
//    glu.gluQuadricDrawStyle (esfera,GLU.GLU_FILL);//GLU_LINE, GLU_POINT, GLU_SILHOUETTE
//    glu.gluQuadricDrawStyle (cilinder,GLU.GLU_LINE);
//    glu.gluQuadricDrawStyle (esfera,GLU.GLU_SILHOUETTE);

    glu.gluQuadricDrawStyle (cilin,GLU.GLU_FILL);
    glu.gluCylinder(cilin, ra, rb, ha, slices, stacks);//Cylender(cilindro,r1,r2,h,slices,stacks);
    glu.gluQuadricDrawStyle (cilin,GLU.GLU_LINE);
    gl.glColor3f(0,0,0);
    glu.gluCylinder(cilin, ra, rb, ha, slices, stacks);//Cylender(cilindro,r1,r2,h,slices,stacks);
    gl.glPopMatrix();
}
    
}
