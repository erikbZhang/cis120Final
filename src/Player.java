import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
    private int x = 375;
    private int y = 540;
    private BufferedImage playerForward;
    private BufferedImage playerBackward;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage disguiseF;
    private BufferedImage disguiseB;
    private BufferedImage disguiseL;
    private boolean visible = true;
    private BufferedImage disguiseR;
    boolean form = false;
    int direction = 1;
    int width;
    int height;

    Color blue;
    Color black;
    public Player() {
        try {
            playerForward = ImageIO.read(new File("../files/forward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            playerBackward = ImageIO.read(new File("../files/backwards.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            playerLeft = ImageIO.read(new File("../files/left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            playerRight = ImageIO.read(new File("../files/right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            disguiseF = ImageIO.read(new File("../files/forwardm.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            disguiseB = ImageIO.read(new File("../files/backwardsm.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            disguiseL = ImageIO.read(new File("../files/leftm.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            disguiseR = ImageIO.read(new File("../files/rightm.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean a) {
        visible = a;
    }
    public void drawMe(Graphics g) {
        if (visible) {
            if (!form) {
                if (direction == 0) {
                    g.drawImage(playerForward, x, y, null);
                }
                if (direction == 1) {
                    g.drawImage(playerBackward, x, y, null);
                }
                if (direction == 2) {
                    g.drawImage(playerLeft, x, y, null);
                }
                if (direction == 3) {
                    g.drawImage(playerRight, x, y, null);
                }
            }
            if (form) {
                if (direction == 0) {
                    g.drawImage(disguiseF, x, y, null);
                }
                if (direction == 1) {
                    g.drawImage(disguiseB, x, y, null);
                }
                if (direction == 2) {
                    g.drawImage(disguiseL, x, y, null);
                }
                if (direction == 3) {
                    g.drawImage(disguiseR, x, y, null);
                }
            }
        }
    }

    public void moveLeft() {
        if (x >= 0) {
            x -= 5;
        }
    }

    public void setX(int xGiven) {
        x = xGiven;
    }

    public void setY(int yGiven) {
        y = yGiven;
    }
    public void moveRight() {
        if (x <= 790) {
            x += 5;
        }
    }
    public void moveUp() {
        if (y >= 0) {
            y -= 5;
        }
    }
    public void moveDown() {
        if (y <= 585) {
            y += 5;
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void reset() {
        x = 375;
        y = 540;
    }
    public void setImage(boolean form, int direction) {
        this.form = form;
        this.direction = direction;

    }
}
