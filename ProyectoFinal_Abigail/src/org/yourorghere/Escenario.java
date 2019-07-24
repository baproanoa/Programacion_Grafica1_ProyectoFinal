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



/**
 *
 * @author Abigail Proaño
 */
public class Escenario extends JFrame implements  KeyListener{
//        , MouseListener, MouseMotionListener 
    public static int ncam=1;
    GLUT glut;
    static  GL gl;
    static GLU glu;
    static float rotar = 0;
    float trasladax,trasladay,trasladaz;
    float movex,movey,movez,movex1,movey1, trasladaX=0, trasladaY=0;
    float rot, i;
    private static boolean v = true;
    
    Esfera cam;
    Cubo2 camara, cam2,cam3;
    
   Cubo pisocasa, pisocasasala,pisocasasalaUp, pisoprin,piso2do,piso22,piso23,pisojardin,pisocuartosUp,pisocuartos, techocuartos; 
   Cubo paredizq,paredizqUp,paredpos,paredent,paredderEnt,paredderUp,paredder,paredadelanteUp,paredadelante,pared2,pared3,pared4,pared5,pared6;
   Cubo columna1;
   ArbolEsferas arbusto;
   ArbolEsfera arbol2;
   ArbolCubo arbol3;
   ArbolPir arbol4;
   Cama camaniña, camaprincipal;
   Gradas gradasEntra,gradas2,gradas3, gradasjardin;
   Mesa comedor, mesatele, mesoncocina, islacocina, mesasala, mesajardin, escritorio, velador, peinadoraniña;
   Lamparas lampcomedor, lamp2,lampCocina, lamp2Cocina, lampEntrada, lampmesa, lampsala;
   Sillas sala,sala2,sala3, sillaMesa, sillaIsla, sillajardin,sillaescritorio,sillapeinadora;
   Baranda barangradadas, barandaEntrada, barandajardin1;
   Cocina estufa, micro;
   ExtractorCocina extract;
   Lavabo lavabobaño;
   Baldosa pisococina, pisobaño, paredbaño;
   Quad2 fondopisoCocina, paredbaño1, paredcuartoniña, paredcuartoniña2, pisoestudio, pisocuarto, pisocuartoniña;
   Calle calleprincipal;
   Refrigerador refri;
   Tetera t1;
   ParedLineas paredsala;
   Alfombras alfombraSala;
   Chimenea chimeneasala;
   Floreros floreromesasala, florero2;
   Puerta puertaprincipal, puertajardin, puerta1;
   Ventanas ventana1,ventanasala, ventana2, ventana3, ventana4;
   Pergola pergolajardin;
   Baño bañoarriba;
   TinaBaño tinabaño;
   Espejo espejobaño;
   Armario armario;
   Television tele;
   Carro carro;
   Computador comp;
   Cuadros cuadro1;
   Piscina piscina;

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




 public class GraphicListener implements GLEventListener{
     
    public void init(GLAutoDrawable drawable) {
      

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
      
        gl.setSwapInterval(1);
        
        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); 
        gl.glEnable(gl.GL_DEPTH_TEST);
        
        
        camara = new Cubo2(gl, 0, 0, 0, 200, 200, 200, 0, 0, 0);
        cam2 = new Cubo2(gl, 0, 0, 0, 200, 200, 200, 0, 0, 0);
        cam3 = new Cubo2(gl, 0, 0, 0, 200, 200, 200, 0, 0, 0);
        cam=new Esfera(-7,1,-7,300,300,300,0,0,0,0,1,0,gl,.5f,7,7);
        
        pisoprin = new Cubo(gl,0,0,0,200f,2f,300f,0,0,0,0f,0.6f,0.2f);
        pisocasa = new Cubo(gl,0,0,0f,40f,1f,50f,0,0,0,0.9f,0.8f,0.6f);
        pisocasasala = new Cubo(gl,0,0,0f,33f,1f,20f,0,0,0,0.9f,0.8f,0.6f);
        pisocasasalaUp = new Cubo(gl,0,0,0f,32f,0.5f,20f,0,0,0,1.8f,1.8f,1.8f);
        piso2do = new Cubo(gl,0,0,0f,26.5f,0.5f,49.5f,0,0,0,1.8f,1.8f,1.8f);
        piso22 = new Cubo(gl,0,0,0f,14f,0.5f,35f,0,0,0,1.8f,1.8f,1.8f);
        piso23 = new Cubo(gl,0,0,0f,14f,0.5f,12f,0,0,0,1.8f,1.8f,1.8f);
        pisojardin = new Cubo(gl,0,0,0f,20f,1f,45f,0,0,0,0.9f,0.8f,0.6f);
        pisocuartos = new Cubo(gl,0,0,0f,40f,1f,50f,0,0,0,0.9f,0.8f,0.6f);
        pisocuartosUp = new Cubo(gl,0,0,0f,39.5f,0.5f,30f,0,0,0,1.8f,1.8f,1.8f);
        techocuartos = new Cubo(gl,0,0,0f,39.5f,1f,30f,0,0,0,0.9f,0.8f,0.6f);
        paredpos = new Cubo(gl,0,0,0,0.1f,30,12.3f,0,0,0,1f,0.5f,0.3f);
        paredizq = new Cubo(gl,0,0,0,0.1f,15,8,0,0,0,0.9f,0.8f,0.7f);
        paredizqUp = new Cubo(gl,0,0,0,0.1f,15,10f,0,0,0,0.9f,0.8f,0.7f);
        paredent = new Cubo(gl,0,0,0,0.1f,15,3,0,0,0,0.9f,0.6f,0.4f);
        paredder = new Cubo(gl,0,0,0,0.1f,30,10,0,0,0,0.9f,0.8f,0.7f);
        paredderEnt = new Cubo(gl,0,0,0,0.1f,15,1.75f,0,0,0,0.9f,0.6f,0.4f);
        paredderUp = new Cubo(gl,0,0,0,0.1f,15,1.75f,0,0,0,0.9f,0.8f,0.7f);
        paredadelanteUp = new Cubo(gl,0,0,0,0.1f,15,12.4f,0,0,0,0.9f,0.8f,0.7f);
        paredadelante = new Cubo(gl,0,0,0,0.1f,15,9.5f,0,0,0,0.9f,0.8f,0.7f);
        pared2 = new Cubo(gl,0,0,0,0.1f,15,9.5f,0,0,0,0.9f,0.8f,0.7f);
        pared3 = new Cubo(gl,0,0,0,0.1f,15,5f,0,0,0,0.9f,0.6f,0.4f);
        pared4 = new Cubo(gl,0,0,0,0.1f,15,5.5f,0,0,0,1f,0.5f,0.3f);
        pared5 = new Cubo(gl,0,0,0,0.1f,15,5.5f,0,0,0,0.9f,0.8f,0.7f);
        pared6 = new Cubo(gl,0,0,0,0.1f,15,3.5f,0,0,0,0.9f,0.8f,0.7f);
        columna1 = new Cubo(gl,0,0,0,2.5f,18,2.5f,0,0,0,0.9f,0.8f,0.7f);
        arbusto = new ArbolEsferas(gl,0,0,0,2,3,3,0,0,0);
        arbol2 = new ArbolEsfera(gl,0,0,0,2,3,3,0,0,0);
        arbol3 = new ArbolCubo(gl,0,0,0,2,3,3,0,0,0);
        arbol4 = new ArbolPir(gl,0,0,0,30,40,30,0,0,0);
        gradasjardin = new Gradas(gl,0,0,0,3,0,0,0,0.9f,0.9f,0.8f);
        gradas2 = new Gradas(gl,0,0,0,2f,0,-90,0,0.8f,0.6f,0.4f);
        gradas3 = new Gradas(gl,0,0,0,2f,0,0,0,0.8f,0.6f,0.4f);
        gradasEntra = new Gradas(gl,0,0,0,3,0,0,0,0.9f,0.9f,0.8f);
        comedor = new Mesa(gl,0,0,0,0,0,0,1f,2f,0.5f,0.9f,0.6f,0.3f);
        escritorio = new Mesa(gl,0,0,0,0,0,0,1f,2f,0.5f,0.9f,0.6f,0.3f);
        mesatele = new Mesa(gl,0,1.5f,1.7f,0,90,0,4f,2f,2f,0.9f,0.6f,0.3f);
        mesoncocina = new Mesa(gl,0,0,0,0,0,0,15,5,3,1f,0.8f,0.6f);
        islacocina = new Mesa(gl,0,0,0,0,0,0,9,5,4,1f,0.8f,0.6f);
        mesasala = new Mesa(gl,0,0,0,0,0,0,3,2.5f,3,1,1,1);
        mesajardin = new Mesa(gl,0,0,0,0,0,0,4,5f,3,0.5f,0.3f,0.1f);
        velador = new Mesa(gl,0,0,0,0,0,0,4,3,4,1f,0.8f,0.6f);
        peinadoraniña = new Mesa(gl,0,0,0,0,0,0,1f,2f,0.5f,1f,0.8f,0.6f);
        lampcomedor = new Lamparas(gl,0,0,0,3,1f,0.7f,0.1f);
        lamp2 = new Lamparas(gl,0,0,0,4,1f,1f,1f);
        lampmesa = new Lamparas(gl,0,0,0,4,1f,1f,1f);
        lampsala = new Lamparas(gl,0,0,0,3,1f,0.7f,0.1f);
        lampCocina = new Lamparas(gl,0,0,0,3,1,1,1);
        lamp2Cocina = new Lamparas(gl,0,0,0,3,1,1,1);
        lampEntrada = new Lamparas(gl,0,0,0,1,1,1,1);
        sala = new Sillas(gl,0,0.8f,0f,0,180,0,7,5f,0.9f,0.7f,0.3f);
        sala2 = new Sillas(gl,0,0.8f,0,0,90,0,7f,5f,0f,0.5f,0.8f);
        sala3 = new Sillas(gl,0,0.8f,0,0,90,0,7f,5f,0.9f,0.8f,0.6f);
        sillaMesa = new Sillas(gl,0,0,0,0,0,0,1,1.5f,0.9f,0.6f,0.3f);
        sillaIsla = new Sillas(gl,0,0,0,0,0,0,1f,4f,0.9f,0.4f,0.5f);
        sillajardin = new Sillas(gl,0,0,0,0,0,0,3,5f,0.5f,0.3f,0.1f);
        sillaescritorio = new Sillas(gl,0,0,0,0,0,0,3,5f,0.9f,0.6f,0.3f);
        sillapeinadora = new Sillas(gl,0,0,0,0,0,0,1.5f,2f,1f,0.8f,0.8f);
        barandaEntrada = new Baranda(gl,0,0,0,0,0,0,5f,0.5f,0.9f,0.9f,0.8f);
        barandajardin1 = new Baranda(gl,0,0,0,0,0,0,5f,0.5f,0.9f,0.9f,0.8f);
        estufa = new Cocina(gl,0,0,0,0,0,0,6,5,3,1,1,1);
        micro = new Cocina(gl,0,0,0,0,0,0,4,2.7f,2f,1,1,1);
        extract = new ExtractorCocina(gl,0,0,0,7f,8f,4f,1f,1f,1f);
        pisococina = new Baldosa(gl,0,0,0,10,15,0.9f,0.9f,0.9f);
        pisobaño = new Baldosa(gl,0,0,0,10,10,0.6f,0.8f,0.9f);
        paredbaño = new Baldosa(gl,0,0,0,10,10,0.6f,0.8f,0.9f);
        pisoestudio = new Quad2(gl,4.9f,16.3f,-34.5f,9.2f,10f,90,0,0,1f,0.8f,0.6f,0.8f,0.6f,0.4f);
        pisocuarto = new Quad2(gl,-13f,16.3f,29f,12f,16f,90,0,0,0.7f,0.5f,0.2f,1f,0.7f,0.4f);
        pisocuartoniña = new Quad2(gl,-13f,16.35f,2f,12f,12f,90,0,0,0.7f,0.5f,0.2f,1f,0.7f,0.4f);
        fondopisoCocina = new Quad2(gl,0,0,0,9,12,0,0,0,1,1,1,1f,1f,1f);
        paredbaño1 = new Quad2(gl,0,0,0,11f,7.3f,0,0,0,0.9f,1f,1f,1f,1f,1f);
        paredcuartoniña = new Quad2(gl,0,0,0,12f,7.3f,0,0,0,0.8f,0f,0.6f,1f,0.8f,1f);
        paredcuartoniña2 = new Quad2(gl,0,0,0,12f,7.3f,0,0,0,1f,0.6f,0.8f,1f,0.8f,1f);
        calleprincipal = new Calle(gl,0,0,0,200,20);
        refri = new Refrigerador(gl,0,0,0,5,10,3,1,1,1);
        armario = new Armario(gl,0,0,0,5,10,3,1f,0.8f,0.6f);
        t1 = new Tetera(gl,0.8f,0,0,0,0,0,0,0.8f,0.6f,0.7f);
        paredsala = new ParedLineas(gl,-16,8,44.35f,1f,8,1,1,1);
        alfombraSala= new Alfombras(gl,0f,-14.99f,-16f,2.5f,1f,0.9f,0.9f);
        chimeneasala = new Chimenea(gl,0,0,0,7,3.5f,2.5f,0.9f,0.9f,0.9f);
        floreromesasala = new Floreros(gl,0,0,0,1.5f,0,0,0);
        florero2 = new Floreros(gl,0,0,0,2f,0,0,0); 
        puertaprincipal = new Puerta(gl,0,0,0,6,12,1.8f,1.8f,1.8f);
        puertajardin = new Puerta(gl,0,0,0,6,12,2f,2f,2f);
        puerta1 = new Puerta(gl,0,0,0,6,12,0.4f,0.3f,0.1f);
        ventana1 = new Ventanas(gl,0,0,0,30,11,1.8f,1.8f,1.8f);
        ventana2 = new Ventanas(gl,0,0,0,18,8,1.8f,1.8f,1.8f);
        ventana3 = new Ventanas(gl,0,0,0,30,11,1.8f,1.8f,1.8f);
        ventana4 = new Ventanas(gl,0,0,0,30,11,1.8f,1.8f,1.8f);
        ventanasala = new Ventanas(gl,0,0,0,13,23,1.8f,1.8f,1.8f);
        pergolajardin = new Pergola(gl,0,0,0,44,12,14,0.5f,0.3f,0.1f);
        camaniña = new Cama(gl,0,0,0,0,0,0,0.9f,0.6f,0.8f,0.5f);
        camaprincipal = new Cama(gl,0,0,0,0,0,0,2f,0.3f,0.1f,0.5f);
        bañoarriba = new Baño(gl,0,0,0,3,6);
        lavabobaño = new Lavabo(gl,0,0,0,2.5f,5);
        tinabaño = new TinaBaño(gl,0,0,0,4,3,5,1.8f,1.8f,1.8f);
        espejobaño = new Espejo(gl,0,0,0,2,3,0.9f,0.9f,0.3f);
        tele = new Television(gl,0,10,0,0,0,0,4,7);
        comp = new Computador(gl,0,0,0,0,0,0,2);
        carro = new Carro(gl,50,2.5f,-150,0,0,0,10,5,5,0,0.1f,0.6f);
        cuadro1 = new Cuadros(gl,0,10,0,0,0,0,4,7);
        piscina = new Piscina(gl,65,5,0,40,50);
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
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        GLU glu= new GLU ();  
       
        
        ////////////////////////////CAMARA FACHADA PRINCIPAL//////////////////////////////////
        if (ncam == 1) {
            
            cam2.setX(-106.5f);
            cam2.setY(17f);
            cam2.setZ(1.5f);
             
             glu.gluLookAt(cam2.x,cam2.y,cam2.z,pisocasa.x,pisocasa.y,pisocasa.z, 0, 1, 0);
                
//                glu.gluLookAt(cam.x - 100, cam.y +10, cam.z, pisocasa.x, pisocasa.y, pisocasa.z, 0, 1, 0);
            }
        
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        
        ////////////////////////////CAMARA FACHADA POSTERIOR//////////////////////////////////
        if(ncam == 2){
            
            cam2.setX(106.5f);
            cam2.setY(17f);
            cam2.setZ(-1.5f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z,pisocasa.x,pisocasa.y,pisocasa.z, 0, 1, 0);
//            
//            glu.gluLookAt(cam.x + 20, cam.y +5, cam.z, pisoprin.x, pisoprin.y, pisoprin.z, 0, 1, 0);
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        
          ////////////////////////////CAMARA ESQUINA (VISTA SALA)//////////////////////////////////
        if(ncam == 3){
//            
            cam2.setX(10f);
            cam2.setY(15f);
            cam2.setZ(20f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z,pisocasa.x,pisocasa.y,pisocasa.z, 0, 1, 0);
//            glu.gluLookAt(cam.x, cam.y+50, cam.z,alfombraSala.x, alfombraSala.y, alfombraSala.z, 0, 1, 0);
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////CAMARA ESQUINA (VISTA COMEDOR COCINA)//////////////////////////////////
        if(ncam == 4){
//          
            cam2.setX(10f);
            cam2.setY(15f);
            cam2.setZ(-20f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z,pisocasa.x,pisocasa.y,pisocasa.z, 0, 1, 0);

        }
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        
        ////////////////////////////CAMARA ESQUINA (VISTA COMEDOR COCINA SALA)//////////////////////////////////
         if(ncam == 5){
//          
            cam2.setX(-20f);
            cam2.setY(15f);
            cam2.setZ(20f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z,pisocasa.x,pisocasa.y,pisocasa.z, 0, 1, 0);
//            glu.gluLookAt(cam.x*0,cam.y+100,cam.z*0, 0, -20,5, 0, 1, 0);
        }
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////CAMARA ESTUDIO SALA DE ESTAR///////////////////////////////
         
          if(ncam == 6){
            
            cam2.setX(-10f);
            cam2.setY(50f);
            cam2.setZ(-10f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z, pisoestudio.x, pisoestudio.y ,pisoestudio.z, 0, 1, 0);
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////CAMARA CUARTO NIÑA///////////////////////////////
            if(ncam == 7){
            
            cam2.setX(-25f);
            cam2.setY(50f);
            cam2.setZ(-10f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z, pisocuartoniña.x, pisocuartoniña.y ,pisocuartoniña.z, 0, 1, 0);
        }
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
              ////////////////////////////CAMARA CUARTO PRINCIPAL///////////////////////////////
            if(ncam == 8){
            
            cam2.setX(-25f);
            cam2.setY(50f);
            cam2.setZ(5f);
            
            glu.gluLookAt(cam2.x,cam2.y,cam2.z, pisocuarto.x, pisocuarto.y ,pisocuarto.z, 0, 1, 0);
        }
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
            ////////////////////////////CAMARA TECLADO FACHADA///////////////////////////////
            if(ncam == 9){

            
            glu.gluLookAt(cam.x - 100, cam.y +10, cam.z, pisocasa.x, pisocasa.y, pisocasa.z, 0, 1, 0);
        }
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
         ////////////////////////////CAMARA ESFERA//////////////////////////////////
        if (ncam == 10) {
            
          i+=0.05f;
        cam.x=(float) Math.cos(i)*8;
        cam.z=(float) Math.sin(i)*8;
             
             glu.gluLookAt(cam.x+100,cam.y+20,cam.z,pisocasa.x,pisocasa.y,pisocasa.z, 0, 1, 0);
                
//                glu.gluLookAt(cam.x - 100, cam.y +10, cam.z, pisocasa.x, pisocasa.y, pisocasa.z, 0, 1, 0);
            }
        
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
              ////////////////////////////CAMARA PANORAMICA//////////////////////////////////
        if (ncam == 11) {
           
//             glu.gluLookAt(cam.x*0,cam.y+100,cam.z*0, carro.x, carro.y,carro.z, 0, 1, 0);
             glu.gluLookAt(cam.x*0,cam.y+100,cam.z*0, 0, -20,5, 0, 1, 0);
            }
        
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
         ////////////////////////////CAMARA TECLADO FACHADA POSTERIOR///////////////////////////////
            if(ncam == 12){

            
            glu.gluLookAt(cam.x + 100, cam.y+10 , cam.z, pisocasa.x, pisocasa.y, pisocasa.z, 0, 1, 0);
        }
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        //PISOS 
        
        //piso principal
        gl.glPushMatrix();
        gl.glTranslatef(-10,-1f,0);
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
        
        gl.glPushMatrix();
//        gl.glTranslatef(0f,16f,10f);
        gl.glTranslatef(-5.5f,16f,30);
        pisocuartosUp.display();
        gl.glPopMatrix();
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
       
        
         //calle
        gl.glPushMatrix();
        gl.glTranslatef(-80,0.1f,0);
        gl.glRotatef(90,0,1,0);
        calleprincipal.display();
        gl.glPopMatrix();
        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        
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
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        
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
        gl.glTranslatef(-25,24,-18f);
        gl.glScalef(1,1,0.5f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-25,24,3f);
        ventana2.ventana1();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-25.1f,24,30f);
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
    
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        
        //lampara puerta de entrada
        gl.glPushMatrix();
        gl.glTranslatef(-22,15.8f,-20);
        lampEntrada.deTecho(glut);
        gl.glPopMatrix();
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        
        //CARRO
        gl.glPushMatrix();
         if (carro.traslada < 200 ) {
           
            gl.glPushMatrix();
            gl.glScalef(0.75f,0.75f,0.75f);
            carro.display(glut);
            System.out.println("valor de la traslación del carro: " + carro.traslada);
            gl.glPopMatrix();
        }
        
        gl.glPopMatrix();
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        
        //JARDIN
        
        //pergola
        gl.glPushMatrix();
        gl.glTranslatef(21,15,3);
        gl.glRotatef(90,0,1,0);
        pergolajardin.display(glut);
        gl.glPopMatrix();
       
        
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
        
        
        //mesa del jardin
        gl.glPushMatrix();
        gl.glTranslatef(23,5.8f,15f);
        mesajardin.mesaredonda(glut);
        gl.glPopMatrix();
        
        //sillas mesa jardin
        gl.glPushMatrix();
        gl.glTranslatef(19,3.5f,15f);
        sillajardin.silla();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(23,3.5f,19f);
        gl.glRotatef(90,0,1,0);
        sillajardin.silla();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(26,3.5f,15f);
        gl.glRotatef(180,0,1,0);
        sillajardin.silla();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(23,3.5f,11f);
        gl.glRotatef(-90,0,1,0);
        sillajardin.silla();
        gl.glPopMatrix();
        
        //piscina
        gl.glPushMatrix();
        piscina.display();
        gl.glPopMatrix();
        
        //flotador

        gl.glPushMatrix();
        gl.glColor3f(0.7f,0,0.4f);
        gl.glTranslatef(75,1,0);
        gl.glRotatef(90,1,0,0);
         gl.glRotatef(rot+=1f,0,0,1);
         gl.glRotatef(rot+=1f,1,0,0);
        glut.glutSolidTorus(1, 3, 20, 20);
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glColor3f(1,0.8f,0);
        gl.glTranslatef(60,1,10);
        gl.glRotatef(90,1,0,0);
         gl.glRotatef(rot+=1f,0,0,1);
         gl.glRotatef(rot+=1f,0,1,0);
        glut.glutSolidTorus(1, 3, 20, 20);
        gl.glPopMatrix();
        
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        
        
        //GRADAS
       
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
         
          //gradas de la entrada
        gl.glPushMatrix();
        gl.glTranslatef(34f,-0.9f,-4.5f);
        gl.glRotatef(180,0,1,0);
        gl.glScalef(1f,0.8f,3f);
        gradasjardin.display(2);
        gl.glPopMatrix();
        ///////////////////////////
        
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
         
      //COMEDOR
      
      gl.glPushMatrix();
      gl.glTranslatef(-25,0,-5);
      gl.glRotatef(90,0,1,0);
         //mesa de comedor
         gl.glPushMatrix();
         gl.glTranslatef(-15f,6f,10);
         gl.glScalef(10,9,10);
         comedor.comedor();
         gl.glPopMatrix();
         ///////////////////////////
         
            //sillas comedor
            //cabecera 1
         gl.glPushMatrix();
         gl.glTranslatef(-22f,3.5f,10);
         gl.glScalef(3f,3.5f,3f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
       
         
         //cabecera 2
         gl.glPushMatrix();
         gl.glTranslatef(-8f,3.5f,10);
         gl.glRotatef(180,0,1,0);
         gl.glScalef(3f,3.5f,3f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         
         //sillas derecha
         gl.glPushMatrix();
         gl.glTranslatef(-18f,3.5f,15);
         gl.glRotatef(90,0,1,0);
         gl.glScalef(3f,3.5f,3f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-13.5f,3.5f,15);
         gl.glRotatef(90,0,1,0);
         gl.glScalef(3f,3.5f,3f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         

           //sillas izquierda
         gl.glPushMatrix();
         gl.glTranslatef(-18f,3.5f,7);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(3f,3.5f,3f);
         sillaMesa.silla();
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-13.5f,3.5f,7);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(3f,3.5f,3f);
         sillaMesa.silla();
         gl.glPopMatrix();
         ///////////////////////////
         gl.glPopMatrix();
         
         //lampara comedor
          gl.glPushMatrix();
         gl.glTranslatef(-15f,12f,10);
         gl.glScalef(3,3,3);
         lampcomedor.colgante(glut);
         gl.glPopMatrix();
         gl.glPopMatrix();
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ///////////////////////////////////////////
         
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
         gl.glRotatef(rot+=1,0,1,0);
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
         gl.glRotatef(rot+=1,0,1,0);
         lamp2Cocina.colgante2(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
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
         
         ///////////////////////////////////////////
         ///////////////////////////////////////////
         ///////////////////////////////////////////
         
         //SALA
         
         //tapiz pared sala
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         paredsala.display(8);
         gl.glPopMatrix();
         ///////////////////////////
         
         //lampara de la sala
         gl.glPushMatrix();
         gl.glTranslatef(-1,13,-30);
         gl.glRotatef(rot+=1,0,1,0);
         gl.glScalef(3,2,3);
         lampsala.colgante(glut);
         gl.glPopMatrix();
         ///////////////////////////
         
         //alfombra de la sala
         gl.glPushMatrix();
         alfombraSala.alfombraRedonda();
         gl.glPopMatrix();
         ///////////////////////////
         
         //sillones
         gl.glPushMatrix();
         gl.glTranslatef(1,-1f,-42f);
         gl.glScalef(2.5f,2f,1.5f);
         gl.glRotatef(180,0,1,0);
         sala.sillon();
         gl.glPopMatrix();
         
          gl.glPushMatrix();
          gl.glTranslatef(-12f,-0.5f,-33);
          gl.glScalef(2.5f,2f,1.5f);
         sala2.sillon();
         gl.glPopMatrix();
         
//           gl.glPushMatrix();
//          gl.glTranslatef(-14.8f,14.4f,-35);
//          gl.glScalef(2.5f,2f,1.5f);
//         sala3.sillon();
//         gl.glPopMatrix();
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

         //////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         
         
          //SEGUNDO PISO
          
        //piso cuartos
        gl.glPushMatrix();
        pisocuarto.dibuja();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        pisocuartoniña.dibuja();
        gl.glPopMatrix();
        //////////////////////////////////////
        //////////////////////////////////////
        //////////////////////////////////////
          
          //CUARTO DE NIÑA
          
           //cama
         gl.glPushMatrix();
         gl.glTranslatef(-14f,17,-2.1f);
         gl.glScalef(13,13,13);
         camaniña.display();
         gl.glPopMatrix();
         
         //veladores
         gl.glPushMatrix();
         gl.glTranslatef(-8,18,-7);
         gl.glRotatef(180,0,1,0);
         velador.mesadenoche(glut);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-20,18,-7);
         gl.glRotatef(180,0,1,0);
         velador.mesadenoche(glut);
         gl.glPopMatrix();
        
         //lamparas mesa de noche
         gl.glPushMatrix();
         gl.glTranslatef(-8,19,-6.5f);
         lampmesa.deMesa(glut);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-20f,19,-6.5f);
         lampmesa.deMesa(glut);
         gl.glPopMatrix();
         
         
         //peinadora
         gl.glPushMatrix();
         gl.glTranslatef(-13f,20f,12);
         gl.glScalef(8,7,8);
         peinadoraniña.peinadora(glut);
         gl.glPopMatrix();
         
         //silla de la peinadora
         gl.glPushMatrix();
         gl.glTranslatef(-13,20,8);
         sillapeinadora.sillaAlta(glut);
         gl.glPopMatrix();
         
         
         //pintura de las paredes
          gl.glPushMatrix();
          gl.glTranslatef(-13f,23.8f,13.7f);
          paredcuartoniña.dibuja();
          gl.glPopMatrix();
          
          gl.glPushMatrix();
          gl.glTranslatef(-13f,23.8f,-8.7f);
          paredcuartoniña.dibuja();
          gl.glPopMatrix();
          
          gl.glPushMatrix();
          gl.glTranslatef(-1.25f,23.6f,2.5f);
          gl.glRotatef(90,0,1,0);
          gl.glScalef(0.95f,1,1f);
          paredcuartoniña2.dibuja();
          gl.glPopMatrix();
          
          gl.glPushMatrix();
          gl.glTranslatef(-24.9f,23.6f,2.5f);
          gl.glRotatef(90,0,1,0);
          gl.glScalef(0.95f,1,1f);
          paredcuartoniña2.dibuja();
          gl.glPopMatrix();
          
            //puerta 
          gl.glPushMatrix();
          gl.glTranslatef(-1f,22,10);
          gl.glRotatef(360,0,1,0);
          puerta1.puertasimple(glut);
          gl.glPopMatrix();
          
           //////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
          
          //ESTUDIO
          
          //escritorio
          gl.glPushMatrix();
          gl.glTranslatef(4,19.8f,-42.5f);
          gl.glScalef(10,7,8);
          escritorio.comedor();
          gl.glPopMatrix();

          //silla del escritorio
          gl.glPushMatrix();
          gl.glTranslatef(4,18.5f,-39f);
          gl.glRotatef(90,0,1,0);
          sillaescritorio.silla();
          gl.glPopMatrix();
          
           //computador
          gl.glPushMatrix();
          gl.glTranslatef(3,22f,-43f);
          comp.display(glut);
          gl.glPopMatrix();
        
          //cuadro
         gl.glPushMatrix();
         gl.glTranslatef(-4f,5,-35);
         gl.glRotatef(90,0,1,0);
         cuadro1.display();
         gl.glPopMatrix();
         
           //puerta del estudio
          gl.glPushMatrix();
          gl.glTranslatef(9.5f,22,-24.6f);
          gl.glRotatef(90,0,1,0);
          puerta1.puertasimple(glut);
          gl.glPopMatrix();
          
          //piso del estudio
          gl.glPushMatrix();
          pisoestudio.dibuja();
          gl.glPopMatrix();
          
          //////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         
          //SALA DE ESTAR 
          
          //sillon
           gl.glPushMatrix();
          gl.glTranslatef(-14.8f,14.4f,-35);
          gl.glScalef(2.5f,2f,1.5f);
         sala3.sillon();
         gl.glPopMatrix();
         
         //television
         gl.glPushMatrix();
         gl.glTranslatef(-4.5f,5,-35);
         gl.glRotatef(-90,0,1,0);
         tele.display();
         gl.glPopMatrix();
          //////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         
         
          //CUARTO PRINCIPAL
         
          //puerta 
          gl.glPushMatrix();
          gl.glTranslatef(-1f,22,19);
          gl.glRotatef(-180,0,1,0);
          puerta1.puertasimple(glut);
          gl.glPopMatrix();
          
          //closet
        
          gl.glPushMatrix();
          gl.glTranslatef(-9f,23.5f,43);
          gl.glScalef(3f,1.5f,1.5f);
//          gl.glRotatef(90,0,1,0);
          armario.display(glut);
          gl.glPopMatrix();
          
          //veladores
           gl.glPushMatrix();
         gl.glTranslatef(-22,18f,22f);
         gl.glRotatef(-90,0,1,0);
         velador.mesadenoche(glut);
         gl.glPopMatrix();
         
            gl.glPushMatrix();
         gl.glTranslatef(-22,18f,38f);
         gl.glRotatef(-90,0,1,0);
         velador.mesadenoche(glut);
         gl.glPopMatrix();
         
         //lamparas mesa de noche
         gl.glPushMatrix();
         gl.glTranslatef(-22,19,38f);
         lampmesa.deMesa(glut);
         gl.glPopMatrix();
         
         gl.glPushMatrix();
         gl.glTranslatef(-22f,19,22f);
         lampmesa.deMesa(glut);
         gl.glPopMatrix();
         
          //cama
         gl.glPushMatrix();
         gl.glTranslatef(-18f,17,30f);
         gl.glRotatef(90,0,1,0);
         gl.glScalef(20,13,13);
         camaprincipal.display();
         gl.glPopMatrix();
         
         //television
         gl.glPushMatrix();
         gl.glTranslatef(-2f,5,31);
         gl.glRotatef(-90,0,1,0);
         tele.display();
         gl.glPopMatrix();
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
        
         
          //BAÑO
          
          //puerta del baño
          gl.glPushMatrix();
          gl.glTranslatef(9.5f,22,23);
          gl.glRotatef(90,0,1,0);
          puerta1.puertasimple(glut);
          gl.glPopMatrix();
          
          //retrete
          gl.glPushMatrix();
          gl.glTranslatef(11f,18f,40);
          bañoarriba.display(glut);
          gl.glPopMatrix();
          
          //lavabo
          gl.glPushMatrix();
          gl.glTranslatef(3f,21f,26);
          lavabobaño.lavabobaño(glut);
          gl.glPopMatrix();
          
          //tina de baño
          gl.glPushMatrix();
          gl.glTranslatef(2f,18.2f,39.3f);
          gl.glRotatef(90, 1, 0, 0);
          gl.glScalef(1.2f,3f,0.75f);
          tinabaño.display();
          gl.glPopMatrix();
          
          //espejo del baño
          gl.glPushMatrix();
          gl.glTranslatef(3,26,23.6f);
          gl.glScalef(0.3f,0.3f,0.3f);
          espejobaño.espejoredondo(glut);
          gl.glPopMatrix();
          
          //baldosas
          gl.glPushMatrix();
          gl.glTranslatef(7.5f,16.3f,20);
          gl.glScalef(0.95f,1.3f,1.3f);
          pisobaño.display(5);
          gl.glPopMatrix();
         
          //baldosas de la pared
          gl.glPushMatrix();
          gl.glTranslatef(13.9f,17f,20);
          gl.glRotatef(90,0,0,1);
          gl.glScalef(0.95f,1.3f,1.3f);
          paredbaño.dibuja(5);
          gl.glPopMatrix();
          
          gl.glPushMatrix();
          gl.glTranslatef(-0.78f,17f,20);
          gl.glRotatef(90,0,0,1);
          gl.glScalef(0.95f,1.3f,1.3f);
          paredbaño.dibuja(5);
          gl.glPopMatrix();
          
          //pintura pared
          gl.glPushMatrix();
          gl.glTranslatef(14,23.8f,34.3f);
          gl.glRotatef(90,0,1,0);
          paredbaño1.dibuja();
          gl.glPopMatrix();
          
          gl.glPushMatrix();
          gl.glTranslatef(-0.79f,23.6f,34.3f);
          gl.glRotatef(90,0,1,0);
          paredbaño1.dibuja();
          gl.glPopMatrix();
          
          gl.glPushMatrix();
          gl.glTranslatef(6.7f,23.6f,23.5f);
          gl.glScalef(0.7f,1,1);
          paredbaño1.dibuja();
          gl.glPopMatrix();
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         //////////////////////////////////////////////
         
         
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
         gl.glTranslatef(6.2f,8.5f,1.36f);
         paredizqUp.display();
         gl.glPopMatrix();
         ///////////////////////////
         
           //pared derecha cuartos arriba exterior
         gl.glPushMatrix();
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(11.3f,23.5f,1.4f);
         paredizqUp.display();
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
        
        //pared posterior sala abajo
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.315f,23.5f,-8.5f);
         pared5.display();
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
        
          //pared pequeña arriba 
         gl.glPushMatrix();
         gl.glRotatef(90,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(6.2f,23.5f,-5.35f);
         paredderUp.display();
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
        
        //pared 2do piso division estudio 
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(1f,23.5f,8.7f);
         pared3.display();
         gl.glPopMatrix();
        ///////////////////////////
        
        //pared puerta estudio
        gl.glPushMatrix();
         gl.glTranslatef(5f,23.5f,-24.7f);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(4,1,5.2f);
         pared6.display();
         gl.glPopMatrix();
         //////////////////////
        
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
        
          //pared posterior sala arriba
         gl.glPushMatrix();
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,4);
         gl.glTranslatef(-3.59f,23.5f,-8.5f);
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
                       
        //paredes baño
        
        //pared baño puerta
         gl.glPushMatrix();
         gl.glTranslatef(6.5f,23.5f,23);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(4,1,4.4f);
         pared6.display();
         gl.glPopMatrix();
         //////////////////////
         
         //pared division cuartos baño
          gl.glPushMatrix();
         gl.glTranslatef(-1f,23.5f,18f);
         gl.glRotatef(180,0,1,0);
         gl.glScalef(4,1,15.5f);
         pared6.display();
         gl.glPopMatrix();
         ///////////////////////////
        
         //pared 2do piso gradas cuartos
         gl.glPushMatrix();
         gl.glTranslatef(-13f,23.5f,-9);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(4,1,7f);
         pared6.display();
         gl.glPopMatrix();
         //////////////////////
         
         //pared 2do piso division cuartos
         gl.glPushMatrix();
         gl.glTranslatef(-13f,23.5f,14);
         gl.glRotatef(-90,0,1,0);
         gl.glScalef(4,1,7f);
         pared6.display();
         gl.glPopMatrix();
         //////////////////////
         
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
        
          //TECHO
      gl.glPushMatrix();
      
        if(v){
        gl.glPushMatrix();
        gl.glTranslatef(-5.5f,31f,0);
        pisocasa.display();
        gl.glPopMatrix();
    
        gl.glPushMatrix();
        gl.glTranslatef(-2f,31f,-35);
        pisocasasala.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
//        gl.glTranslatef(0f,16f,10f);
        gl.glTranslatef(-5.5f,31f,30);
        techocuartos.display();
        gl.glPopMatrix();
        }
        
        gl.glPopMatrix();
        ///////////////////////////
        ///////////////////////////
        ///////////////////////////

         //COLUMNAS
        gl.glPushMatrix();
        gl.glTranslatef(12,7f,43);
        gl.glRotatef(180,0,1,0);
        columna1.display();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-22,7f,43);
        gl.glRotatef(180,0,1,0);
        columna1.display();
        gl.glPopMatrix();
        ///////////////////////////        
        
            //arbustos entrada
        gl.glPushMatrix();
        gl.glTranslatef(-20,-2,-29);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
        gl.glTranslatef(-20,-2,-35);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
        gl.glTranslatef(-20,-2,-41);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
        gl.glTranslatef(-27,-2,-10);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
        gl.glTranslatef(-27,-2,-4);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
        gl.glTranslatef(-27,-2,2);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
        gl.glTranslatef(-27,-2,8);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
         gl.glPushMatrix();
        gl.glTranslatef(-27,-2,14);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
        gl.glTranslatef(-27,-2,20);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
        gl.glTranslatef(-27,-2,26);
        gl.glScalef(5,5,5);
        arbusto.dibujararbol();
       gl.glPopMatrix();
       /////////////////////////////////
       ////////////////////////////////
       /////////////////////////////////
       
       //ARBOLES
       
       //arboles derecha
       gl.glPushMatrix();
       gl.glTranslatef(-10,6,60);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(-30,6,70);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(-15,6,90);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(-20,6,65);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(15,6,90);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(20,6,65);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
       gl.glTranslatef(5,6,75);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       ///////////////////////////////////
       ///////////////////////////////////
       ///////////////////////////////////
       
       //arboles izquierda
        gl.glPushMatrix();
       gl.glTranslatef(-10,6,-60);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(-30,6,-70);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
       gl.glTranslatef(-15,6,-90);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
       gl.glTranslatef(-20,6,-75);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(5,6,-75);
       arbol4.dibujararbol();
       
       gl.glPopMatrix();
        gl.glPushMatrix();
       gl.glTranslatef(15,6,-90);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
         gl.glPushMatrix();
       gl.glTranslatef(20,6,-65);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(50,6,-70);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(-50,6,-70);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
       gl.glTranslatef(80,6,-50);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
           gl.glPushMatrix();
       gl.glTranslatef(80,6,50);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
           gl.glPushMatrix();
       gl.glTranslatef(70,6,-60);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
          gl.glPushMatrix();
       gl.glTranslatef(70,6,60);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
        gl.glPushMatrix();
       gl.glTranslatef(60,6,-40);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(60,6,40);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(40,6,50);
       arbol4.dibujararbol();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(40,6,-50);
       arbol4.dibujararbol();
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
              if (e.getKeyChar()=='5'){
        Escenario.ncam=5;
    }
              
    if (e.getKeyChar()=='6'){
        Escenario.ncam=6;
    }
    
     if (e.getKeyChar()=='7'){
        Escenario.ncam=7;
    }
    if (e.getKeyChar()=='8'){
        Escenario.ncam=8;
    }
     
     if (e.getKeyChar()=='9'){
        Escenario.ncam=9;
    }
     
      if (e.getKeyChar()=='a'){
        Escenario.ncam=10;
    }
       if (e.getKeyChar()=='s'){
        Escenario.ncam=11;
    }

          if (e.getKeyChar()=='d'){
        Escenario.ncam=12;
    }
    }    

    public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
           cam.x+=0.5;
           cam.setx(cam.getx());
            System.out.println("Valor en la traslacion de X: "+cam.x);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            cam.x-=0.5;
            cam.setx(cam.getx());
            System.out.println("Valor en la traslacion de X: "+cam.x);
        }
        
        if(e.getKeyCode()== KeyEvent.VK_UP){
            if (cam.y < 78) {
                
                cam.y+=0.5;
            cam.sety(cam.gety());
            System.out.println("Valor en la traslacion de Y: "+cam.y);
            }
            
        }
        
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            
            if (cam.y > -5) {
                cam.y-=0.5;
            cam.sety(cam.gety());
            System.out.println("Valor en la traslacion de Y: "+cam.y);
            }
            
        }
        if(e.getKeyCode()== KeyEvent.VK_X){
            
            if (cam.z < 144) {
            cam.z+=0.5;
            cam.setz(cam.getz());
            System.out.println("Valor en la traslacion de Z: "+cam.z);
            }
            
        }
        
        if(e.getKeyCode()== KeyEvent.VK_Z){
            
            if (cam.z > -127) {
            cam.z-=0.5;
            cam.setz(cam.getz());
            System.out.println("Valor en la traslacion de Z: "+cam.z);
            }
            
        }
        
           if(e.getKeyCode()== KeyEvent.VK_T){
            
           v^=true;
            
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