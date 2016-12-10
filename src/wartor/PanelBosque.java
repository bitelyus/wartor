
package wartor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import java.util.*;
import javax.imageio.ImageIO;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class PanelBosque extends JPanel{
    
    // ZONA DE ATRIBUTOS
    
    //Pez pez = new Pez(10,10,this);
    //Pez pez2 = new Pez(35,50,this);
    private final List<Pez> mipezera = new ArrayList<Pez>();
    private final List<Boqueron> mipezerab = new ArrayList<Boqueron>();
    private final List<Burbuja> mipezerabb = new ArrayList<Burbuja>();
    private final List<Choke> mischokes = new ArrayList<Choke>();
    
    // ZONA DE CONSTRUCTORES
    
    public PanelBosque() {
        
        this.setBounds(0,0,500,500);    // TAMAÑO DEL PANEL
        
        for (int i=0;i<30;i++){          // LE AÑADIMO 10 PEZCES
            Pez mipez = new Pez(this);  // CREAMOS UN PEZ CON DATOS ALEATORIOS
            new Thread(mipez).start();  // ARRANCAMOS EL PEZ
            mipezera.add(mipez);        // LO AÑADIMOS A LA PEZERA DE NORMALES
        }   
        
        for (int i=0;i<10;i++){         // LE AÑADIMOS 10 TIBURONES
            Boqueron mitibuboqueron = new Boqueron(this);
            new Thread(mitibuboqueron).start(); // ARRANCAMOS EL TIBUBOQUERON
            mipezerab.add(mitibuboqueron);      // LO AÑADIMOS A LA PEZERA DE TIBUBOQUERONES
        }
        
        for (int i=0;i<50;i++){         // LE AÑADIMOS 10 TIBURONES
            Burbuja miburbuja = new Burbuja(this);
            new Thread(miburbuja).start(); // ARRANCAMOS EL TIBUBOQUERON
            mipezerabb.add(miburbuja);      // LO AÑADIMOS A LA PEZERA DE TIBUBOQUERONES
        }
    }
    
    // ZONA DE METODOS
    /**
     * Sobreescritura del Método paint que se ejecuta cada vez que se pinta la
     * pantalla
     * @param g Graphics
     */
    @Override // cando hay un paint, se ejecuta siempre antes que cualquier otra cosa
    public void paint(Graphics g) {
        
        // System.out.println("estoy pintando");
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,500,500);

        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("burbuja.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                
        for (int i=0;i<50;i++) {
            g.drawImage(img,mipezerabb.get(i).getX(),mipezerabb.get(i).getY(),this);
        }  
        
        try {
            img = ImageIO.read(new File("pez.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        for (Pez mipez : mipezera) {
            g.drawImage(img, mipez.getX(), mipez.getY(), this);
            //System.out.println("SEXO: "+mipez.getSexo());
        }
        
        try {
            img = ImageIO.read(new File("tiburon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                
        for (Boqueron mitiburon : mipezerab) {
            g.drawImage(img, mitiburon.getX(), mitiburon.getY(), this);
        }        
        
         
        
        // PARA PINTAR LAS PLANTAS EN LA ESQUINA >:)
        
        try {
            img = ImageIO.read(new File("algas.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // imagen, horizontal, vertical, paneldondesepintara
        g.drawImage(img, 210, 260, this);
        
        
        // COMPROBAR POSICIÓN DE LOS PECES!!. 
        // SI ESTAN EN LA MISMA X E Y TIBURON Y PEZ > MUERE PECECITO
        ArrayList<Pez> pecesmuertos = new ArrayList();
        for (Pez pez : mipezera) {
            for (Boqueron tiburon : mipezerab) {
                if (pez.getEstado().equalsIgnoreCase(tiburon.getEstado())) {
                    System.out.println("HA CHOCADO UN TIBUBOQUERON CON UN PEZ!!");
                    pecesmuertos.add(pez);
                } 
            }
        }
        
        // ELIMINAR LOS MUERTOS
        for (Pez muerto : pecesmuertos) {
            if (mipezera.remove(muerto)) {
                System.out.println("HA MUERTO UN PECECITO >:(");
            }
        }
        
        
        
    }
    
}
