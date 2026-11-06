package eg.edu.alexu.csd.oop.circus;

import javax.swing.*;
import java.awt.*;

public class CircusMenuPanel extends JPanel{
    private final Image background;
    private final Image clown;

    public CircusMenuPanel(){
        background = new ImageIcon("resources/images/circus_background.jpeg").getImage();
        clown = new ImageIcon("resources/images/clown.png").getImage();

        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
    }

    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g.create();

        int width = getWidth();
        int height = getHeight();

        g2.setColor(new Color(35, 12, 45));
        g2.fillRect(0, 0, width, height);

        double scale = Math.min((double) height / background.getHeight(this), (double) width / background.getWidth(this));

        int imageWidth = (int)(background.getWidth(this) * scale);
        int imageHeight = (int)(background.getHeight(this) * scale);
        
        int imageX = (width - imageWidth) / 2;
        int imageY = (height - imageHeight) / 2;

        g2.drawImage(background, imageX, imageY, imageWidth, imageHeight, this);

        g2.drawImage(clown, 15, 190, 270, 400, this);

        g2.setFont(new Font("Serif", Font.BOLD, 42));

        String title = "CIRCUS OF PLATES";

        FontMetrics metrics = g2.getFontMetrics();
        int titleX = (width - metrics.stringWidth(title)) / 2;

        g2.setColor(new Color(80, 15, 10));
        g2.drawString(title, titleX + 3, 75 + 3);

        g2.setColor(new Color(255, 205, 65));
        g2.drawString(title, titleX, 75);

        g2.dispose();
    }
}