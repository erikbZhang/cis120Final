import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Knife extends Item {

    private BufferedImage knifeImage;

    public Knife(int x, int y, String a) {
        super(x, y, a);
    }
    public void drawKnife() {
        try {
            knifeImage = ImageIO.read(new File("../files/knife.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void drawMe(int xx, int yy, Graphics g) {
        if (super.getVisible()) {
            super.changeX(xx);
            super.changeY(yy);
            drawKnife();
            g.drawImage(knifeImage, xx, yy, null);
        }
    }
}
