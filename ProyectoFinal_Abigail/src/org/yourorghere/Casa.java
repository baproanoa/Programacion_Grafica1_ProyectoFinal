/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;
import org.yourorghere.Cubo;

/**
 *
 * @author Abigail Proaño
 */
public class Casa {
    GL gl;
    Cubo piso, pared1, pared2, pared3, pared4, pared5, pared6;
    float x,y,z,rx,ry,rz,r,g,b,r2,g2,b2;

    public Casa(GL gl, float x, float y, float z, float rx, float ry, float rz, float r, float g, float b, float r2, float g2, float b2) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
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
    
    public void display(){
        piso = new Cubo(gl, x,y,z,rx,ry,rz,0,0,0,r,g,b);
        
        
    }
}
