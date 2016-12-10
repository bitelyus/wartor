package wartor;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class VentanaWarTor extends JFrame {
    
    PanelBosque pb = new PanelBosque();

    public VentanaWarTor() {
        super("WAR TOR");   // LE PONEMOS NOMBRE A LA VENTANA
        try {               // ESTO PARA LOS MACS
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        this.setBounds(10, 10, 500, 500);   // DEFINIMOS EL TAMAÑO Y POSICION DE LA VENTANA
        this.add(pb);                       // AÑADIMOS EL PANEL
        this.setResizable(false);
        this.setVisible(true);              // HACEMO VISIBLE LA VENTANA
    }
}
