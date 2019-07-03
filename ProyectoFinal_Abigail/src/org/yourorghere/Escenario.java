package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.nio.file.Files.size;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import com.sun.opengl.util.GLUT;
import java.awt.event.KeyEvent;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.KeyListener;
import org.yourorghere.Arbol3D;
import org.yourorghere.Casa3D;
import org.yourorghere.Esfera;
import org.yourorghere.Gradas;
import org.yourorghere.Lamparas;
import org.yourorghere.Mesa;
import org.yourorghere.Sillas;



/**
 *
 * @author Abigail Proaño
 */
public class Escenario extends JFrame implements  KeyListener {
    public static int ncam=1;
    GLUT glut;
    static  GL gl;
    static GLU glu;
    static float rotar = 0;
    float movex,movey,movez,movex1,movey1;
//    CILINDRO cilindro, cono, cubo;
    float rot, i;
    Esfera cam;
    Casa3D casa;
   Cubo pisocasa, pisoprin,piso2do,piso22, pared,pared2,pared3, mesacocina, estante;
   Arbol3D arbol;
   Cama cama1, cama2, cama3;
   Gradas gradasEntra,gradas2,gradas3;
   Mesa comedor, mesatele;
   Lamparas lamp1, lamp2;
   Sillas sala,sala2, sillaMesa;
   



    public Escenario(){
//        setTitle("Puntos");
        setSize(700,700);
        setLocation(10,40);
       
        // Intancia de clase GraphicListener
        
        GraphicListener listener = new GraphicListener();
        GLCanvas canvas= new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
          Animator animator = new Animator(canvas);
        animator.start();
        
                addKeyListener(this); // Para que canvas reconozca las pulsaciones del teclado
        
    }
    
    public static void main(String[] args) {
        
         Escenario frame = new Escenario();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                       
 
    }
 public class GraphicListener implements GLEventListener{
     
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        
        // Enable VSync
        gl.setSwapInterval(1);
        
        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        gl.glShadeModel(GL.GL_SMOOTH); 
        

        cam=new Esfera(-7,1,-7,1,1,1,0,0,0,0,1,0,gl,.5f,7,7);
        casa = new Casa3D(gl,-0.7f,-0.3f,0.3f,1.75f,1.75f,0,0,0);
        pisocasa = new Cubo(gl,0,0,0f,20f,1f,20f,0,0,0,0.9f,0.8f,0.6f);
        piso2do = new Cubo(gl,0,0,0f,12f,0.25f,19.5f,0,0,0,0.9f,0.8f,0.6f);
        piso22 = new Cubo(gl,0,0,0f,6f,0.25f,16f,0,0,0,0.9f,0.8f,0.6f);
        pisoprin = new Cubo(gl,0,0,0,50f,2f,70f,0,0,0,0f,0.6f,0.2f);
        pared = new Cubo(gl,0,0,0,0.1f,20,5,0,0,0,0.9f,0.9f,0.6f);
        pared2 = new Cubo(gl,0,0,0,0.1f,10,1,0,0,0,0.9f,0.9f,0.6f);
        pared3 = new Cubo(gl,0,0,0,0.1f,1.5f,1.2f,0,0,0,0.9f,0.9f,0.6f);
        mesacocina = new Cubo(gl,0f,0f,0f,1f,0.3f,0.3f,0,0,0,0.9f,0.7f,0.6f);
        arbol = new Arbol3D(gl,0,0,0,0.5f,0.4f,0,0,0);
        cama1 = new Cama(gl,0,0,0,0,0,0,0.3f,0.7f,0.9f,0.7f);
        cama2 = new Cama(gl,0,0,0,0,0,0,1f,0.3f,0.6f,0.7f);
        cama3 = new Cama(gl,0,0,0,0,0,0,0.6f,0f,0.2f,0.7f);
        gradasEntra = new Gradas(gl,0,0,0,3,0,0,0,1,0,0);
        gradas2 = new Gradas(gl,0,0,0,2f,0,-90,0,0.5f,0.3f,0);
        gradas3 = new Gradas(gl,0,0,0,2f,0,0,0,0.5f,0.3f,0);
        comedor = new Mesa(gl,0,0,0,0,0,0,1f,2f,0.5f,0.9f,0.6f,0.3f);
        mesatele = new Mesa(gl,0,1.5f,1.7f,0,90,0,4f,2f,2f,0.9f,0.6f,0.3f);
        lamp1 = new Lamparas(gl,0,0,0,3,1f,0.7f,0.1f);
        lamp2 = new Lamparas(gl,0,0,0,4,1f,1f,1f);
        sala = new Sillas(gl,0,0.8f,0f,0,180,0,7,5f,0.2f,0.1f,0.5f);
        sala2 = new Sillas(gl,-6,0.8f,-1.1f,0,90,0,5f,5f,0.2f,0.1f,0.5f);
        sillaMesa = new Sillas(gl,0,0,0,0,0,0,1,1.5f,0.9f,0.6f,0.3f);
        
        
//        cama2 = new Cama(gl,0,0,0,0,0,0,2f,0.3f,0.1f,0.5f);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        glut=new GLUT();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
       
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        GLU glu= new GLU ();  
        
        cam.setx(-7);
        cam.sety(15);
        
//        gl.glPushMatrix();
      
//        gl.glPopMatrix();
//        i+=.01f;
//        float cos=(float) Math.cos(i)*4;
//        float sin=(float) Math.sin(i)*4;
        if(ncam == 1){
//            glu.gluLookAt(movex, movey, movez, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(-7, 10, -10, pisocasa.x+20, pisocasa.y-20, pisocasa.z+10, 0, 1, 0);
        }
        if(ncam == 2){
//            glu.gluLookAt(movex1+cos, movey1+sin, 0, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(cam.x, cam.y, cam.z, pisocasa.x+20, pisocasa.y-20, pisocasa.z+10, 0, 1, 0);
        }
        
        if(ncam == 3){
//            glu.gluLookAt(movex1+cos, movey1+sin, 0, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(pisocasa.x+5, pisocasa.y+20, pisocasa.z,pisocasa.x, pisocasa.y, pisocasa.z, 0, 1, 0);
        }
        
        if(ncam == 4){
//            glu.gluLookAt(movex, movey, movez, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(cam.x,cam.y,cam.z, -2, 0, 7.5f, 0, 1, 0);
        }
        
        
        //piso principal
        gl.glPushMatrix();
        gl.glTranslatef(0,-1f,0);
        pisoprin.display();
        gl.glPopMatrix();
        
        //piso de la casa
        gl.glPushMatrix();
        gl.glTranslatef(-5.5f,0.5f,0);
        pisocasa.display();
        gl.glPopMatrix();
        
//        //2do piso de la casa
//        gl.glPushMatrix();
//        gl.glTranslatef(-1.8f,9.7f,0);
//        piso2do.display();
//        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-8f,9.7f,-0.5f);
        piso22.display();
        gl.glPopMatrix();
        
        //gradas de la entrada
        gl.glPushMatrix();
        gl.glTranslatef(-18f,-0.175f,0.5f);
        gl.glScalef(0.5f,0.35f,0.8f);
//        gl.glRotatef(180,0,1,0);
        gradasEntra.display(3);
        gl.glPopMatrix();
         
        //pared entrada
//        gl.glPushMatrix();
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(-3.85f,3.5f,-0.008f);
//         pared.display();
//         gl.glPopMatrix();
             
         //gradas segundo piso
         gl.glPushMatrix();
         gl.glTranslatef(-14.5f,0.85f,3.9f);
         gradas2.display(7);
         gl.glPopMatrix();
         
             //gradas2 segundo piso
         gl.glPushMatrix();
         gl.glTranslatef(-13.5f,4.85f,8.58f);
         gradas3.display(7);
         gl.glPopMatrix();
         
         
         
         //mesa de comedor
         gl.glPushMatrix();
         gl.glTranslatef(-1f,3f,-5);
         gl.glScalef(5,4,5);
         comedor.comedor();
         gl.glPopMatrix();
         
            //sillas comedor
            //cabecera 1
         gl.glPushMatrix();
         gl.glTranslatef(-4f,2.1f,-5);
         gl.glScalef(1f,1.5f,1.5f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         //izq
         gl.glPushMatrix();
         gl.glRotatef(-90,0,1,0);
         gl.glTranslatef(-6.5f,2.1f,2);
         gl.glScalef(1f,1.5f,1.5f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
          gl.glPushMatrix();
         gl.glRotatef(-90,0,1,0);
         gl.glTranslatef(-6.5f,2.1f,0);
         gl.glScalef(1f,1.5f,1.5f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         //der
           gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glTranslatef(3.5f,2.1f,-1.7f);
         gl.glScalef(1f,1.5f,1.5f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
           gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glTranslatef(3.5f,2.1f,0.5f);
         gl.glScalef(1f,1.5f,1.5f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
          //cabecera 1
         gl.glPushMatrix();
         gl.glTranslatef(2f,2.1f,-5);
         gl.glRotatef(180,0,1,0);
         gl.glScalef(1f,1.5f,1.5f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         //lampara comedor
          gl.glPushMatrix();
         gl.glTranslatef(-1f,5f,-5);
         lamp1.colgante(glut);
         gl.glPopMatrix();
         
         //SALA
         
         //sillones
         gl.glPushMatrix();
         gl.glTranslatef(-2,0,7.5f);
         sala.sillon();
         gl.glPopMatrix();
         
          gl.glPushMatrix();
         sala2.sillon();
         gl.glPopMatrix();
         
         //lampara de piso
          gl.glPushMatrix();
          gl.glTranslatef(2.5f,0.1f,8);
          gl.glRotatef(45,0,1,0);
          lamp2.dePiso(glut);
         gl.glPopMatrix();
         
         //mesa televisor
         gl.glPushMatrix();
         mesatele.mesaSala(glut);
         gl.glPopMatrix();
         
         
         //PAREDES
        //pared posterior
         gl.glPushMatrix();
         gl.glScalef(4,1,4);
         gl.glTranslatef(1.075f,3.5f,-0.008f);
         pared.display();
         gl.glPopMatrix();
         
         //pared der
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(-2.45f,3.5f,-1.4f);
         pared.display();
         gl.glPopMatrix();
         
          //pared iz
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(2.45f,3.5f,-1.4f);
         pared.display();
         gl.glPopMatrix();
         
         //pared mitad
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(0.2f,3.5f,0.6f);
         pared2.display();
         gl.glPopMatrix();
         
         //pared mitad
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(0.2f,3.5f,-1.5f);
         pared2.display();
         gl.glPopMatrix();
         
         //pared mitad hueco
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(0.2f,7.8f,-0.5f);
         pared3.display();
         gl.glPopMatrix();
         
      

       
    
        gl.glFlush();
    }
    
//        public void mueve(){
//            rot += 0.05;
//            gl.glTranslatef(0, 0, rot);
//        }
//    
        public void girar(){
            rotar += 0.1;
            gl.glRotatef(rotar, 1, 1, 1);
        }
        public void girarX(){
            rotar += 0.1;
            gl.glRotatef(rotar, 1, 0, 0);
//            System.out.println("rota en x: " + rotar);
        }
        
        public void girarY(){
            rotar += 0.05;
            gl.glRotatef(rotar, 0, 1, 0);
//            System.out.println("rota en y: " + rotar);
        }
        
        public void girarZ(){
            rotar += 0.1;
            gl.glRotatef(rotar, 0, 0, 1);
//            System.out.println("rota en z: " + rotar);
        }
        
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    
     }
    public void keyTyped(KeyEvent e) {
        
        if(e.getKeyChar()=='1'){
            Escenario.ncam=1;
        
    }
    
        if (e.getKeyChar()=='2'){
        Escenario.ncam=2;
    }
            if (e.getKeyChar()=='3'){
        Escenario.ncam=3;
    }
            
            
            if (e.getKeyChar()=='4'){
        Escenario.ncam=4;
    }
        
    }    

    public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
           cam.x+=0.1;
           cam.setx(cam.getx());
            System.out.println("Valor en la traslacion de X: "+cam.x);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            cam.x-=0.1;
            cam.setx(cam.getx());
            System.out.println("Valor en la traslacion de X: "+cam.x);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_UP){
            cam.y+=0.1;
            cam.sety(cam.gety());
            System.out.println("Valor en la traslacion de Y: "+cam.y);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            cam.y-=0.1;
            cam.sety(cam.gety());
            System.out.println("Valor en la traslacion de Y: "+cam.y);
        }
        if(e.getKeyCode()== KeyEvent.VK_X){
            cam.z+=0.1;
            cam.setz(cam.getz());
            System.out.println("Valor en la traslacion de Z: "+cam.z);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_Z){
            cam.z-=0.1;
            cam.setz(cam.getz());
            System.out.println("Valor en la traslacion de Z: "+cam.z);
        }
        

         if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
            cam.x=0;
            cam.y=0;
            cam.w=1;
            cam.h=1;
            cam.rx=0;
            cam.ry=0;
            cam.rz=0;

        }
    }

    public void keyReleased(KeyEvent ke) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

