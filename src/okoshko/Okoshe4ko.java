package okoshko;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Okoshe4ko extends JFrame{
    //private JPanel MyPanel;
    //private Container contentPane;
    public Okoshe4ko() {
        super("Okoshe4ko");
        Container contentPane = getContentPane();
        MyPanel  randPic= new MyPanel();

        contentPane.add(randPic);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int x=screenSize.width;
        int y=screenSize.height;
        setLocation(x/4,y/4);
        setSize (x/2,y/2);
        setVisible(true);
        randPic.setBackground(new Color(113, 201,250));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel{

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random randnum = new Random();
        Graphics2D g2d = (Graphics2D)g;
        for (int i=0;i<12;i++ ) {
            int randint = randnum.nextInt(3);
            Shape randShape;
            int x = randnum.nextInt(getWidth());
            int w = randnum.nextInt(getWidth()-x);
            int y = randnum.nextInt(getHeight());
            int h = randnum.nextInt(getHeight()-y);
            switch(randint){
                case 0:
                    randShape = new Rectangle2D.Double(x,y,w,h);
                    break;
                case 1:
                    randShape = new Ellipse2D.Double(x,y,w,h);
                    break;
                default:
                    randShape = new Line2D.Double(x,y,w,h);
            }
            g2d.setColor(new Color(randnum.nextInt(255),randnum.nextInt(255) ,randnum.nextInt(255) ));
            g2d.setStroke(new BasicStroke(randnum.nextInt(15)));
            g2d.draw(randShape);
        }
    }
}