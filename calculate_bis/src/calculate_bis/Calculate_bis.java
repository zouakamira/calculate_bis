package calculate_bis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final JLabel labelaffich;


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
       //affiche
        labelaffich = new JLabel("0");
        // Comportement par défaut à la fermeture
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Titre
        this.setTitle("Calculette qui pète le feu de ouf");
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

        panneauEcran.add(labelaffich);

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
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calculer(e);
                }
            });
        }
        // Les opérations
        String[] operationsLabel = {"CE", "C", "+", "-", "x", "/"};
        panneauOperations.setLayout(new GridLayout(3, 2, 3, 3));
        for (String s : operationsLabel)
        {
            JButton jb = new JButton(s);
            jb.setPreferredSize(this.operateurDimension);
            panneauOperations.add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calculer(e);
                }
            });
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

    public void calculer(ActionEvent e)
    {
        //AFFICHAGE ds l'ecran
      labelaffich.setText(e.getActionCommand());


        String action = e.getActionCommand();
        labelaffich.setText(action);





        switch(action)
        {
            case "0":
                System.out.println(action + "ça marche");
                break;
            case "1":
                System.out.println(action + "ça marche");
                break;
            case "2":
                System.out.println(action + "ça marche");
                break;
            case "3":
                System.out.println(action + "ça marche");
                break;
        }





































        double valeurInitiale = 0.0;
        double valeurNouvelle = 0.0;
        String operande = "";
        double resultat = calcul(valeurInitiale, valeurNouvelle, operande);
    }

    public static double calcul(double valI, double valN, String op) {
        double var = 0.0;
        switch (op) {
            case "+":
                var = valI + valN;
            break;
            case "-":
                var = valI - valN;
            break;
            case "*":
                var = valI * valN;
            break;
            case "/":
                var = valI / valN;
            break;
            default: return 0.0;
        }
        return var;
    }

}
