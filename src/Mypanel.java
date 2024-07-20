import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;



public class Mypanel extends JPanel implements KeyListener , MouseListener, MouseMotionListener {


    private MyRectangle rectangle;
    private ArrayList<MyRectangle>  enemy;
    private ArrayList<MyPoint> myPoints;
    private MyRectangle movedRectangle;
    private ArrayList<MyPoint> myPoints2;
    public Mypanel() {

        this.setLayout(null);
        this.setBounds(0, 0, 800, 600);
        this.rectangle=new MyRectangle(0,0,50);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.myPoints=new ArrayList<>();
        this.enemy=new ArrayList<>();
        this.myPoints2=new ArrayList<>();
        enemy.add(new MyRectangle(new Random().nextInt(800),new Random().nextInt(600),50));
        this.movedRectangle=new MyRectangle(50,0,15);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);



    }
    public Rectangle getAsRec(MyRectangle rect) {
        return new Rectangle(rect.getX(),rect.getY(),rect.getWidth(),rect.getWidth());
    }
    public boolean intersect(MyRectangle rectangle) {
        Boolean intersects=false;
        for (MyRectangle enemy:this.enemy) {
            if(getAsRec(rectangle).intersects(getAsRec(enemy))){
                intersects=true;
            }
        }
        return intersects;
    }
    private int random(){
        Random random=new Random();

        return random.nextInt(1,5);
    }
//    public void game(){
//            new Thread(()->{
//                while(true){
//                    if(intersect()){
//                        this.rectangle.setX(0);
//                        this.rectangle.setY(0);
//
//                        repaint();
//                    }
//                }
//            }).start();
//
//
//
//        }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLUE);
        g.setColor(Color.red);
        g.fillRect( this.rectangle.getX(),this.rectangle.getY(),this.rectangle.getWidth(),this.rectangle.getWidth() );
        int r=0;
        int j=0;
        int b=0;
        for (int i = 0; i < this.myPoints.size()-1; i++) {
            g.setColor(new Color(r+=random(),j+=random(),b+=random()));
            g.fillRect(myPoints.get(i).getX(),myPoints.get(i).getY(),this.rectangle.getWidth(),this.rectangle.getWidth());
        }
        g.setColor(Color.black);
        g.fillRect(this.rectangle.getX(),this.rectangle.getY(),this.rectangle.getWidth(),this.rectangle.getWidth());

        g.setColor(Color.red);
        for(MyRectangle enemy:this.enemy){
            g.fillRect(enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getWidth());
        }
        if(intersect(this.rectangle)){
            g.setColor(Color.black);
            this.myPoints.clear();
            this.rectangle.setnX(0);
            this.rectangle.setnY(0);

            g.fillRect(0,0,this.rectangle.getWidth(),this.rectangle.getWidth());
           enemy.add(new MyRectangle(new Random().nextInt(800),new Random().nextInt(600),50));



        }

        g.setColor(Color.CYAN);
        g.fillRect(movedRectangle.getX(),movedRectangle.getY(),movedRectangle.getWidth(),movedRectangle.getWidth());
        g.setColor(Color.CYAN);
        for (int i = 1; i < this.myPoints2.size(); i++) {
            g.fill3DRect(myPoints2.get(i).getX(),myPoints2.get(i).getY(),this.movedRectangle.getWidth(),this.movedRectangle.getWidth(),true);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {

            case KeyEvent.VK_RIGHT:
                this.rectangle.setX(rectangle.getWidth());
                break;
            case KeyEvent.VK_LEFT:
                this.rectangle.setX(-rectangle.getWidth());
                break;
            case KeyEvent.VK_UP:
                this.rectangle.setY(-rectangle.getWidth());
                break;
            case KeyEvent.VK_DOWN:
                this.rectangle.setY(rectangle.getWidth());
                break;
        }
        this.myPoints.add(new MyPoint(this.rectangle.getX(),this.rectangle.getY()));
        repaint();
    }

    @Override
//    public void keyPressed(KeyEvent e) {
//        int key=e.getKeyCode();
//        if(key==KeyEvent.VK_KP_RIGHT){
//            this.rectangle.setX(this.rectangle.getWidth());
//
//
//        }
//        else if(key==KeyEvent.VK_KP_LEFT){
//            this.rectangle.setX(-this.rectangle.getWidth());
//        }
//        else if(key==KeyEvent.VK_KP_UP){
//            this.rectangle.setY(-this.rectangle.getWidth());
//        }
//        else if(key==KeyEvent.VK_KP_DOWN){
//            this.rectangle.setY( this.rectangle.getWidth());
//
//        }
//
//    }


    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x+" "+y);
        myPoints2.add(new MyPoint(x,y));

        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {



    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x+" "+y);
        myPoints2.add(new MyPoint(x,y));

        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    this.myPoints2.clear();

    repaint();
    }
}
