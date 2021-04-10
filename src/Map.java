import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map extends Item {

    private BufferedImage mapImage;

    public Map(int x, int y, String a) {
        super(x, y, a);
    }
    public void drawMap() {
        try {
            mapImage = ImageIO.read(new File("../files/map.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void drawMe(int xx, int yy, Graphics g) {
        if (super.getVisible()) {
            super.changeX(xx);
            super.changeY(yy);
            drawMap();
            g.drawImage(mapImage, xx, yy, null);
        }
    }
}
