import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Leader extends Character {
    int width;
    int height;
    double movementX = 50;
    private BufferedImage friendImage;

    public Leader(int x, int y, String name) {
        super(x,y,name);
    }
    public void drawFriend() {
        try {
            friendImage = ImageIO.read(new File("../files/leader.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getX() {
        return (super.getX() + (int)movementX);
    }

    @Override
    public void drawMe(Graphics g) {
        if (movementX > 0) {
            movementX = movementX - .2;
        }
        if (super.getVisible()) {
            drawFriend();
            g.drawImage(friendImage, super.getX() + (int)movementX, super.getY(), null);
        }

    }
    @Override
    public String dialogue() {
        return ("We really need your help. Infiltrate the monster base and save humanity! "
                + "You might need a disguise though...");
    }
    public void changeTalkable(boolean a){};
}
