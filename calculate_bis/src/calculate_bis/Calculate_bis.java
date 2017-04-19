package calculate_bis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Calculate_bis extends JFrame
{

    private final JPanel content;
    private final JPanel panneauEcran;
    private final JPanel panneauBoutons;
    private final JPanel panneauOperations;
    private final Dimension chiffreDimension;
    private final Dimension operateurDimension;

    public Calculate_bis()
    {
        // La dimension des boutons
        this.operateurDimension = new Dimension(100, 80);
        this.chiffreDimension = new Dimension(120, 60);
        // Instanciation des variables
        this.content = new JPanel();
        this.panneauEcran = new JPanel();
        this.panneauBoutons = new JPanel();
        this.panneauOperations = new JPanel();

        // Comportement par défaut à la fermeture
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Titre
        this.setTitle("Calculette");
        // Mise en place du contenu
        this.initComponents();
        this.pack();
        // Affichage
        this.setVisible(true);
    }

    private void initComponents()
    {
        // L'affichage : on crée des bordures autour du panneau d'affichage de l'écran
        panneauEcran.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5), // Le padding
                BorderFactory.createLineBorder(Color.BLACK, 1) // La bordure
        ));
        panneauEcran.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panneauEcran.add(new JLabel("0"));

        // Les chiffres
        String[] boutonsLabel = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", ".", "="
        };
        panneauBoutons.setLayout(new GridLayout(4, 3, 2, 2));
        for (String s : boutonsLabel)
        {
            JButton jb = new JButton(s);
            jb.setPreferredSize(this.chiffreDimension);
            panneauBoutons.add(jb);
        }
        // Les opérations
        String[] operationsLabel = {"CE", "C", "+", "-", "x", "/"};
        panneauOperations.setLayout(new GridLayout(3, 2, 3, 3));
        for (String s : operationsLabel)
        {
            JButton jb = new JButton(s);
            jb.setPreferredSize(this.operateurDimension);
            panneauOperations.add(jb);
        }

        // Le contenu global
        content.setLayout(new BorderLayout(5, 5));
        content.add(panneauEcran, BorderLayout.NORTH);
        content.add(panneauBoutons, BorderLayout.CENTER);
        content.add(panneauOperations, BorderLayout.EAST);
        this.setContentPane(content);
    }

    public static void main(String[] args)
    {
        Calculate_bis cal = new Calculate_bis();
        System.out.println("J'aime les pâtes");
    }

}
