package tp5client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public final class JFenetre_tp5 extends JFrame { 
 
    public static int FENETRE_INT = 500;
    
    
public JFenetre_tp5() { //Permet de créer la fenêtre et les éléments de base
        super("Réservation de places de théatre"); //titre
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Fermeture de l'application lorsequ'on ferme la fenêtre
        setResizable(true); // Redimensionnement supporté depuis l'amélioration
        this.setSize(FENETRE_INT,FENETRE_INT);
        this.setLayout(new BorderLayout());






    }
}
   
