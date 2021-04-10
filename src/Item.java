
import java.awt.Graphics;

public abstract class Item {
    //ArrayList<Item> itemList = new ArrayList<Item>();
    private int x;
    private int y;
    private boolean visible;
    private String name;
    public Item(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        //itemList.add(new (x, y, name));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public abstract void drawMe(int a, int b, Graphics g);
    public void changeX(int a) {
        x = a;
    }
    public void changeY(int a) {
        y = a;
    }
    public boolean getVisible() {
        return visible;
    }
    public void setVisible(boolean a) {
        visible = a;
    }
    public String toString() {
        return name;
    }
}
