/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wartor;

import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class Choke extends TimerTask implements Runnable {
    
    private int x;
    private int y;
    
    private PanelOceano pb;
    private int tiempodevida=0;
    
    public Choke(int x, int y, PanelOceano pb) {
        this.x=x;
        this.y=y;
        this.pb = pb;
        this.tiempodevida=0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Choke.class.getName()).log(Level.SEVERE, null, ex);
            }
            tiempodevida++;
            pb.repaint();
        }
    }

    public PanelOceano getPb() {
        return pb;
    }

    public void setPb(PanelOceano pb) {
        this.pb = pb;
    }

    public int getTiempodevida() {
        return tiempodevida;
    }

    public void setTiempodevida(int tiempodevida) {
        this.tiempodevida = tiempodevida;
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
    
}
