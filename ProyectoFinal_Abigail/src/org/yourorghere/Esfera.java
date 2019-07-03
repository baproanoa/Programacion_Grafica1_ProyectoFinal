/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import com.sun.opengl.util.texture.Texture;
import java.util.Random;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Jarol
 */
public class Esfera {
    Random rnd = new Random();
    float ra;//radio
    int slices, stacks;//son los cortes horizontales y verticales realizamos para hacer una esfera
    Texture t;
    float x,y,z,w,h,d,rx,ry,rz,r,g,b;
    GL gl;
//sol = new ESFERA(gl,0.9f,100,100,-2,10f,25,1f,1f,0,1,1,1,0,0,0);
    ///sol = new ESFERA(1f,1f,0,-2,10,25,1,1,1,0,0,0,gl,0.9f,100,100);
    public Esfera( float x, float y, float z,float w, float h, float d,float rx, float ry, float rz, float r, float g, float b,GL gl, float ra, int slices, int stacks) {
         
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
        
        
//        this.gl = gl;
        this.ra=ra;
        this.slices = slices;
        this.stacks = stacks;
        this.t=null;
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

    GLUquadric esfer = glu.gluNewQuadric(); //renderizar conos, cilindros, y todo
    glu.gluQuadricDrawStyle (esfer,GLU.GLU_FILL);//GLU_LINE, GLU_POINT, GLU_SILHOUETTE
    
//    gl.glColor4f(rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat(),.5f);
    glu.gluSphere(esfer,ra,slices,stacks);//recibe el radio, numero de cortes horizontales y verticales
    
    glu.gluQuadricDrawStyle (esfer,GLU.GLU_LINE);
//    glu.gluQuadricDrawStyle (esfera,GLU.GLU_SILHOUETTE);
  
        
      
    gl.glColor4f(rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat(),.5f);
       
    
    glu.gluSphere(esfer,ra,slices,stacks);//recibe el radio, numero de cortes horizontales y verticales
    
 
    gl.glPopMatrix();
}
    public void display1(){
     

    gl.glPushMatrix();
    
    gl.glTranslatef(x,y,z);     //Traslacion
    gl.glRotatef(rx,1,0,0);
    gl.glRotatef(ry,0,1,0);
    gl.glRotatef(rz,0,0,1);
    gl.glColor3f(r, g, b);
    GLU glu=new GLU();

    GLUquadric esfer = glu.gluNewQuadric(); //renderizar conos, cilindros, y todo
    glu.gluQuadricDrawStyle (esfer,GLU.GLU_FILL);//GLU_LINE, GLU_POINT, GLU_SILHOUETTE
    glu.gluSphere(esfer,ra,slices,stacks);//recibe el radio, numero de cortes horizontales y verticales
    
   
    
 
    gl.glPopMatrix();
}
   
        
    
     float getry() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.ry;
    }

    float getx() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.x;
    }

    float getrx() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return this.rx;
    }

    float gety() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return this.y;
    }

    float getz() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return this.z;
    }
        float setry(float ry) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.ry;
    }

    float setx(float x) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.x;
    }

    double setrx(float rx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return this.rx;
    }

    float sety(float y) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return this.y;
    }

    float setz(float z) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return this.z;
    }
}
