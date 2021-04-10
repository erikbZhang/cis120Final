import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bouncer extends Character {
    int width;
    int height;
    private boolean talkable = false;

    private BufferedImage bouncer;

    public Bouncer(int x, int y, String name) {
        super(x,y,name);
    }
    public void drawFriend() {
        try {
            bouncer = ImageIO.read(new File("../files/bouncer.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void drawMe(Graphics g) {
        if (super.getVisible()) {
            drawFriend();
            g.drawImage(bouncer, super.getX(), super.getY(), null);
        }

    }
    public String dialogue() {
        if (talkable) {
            return ("You want to join us? Alright let's go.");
        } else {
            return ("sfjskadfsakj ajdsfnkjdsaf  adsfdjlkasdfj askdfklk asdfkjkj"
                    + "             I need a way to talk to him... ");
        }
    }
    public boolean getTalkable() {
        return talkable;
    }
    public void changeTalkable(boolean a) {
        talkable = a;
    }
}
