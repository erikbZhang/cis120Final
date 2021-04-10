import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Screen extends JPanel implements ActionListener, KeyListener {
    private Leader f1;
    private Key i1;
    private Costume i2;
    private Book i3;
    private Map i4;
    private Secrets i5;
    private Character f2;
    private Character f3;
    private Knife i6;
    private JButton playButton;
    private JButton loadButton;
    private JButton saveButton;
    private JTextPane titleInstructions;
    private JTextPane titlePane;
    private String instructions;
    private String title;
    private String name;

    private Font myFont;
    private Font myFont2;

    private boolean showTitle;
    private boolean startTimer;
    private boolean ranOnce;
    private boolean quest1;
    private boolean alreadyAdded;
    private boolean quest2;
    private boolean quest3;
    private boolean specialDialogue;
    private boolean addedd;
    private boolean frozen3;
    private boolean onePlay;
    private boolean noSave;

    private boolean inventory;
    private boolean added;
    private int doublePress = 0;

    private ArrayList<Character> characters;
    private ArrayList<Character> dummies;
    private ArrayList<Item> groundItems;
    private ArrayList<Item> inventoryItems;
    private BufferedImage coverImage;
    private BufferedImage stage3;
    private BufferedImage playerMI;
    private BufferedImage quest1Image;
    private BufferedImage dialogue;
    private BufferedImage stage1;
    private BufferedImage playerI;
    private BufferedImage water;
    private BufferedImage private2;
    private BufferedImage stage2;
    private BufferedImage door;
    private BufferedImage winScreen;

    private int dialogueCounter = 0;
    private Player player;
    private boolean isDialogue = false;
    private boolean freeze = false;
    private boolean won = false;
    private boolean freezePlayer;
    private int ccounter = 0;
    private int counter = 0;
    private boolean freeeze = false;
    private int cccounter = 0;
    private boolean form = false;
    private boolean activeDoor = false;
    private String temp;


    private Stopwatch stopwatch;

    private Item[][] inventoryGrid;
    public Screen() {
        characters = new ArrayList<Character>();
        dummies = new ArrayList<Character>();
        groundItems = new ArrayList<Item>();
        inventoryItems = new ArrayList<Item>();
        setLayout(null);
        addKeyListener(this);
        showTitle = true;
        stopwatch = new Stopwatch();

        inventoryGrid = new Item[3][2];
        f1 = new Leader(400, 400, "Rebel Leader");
        f3 = new Boss(400, 100, "Boss");
        f2 = new Bouncer(375, 100, "Bouncer");
        i1 = new Key(400, 200, "Key");
        i2 = new Costume(250, 400, "Costume");
        i3 = new Book(600, 60, "book");
        i4 = new Map(50, 400, "Map");
        i5 = new Secrets(780, 560, "Secrets");
        i6 = new Knife(400, 400, "Knife");
        characters.add(f1);
        characters.add(f2);
        dummies.add(new Bouncer(100, 200, "Random"));
        dummies.add(new Bouncer(300, 30, "Random"));
        groundItems.add(i1);
        groundItems.add(i2);
        groundItems.add(i3);
        myFont = new Font("Impact", 100, 40);
        myFont2 = new Font("Impact", 50, 20);

        playButton = new JButton("Play");
        playButton.setBounds(330, 500, 100, 30);
        playButton.addActionListener(this);
        this.add(playButton);
        playButton.setVisible(true);

        loadButton = new JButton("Load");
        loadButton.setBounds(330, 400, 100, 30);
        loadButton.addActionListener(this);
        this.add(loadButton);
        loadButton.setVisible(true);

        saveButton = new JButton("Save and Quit");
        saveButton.setBounds(600, 20, 150, 30);
        saveButton.addActionListener(this);
        this.add(saveButton);
        saveButton.setVisible(false);

        titleInstructions = new JTextPane();
        titleInstructions.setBounds(175, 200, 450, 200);
        titleInstructions.setFont(myFont2);
        this.add(titleInstructions);
        instructions = "Welcome to Spy, a discovery-based RPG! \n" +
                "Rules:" + "\n" + "WASD to walk" + "\n" + "I to open inventory" + "\n"
                + "P to skip levels";
        titleInstructions.setText(instructions);
        titleInstructions.setVisible(true);

        titlePane = new JTextPane();
        titlePane.setBounds(175, 50, 450, 50);
        titlePane.setFont(myFont);
        this.add(titlePane);
        title = "                  Spy";
        titlePane.setText(title);
        titlePane.setVisible(true);

        player = new Player();
        addKeyListener(this);
        setFocusable(true);
        try {
            dialogue = ImageIO.read(new File("../files/dialogue.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            private2 = ImageIO.read(new File("../files/private.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            stage1 = ImageIO.read(new File("../files/stage1.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            playerI = ImageIO.read(new File("../files/backwardsLarge.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            winScreen = ImageIO.read(new File("../files/youWin.jpg"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            playerMI = ImageIO.read(new File("../files/backwardsmLarge.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            water = ImageIO.read(new File("../files/water.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            stage2 = ImageIO.read(new File("../files/stage2.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            door = ImageIO.read(new File("../files/doors.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }
        try {
            stage3 = ImageIO.read(new File("../files/finalStage.png"));
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "diaogue");
        }

    }

    public void titleBackground() {
        try {
            coverImage = ImageIO.read(new File("../files/images.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage() + "title");
        }

    }

    public ArrayList<Integer> getInventory() {
        ArrayList<Integer> inv = new ArrayList<Integer>();
        if (inventoryItems != null) {
            for (int i = 0; i < inventoryItems.size(); i++) {
                if (inventoryItems.get(i) == i1) {
                    inv.add(1);
                } else if (inventoryItems.get(i) == i2) {
                    inv.add(2);
                } else if (inventoryItems.get(i) == i3) {
                    inv.add(3);
                } else if (inventoryItems.get(i) == i4) {
                    inv.add(4);
                } else if (inventoryItems.get(i) == i5) {
                    inv.add(5);
                } else if (inventoryItems.get(i) == i6) {
                    inv.add(6);
                }
            }
            return inv;
        }
        return null;
    }

    public void setPlayerX(int x) {
        player.setX(x);
    }

    public void setPlayerY(int y) {
        player.setY(y);
    }

    public void playSound(int a) {
        if (a == 0 && !onePlay && isDialogue) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(
                        new File("../files/conversation.wav").toURI().toURL()));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
            onePlay = true;
        }
        if (a == 1) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(
                        new File("../files/pickUp.wav").toURI().toURL()));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
        if (a == 2) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(
                        new File("../files/questWin.wav").toURI().toURL()));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 594);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Color white = new Color(100, 100, 100);
        Color black = new Color(0, 0, 0);
        if (won) {
            quest3 = false;
            g.setColor(black);
            g.fillRect(0, 0, 800, 600);
            for (int xy = 0; xy < characters.size(); xy++) {
                characters.get(xy).setVisible(false);
                characters.remove(xy);
            }
            for (int zz = 0; zz < groundItems.size(); zz++) {
                groundItems.remove(zz);
            }
            player.setVisible(false);
            g.drawImage(winScreen, 120, 100, this);
        }
        if (showTitle) {
            titleBackground();
            g.drawImage(coverImage, 0, 0, this);
        }

        if (!inventory) {
            if (quest3) {

                for (int z = 0; z < groundItems.size(); z++) {
                    if (groundItems.get(z) == i4) {
                        groundItems.remove(z);
                    }
                }
                if (!alreadyAdded) {
                    playSound(2);
                    characters.add(f3);
                    alreadyAdded = true;
                }
                dummies.get(0).setVisible(false);
                dummies.get(1).setVisible(false);
                for (int ii = 0; ii < 25; ii++) {
                    for (int cc = 0; cc < 18; cc++) {
                        g.drawImage(stage3, ii * 142, cc * 131, this);
                    }
                }
                g.setFont(myFont);
                g.setColor(Color.WHITE);
                g.drawString("Quest 3", 0, 40);
                characters.get(0).setVisible(true);
                characters.get(0).drawMe(g);
                if (specialDialogue) {
                    g.drawImage(dialogue, 0, 500, this);
                    freezePlayer = true;
                    g.setFont(new Font("Impact", Font.PLAIN, 25));
                    g.drawString("Monster Leader", 50, 530);
                    g.setFont(new Font("Impact", Font.PLAIN, 15));
                    g.drawString("...what's in my stomach? I don't feel so good.", 50, 555);
                    for (int time = 0; time < 100000; time++) {
                        if (time == 100000) {
                            specialDialogue = false;
                            won = true;
                            playSound(2);
                        }
                    }
                }
                if (freeeze && cccounter == 0) {
                    g.setColor(Color.BLACK);
                    g.drawImage(dialogue, 0, 500, this);
                    g.setFont(new Font("Impact", Font.PLAIN, 25));
                    g.drawString("Monster Leader", 50, 530);
                    g.setFont(new Font("Impact", Font.PLAIN, 15));
                    g.drawString("Dude I need my Key to hit the nuke... help me out!"
                            + " (I should probably stop him... Find a weapon?)", 50, 555);

                }
                if (!frozen3) {
                    freeeze = true;
                    frozen3 = true;
                }
                if (!groundItems.isEmpty() && groundItems != null) {
                    for (int x = 0; x < groundItems.size(); x++) {
                        groundItems.get(x).setVisible(true);
                        if (groundItems.get(x) == i1) {
                            groundItems.get(x).drawMe(50, 400, g);
                        }
                        if (groundItems.get(x) == i6) {
                            groundItems.get(x).drawMe(400, 400, g);
                        }
                    }
                }
            }
        }

        if (!inventory) {
            if (quest2) {

                quest1 = false;
                for (int ii = 0; ii < 25; ii++) {
                    for (int cc = 0; cc < 18; cc++) {
                        g.drawImage(stage2, ii * 32, cc * 33, this);
                    }
                }
                dummies.get(0).setVisible(true);
                dummies.get(0).drawMe(g);
                dummies.get(1).setVisible(true);
                dummies.get(1).drawMe(g);
                g.drawImage(door, 600, 35, this);
                //characters.get(0).setVisible(false);
                //characters.get(1).setVisible(false);
                if (characters.size() >= 1) {
                    characters.remove(0);
                }
                if (characters.size() >= 2) {
                    characters.remove(1);
                }
                g.setFont(myFont);
                g.setColor(Color.WHITE);
                g.drawString("Quest 2", 0, 40);
                if (freeze && ccounter == 0) {

                    g.setColor(Color.BLACK);
                    g.drawImage(dialogue, 0, 500, this);
                    g.setFont(new Font("Impact", Font.PLAIN, 25));
                    g.drawString("Rebel Leader", 50, 530);
                    g.setFont(new Font("Impact", Font.PLAIN, 15));
                    g.drawString("Find anything you can, and get it to us asap!"
                            + " We need you...", 50, 555);

                }
                if (!ranOnce) {
                    freeze = true;
                    ranOnce = true;
                }
                for (int x = 0; x < groundItems.size(); x++) {
                    if (groundItems.get(x) != i1) {
                        groundItems.get(x).setVisible(true);
                        if (groundItems.get(x) == i4) {
                            groundItems.get(x).drawMe(50, 400, g);
                        }
                        if (groundItems.get(x) == i5) {
                            groundItems.get(x).drawMe(780, 560, g);
                        }
                    }
                }
                for (int j = 0; j < inventoryItems.size(); j++) {
                    if (inventoryItems.get(j) == i4 || inventoryItems.get(j) == i5) {
                        if (j != inventoryItems.size() - 1 && (inventoryItems.get(j - 1) == i4
                                || inventoryItems.get(j + 1) == i5)) {
                            g.setColor(Color.BLACK);
                            g.drawImage(dialogue, 0, 500, this);
                            g.setFont(new Font("Impact", Font.PLAIN, 25));
                            g.drawString("Rebel Leader", 50, 530);
                            g.setFont(new Font("Impact", Font.PLAIN, 15));
                            g.drawString("Get to a private place now...", 50, 555);
                            activeDoor = true;
                        }
                    }
                }
            }
            if (quest1) {
                for (int i = 0; i < 25; i++) {
                    for (int c = 0; c < 18; c++) {
                        if ((i >= 0 && i <= 3) || (i >= 15)) {
                            g.drawImage(water, i * 32, c * 33, this);
                        } else {
                            g.drawImage(stage1, i * 32, c * 33, this);
                        }
                    }
                }
                g.setFont(myFont);
                g.setColor(Color.BLACK);
                g.drawString("Quest 1", 0, 40);
                g.drawImage(quest1Image, 0, 0, this);
                characters.get(0).setVisible(true);
                characters.get(0).drawMe(g);
                characters.get(1).setVisible(true);
                characters.get(1).drawMe(g);
                for (int x = 0; x < groundItems.size(); x++) {
                    if (groundItems.get(x) != i1) {
                        groundItems.get(x).setVisible(true);
                        if (groundItems.get(x) == i2) {
                            groundItems.get(x).drawMe(200, 300, g);
                        }
                        if (groundItems.get(x) == i3) {
                            groundItems.get(x).drawMe(600, 60, g);
                        }
                    }
                }
            }
        }
        if (!inventory) {
            player.drawMe(g);
        }
        if (!inventory) {
            if (isDialogue) {
                playSound(0);
                startTimer = true;
                g.setColor(Color.BLACK);
                g.drawImage(dialogue, 0, 500, this);
                g.setFont(new Font("Impact", Font.PLAIN, 25));
                g.drawString(name, 50, 530);
                g.setFont(new Font("Impact", Font.PLAIN, 15));
                g.drawString(temp, 50, 555);
            }
        }
        if (noSave) {
            g.setColor(Color.WHITE);
            g.fillRect(300,420, 180, 40);
            g.setFont(new Font("Impact", Font.PLAIN, 25));
            g.setColor(Color.BLACK);
            g.drawString("No Save!", 338, 450);

        }
        if (!showTitle) {
            if (inventory) {
                g.setColor(black);
                g.fillRect(0, 0, 800, 600);
                g.setColor(white);
                for (int r = 0; r < 3; r++) {
                    for (int cc = 0; cc < 2; cc++) {
                        g.fillRect(450 + cc * 150, 50 + r * 120, 100, 100);
                    }
                }
                for (int rr = 0; rr < inventoryItems.size(); rr++) {
                    if (inventoryItems.get(rr) == i2) {
                        inventoryGrid[0][0] = i2;
                    }
                    if (inventoryItems.get(rr) == i3) {
                        inventoryGrid[0][1] = i3;
                    }
                    if (inventoryItems.get(rr) == i4) {
                        inventoryGrid[1][0] = i4;
                    }
                    if (inventoryItems.get(rr) == i5) {
                        inventoryGrid[1][1] = i5;
                    }
                    if (inventoryItems.get(rr) == i6) {
                        inventoryGrid[2][0] = i6;
                    }
                    if (inventoryItems.get(rr) == i1) {
                        inventoryGrid[2][1] = i1;
                    }
                }
                for (int j = 0; j < inventoryGrid.length; j++) {
                    for (int k = 0; k < inventoryGrid[0].length; k++) {
                        System.out.println("inventory grid" +  inventoryGrid[j][k]);
                        if (inventoryGrid[j][k] != null) {
                            inventoryGrid[j][k].drawMe(335 + 150 * (k + 1), -20 + 120 * (j + 1), g);
                        }
                    }
                }
                if (!form) {
                    g.drawImage(playerI, 50, 50, null);
                } else {
                    g.drawImage(playerMI, 50, 50, null);
                }
                g.setFont(myFont);
                g.setColor(Color.WHITE);
                g.drawString("Inventory", 50, 550);

            }
            if (quest3 || quest2 || quest1) {
                showTitle = false;
                playButton.setVisible(false);
                titleInstructions.setVisible(false);
                titlePane.setVisible(false);
                saveButton.setVisible(true);
                loadButton.setVisible(false);
                noSave = false;
                repaint();
                g.drawString("Time elapsed:" + stopwatch.getElapsedTimeSeconds(), 0, 80);

            }
        }


    }


    public void animate() {

        while (true) {

            //System.out.println(groundItems);
            System.out.println("inventory " + inventoryItems);
            if (freeze) {
                onePlay = false;
                freezePlayer = true;
                playSound(0);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                freezePlayer = false;
                ccounter++;
                freeze = false;
            }
            if (freeeze) {
                onePlay = false;
                freezePlayer = true;
                playSound(0);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                freezePlayer = false;
                cccounter++;
                freeeze = false;
            }
            if (!quest2) {
                for (int i = 0; i < characters.size(); i++) {
                    if (characters.get(i).getVisible()) {
                        if (characters.get(i).getY() >= player.getY() - 50 &&
                                characters.get(i).getY() <= player.getY() + 50) {
                            if (characters.get(i).getX() >= player.getX() - 50 &&
                                    characters.get(i).getX() <= player.getX() + 50) {
                                isDialogue = true;
                                temp = characters.get(i).dialogue();
                                name = characters.get(i).getName();
                                if (characters.get(i) == f3) {
                                    for (int g = 0; g < inventoryItems.size(); g++) {
                                        if (inventoryItems.get(g) == i6) {
                                            if (inventoryItems.get(g - 1) == i1) {
                                                isDialogue = false;
                                                specialDialogue = true;
                                                try {
                                                    Thread.sleep(2500);
                                                } catch (InterruptedException ex) {
                                                    Thread.currentThread().interrupt();
                                                }
                                                specialDialogue = false;
                                                won = true;

                                            } else if (g != inventoryItems.size() - 1) {
                                                isDialogue = false;
                                                specialDialogue = true;
                                                try {
                                                    Thread.sleep(2500);
                                                } catch (InterruptedException ex) {
                                                    Thread.currentThread().interrupt();
                                                }
                                                specialDialogue = false;
                                                won = true;
                                            }
                                        }
                                    }

                                }
                                if (quest1) {
                                    if (characters.get(1).getTalkable()) {
                                        for (int iii = 0; iii < inventoryItems.size(); iii++) {
                                            if (inventoryItems.get(iii) == i2) {
                                                try {
                                                    Thread.sleep(600);
                                                } catch (InterruptedException ex) {
                                                    Thread.currentThread().interrupt();
                                                }
                                                isDialogue = false;
                                                quest1 = false;
                                                quest2 = true;
                                                if (!added) {
                                                    playSound(2);
                                                    groundItems.add(i4);
                                                    groundItems.add(i5);
                                                    added = true;
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }


            for (int x = 0; x < groundItems.size(); x++) {
                if (groundItems.get(x).getVisible()) {
                    if (groundItems.get(x).getY() >= player.getY() - 50
                            && groundItems.get(x).getY() <= player.getY() + 50) {
                        if (groundItems.get(x).getX() >= player.getX() - 50
                                && groundItems.get(x).getX() <= player.getX() + 50) {
                            inventoryItems.add(groundItems.get(x));
                            if (groundItems.get(x) == i2) {
                                form = true;
                            }
                            if (groundItems.get(x) == i3) {
                                characters.get(1).changeTalkable(true);
                            }
                            groundItems.remove(x);
                            playSound(1);

                        }
                    }
                }
            }
            dialogueCounter++;

            if (dialogueCounter > 200) {
                isDialogue = false;
                dialogueCounter = 0;
            }
            if (activeDoor) {
                if (player.getX() >= 550 && player.getX() <= 650) {
                    if (player.getY() >= 0 && player.getY() <= 100) {
                        quest2 = false;
                        quest3 = true;
                        if (!addedd) {
                            characters.add(f3);
                            groundItems.remove(0);
                            groundItems.add(i1);
                            groundItems.add(i6);


                            addedd = true;
                        }
                    }
                }
            }
            if (startTimer) {
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                onePlay = false;
                isDialogue = false;
                startTimer = false;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            repaint();

        }
    }

    public void saveAction() {
        try {
            FileWriter fw = new FileWriter("save.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String quest = "";
            String ground = "";
            String inventory = "";
            for (int i = 0; i < groundItems.size(); i++) {
                ground += groundItems.get(i).toString();
                if (i != groundItems.size() - 1) {
                    ground += "/ ";
                }
            }
            for (int i = 0; i < inventoryItems.size(); i++) {
                inventory += inventoryItems.get(i).toString();
                if (i != inventoryItems.size() - 1) {
                    inventory += "/";
                }
            }
            if (quest1) {
                quest = "1";
            } else if (quest2) {
                quest = "2";
            } else if (quest3) {
                quest = "3";
            } else {
                quest = "no save";
            }
            bw.write(quest);
            bw.newLine();
            bw.write(player.getX() + "/" + player.getY());
            bw.newLine();
            bw.write(ground);
            bw.newLine();
            bw.write(inventory);
            bw.newLine();
            bw.write(Integer.toString(stopwatch.getElapsedTimeSeconds()));
            bw.close();
            fw.close();
            System.exit(0);
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadAction() {
        try {
            FileReader fr = new FileReader("save.txt");
            Boolean shouldBreak = false;
            BufferedReader bw = new BufferedReader(fr);
            String quest = bw.readLine();
            if (quest == null) {
                noSave = true;
                shouldBreak = true;
            } else if (quest.equals("1")) {
                added = false;
                quest1 = true;
            } else if (quest.equals("2")) {
                quest2 = true;
            } else if (quest.equals("3")) {
                quest3 = true;
            } else {
                noSave = true;
                shouldBreak = true;
            }
            if (!shouldBreak) {
                String position = bw.readLine();
                String[] positions = position.split("/");
                if (positions != null) {
                    player.setX(Integer.parseInt(positions[0]));
                    player.setY(Integer.parseInt(positions[1]));
                }
                String ground = bw.readLine();
                if (ground != null) {
                    String[] grounds = ground.split("/");
                    for (int i = 0; i < grounds.length; i++) {
                        grounds[i] = grounds[i].trim();
                        if (grounds[i].equals("Knife")) {
                            groundItems.add(i6);
                            i6.setVisible(true);
                        }
                        if (grounds[i].equals("Key") && !groundItems.contains(i1)) {
                            groundItems.add(i1);
                            i1.setVisible(true);
                        }
                        if (grounds[i].equals("book")) {
                            groundItems.add(i3);
                            i3.setVisible(true);
                        }
                        if (grounds[i].equals("Map")) {
                            groundItems.add(i4);
                            i4.setVisible(true);
                        }
                        if (grounds[i].equals("Secrets")) {
                            groundItems.add(i5);
                            i5.setVisible(true);
                        }
                        if (grounds[i].equals("Costume")) {
                            groundItems.add(i2);
                            i2.setVisible(true);
                        }
                    }
                }
                String inventory = bw.readLine();
                if (inventory != null) {
                    String[] inventories = inventory.split("/");
                    for (int i = 0; i < inventories.length; i++) {
                        inventories[i] = inventories[i].trim();
                        if (inventories[i].equals("Knife")) {
                            if (groundItems.contains(i6)) {
                                groundItems.remove(i6);
                            }
                            inventoryItems.add(i6);
                        }
                        if (inventories[i].equals("Key")) {
                            if (groundItems.contains(i1)) {
                                groundItems.remove(i1);
                            }
                            inventoryItems.add(i1);
                        }
                        if (inventories[i].equals("book")) {
                            if (groundItems.contains(i3)) {
                                groundItems.remove(i3);
                            }
                            inventoryItems.add(i3);
                        }
                        if (inventories[i].equals("Map")) {
                            if (groundItems.contains(i4)) {
                                groundItems.remove(i4);
                            }
                            inventoryItems.add(i4);
                        }
                        if (inventories[i].equals("Secrets")) {
                            if (groundItems.contains(i5)) {
                                groundItems.remove(i5);
                            }
                            inventoryItems.add(i5);
                        }
                        if (inventories[i].equals("Costume")) {
                            form = true;
                            if (groundItems.contains(i2)) {
                                groundItems.remove(i2);
                            }
                            inventoryItems.add(i2);
                        }
                    }
                    stopwatch.start();
                    String time = bw.readLine();
                    if (time != null) {
                        stopwatch.startAtTime(Integer.parseInt(time));
                    }

                    bw.close();
                    fr.close();
                }
            }
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            showTitle = false;
            stopwatch.start();
            playButton.setVisible(false);
            titleInstructions.setVisible(false);
            titlePane.setVisible(false);
            saveButton.setVisible(true);
            loadButton.setVisible(false);
            noSave = false;
            quest1 = true;
            repaint();
        }
        if (e.getSource() == saveButton) {
            Thread saving = new Thread(new Runnable() {
                public void run() {
                    saveAction();
                }
            });
            saving.start();
            repaint();
        }
        if (e.getSource() == loadButton) {
            showTitle = false;
            playButton.setVisible(false);
            titleInstructions.setVisible(false);
            titlePane.setVisible(false);
            saveButton.setVisible(true);
            loadButton.setVisible(false);
            stopwatch.start();
            loadAction();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!freezePlayer) {
            if (e.getKeyCode() == 83) {
                player.moveDown();
                player.setImage(form, 1);
                repaint();
            }
            if (e.getKeyCode() == 87) {
                player.moveUp();
                player.setImage(form, 0);
                repaint();
            }
            if (e.getKeyCode() == 68) {
                player.moveRight();
                player.setImage(form, 3);
                repaint();
            }
            if (e.getKeyCode() == 65) {
                player.moveLeft();
                player.setImage(form, 2);
                repaint();
            }
        }
        if (e.getKeyCode() == 80) {
            doublePress++;
            if (doublePress % 2 == 0) {
                if (quest3) {
                    won = true;
                }
                if (quest2) {
                    quest3 = true;
                    quest2 = false;
                    characters.add(f3);
                    for (int i = 0; i < groundItems.size(); i++) {
                        groundItems.remove(i);
                    }
                    inventoryItems.add(i4);
                    inventoryItems.add(i5);
                    form = true;
                    groundItems.add(i1);
                    groundItems.add(i6);
                    alreadyAdded = true;
                }
                if (quest1) {
                    quest2 = true;
                    form = true;
                    quest1 = false;
                    for (int i = 0; i < groundItems.size(); i++) {
                        groundItems.remove(i);
                    }
                    inventoryItems.add(i2);
                    inventoryItems.add(i3);
                    if (!added) {
                        groundItems.add(i4);
                        groundItems.add(i5);
                        added = true;
                    }

                }
            }
        }


        repaint();

    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (!freezePlayer) {
            if (e.getKeyCode() == 73) {
                counter++;
                if (counter % 2 == 0) {
                    if (inventory) {
                        inventory = false;
                    } else {
                        inventory = true;
                    }
                }
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }




}
