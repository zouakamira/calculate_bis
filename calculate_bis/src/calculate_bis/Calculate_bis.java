package calculate_bis;

/**
*Crée en travail groupé via GitHub et répartit par :
 *  Amira,
 *  Jacques,
 *  Pascal,
 *  Christophe
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Calculate_bis extends JFrame {
    private final JPanel content;
    private final JPanel panneauEcran;
    private final JPanel panneauBoutons;
    private final JPanel panneauOperations;
    private final Dimension chiffreDimension;
    private final Dimension operateurDimension;
    private final JLabel labelaffich;
    private ArrayList liste = new ArrayList();

    public String nombre = "";
    public String memoire = "";
    public double val2 = 0;
    public double val1 = 0;


    public Calculate_bis() {
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
        this.setTitle("Calculette");
        // Mise en place du contenu
        this.initComponents();
        this.pack();
        // Affichage
        this.setVisible(true);
        this.setMinimumSize(this.getSize());
    }

    private void initComponents() {
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
        for (String s : boutonsLabel) {
            JButton jb = new JButton(s);
            // coleur aleatoire

            //jb.setBackground(colorChange());//change button color
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
        for (String s : operationsLabel) {
            JButton jb = new JButton(s);
            //jb.setBackground(colorChange());
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

    public static void main(String[] args) {
        Calculate_bis cal = new Calculate_bis();
    }

    public void calculer(ActionEvent e) {
        //AFFICHAGE ds l'ecran


        String action = e.getActionCommand();


        switch (action) {
            //Nombres
            case "0":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "1":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "2":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "3":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "4":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "5":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "6":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "7":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "8":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            case "9":
                nombre = nombre + e.getActionCommand();
                labelaffich.setText(nombre);
                break;
            //Opérations
            case ".":
                if (!nombre.contains(".")) {
                    nombre = nombre + e.getActionCommand();
                    labelaffich.setText(nombre);
                }
                break;
            case "=":
                if (memoire == "") {
                    memoire = action;
                    val2 = Double.parseDouble(nombre);
                    nombre = "";
                } else {
                    val1 = Double.parseDouble(nombre);
                    nombre = "";
                    val2 = calcul(val1, val2, memoire);
                    afficher(val2);
                    System.out.println(val2);
                    val1 = 0.0;
                    val2 = 0.0;
                    memoire = "";
                }


                break;
            case "CE":
                String text = labelaffich.getText();
                String tex = text.substring(0, text.length()-1);
                System.out.println(tex);
                labelaffich.setText(tex);
                val2 = Double.parseDouble(tex);
                val2 = Double.parseDouble(tex);
                nombre = tex;
                memoire = "";
                break;
            case "C":
                val1 = 0;
                val2 = 0;
                nombre = "0";
                labelaffich.setText(nombre);
                break;
            case "+":

                if (memoire == "") {
                    memoire = action;
                    if (nombre != "") {
                        val2 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    //labelaffich.setText(nombre+memoire);
                    nombre = "";
                } else {
                    if (nombre != "") {
                        val1 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    nombre = "";

                    val2 = calcul(val1, val2, memoire);
                    System.out.println(val2);
                    memoire = action;


                }


                break;
            case "-":
                if (memoire == "") {
                    memoire = action;
                    if (nombre != "") {
                        val2 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    //labelaffich.setText(nombre+memoire);
                    nombre = "";
                } else {
                    if (nombre != "") {
                        val1 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    nombre = "";
                    val2 = calcul(val1, val2, memoire);
                    System.out.println(val2);
                    memoire = action;
                }
                break;
            case "x":
                if (memoire == "") {
                    memoire = action;
                    if (nombre != "") {
                        val2 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    //labelaffich.setText(nombre+memoire);
                    nombre = "";
                } else {
                    if (val2 == 0) {
                        val2 = 1;
                    }
                    if (nombre != "") {
                        val1 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    nombre = "";
                    val2 = calcul(val1, val2, memoire);
                    System.out.println(val2);
                    memoire = action;
                }
                break;
            case "/":
                if (memoire == "") {
                    memoire = action;
                    if (nombre != "") {
                        val2 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    //labelaffich.setText(nombre+memoire);
                    nombre = "";
                } else {
                    if (val2 == 0) {
                        val2 = 1;
                    }
                    if (nombre != "") {
                        val1 = Double.parseDouble(nombre);
                    } else {
                        System.out.println("WOOPS!");
                    }
                    nombre = "";
                    val2 = calcul(val1, val2, memoire);
                    System.out.println(val2);
                    memoire = action;
                }
                break;
        }


    }

    public double calcul(double valI, double valN, String op) {
        double var = 0.0;
        switch (op) {
            case "+":
                var = valI + valN;
                break;
            case "-":
                var = -(valI - valN);
                break;
            case "x":
                var = valI * valN;
                break;
            case "/":
                try {
                    var = valN / valI;
                } catch (ArithmeticException e) {
                    this.labelaffich.setText("ERROR");
                }
                break;
        }
        return var;
    }

    public void afficher(double resultat) {
        this.labelaffich.setText(String.valueOf(resultat));
    }

    //methode pour changer couleur
    public Color colorChange() {
        Random rand = new Random();

        int redValue = generateRandom(0, 255, liste);
        liste.add(redValue);
        int greenValue = generateRandom(0, 255, liste);
        liste.add(greenValue);
        int blueValue = generateRandom(0, 255, liste);
        liste.add(blueValue);
        Color clr = new Color(redValue, greenValue, blueValue);
        return clr;
    }

    public int generateRandom(int start, int end, ArrayList<Integer> excludeRows) {
        Random rand = new Random();
        int range = end - start + 1;

        int random = rand.nextInt(range) + 1;
        while (excludeRows.contains(random)) {
            random = rand.nextInt(range) + 1;
        }

        return random;
    }
}
