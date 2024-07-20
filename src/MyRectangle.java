import java.awt.*;

public class MyRectangle {
    private int x;
    private int y;
    private int width;

    public MyRectangle(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;

    }
    public void setnY(int y) {
        this.y = y;

    }
    public void setnX(int x) {
        this.x = x;

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y += y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x;


    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
