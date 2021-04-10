import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Secrets extends Item {

    private BufferedImage secretImage;

    public Secrets(int x, int y, String a) {
        super(x, y, a);
    }
    public void drawSecrets() {
        try {
            secretImage = ImageIO.read(new File("../files/secrets.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void drawMe(int xx, int yy, Graphics g) {
        if (super.getVisible()) {
            super.changeX(xx);
            super.changeY(yy);
            drawSecrets();
            g.drawImage(secretImage, xx, yy, null);
        }
    }
}
