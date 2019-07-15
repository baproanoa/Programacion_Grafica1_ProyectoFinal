package org.yourorghere;

import com.sun.opengl.util.Animator;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;




/**
 *
 * @author Abigail Proaño
 */
public class Escenario extends JFrame implements  KeyListener,MouseListener,MouseMotionListener{
//        , MouseListener, MouseMotionListener 
    public static int ncam=1;
    GLUT glut;
    static  GL gl;
    static GLU glu;
    static float rotar = 0;
    float movex,movey,movez,movex1,movey1, trasladaX=0, trasladaY=0;
    float rot, i;
    Esfera cam;
    Casa3D casa;
   Cubo pisocasa, pisocasasala,pisocasasalaUp, pisoprin,piso2do,piso22,piso23,pisojardin; 
   Cubo paredizq,paredizqUp,paredpos,paredent,paredderEnt,paredder,paredadelanteUp,paredadelante,pared2,pared3,pared4;
   Cubo2 camara;
   Arbol3D arbol;
   Cama cama1, cama2, cama3;
   Gradas gradasEntra,gradas2,gradas3, gradasjardin;
   Mesa comedor, mesatele, mesoncocina, islacocina, mesasala;
   Lamparas lampcomedor, lamp2,lampCocina, lamp2Cocina, lampEntrada;
   Sillas sala,sala2, sillaMesa, sillaIsla;
   Television teleSala;
   Baranda barangradadas, barandaEntrada, barandajardin1,barandajardin2,barandajardin3;
   Cocina estufa, micro;
   ExtractorCocina extract;
   Lavabo lavCocina;
   Baldosa pisococina;
   Quad2 fondopisoCocina, techoprimerpiso;
   Refrigerador refri;
   Tetera t1;
   ParedLineas paredsala;
   Alfombras alfombraSala;
   Chimenea chimeneasala;
   Floreros floreromesasala, florero2;
   Puerta puertaprincipal, puertajardin;
   Ventanas ventana1,ventanasala, ventana2, ventana3, ventana4;
   Pergola pergolajardin;

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
//                addMouseListener(this);
//                addMouseMotionListener(this);
    }
    
    public static void main(String[] args) {
        
         Escenario frame = new Escenario();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                       
 
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        camara = new Cubo2(gl, 0, 0, 0, 300, 300, 300, 0, 0, 0);
        cam=new Esfera(-7,1,-7,1,1,1,0,0,0,0,1,0,gl,.5f,7,7);
        
        pisoprin = new Cubo(gl,0,0,0,200f,2f,300f,0,0,0,0f,0.6f,0.2f);
        pisocasa = new Cubo(gl,0,0,0f,40f,1f,50f,0,0,0,0.9f,0.8f,0.6f);
        pisocasasala = new Cubo(gl,0,0,0f,33f,1f,20f,0,0,0,0.9f,0.8f,0.6f);
        pisocasasalaUp = new Cubo(gl,0,0,0f,32f,0.5f,20f,0,0,0,1.8f,1.8f,1.8f);
        piso2do = new Cubo(gl,0,0,0f,26.5f,0.5f,49.5f,0,0,0,1.8f,1.8f,1.8f);
        piso22 = new Cubo(gl,0,0,0f,14f,0.5f,35f,0,0,0,1.8f,1.8f,1.8f);
        piso23 = new Cubo(gl,0,0,0f,14f,0.5f,12f,0,0,0,1.8f,1.8f,1.8f);
        pisojardin = new Cubo(gl,0,0,0f,20f,1f,45f,0,0,0,0.9f,0.8f,0.6f);
        paredpos = new Cubo(gl,0,0,0,0.1f,30,12.3f,0,0,0,1f,0.5f,0.3f);
        paredizq = new Cubo(gl,0,0,0,0.1f,15,8,0,0,0,0.9f,0.8f,0.7f);
        paredizqUp = new Cubo(gl,0,0,0,0.1f,15,10f,0,0,0,0.9f,0.8f,0.7f);
        paredent = new Cubo(gl,0,0,0,0.1f,15,3,0,0,0,0.9f,0.6f,0.4f);
        paredder = new Cubo(gl,0,0,0,0.1f,30,10,0,0,0,0.9f,0.8f,0.7f);
        paredderEnt = new Cubo(gl,0,0,0,0.1f,15,1.75f,0,0,0,0.9f,0.6f,0.4f);
        paredadelanteUp = new Cubo(gl,0,0,0,0.1f,15,12.4f,0,0,0,0.9f,0.8f,0.7f);
        paredadelante = new Cubo(gl,0,0,0,0.1f,15,9.5f,0,0,0,0.9f,0.8f,0.7f);
        pared2 = new Cubo(gl,0,0,0,0.1f,15,9.5f,0,0,0,0.9f,0.8f,0.7f);
        pared3 = new Cubo(gl,0,0,0,0.1f,15,5f,0,0,0,0.9f,0.6f,0.4f);
        pared4 = new Cubo(gl,0,0,0,0.1f,15,5.5f,0,0,0,1f,0.5f,0.3f);
        arbol = new Arbol3D(gl,0,0,0,0.5f,0.4f,0,0,0);
        cama1 = new Cama(gl,0,0,0,0,0,0,0.3f,0.7f,0.9f,0.7f);
        cama2 = new Cama(gl,0,0,0,0,0,0,1f,0.3f,0.6f,0.7f);
        cama3 = new Cama(gl,0,0,0,0,0,0,0.6f,0f,0.2f,0.7f);
        gradasEntra = new Gradas(gl,0,0,0,3,0,0,0,0.9f,0.9f,0.8f);
        gradas2 = new Gradas(gl,0,0,0,2f,0,-90,0,0.8f,0.6f,0.4f);
        gradas3 = new Gradas(gl,0,0,0,2f,0,0,0,0.8f,0.6f,0.4f);
        comedor = new Mesa(gl,0,0,0,0,0,0,1f,2f,0.5f,0.9f,0.6f,0.3f);
        mesatele = new Mesa(gl,0,1.5f,1.7f,0,90,0,4f,2f,2f,0.9f,0.6f,0.3f);
        mesoncocina = new Mesa(gl,0,0,0,0,0,0,15,5,3,1f,0.8f,0.6f);
        islacocina = new Mesa(gl,0,0,0,0,0,0,9,5,4,1f,0.8f,0.6f);
        mesasala = new Mesa(gl,0,0,0,0,0,0,3,2.5f,3,1,1,1);
        lampcomedor = new Lamparas(gl,0,0,0,3,1f,0.7f,0.1f);
        lamp2 = new Lamparas(gl,0,0,0,4,1f,1f,1f);
        lampCocina = new Lamparas(gl,0,0,0,3,1,1,1);
        lamp2Cocina = new Lamparas(gl,0,0,0,3,1,1,1);
        lampEntrada = new Lamparas(gl,0,0,0,1,1,1,1);
        sala = new Sillas(gl,0,0.8f,0f,0,180,0,7,5f,0.9f,0.7f,0.3f);
        sala2 = new Sillas(gl,0,0.8f,0,0,90,0,7f,5f,0f,0.5f,0.8f);
        sillaMesa = new Sillas(gl,0,0,0,0,0,0,1,1.5f,0.9f,0.6f,0.3f);
        sillaIsla = new Sillas(gl,0,0,0,0,0,0,1f,4f,0.9f,0.4f,0.5f);
        barandaEntrada = new Baranda(gl,0,0,0,0,0,0,5f,0.5f,0.9f,0.9f,0.8f);
        barandajardin1 = new Baranda(gl,0,0,0,0,0,0,5f,0.5f,0.9f,0.9f,0.8f);
        estufa = new Cocina(gl,0,0,0,0,0,0,6,5,3,1,1,1);
        micro = new Cocina(gl,0,0,0,0,0,0,4,2.7f,2f,1,1,1);
        extract = new ExtractorCocina(gl,0,0,0,7f,8f,4f,1f,1f,1f);
        lavCocina = new Lavabo(gl,0,0,0,5,3,3,0,0,1);
        pisococina = new Baldosa(gl,0,0,0,10,15,0.9f,0.9f,0.9f);
        fondopisoCocina = new Quad2(gl,0,0,0,9,12,0,0,0,1,1,1,1f,1f,1f);
        refri = new Refrigerador(gl,0,0,0,5,10,3,1,1,1);
        t1 = new Tetera(gl,0.8f,0,0,0,0,0,0,0.8f,0.6f,0.7f);
        paredsala = new ParedLineas(gl,-16,8,44.35f,1f,8,1,1,1);
        alfombraSala= new Alfombras(gl,-0.5f,1.1f,0f,2.5f,1f,0.9f,0.9f);
        chimeneasala = new Chimenea(gl,0,0,0,7,3.5f,2.5f,0.9f,0.9f,0.9f);
        floreromesasala = new Floreros(gl,0,0,0,1.5f,0,0,0);
        florero2 = new Floreros(gl,0,0,0,2f,0,0,0);
        puertaprincipal = new Puerta(gl,0,0,0,6,12,1.8f,1.8f,1.8f);
        puertajardin = new Puerta(gl,0,0,0,6,12,2f,2f,2f);
        ventana1 = new Ventanas(gl,0,0,0,30,11,1.8f,1.8f,1.8f);
        ventana2 = new Ventanas(gl,0,0,0,18,8,1.8f,1.8f,1.8f);
        ventana3 = new Ventanas(gl,0,0,0,30,11,1.8f,1.8f,1.8f);
        ventana4 = new Ventanas(gl,0,0,0,30,11,1.8f,1.8f,1.8f);
        ventanasala = new Ventanas(gl,0,0,0,13,23,1.8f,1.8f,1.8f);
        pergolajardin = new Pergola(gl,0,0,0,44,12,14,0.5f,0.3f,0.1f);
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
        glu.gluPerspective(60, h, 1.0, 110.0);
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
//        if(ncam == 1){
////            glu.gluLookAt(movex, movey, movez, 0.5f, -0.6f, -6, 0, 1, 0);
//            glu.gluLookAt(cam.x, cam.y, cam.z, pisocasa.x+20, pisocasa.y-20, pisocasa.z+10, 0, 1, 0);
//        }
        if (ncam == 1) {
                //glu.gluLookAt(cam.x +120f, cam.y +30f, cam.z+5, suelo.x, suelo.y, suelo.z, 0, 1, 0);
                glu.gluLookAt(cam.x - 50, cam.y +10, cam.z, pisoprin.x, pisoprin.y, pisoprin.z, 0, 1, 0);
            }
        if(ncam == 2){
//            glu.gluLookAt(movex1+cos, movey1+sin, 0, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(cam.x + 20, cam.y +5, cam.z, pisoprin.x, pisoprin.y, pisoprin.z, 0, 1, 0);
        }
        
        if(ncam == 3){
//            glu.gluLookAt(movex1+cos, movey1+sin, 0, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(pisocasa.x+5, pisocasa.y+20, pisocasa.z,pisocasa.x, pisocasa.y, pisocasa.z, 0, 1, 0);
        }
        
        if(ncam == 4){
//            glu.gluLookAt(movex, movey, movez, 0.5f, -0.6f, -6, 0, 1, 0);
            glu.gluLookAt(cam.x,cam.y,cam.z, gradas2.x + 10, gradas2.y ,gradas2.z-20, 0, 1, 0);
        }
        
        
        //PISOS 
        
        //piso principal
        gl.glPushMatrix();
        gl.glTranslatef(20,-1f,0);
        pisoprin.display();
        gl.glPopMatrix();
        ///////////////////////////
        
        //piso de la casa
        gl.glPushMatrix();
        gl.glTranslatef(-5.5f,0.5f,0);
        pisocasa.display();
        gl.glPopMatrix();
        ///////////////////////////
        
        //piso sala de la casa
        gl.glPushMatrix();
        gl.glTranslatef(-2f,0.5f,-35);
        pisocasasala.display();
        gl.glPopMatrix();
        ///////////////////////////
        
        //piso del jardin
        gl.glPushMatrix();
        gl.glTranslatef(20f,0.5f,2.5f);
        pisojardin.display();
        gl.glPopMatrix();
        ///////////////////////////
        
        //2do piso de la casa
    
        gl.glPushMatrix();
        gl.glTranslatef(-1.9f,16f,-34.5f);
        pisocasasalaUp.display();
        gl.glPopMatrix();
      
        
        gl.glPushMatrix();
        gl.glTranslatef(1f,16f,0);
        piso2do.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-18f,16f,7.45f);
        piso22.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-18f,16f,-18.59f);
        piso23.display();
        gl.glPopMatrix();
        /////////////////////////
       
        //PUERTAS
        
        //puerta principal
        gl.glPushMatrix();
        gl.glTranslatef(-17.6f,7f,-20);
        puertaprincipal.display(glut);
        gl.glPopMatrix();
        
        //puerta del jardin
        gl.glPushMatrix();
        gl.glTranslatef(14f,7f,-10);
        puertajardin.puertadoble(glut);
        gl.glPopMatrix();
        /////////////////////////
        
        //VENTANAS
        
        gl.glPushMatrix();
        gl.glTranslatef(-25,9,5.5f);
        ventana1.ventana1();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-18.3f,17,-35f);
        ventanasala.ventana2();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-25,24,-13f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-25,24,13f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        //ventanas posteriores
        
        //ventana 1 arriba
        gl.glPushMatrix();
        gl.glTranslatef(14.5f,24,13f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        //ventana 1 abajo
        gl.glPushMatrix();
        gl.glTranslatef(14.5f,9,13f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        //ventana 2 arriba
        gl.glPushMatrix();
        gl.glTranslatef(14.5f,24,-10f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        //ventana 3 arriba
        gl.glPushMatrix();
        gl.glTranslatef(14.5f,24,-33f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        //ventana 3 abajo
        gl.glPushMatrix();
        gl.glTranslatef(14.5f,9,-33f);
        ventana2.ventana1();
        gl.glPopMatrix();
        /////////////////////////
        
        //lampara puerta de entrada
        gl.glPushMatrix();
        gl.glTranslatef(-22,15.8f,-20);
        lampEntrada.deTecho(glut);
        gl.glPopMatrix();
        /////////////////////////
        
        //JARDIN
        
        //pergola
        gl.glPushMatrix();
        gl.glTranslatef(21,15,3);
        gl.glRotatef(90,0,1,0);
        pergolajardin.display(glut);
        gl.glPopMatrix();
        
        //baranda del jardin
//        gl.glPushMatrix();
//        gl.glTranslatef(30f,3.5f,0f);
//        gl.glRotatef(90,0,1,0);
//        barandajardin1.display(5);
//        gl.glPopMatrix();
        
         //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30f,3.5f,-7.5f);
        gl.glRotatef(90,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        
         //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30f,3.5f,-15f);
        gl.glRotatef(90,0,1,0);
        barandajardin1.display(3);
        gl.glPopMatrix();
        
         //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30f,3.5f,7.5f);
        gl.glRotatef(90,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
       
        //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30f,3.5f,15f);
        gl.glRotatef(90,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        
         //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30f,3.5f,22.5f);
        gl.glRotatef(90,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        
        //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30f,3.5f,25.5f);
        gl.glRotatef(90,0,1,0);
        barandajardin1.display(3);
        gl.glPopMatrix();
        
          //baranda del jardin
        gl.glPushMatrix();
        gl.glTranslatef(30.3f,3.5f,24.7f);
        gl.glRotatef(180,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(23f,3.5f,24.7f);
        gl.glRotatef(180,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(30.3f,3.5f,-20f);
        gl.glRotatef(180,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(23f,3.5f,-20f);
        gl.glRotatef(180,0,1,0);
        barandajardin1.display(5);
        gl.glPopMatrix();
        /////////////////////////
        
        
        //GRADAS
       
        //gradas de la entrada
        gl.glPushMatrix();
        gl.glTranslatef(-30f,-0.9f,-18f);
        gl.glScalef(1f,0.8f,1f);
        gradasEntra.display(2);
        gl.glPopMatrix();
        ///////////////////////////
             
         //gradas segundo piso
         gl.glPushMatrix();
         gl.glTranslatef(-23.1f,0.5f,-4.3f);
         gl.glRotatef(180,0,1,0);
         gl.glScalef(1.5f,1.5f,1.5f);
         gradas2.display(7);
         gl.glPopMatrix();
         ///////////////////////////
         
             //gradas2 segundo piso arriba
         gl.glPushMatrix();
         gl.glTranslatef(-22f,6.5f,-11.45f);
         gl.glScalef(1.5f,1.5f,1.5f);
         gradas3.display(9);
         gl.glPopMatrix();
         ///////////////////////////
         
      //COMEDOR
      
         //mesa de comedor
         gl.glPushMatrix();
         gl.glTranslatef(-15f,4.5f,10);
         gl.glScalef(8,7,8);
         comedor.comedor();
         gl.glPopMatrix();
         ///////////////////////////
         
            //sillas comedor
            //cabecera 1
         gl.glPushMatrix();
         gl.glTranslatef(-19f,2.9f,10);
         gl.glScalef(2f,2.5f,2f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         
         //cabecera 2
         gl.glPushMatrix();
         gl.glTranslatef(-10.5f,2.9f,10);
         gl.glRotatef(180,0,1,0);
         gl.glScalef(2f,2.5f,2f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         
         //sillas derecha
         gl.glPushMatrix();
         gl.glTranslatef(-16f,2.9f,13);
         gl.glRotatef(90,0,1,0);
         gl.glScalef(2f,2.5f,2f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-13.5f,2.9f,13);
         gl.glRotatef(90,0,1,0);
         gl.glScalef(2f,2.5f,2f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         

           //sillas izquierda
         gl.glPushMatrix();
         gl.glTranslatef(-16f,2.9f,7);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(2f,2.5f,2f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-13.5f,2.9f,7);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(2f,2.5f,2f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         
         //lampara comedor
          gl.glPushMatrix();
         gl.glTranslatef(-15f,12f,10);
         gl.glScalef(3,3,3);
         lampcomedor.colgante(glut);
         gl.glPopMatrix();
         ///////////////////////////
         ///////////////////////////
         
         //COCINA
         
         //piso cocina
         gl.glPushMatrix();
         gl.glTranslatef(3.9f,1.05f,12.5f);
         gl.glRotatef(270,1,0,0);
         fondopisoCocina.dibuja();
         gl.glPopMatrix();
         ///////////////////////////
        
         //piso cocina
         gl.glPushMatrix();
         gl.glTranslatef(3.9f,1.07f,-2.5f);
         pisococina.display(7);
         gl.glPopMatrix();
         ///////////////////////////
         
         //meson cocina fondo
         gl.glPushMatrix();
         gl.glTranslatef(12.5f,3f,14);
         gl.glRotatef(90,0,1,0);
         mesoncocina.cocina(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //isla cocina 
         gl.glPushMatrix();
         gl.glTranslatef(-1f,3f,12);
         gl.glRotatef(90,0,1,0);
         islacocina.isla();
         gl.glPopMatrix();
         ///////////////////////////
         
         //lampara isla cocina
         gl.glPushMatrix();
         gl.glTranslatef(0,14.5f,10);
         lampCocina.colgante2(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //sillas isla cocina
         gl.glPushMatrix();
         gl.glTranslatef(-5.5f,5f,10);
         sillaIsla.sillaAlta(glut);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-5.5f,5f,13);
         sillaIsla.sillaAlta(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         
         //lampara isla cocina
         gl.glPushMatrix();
         gl.glTranslatef(0,14.5f,13);
         lamp2Cocina.colgante2(glut);
         gl.glPopMatrix();
         ///////////////////////////
//         //lavabo cocina
//         gl.glPushMatrix();
//         gl.glTranslatef(0f,7f,0);
//         gl.glRotatef(90,0,1,0);
//         gl.glRotatef(-270,0,0,1);
//         lavCocina.lavabococina();
//         gl.glPopMatrix();
//         ///////////////////////////
         
         //meson cocina der
         gl.glPushMatrix();
         gl.glTranslatef(6f,3f,23);
         mesoncocina.cocina(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //estufa
         gl.glPushMatrix();
         gl.glTranslatef(12.5f,3,3.5f);
         gl.glRotatef(90,0,1,0);
         estufa.display(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //microondas
         gl.glPushMatrix();
         gl.glTranslatef(2f,7,23f);
         gl.glRotatef(90,0,1,0);
         gl.glRotatef(-90,0,1,0);
         micro.dibujaMicro(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //refri
         gl.glPushMatrix();
         gl.glTranslatef(-5,6,23);
         refri.display(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //extractor cocina
         gl.glPushMatrix();
         gl.glTranslatef(12,12f,3.5f);
         gl.glRotatef(90,0,1,0);
         extract.display(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //tetera
         gl.glPushMatrix();
         gl.glTranslatef(13f,6.5f,8);
         gl.glRotatef(90,0,1,0);
         t1.drawSolid(glut);
         gl.glPopMatrix();
         ///////////////////////////
         //mueble cocina arriba fondo
         gl.glPushMatrix();
         gl.glTranslatef(12.5f,13.5f,14);
         gl.glRotatef(-270,0,1,0);
         gl.glRotatef(180,0,0,1);
         mesoncocina.cocina(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         
         //mueble cocina arriba der
         gl.glPushMatrix();
         gl.glTranslatef(6f,13.5f,23);
         gl.glRotatef(180,0,0,1);
         mesoncocina.cocina(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //SALA
         
         //tapiz pared sala
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         paredsala.display(8);
         gl.glPopMatrix();
         ///////////////////////////
         
         //alfombra de la sala
         gl.glPushMatrix();
         gl.glTranslatef(2,0,-14);
         alfombraSala.alfombraRedonda();
         gl.glPopMatrix();
         ///////////////////////////
         
         //sillones
         gl.glPushMatrix();
         gl.glTranslatef(1,-0.5f,-42f);
         gl.glScalef(1.5f,1.5f,2);
         gl.glRotatef(180,0,1,0);
         sala.sillon();
         gl.glPopMatrix();
         
          gl.glPushMatrix();
          gl.glTranslatef(-8,-0.5f,-30);
          gl.glScalef(1.5f,1.5f,1);
         sala2.sillon();
         gl.glPopMatrix();
         ///////////////////////////
         
         //mesa de centro sala
         gl.glPushMatrix();
         gl.glTranslatef(0,3.5f ,-30);
         mesasala.mesaredonda(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //florero mesa sala
         gl.glPushMatrix();
         gl.glTranslatef(0,5,-30);
         floreromesasala.tipo1(glut);
         gl.glPopMatrix();
          ///////////////////////////
          
         //chimenea sala
         gl.glPushMatrix();
         gl.glTranslatef(12.5f,4.5f ,-33);
         gl.glRotatef(90,0,1,0);
         chimeneasala.display();
         gl.glPopMatrix();
         ///////////////////////////
         
//         //florero 2 
//         gl.glPushMatrix();
//         gl.glTranslatef(0,5,0);
//         florero2.tipo2(glut);
//         gl.glPopMatrix();
//         ///////////////////////////
         
         //lampara de piso
//          gl.glPushMatrix();
//          gl.glTranslatef(2.5f,0.1f,8);
//          gl.glRotatef(45,0,1,0);
//          lamp2.dePiso(glut);
//         gl.glPopMatrix();
         ///////////////////////////
         
         //mesa televisor
//         gl.glPushMatrix();
//         mesatele.mesaSala(glut);
//         gl.glPopMatrix();
         ///////////////////////////
         
         
         //PAREDES
         
        //pared posterior
         gl.glPushMatrix();
         gl.glScalef(4,1,4);
         gl.glTranslatef(3.57f,16f,-0.008f);
         paredpos.display();
         gl.glPopMatrix();
         ///////////////////////////
         
         //pared der
         gl.glPushMatrix();
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.2f,16f,1.36f);
         paredder.display();
         gl.glPopMatrix();
         ///////////////////////////
         
          //pared izq abajo
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(11.16f,8.5f,-0.48f);
         paredizq.display();
         gl.glPopMatrix();
        ///////////////////////////
        
          //pared izq arriba
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(11.16f,23.5f,-0.48f);
         paredizq.display();
         gl.glPopMatrix();
        ///////////////////////////
        
          //pared izq arriba
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.2f,23.5f,-1.4f);
         paredizqUp.display();
         gl.glPopMatrix();
        ///////////////////////////
        
         //pared entrada
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(4.45f,8.5f,4.75f);
         paredent.display();
         gl.glPopMatrix();
        ///////////////////////////
        
          //pared entrada derecha
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(3.2f,8.5f,-5.35f);
         paredderEnt.display();
         gl.glPopMatrix();
        ///////////////////////////
        
        //pared adelante sala abajo
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(4.49f,8.5f,8.7f);
         pared3.display();
         gl.glPopMatrix();
        ///////////////////////////
        
        //pared adelante sala arriba
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(4.49f,23.5f,8.7f);
         pared3.display();
         gl.glPopMatrix();
        ///////////////////////////
        
        //pared posterior sala abajo
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(-3.59f,8.5f,8.5f);
         gl.glRotatef(180,0,1,0);
         pared4.display();
         gl.glPopMatrix();
        ///////////////////////////
        
        //pared posterior sala arriba
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(-3.59f,23.5f,8.5f);
         gl.glRotatef(180,0,1,0);
         pared4.display();
         gl.glPopMatrix();
        ///////////////////////////
        
           //pared delantera abajo
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.3f,8.5f,-1.45f);
         paredadelante.display();
         gl.glPopMatrix();
         ///////////////////////////

          //pared adelante arriba
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.3f,23.5f,-0.008f);
         paredadelanteUp.display();
         gl.glPopMatrix();
         ///////////////////////////
           
//        //pared mitad (cuartos) 2do piso
//         gl.glPushMatrix();
//         gl.glRotatef(180,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(2f,23.5f,-1.45f);
//         pared2.display();
//         gl.glPopMatrix();
//         ///////////////////////////
         
//           //pared izq arriba
//         gl.glPushMatrix();
//         gl.glRotatef(90,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(0f,23.5f,-1.4f);
//         paredizqUp.display();
//         gl.glPopMatrix();
//        ///////////////////////////
  
        //barandas entrada
        gl.glPushMatrix();
        gl.glTranslatef(-25.8f,3.5f,-24.7f);
        barandaEntrada.display(4);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-25.3f,3.5f,-19.5f);
        gl.glRotatef(90,0,1,0);
        barandaEntrada.display(3);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-25.3f,3.5f,-12.5f);
        gl.glRotatef(90,0,1,0);
        barandaEntrada.display(3);
        gl.glPopMatrix();
        ///////////////////////////
        
          //techo de la casa
      
        gl.glPushMatrix();
        gl.glTranslatef(-5.5f,31f,0);
        pisocasa.display();
        gl.glPopMatrix();
    
        gl.glPushMatrix();
        gl.glTranslatef(-2f,31f,-35);
        pisocasasala.display();
        gl.glPopMatrix();
     
        ///////////////////////////

         

       
    
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
           cam.x+=0.2;
           cam.setx(cam.getx());
            System.out.println("Valor en la traslacion de X: "+cam.x);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            cam.x-=0.2;
            cam.setx(cam.getx());
            System.out.println("Valor en la traslacion de X: "+cam.x);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_UP){
            cam.y+=0.2;
            cam.sety(cam.gety());
            System.out.println("Valor en la traslacion de Y: "+cam.y);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            cam.y-=0.2;
            cam.sety(cam.gety());
            System.out.println("Valor en la traslacion de Y: "+cam.y);
        }
        if(e.getKeyCode()== KeyEvent.VK_X){
            cam.z+=0.2;
            cam.setz(cam.getz());
            System.out.println("Valor en la traslacion de Z: "+cam.z);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_Z){
            cam.z-=0.2;
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
     
    }

  
   
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            if (e.getButton() == MouseEvent.BUTTON2_DOWN_MASK) {
//             if (ncam == 2) {
//        cam.x+=xinicial;
//        cam.setx(cam.getx());
//        } 
//        }
//        
//            if (e.getButton() == MouseEvent.BUTTON1_DOWN_MASK) {
//             if (ncam == 2) {
//        cam.x-=xinicial;
//        cam.setx(cam.getx());
//        } 
//        }
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseDragged(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//    
//             int xinicial = 0, yinicial = 0;
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        
//       
//        if (xinicial > e.getX()) {
//            cam.x -= 0.2;
//        }
//        
//        if (xinicial < e.getX()) {
//            cam.x += 0.2;
//        }
//        
//         if (xinicial > e.getY()) {
//            cam.y -= 0.2;
//        }
//        
//        if (xinicial < e.getY()) {
//            cam.y += 0.2;
//        }
//    }
//       
        
    }