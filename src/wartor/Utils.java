package wartor;

/**
 * Cláse de Apoyo a operaciones comunes.
 * @author bitelyus @ <www.miguelkiko.com>
 */
public class Utils {
    
    /**
     * Método que devuelve un random indicando los indices
     * @param desde El indice más bajo
     * @param hasta El máximo valor
     * @return El número aleatorio
     */
    public static int rndm(int desde, int hasta) {
        return (int)(Math.random()*(hasta-desde+1)+desde);
    }
    
}
