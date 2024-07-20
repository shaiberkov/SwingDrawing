import javax.swing.*;

public class Window extends JFrame {
    private Mypanel panel;


    public Window() {
        this.setTitle("Drawing Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(0,0,800,600);
        Mypanel panel = new Mypanel();
        this.add(panel);
        panel.requestFocusInWindow();


    }
    public void initialiseWindow(){

    }
}
