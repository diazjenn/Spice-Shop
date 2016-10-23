package pricefinder;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

/**
 * Name: SpiceShopRegister.java
 * Written By: Jennifer Diaz 
 * Date: 2016/05/24
 */
public class SpiceShopRegister implements ActionListener {

    private JLabel jlab;
    private JPanel jpnl;
    private JPanel jpnl2;
    private final JButton jbtnAmount;
    private final JButton jbtnTotal;

    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private ArrayList<Double> quantity = new ArrayList<>();

//    private ArrayList<String> newSet = new ArrayList<>();
//    private ArrayList<Double> newPrices = new ArrayList<>();
//    private ArrayList<Double> newQ = new ArrayList<>();

    private double price;
    private final double tax = 0.0950;
    private double total;

    public SpiceShopRegister() {

        // Create a JFrame container
        JFrame jfrm = new JFrame("SpiceShop Register");

        // Give the frame an initial size
        jfrm.setSize(375, 150);

        // Terminate the program when the user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creat CardLayout and JPanels
        CardLayout grid = new CardLayout();
        jfrm.setLayout(new BorderLayout());
        jpnl = new JPanel(grid);
        jpnl2 = new JPanel();

        // Create label that will display the menu seletion
        jlab = new JLabel();
        jpnl2.add(jlab);

        // Create menu bar
        JMenuBar jmb = new JMenuBar();

        //Create the Ground Spices menu
        JMenu jmBlends = new JMenu("Spices and Rubs");
        // Use ALT with mnemonic Key
        jmBlends.setMnemonic(KeyEvent.VK_B);

        // Create Spices ImageIcons
        ImageIcon iconCard = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/ground_cardamom.jpg"));
        ImageIcon iconChinese = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/five-spice-powder.jpg"));
        ImageIcon iconCinn = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/vietnamese-cinnamon.jpg"));
        ImageIcon iconCori = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/ground_coriander.jpg"));
        ImageIcon iconCumin = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/groundcumin_2.jpg"));
        ImageIcon iconCurry = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/japanese_yellow_curry_powder.jpg"));
        ImageIcon iconGaram = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/garam_masala.jpg"));
        ImageIcon iconGinger = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/ginger-powder.jpg"));
        ImageIcon iconGarlic = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/granulated-garlic_1.jpg"));
        ImageIcon iconJamai = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/jamaican_jerk_seasoning.jpg"));
        ImageIcon iconMustard = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/japanese_yellow_curry_powder.jpg"));
        ImageIcon iconOnion = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/onion-powder.jpg"));
        ImageIcon iconTurmeric = new ImageIcon(SpiceShopRegister.class.getResource("images/Spices/turmeric (1).jpg"));

        // Create Ground Spices submenu       
        JMenuItem jmiCard = new JMenuItem("Cardamom Ground", iconCard);
        JMenuItem jmiChinese = new JMenuItem("Chinese Five Spice", iconChinese);
        JMenuItem jmiCinnamon = new JMenuItem("Cinnamon", iconCinn);
        JMenuItem jmiCoriander = new JMenuItem("Coriander", iconCori);
        JMenuItem jmiCumin = new JMenuItem("Cumin", iconCumin);
        JMenuItem jmiCurry = new JMenuItem("Curry Powder", iconCurry);
        JMenuItem jmiGaram = new JMenuItem("Garam Masala", iconGaram);
        JMenuItem jmiGinger = new JMenuItem("Ginger", iconGinger);
        JMenuItem jmiGarlic = new JMenuItem("Garlic Granulated", iconGarlic);
        JMenuItem jmiJamaican = new JMenuItem("Jamaican Jerk Seasoning", iconJamai);
        JMenuItem jmiMustard = new JMenuItem("Mustard Powder", iconMustard);
        JMenuItem jmiOnion = new JMenuItem("Onion Powder", iconOnion);
        JMenuItem jmiTurmeric = new JMenuItem("Turmeric Powder", iconTurmeric);

        jmBlends.add(jmiCard);
        jmBlends.add(jmiChinese);
        jmBlends.add(jmiCinnamon);
        jmBlends.add(jmiCoriander);
        jmBlends.add(jmiCumin);
        jmBlends.add(jmiCurry);
        jmBlends.add(jmiGaram);
        jmBlends.add(jmiGinger);
        jmBlends.add(jmiGarlic);
        jmBlends.add(jmiJamaican);
        jmBlends.add(jmiMustard);
        jmBlends.add(jmiOnion);
        jmBlends.add(jmiTurmeric);
        jmb.add(jmBlends);

        //Create the Salts menu
        JMenu jmSalts = new JMenu("Salts");
        // Use ALT with mnemonic Key
        jmSalts.setMnemonic(KeyEvent.VK_S);

        // Create Salts ImageIcons
        ImageIcon iconSmokeS = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/alderwood_smoked_sea_salt.jpg"));
        ImageIcon iconTruffleS = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/black_truffle_salt.jpg"));
        ImageIcon iconBlackS = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/hawaiian_black_sea_salt.jpg"));
        ImageIcon iconSeaS = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/greekseasalt_1.jpg"));
        ImageIcon iconFleur = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/fleurdesel_2.jpg"));
        ImageIcon iconPinkS = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/himalayan-salt.jpg"));
        ImageIcon iconVanillaS = new ImageIcon(SpiceShopRegister.class.getResource("images/Salts/vanilla_fleur_de_sel.jpg"));

        // Create Salts submenu       
        JMenuItem jmiSmoked = new JMenuItem("Smoked Sea Salt", iconSmokeS);
        JMenuItem jmiTruffle = new JMenuItem("Black Truffle Sea Salt", iconTruffleS);
        JMenuItem jmiBlack = new JMenuItem("Black Lava Flake Sea Salt", iconBlackS);
        JMenuItem jmiSeaSalt = new JMenuItem("Sea Salt", iconSeaS);
        JMenuItem jmiFleur = new JMenuItem("Fleur de Sel", iconFleur);
        JMenuItem jmiHima = new JMenuItem("Himalayan Pink Salt", iconPinkS);
        JMenuItem jmiVanillaSalt = new JMenuItem("Vanilla Bean Sea Salt", iconVanillaS);

        jmSalts.add(jmiSmoked);
        jmSalts.add(jmiTruffle);
        jmSalts.add(jmiBlack);
        jmSalts.add(jmiSeaSalt);
        jmSalts.add(jmiFleur);
        jmSalts.add(jmiHima);
        jmSalts.add(jmiVanillaSalt);
        jmb.add(jmSalts);

        //Create the Herbs menu
        JMenu jmHerbs = new JMenu("Herbs");
        // Use ALT with mnemonic Key
        jmHerbs.setMnemonic(KeyEvent.VK_H);

        // Create Herbs ImageIcons
        ImageIcon iconBasil = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/dried-basil_3.jpg"));
        ImageIcon iconBayL = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/bay-leaf_2.jpg"));
        ImageIcon iconProvence = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/herbs-de-provence_1.jpg"));
        ImageIcon iconHibis = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/hibiscus_2.jpg"));
        ImageIcon iconKaffir = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/kaffir_lime_leaves.jpg"));
        ImageIcon iconMarjoram = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/marjoram_2.jpg"));
        ImageIcon iconOrega = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/mediterranean_oregano.jpg"));
        ImageIcon iconParsley = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/parsley_flakes.jpg"));
        ImageIcon iconTarra = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/tarragon_2.jpg"));
        ImageIcon iconThyme = new ImageIcon(SpiceShopRegister.class.getResource("images/Herbs/thyme_2.jpg"));

        // Create Herbs submenu       
        JMenuItem jmiBasil = new JMenuItem("Dried Basil", iconBasil);
        JMenuItem jmiBayLeaves = new JMenuItem("Bay Leaves", iconBayL);
        JMenuItem jmiProvence = new JMenuItem("Herbs de Provence", iconProvence);
        JMenuItem jmiHibiscus = new JMenuItem("Hibiscus", iconHibis);
        JMenuItem jmiKaffir = new JMenuItem("Kaffir Lime Leaves", iconKaffir);
        JMenuItem jmiMarjoram = new JMenuItem("Dried Marjoram", iconMarjoram);
        JMenuItem jmiOregano = new JMenuItem("Dried Oregano", iconOrega);
        JMenuItem jmiParsley = new JMenuItem("Dried Parsley", iconParsley);
        JMenuItem jmiTarragon = new JMenuItem("Dried Tarragon", iconTarra);
        JMenuItem jmiThyme = new JMenuItem("Dried Thyme", iconThyme);

        jmHerbs.add(jmiBasil);
        jmHerbs.add(jmiBayLeaves);
        jmHerbs.add(jmiProvence);
        jmHerbs.add(jmiHibiscus);
        jmHerbs.add(jmiKaffir);
        jmHerbs.add(jmiMarjoram);
        jmHerbs.add(jmiOregano);
        jmHerbs.add(jmiParsley);
        jmHerbs.add(jmiTarragon);
        jmHerbs.add(jmiThyme);
        jmb.add(jmHerbs);

        //Create the Whole Spices menu
        JMenu jmWhole = new JMenu("Whole");
        // Use ALT with mnemonic Key
        jmWhole.setMnemonic(KeyEvent.VK_W);

        // Create Herbs ImageIcons
        ImageIcon iconGreenC = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/green-cardamon.jpg"));
        ImageIcon iconCinnS = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/cinnamon-sticks-4-inches.jpg"));
        ImageIcon iconClovesW = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/cloves.jpg"));
        ImageIcon iconCorai = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/extra-bold-coriander-seed_1_.jpg"));
        ImageIcon iconCuminS = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/cuminseed_2.jpg"));
        ImageIcon iconFennelS = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/fennel-seed.jpg"));
        ImageIcon iconMustardS = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/yellow-mustard-seed.jpg"));
        ImageIcon iconNutmegW = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/whole_nutmeg.jpg"));
        ImageIcon iconSaffron = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/spanish_saffron.jpg"));
        ImageIcon iconStarAnise = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/star_anise.jpg"));
        ImageIcon iconVanillaB = new ImageIcon(SpiceShopRegister.class.getResource("images/Whole/india.jpg"));

        // Create Whole Spices submenu       
        JMenuItem jmiGreenCard = new JMenuItem("Cardamom Pods Green", iconGreenC);
        JMenuItem jmiCinnSticks = new JMenuItem("Cinnamon Sticks", iconCinnS);
        JMenuItem jmiWholeCloves = new JMenuItem("Cloves Whole", iconClovesW);
        JMenuItem jmiCorainder = new JMenuItem("Coriander Seed", iconCorai);
        JMenuItem jmiCuminSeeds = new JMenuItem("Cumin Seed", iconCuminS);
        JMenuItem jmiFennel = new JMenuItem("Fennel Seed", iconFennelS);
        JMenuItem jmiMustardSeed = new JMenuItem("Mustard Seed Yellow", iconMustardS);
        JMenuItem jmiNutmeg = new JMenuItem("Nutmeg Whole", iconNutmegW);
        JMenuItem jmiSaffron = new JMenuItem("Spanish Saffron", iconSaffron);
        JMenuItem jmiStarAnise = new JMenuItem("Star Anise Whole", iconStarAnise);
        JMenuItem jmiVanillaBean = new JMenuItem("Vanilla Bean", iconVanillaB);

        jmWhole.add(jmiGreenCard);
        jmWhole.add(jmiCinnSticks);
        jmWhole.add(jmiWholeCloves);
        jmWhole.add(jmiCorainder);
        jmWhole.add(jmiCuminSeeds);
        jmWhole.add(jmiFennel);
        jmWhole.add(jmiMustardSeed);
        jmWhole.add(jmiNutmeg);
        jmWhole.add(jmiSaffron);
        jmWhole.add(jmiStarAnise);
        jmWhole.add(jmiVanillaBean);
        jmb.add(jmWhole);

        //Create the Chiles menu
        JMenu jmChiles = new JMenu("Chiles");
        // Use ALT with mnemonic Key
        jmBlends.setMnemonic(KeyEvent.VK_C);

        // Create Herbs ImageIcons
        ImageIcon iconAncho = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/ancho-chile-powder.jpg"));
        ImageIcon iconChili = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/hotchilepowder_2.jpg"));
        ImageIcon iconSweetC = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/chilepowder_2.jpg"));
        ImageIcon iconCayenne = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/ground-cayenne-pepper.jpg"));
        ImageIcon iconFlakes = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/crushedredpepper_3.jpg"));
        ImageIcon iconSweetP = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/sweet-hungarian-paprika.jpg"));
        ImageIcon iconSmokedP = new ImageIcon(SpiceShopRegister.class.getResource("images/Chiles/smoked-hot-paprika.jpg"));

        // Create Ground Spices submenu
        JMenuItem jmiAncho = new JMenuItem("Ancho Chile Powder", iconAncho);
        JMenuItem jmiChili = new JMenuItem("Hot Chile Powder", iconChili);
        JMenuItem jmiSweetC = new JMenuItem("Sweet Chile Powder", iconSweetC);
        JMenuItem jmiCayenne = new JMenuItem("Cayenne Red Pepper", iconCayenne);
        JMenuItem jmiFlakes = new JMenuItem("Crushed Red Pepper Flakes", iconFlakes);
        JMenuItem jmiSweetP = new JMenuItem("Sweet Paprika", iconSweetP);
        JMenuItem jmiSmokedP = new JMenuItem("Smoked Paprika", iconSmokedP);

        jmChiles.add(jmiAncho);
        jmChiles.add(jmiChili);
        jmChiles.add(jmiSweetC);
        jmChiles.add(jmiCayenne);
        jmChiles.add(jmiFlakes);
        jmChiles.add(jmiSweetP);
        jmChiles.add(jmiSmokedP);
        jmb.add(jmChiles);

        // Add action listeners for menu items
        jmiCard.addActionListener(this);
        jmiChinese.addActionListener(this);
        jmiCinnamon.addActionListener(this);
        jmiCoriander.addActionListener(this);
        jmiCumin.addActionListener(this);
        jmiCurry.addActionListener(this);
        jmiGaram.addActionListener(this);
        jmiGinger.addActionListener(this);
        jmiGarlic.addActionListener(this);
        jmiJamaican.addActionListener(this);
        jmiMustard.addActionListener(this);
        jmiOnion.addActionListener(this);
        jmiTurmeric.addActionListener(this);
        jmiSmoked.addActionListener(this);
        jmiTruffle.addActionListener(this);
        jmiBlack.addActionListener(this);
        jmiSeaSalt.addActionListener(this);
        jmiFleur.addActionListener(this);
        jmiHima.addActionListener(this);
        jmiVanillaSalt.addActionListener(this);
        jmiBasil.addActionListener(this);
        jmiBayLeaves.addActionListener(this);
        jmiProvence.addActionListener(this);
        jmiHibiscus.addActionListener(this);
        jmiKaffir.addActionListener(this);
        jmiMarjoram.addActionListener(this);
        jmiOregano.addActionListener(this);
        jmiParsley.addActionListener(this);
        jmiTarragon.addActionListener(this);
        jmiThyme.addActionListener(this);
        jmiGreenCard.addActionListener(this);
        jmiCinnSticks.addActionListener(this);
        jmiWholeCloves.addActionListener(this);
        jmiCorainder.addActionListener(this);
        jmiCuminSeeds.addActionListener(this);
        jmiFennel.addActionListener(this);
        jmiMustardSeed.addActionListener(this);
        jmiNutmeg.addActionListener(this);
        jmiSaffron.addActionListener(this);
        jmiStarAnise.addActionListener(this);
        jmiVanillaBean.addActionListener(this);
        jmiAncho.addActionListener(this);
        jmiChili.addActionListener(this);
        jmiSweetC.addActionListener(this);
        jmiCayenne.addActionListener(this);
        jmiFlakes.addActionListener(this);
        jmiSweetP.addActionListener(this);
        jmiSmokedP.addActionListener(this);

        // Add menu bar to frame
        jfrm.setJMenuBar(jmb);

        jbtnAmount = new JButton("Quantity");
        jbtnAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a dialog that inputs a string
                String response = JOptionPane.showInputDialog("Enter amount in ounces");

                // If the response is null, then the dialog
                // was cancelled or closed. If response is a
                // zero-length string, then no input was entered.
                // Otherweise, respnose contains a string entered by the user
                if (response == null) {
                    jlab.setText("Dialog cancelled or closed");
                } else if (response.length() == 0) {
                    jlab.setText("No string entered.");
                } else {
                    double value = Double.parseDouble(response);
                    quantity.add(value);
                    jlab.setText(response + " oz. added");
                }
            }
        });
        jbtnTotal = new JButton("Total");
        jbtnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printTotal();
            }
        });

        JPanel pnlButtons = new JPanel();
        pnlButtons.setSize(300, 200);
        GridLayout layout = new GridLayout(1, 2, 10, 10);

        pnlButtons.setLayout(layout);
        pnlButtons.add(jbtnAmount);
        pnlButtons.add(jbtnTotal);

        // Add the label to content pane
        jfrm.add(jpnl, BorderLayout.CENTER);
        jfrm.add(jpnl2);
        jfrm.add(pnlButtons, BorderLayout.SOUTH);

        // Display the frame
        jfrm.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the action command from menu selection
        String itemString = e.getActionCommand();
        if (itemString.equals("Cardamom Ground")) {
            setPrice(2.10);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Chinese Five Spice")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cinnamon")) {
            setPrice(1.50);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Coriander")) {
            setPrice(1.65);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cumin")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Curry Powder")) {
            setPrice(2.05);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Garam Masala")) {
            setPrice(2.05);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Ginger")) {
            setPrice(2.10);
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Garlic Granulated")) {
            setPrice(1.65);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Jamaican Jerk Seasoning")) {
            setPrice(1.55);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Mustard Powder")) {
            setPrice(1.10);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Onion Powder")) {
            setPrice(1.55);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Turmeric Powder")) {
            setPrice(1.45);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Smoked Sea Salt")) {
            setPrice(2.35);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Black Truffle Sea Salt")) {
            setPrice(4.25);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Black Lava Flake Sea Salt")) {
            setPrice(2.00);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Sea Salt")) {
            setPrice(1.60);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Fleur de Sel")) {
            setPrice(2.80);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Himalayan Pink Salt")) {
            setPrice(1.85);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Vanilla Bean Sea Salt")) {
            setPrice(3.15);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Dried Basil")) {
            setPrice(2.15);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Bay Leaves")) {
            setPrice(2.15);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Herbs de Provence")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Hibiscus")) {
            setPrice(1.65);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Kaffir Lime Leaves")) {
            setPrice(3.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Dried Marjoram")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Dried Oregano")) {
            setPrice(2.00);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Dried Parsley")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Dried Tarragon")) {
            setPrice(3.20);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Dried Thyme")) {
            setPrice(1.60);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cardamom Pods Green")) {
            setPrice(2.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cinnamon Sticks")) {
            setPrice(2.15);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cloves Whole")) {
            setPrice(2.50);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Coriander Seed")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cumin Seed")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Fennel Seed")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Mustard Seed Yellow")) {
            setPrice(1.65);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Nutmeg Whole")) {
            setPrice(2.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Spanish Saffron")) {
            setPrice(208.00);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Star Anise Whole")) {
            setPrice(2.15);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Vanilla Bean")) {
            setPrice(1.85);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Ancho Chile Powder")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Hot Chile Powder")) {
            setPrice(1.60);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Sweet Chile Powder")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Cayenne Red Pepper")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Crushed Red Pepper Flakes")) {
            setPrice(1.75);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else if (itemString.equals("Sweet Paprika")) {
            setPrice(1.40);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        } else {
            setPrice(1.50);
            prices.add(getPrice());
            jlab.setText(itemString + " selected @ $" + getPrice());
            items.add(itemString);
        }
    }

    public void printTotal() {
        GregorianCalendar date = new GregorianCalendar();

        DecimalFormat df = new DecimalFormat("###.00");
        double subTotal = 0;

//        checkDuplicates(items, quantity);

        System.out.println("**********************************************************");
        System.out.println("                       SPICE SHOP                         ");
        System.out.print("\t\t" + (date.get(Calendar.MONTH) + 1));
        System.out.print("/" + date.get(Calendar.DATE));
        System.out.print("/" + date.get(Calendar.YEAR) + "\t");
        System.out.print(date.get(Calendar.HOUR) + ":");
        System.out.print(date.get(Calendar.MINUTE) + ":");
        System.out.println(date.get(Calendar.SECOND));
        System.out.println("**********************************************************");

        String s = String.format("%-25s %10s %10s %10s", "ITEM", "PRICE", "QTY", "TOTAL");
        System.out.println(s);

        for (int i = 0; i < items.size(); i++) {
            total = itemTotal(quantity.get(i), prices.get(i));
            String s1 = String.format("%-25s %10s %10s", items.get(i), prices.get(i), quantity.get(i));
            System.out.print(s1);

            String s2 = String.format("%11s\n", df.format(total));
            System.out.print(s2);

            subTotal += total;
        }

        System.out.println("");
        String sSubTotal = String.format("%1$58s", "SUBTOTAL " + df.format(subTotal));
        String sTax = String.format("%1$58s", "T " + (tax * 100) + "% TAX " + df.format(subTotal * tax));
        String sTotal = String.format("%1$58s", "TOTAL " + df.format((subTotal * tax) + subTotal));
        System.out.println(sSubTotal);
        System.out.println(sTax);
        System.out.println(sTotal);
        System.out.println("\n\n\t     NO RETURNS/EXCHANGES ARE ACCEPTED.\n");
        System.out.println("**********************************************************\n\n");

        items.clear();
        prices.clear();
        quantity.clear();
        jlab.setText("");
    }

    public void addItem(String s) {
        items.add(s);
    }

    public void setPrice(double p) {
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public double itemTotal(double d, double p) {
        double itemTotal;

        itemTotal = d * p;
        return itemTotal;
    }

//    public void checkDuplicates(ArrayList<String> s, ArrayList<Double> q) {
//        for (String item : s) {
//            if(s.contains(item))
//        }
//
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SpiceShopRegister();
            }
        });
    }
}
