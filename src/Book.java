import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Book extends Item {
    private BufferedImage bookImage;

    public Book(int x, int y, String a) {
        super(x, y, a);
    }
    public void drawBook() {
        try {
            bookImage = ImageIO.read(new File("../files/book.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void drawMe(int xx, int yy, Graphics g) {
        if (super.getVisible()) {
            super.changeX(xx);
            super.changeY(yy);
            drawBook();
            g.drawImage(bookImage, xx, yy, null);
        }
    }
}
