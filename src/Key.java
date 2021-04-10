import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends Item {

    private BufferedImage keyImage;

    public Key(int x, int y, String a) {
        super(x, y, a);
    }
    public void drawKey() {
        try {
            keyImage = ImageIO.read(new File("../files/key.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void drawMe(int xx, int yy, Graphics g) {
        if (super.getVisible()) {
            super.changeX(xx);
            super.changeY(yy);
            drawKey();
            g.drawImage(keyImage, xx, yy, null);
        }
    }
}
