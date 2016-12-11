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
public class Pez implements Runnable {

    private int x;          // posición x
    private int y;          // posición y 
    private int velocidad;  // velocidad en milisegundos
    private int sexo;       // 0 - HEMBRA   1 - MACHO
    PanelBosque pb;         // panel bosque
    private int tamaño;     // el radio de la circunferencia que representa el pez
    private double radio;
    private double xcentro;
    private double ycentro;

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
    
    public Pez(PanelBosque pb) {
        this.x = Utils.rndm(0,500);
        this.y = Utils.rndm(0,500);
        this.velocidad=Utils.rndm(5,25);
        this.sexo = Utils.rndm(0,1);
        this.pb = pb;
        this.tamaño=5;
        this.radio=5.5;
        this.xcentro=(double)this.getX();
        this.ycentro=(double)this.getY();
    }

    public Pez(int x, int y, int v, PanelBosque pb) {
        this.x = x;
        this.y = y;
        this.velocidad = v;
        this.sexo = Utils.rndm(0,1);
        this.pb = pb;
        this.tamaño=5;
        this.radio=5.5;
        this.xcentro=(double)this.getX();
        this.ycentro=(double)this.getY();
    }
    
    public Pez(int x, int y, int v, int sexo, PanelBosque pb) {
        this.x = x;
        this.y = y;
        this.velocidad = v;
        this.sexo = sexo;
        this.pb = pb;
        this.tamaño=5;
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
    
    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
    /**
     * Sobreescritura del método run
     */
    @Override
    public void run() {
        int movimiento = 0;
        while (true) {
            movimiento=Utils.rndm(0,4);
            switch (movimiento) {
                case 0:
                    x=(x+1)%450;
                    break;
                case 1:
                    y=(y+1)%450;
                    break;
                case 2:
                    x=(x-1)%450;
                    break;
                case 3:
                    x=(x+1)%450;
                    y=(y+1)%450;
                    break;
                case 4:
                    x=(x+1)%450;
            }
            
            try {
                Thread.sleep(this.velocidad);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            pb.repaint();
        }
    }
    
    public String getEstado() {
        return this.getX()+""+this.getY();
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    

}
