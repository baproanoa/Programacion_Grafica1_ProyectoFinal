/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Abigail Proaño
 */
public class Circle {

    public Circle() {
    }
    
    public static void drawCircle(GL gl, float x0, float y0, float ancho,float alto, float c1, float c2, float c3){
       
        gl.glScalef(x0 + ancho,y0 + alto,0); 
        gl.glBegin(gl.GL_POLYGON);
         
        for (int i = 0; i < 100 ; i++) {
            gl.glVertex2f((float)(Math.cos(i*2*Math.PI/100 )),(float)(Math.sin(i*2*Math.PI/100)) );
            gl.glColor3f(c1, c2, c3);
        }
        gl.glEnd();
    }
//      public static void dibujarCirculo(GL gl,float c1, float c2, float c3){
//        gl.glBegin(gl.GL_POLYGON);
//        for (int i = 0; i < cir +1; i++) {
//            gl.glVertex2f((float)(Math.cos(i*2*Math.PI/100)),(float)(Math.sin(i*2*Math.PI/100)) );
//            gl.glColor3f(c1, c2, c3);
//        }
//        gl.glEnd();
//    }
}
