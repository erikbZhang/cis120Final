import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Boss extends Character {
    int width;
    int height;
    double movementX = 0;
    boolean pace = false;

    private BufferedImage bossImage;

    public Boss(int x, int y, String name) {
        super(x,y,name);
    }
    public void drawBoss() {
        try {
            bossImage = ImageIO.read(new File("../files/boss.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public boolean getTalkable() {
        return true;
    }

    @Override
    public int getX() {
        return (super.getX() + (int)movementX - 50);
    }

    @Override
    public void drawMe(Graphics g) {
        if (super.getVisible()) {
            if (movementX < 100 && !pace) {
                movementX = movementX + .2;
            } else if (!pace) {
                pace = true;
            } else if (movementX > 0 && pace) {
                movementX = movementX - .3;
            } else {
                pace = false;
            }

            drawBoss();
            g.drawImage(bossImage, super.getX() + (int)movementX - 50, super.getY(), null);
        }

    }
    @Override
    public String dialogue() {
        return ("Where's my key?");
    }
}
