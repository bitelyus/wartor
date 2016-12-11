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
public class Boqueron implements Runnable {

    private int x;          // POSICIÓN X EN EL MAPA
    private int y;          // POSICIÓN Y EN EL MAPA
    final private int velocidad;  // FRECUENCIA DEL SLEEP
    int sexo;               // 0 - HEMBRA   1 - MACHO
    PanelOceano pb;         // UN PANEL BOSQUE
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
    
    public Boqueron (PanelOceano pb) {
        this.x = Utils.rndm(0,450);
        this.y = Utils.rndm(0,450);
        this.velocidad = Utils.rndm(10,20);
        this.sexo = Utils.rndm(0,1);
        this.pb = pb;
        this.radio=10;
        this.xcentro=(double)this.x; 
        this.ycentro=(double)this.y;
    }
    
    public Boqueron(int x, int y, int v, int sexo, PanelOceano pb) {
        this.x = x;
        this.y = y;
        this.velocidad = v;
        this.sexo = sexo;
        this.pb = pb;
        this.radio=5;
        this.xcentro=(double)this.x;
        this.ycentro=(double)this.y;
     }

    public Boqueron(int x, int y, int v, PanelOceano pb) {
        this.x = x;
        this.y = y;
        this.velocidad = v;
        this.sexo = Utils.rndm(0,1);
        this.pb = pb;
        this.radio=5;
        this.xcentro=(double)this.x;
        this.ycentro=(double)this.y;
     }
    
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
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public void run() {
        int movimiento = 0;
        while (true) {
            movimiento=Utils.rndm(0,4);
            switch (movimiento) {
                case 0:
                    if (x<0) { x=450; } else { x=(x+1)%450; xcentro=(double)(xcentro+1)%450; }
                    break;
                case 1:
                    if (x<0) { x=450; } else { x=(x+1)%450; xcentro=(double)(xcentro+1)%450;  }
                    if (y<0) { y=450; } else { y=(y-1)%450; ycentro=(double)(ycentro-1)%450;  }
                    break;
                case 2:
                    if (y<0) { y=450; } else { y=(y-1)%450;  ycentro=(double)(ycentro-1)%450; }
                    //y=(y-1)%450;
                    break;
                case 3:
                    if (y<0) { y=450; } else { y=(y-1)%450; ycentro=(double)(ycentro-1)%450;  }
                    x=(x+1)%450;
                    xcentro=(double)(xcentro+1)%450;
                    break;
                case 4:
                    x=(x+2)%450;
                    xcentro=(double)(xcentro+2)%450;
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
    
    public String getEstado() {
        return this.getX()+""+this.getY();
    }
    
    public double calcularDistanciaDesde(Pez pez) {
        double cateto1 =  pez.getX() - this.getX()+25;
        double cateto2 =  pez.getY() - this.getY();
        double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
        return hipotenusa;
    }
    
}
