import java.awt.Graphics;
public class Character {
    //ArrayList<Item> itemList = new ArrayList<Item>();
    private int x;
    private int y;
    private String name;
    private boolean visible = false;
    public Character(int x, int y, String name) {
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
    public String getName() {
        return name;
    }
    public void drawMe(Graphics g) {
        g.drawImage(null, x, y, null);
    }
    public String dialogue() {
        return ("generic talking");
    }
    public void changeTalkable(boolean a) {
        if (a) {
            a = false;
        } else {
            a = true;
        }
    }
    public boolean getTalkable() {
        return true;
    }
    public void setVisible(boolean a) {
        visible = a;
    }
    public boolean getVisible() {
        return visible;
    }

}
