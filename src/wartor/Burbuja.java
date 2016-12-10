/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wartor;

/**
 *
 * @author bitelyus @ <www.miguelkiko.com>
 */
public class Burbuja implements Runnable {

    private int x;          // posición x
    private int y;          // posición y 
    private int velocidad;  // velocidad en milisegundos
    PanelBosque pb;         // panel bosque
    private double radio;
    private double xcentro;
    private double ycentro;

    
    public Burbuja(PanelBosque pb) {
        this.x = Utils.rndm(0,500);
        this.y = Utils.rndm(0,500);
        this.velocidad=Utils.rndm(5,25);
        this.pb = pb;
        this.radio=5.5;
        this.xcentro=(double)this.getX();
        this.ycentro=(double)this.getY();
    }

    // Getters & Setters
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
   
    public double getXcentro() {
        return xcentro;
    }

    public void setXcentro(double xcentro) {
        this.xcentro = xcentro;
    }

    public double getYcentro() {
        return ycentro;
    }

    public void setYcentro(double ycentro) {
        this.ycentro = ycentro;
    }
    
    /**
     * Sobreescritura del método run
     */
    @Override
    public void run() {
        int movimiento = 0;
        while (true) {
            movimiento=Utils.rndm(0,2);
                switch (movimiento) {
                case 0:
                    if (x<0) { x=450; } else { x=(x+1)%450; }
                    if (y<0) { y=450; } else { y=(y-1)%450; }
                    break;
                case 1:
                    if (x<0) { x=450; } else { x=(x-1)%450; }
                    if (y<0) { y=450; } else { y=(y-1)%450; }
                    break;
            }
            //System.out.println(this.getY());
            try {
                Thread.sleep(this.velocidad);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            pb.repaint();

        }
    }
    
}
