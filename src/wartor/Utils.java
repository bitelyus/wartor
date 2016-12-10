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
public class Utils {
    
    public static int rndm(int desde, int hasta) {
        return (int)(Math.random()*(hasta-desde+1)+desde);
    }
    
}
