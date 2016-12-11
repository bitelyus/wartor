package wartor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JPanel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class PanelOceano extends JPanel {

    // ZONA DE ATRIBUTOS
    //Pez pez = new Pez(10,10,this);
    //Pez pez2 = new Pez(35,50,this);
    private final List<Pez> mipezera = new ArrayList<Pez>();
    private final List<Boqueron> mipezerab = new ArrayList<Boqueron>();
    private final List<Burbuja> mipezerabb = new ArrayList<Burbuja>();

    // ZONA DE CONSTRUCTORES
    public PanelOceano() {

        this.setBounds(0, 0, 500, 500); // TAMAÑO DEL PANEL

        for (int i = 0; i < 40; i++) {  // LE AÑADIMOS UN PUÑADO DE PECES
            Pez mipez = new Pez(this);  // CREAMOS UN PEZ CON DATOS ALEATORIOS
            new Thread(mipez).start();  // ARRANCAMOS EL PEZ
            mipezera.add(mipez);        // LO AÑADIMOS A LA PEZERA DE NORMALES
        }

        for (int i = 0; i < 8; i++) {         // LE AÑADIMOS OTRO TANTO DE TIBURONES
            Boqueron mitibuboqueron = new Boqueron(this);
            new Thread(mitibuboqueron).start(); // ARRANCAMOS EL TIBUBOQUERON
            mipezerab.add(mitibuboqueron);      // LO AÑADIMOS A LA PEZERA DE TIBUBOQUERONES
        }

        for (int i = 0; i < 50; i++) {         // LE AÑADIMOS 50 BURBUJAS
            Burbuja miburbuja = new Burbuja(this);
            new Thread(miburbuja).start(); // ARRANCAMOS LA BURBUJA
            mipezerabb.add(miburbuja);      // LO AÑADIMOS A LA PEZERA DE BURBUJAS
        }

    }

    // ZONA DE METODOS
    /**
     * Sobreescritura del Método paint que se ejecuta cada vez que se pinta la
     * pantalla
     *
     * @param g Graphics
     */
    @Override // cando hay un paint, se ejecuta siempre antes que cualquier otra cosa
    public void paint(Graphics g) {

        // System.out.println("estoy pintando");
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 500);

        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("burbuja.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
        for (Burbuja b : mipezerabb) {
            g.drawImage(img, b.getX(), b.getY(), this);
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
        // SI LA DISTANCIA ENTRE TIBURON Y PEZ ES MENOR DE 10 > MUERE PECECITO
        ArrayList<Pez> pecesmuertos = new ArrayList();
        for (Boqueron tiburon : mipezerab) {
            for (Pez pez : mipezera) {
                //System.out.println(tiburon.calcularDistanciaDesde(pez));
                if (tiburon.calcularDistanciaDesde(pez)<tiburon.getRadio()+5) { // EL RADIO DEL TIBURON Y 5 DEL PEZ
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

        // SI UN PEZ ESTA EN CONTACTO CON OTRO Y SON DISTINTO SEXO, PROCREAN
        int contador = 0;
        for (Pez pez : mipezera) {
            for (Pez pez2 : mipezera) {
                if ( pez!=pez2 && pez.getEstado().equalsIgnoreCase(pez2.getEstado()) ) {
                    if (pez.getSexo() != pez2.getSexo()) {
                        // nuevo pez!
                        contador++;
                        System.out.println("DOS PEZECILLOS HAN PROCREADO!!");
                    }
                }
            }
        }
        
        // CREAR LOS NUEVOS PECES PROCREADOS
        for (int i=0;i<contador;i++) {  // POR CADA CONTACTO MACHO HEMBRA
            Pez mipez = new Pez(this);  // CREAMOS UN PEZ CON DATOS ALEATORIOS
            new Thread(mipez).start();  // ARRANCAMOS EL PEZ
            mipezera.add(mipez);        // LO AÑADIMOS A LA PECERA
        }
        
        g.setColor(Color.red);
        g.setFont(new Font("SansSerif",Font.BOLD, 15));
        g.drawString("PECES: " + mipezera.size(), 10,470);
       
    }

}
