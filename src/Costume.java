import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Costume extends Item {

    private BufferedImage costume;
    public Costume(int x, int y, String a) {
        super(x, y, a);
    }
    public void drawCostume() {
        try {
            costume = ImageIO.read(new File("../files/costume.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void drawMe(int xx, int yy, Graphics g) {
        if (super.getVisible()) {
            super.changeX(xx);
            super.changeY(yy);
            drawCostume();
            g.drawImage(costume, xx, yy, null);
        }
    }
}
