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
//    CILINDRO cilindro, cono, cubo;
    float rot, i;
    Esfera cam;
    Casa3D casa;
   Cubo pisocasa, pisoprin,piso2do,piso22, paredizq,paredizqUp,paredpos,paredent,paredderEnt,paredder,paredadelanteUp,paredadelante,pared2,pared3,pared4, mesacocina, estante;
   Cubo2 camara;
   Arbol3D arbol;
   Cama cama1, cama2, cama3;
   Gradas gradasEntra,gradas2,gradas3;
   Mesa comedor, mesatele, mesoncocina, islacocina;
   Lamparas lampcomedor, lamp2,lampCocina, lamp2Cocina;
   Sillas sala,sala2, sillaMesa;
   Baranda barangradas;
   Television teleSala;
   Baranda barandaEntrada;
   Cocina estufa;
   ExtractorCocina extract;
   Lavabo lavCocina;
   Baldosa pisococina;
   Quad2 fondopisoCocina;


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
        
        camara = new Cubo2(gl, 0, 0, 0, 100, 100, 100, 0, 0, 0);
        cam=new Esfera(-7,1,-7,1,1,1,0,0,0,0,1,0,gl,.5f,7,7);
        casa = new Casa3D(gl,-0.7f,-0.3f,0.3f,1.75f,1.75f,0,0,0);
        pisocasa = new Cubo(gl,0,0,0f,40f,1f,50f,0,0,0,0.9f,0.8f,0.6f);
        piso2do = new Cubo(gl,0,0,0f,39.5f,0.5f,49.5f,0,0,0,0.5f,0.3f,0f);
        piso22 = new Cubo(gl,0,0,0f,9f,0.25f,17.5f,0,0,0,0.5f,0.3f,0f);
        pisoprin = new Cubo(gl,0,0,0,70f,2f,100f,0,0,0,0f,0.6f,0.2f);
        paredpos = new Cubo(gl,0,0,0,0.1f,30,12.3f,0,0,0,1f,0.5f,0.3f);
        paredizq = new Cubo(gl,0,0,0,0.1f,15,8,0,0,0,0.9f,0.8f,0.7f);
        paredizqUp = new Cubo(gl,0,0,0,0.1f,15,10f,0,0,0,0.9f,0.8f,0.7f);
        paredent = new Cubo(gl,0,0,0,0.1f,15,3,0,0,0,0.9f,0.6f,0.4f);
        paredder = new Cubo(gl,0,0,0,0.1f,30,10,0,0,0,0.9f,0.8f,0.7f);
        paredderEnt = new Cubo(gl,0,0,0,0.1f,15,1.75f,0,0,0,0.9f,0.6f,0.4f);
        paredadelanteUp = new Cubo(gl,0,0,0,0.1f,15,12.4f,0,0,0,0.9f,0.8f,0.7f);
        paredadelante = new Cubo(gl,0,0,0,0.1f,15,9.5f,0,0,0,0.9f,0.8f,0.7f);
        pared2 = new Cubo(gl,0,0,0,0.1f,10,1,0,0,0,0.9f,0.9f,0.6f);
        pared3 = new Cubo(gl,0,0,0,0.1f,1.5f,1.2f,0,0,0,0.9f,0.9f,0.6f);
        pared4 = new Cubo(gl,0,0,0,0.1f,6.5f,4.7f,0,0,0,0.9f,0.9f,0.6f);
        arbol = new Arbol3D(gl,0,0,0,0.5f,0.4f,0,0,0);
        cama1 = new Cama(gl,0,0,0,0,0,0,0.3f,0.7f,0.9f,0.7f);
        cama2 = new Cama(gl,0,0,0,0,0,0,1f,0.3f,0.6f,0.7f);
        cama3 = new Cama(gl,0,0,0,0,0,0,0.6f,0f,0.2f,0.7f);
        gradasEntra = new Gradas(gl,0,0,0,3,0,0,0,0.9f,0.9f,0.8f);
        gradas2 = new Gradas(gl,0,0,0,2f,0,-90,0,0.5f,0.3f,0);
        gradas3 = new Gradas(gl,0,0,0,2f,0,0,0,0.5f,0.3f,0);
        comedor = new Mesa(gl,0,0,0,0,0,0,1f,2f,0.5f,0.9f,0.6f,0.3f);
        mesatele = new Mesa(gl,0,1.5f,1.7f,0,90,0,4f,2f,2f,0.9f,0.6f,0.3f);
        mesoncocina = new Mesa(gl,0,0,0,0,0,0,15,5,3,1f,0.8f,0.6f);
        islacocina = new Mesa(gl,0,0,0,0,0,0,9,5,4,1f,0.8f,0.6f);
        lampcomedor = new Lamparas(gl,0,0,0,3,1f,0.7f,0.1f);
        lamp2 = new Lamparas(gl,0,0,0,4,1f,1f,1f);
        lampCocina = new Lamparas(gl,0,0,0,3,1,1,1);
        lamp2Cocina = new Lamparas(gl,0,0,0,3,1,1,1);
        sala = new Sillas(gl,0,0.8f,0f,0,180,0,7,5f,1f,0.6f,0.5f);
        sala2 = new Sillas(gl,-6,0.8f,-1.1f,0,90,0,5f,5f,0.2f,0.1f,0.5f);
        sillaMesa = new Sillas(gl,0,0,0,0,0,0,1,1.5f,0.9f,0.6f,0.3f);
        barangradas = new Baranda(gl,0,0,0,0,0,0,0.2f,0.4f,0,0,1);
        teleSala = new Television(gl,0,0,0,0,0,0,2f,1.5f);
        barandaEntrada = new Baranda(gl,0,0,0,0,0,0,5f,0.5f,0.9f,0.9f,0.8f);
        estufa = new Cocina(gl,0,0,0,0,0,0,6,5,3,1,1,1);
        extract = new ExtractorCocina(gl,0,0,0,7f,8f,4f,1f,1f,1f);
        lavCocina = new Lavabo(gl,0,0,0,5,3,3,0,0,1);
        pisococina = new Baldosa(gl,0,0,0,10,15,0.9f,0.9f,0.9f);
        fondopisoCocina = new Quad2(gl,0,0,0,9,12,0,0,0,1,1,1,1f,1f,1f);
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
        
        
        //piso principal
        gl.glPushMatrix();
        gl.glTranslatef(0,-1f,0);
        pisoprin.display();
        gl.glPopMatrix();
        ///////////////////////////
        
        //piso de la casa
        gl.glPushMatrix();
        gl.glTranslatef(-5.5f,0.5f,0);
        pisocasa.display();
        gl.glPopMatrix();
        ///////////////////////////
        
        //2do piso de la casa
        gl.glPushMatrix();
        gl.glTranslatef(-5.5f,16f,0);
        piso2do.display();
        gl.glPopMatrix();
        ///////////////////////////
        

        //gradas de la entrada
        gl.glPushMatrix();
        gl.glTranslatef(-29f,-0.9f,-19f);
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
         
         //lampara isla cocina
         gl.glPushMatrix();
         gl.glTranslatef(0,14.5f,15);
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
         
         //extractor cocina
         gl.glPushMatrix();
         gl.glTranslatef(12,12f,3.5f);
         gl.glRotatef(90,0,1,0);
         extract.display(glut);
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
         
         //sillones
         gl.glPushMatrix();
         gl.glTranslatef(1,-0.5f,-22.5f);
         gl.glScalef(1.5f,1.5f,2);
         gl.glRotatef(180,0,1,0);
         sala.sillon();
         gl.glPopMatrix();
         
//          gl.glPushMatrix();
//         sala2.sillon();
//         gl.glPopMatrix();
         ///////////////////////////
         
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
         
          //pared izq
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.2f,8.5f,-0.4f);
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
        
//           //pared delantera
//         gl.glPushMatrix();
//         gl.glRotatef(180,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(6.3f,8.5f,-1.45f);
//         paredadelante.display();
//         gl.glPopMatrix();
//         ///////////////////////////
//
//          //pared adelante arriba
//         gl.glPushMatrix();
//         gl.glRotatef(180,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(6.3f,23.5f,-0.008f);
//         paredadelanteUp.display();
//         gl.glPopMatrix();
//         ///////////////////////////
           
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
        
//         //pared mitad
//         gl.glPushMatrix();
//         gl.glRotatef(90,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(0.2f,4.7f,0.6f);
//         pared2.display();
//         gl.glPopMatrix();
//         ///////////////////////////
//         
//         //pared mitad 2
//         gl.glPushMatrix();
//         gl.glRotatef(90,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(0.2f,4.7f,-1.5f);
//         pared2.display();
//         gl.glPopMatrix();
//         ///////////////////////////
//         
//         //pared mitad hueco
//         gl.glPushMatrix();
//         gl.glRotatef(90,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(0.2f,8.5f,-0.5f);
//         pared3.display();
//         gl.glPopMatrix();
//         ///////////////////////////
         
//         //pared segundo piso cuartos
//         gl.glPushMatrix();
//         gl.glRotatef(90,0,1,0);
//         gl.glScalef(4,1,4);
//         gl.glTranslatef(-0.2f,12.9f,-1.4f);
//         pared4.display();
//         gl.glPopMatrix();
//         //////////////////////////
         

       
    
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