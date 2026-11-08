package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOverFrame extends JFrame {
    private static final Color GOLD = new Color(255, 205, 65);
    private static final Color RED = new Color(210, 55, 65);
    private static final Color BLUE = new Color(45, 130, 210);

    public GameOverFrame(int score, String reason, Runnable playAgainAction, Runnable mainMenuAction){
        setTitle("Circus of Plates - Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(null){
            @Override 
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2.setColor(new Color(45, 15, 65));
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setFont(new Font("Serif", Font.BOLD, 58));
                g2.setColor(GOLD);
                g2.drawString("GAME OVER", 190, 130);

                g2.setFont(new Font("Serif", Font.BOLD, 25));
                g2.setColor(Color.WHITE);
                g2.drawString(reason, 190, 210);

                g2.setFont(new Font("Serif", Font.BOLD, 35));
                g2.setColor(GOLD);
                g2.drawString("Final Score: " + score, 245, 300);

                g2.dispose();
            }
        };

        JButton playAgainButton = createButton("Play Again", RED);
        JButton mainMenuButton = createButton("Main Menu", BLUE);

        playAgainButton.setBounds(200, 390, 180, 55);
        mainMenuButton.setBounds(420, 390, 180, 55);

        playAgainButton.addActionListener(e -> {
            dispose();
            playAgainAction.run();
        });

        mainMenuButton.addActionListener(e -> {
            dispose();
            mainMenuAction.run();
        });

        panel.add(playAgainButton);
        panel.add(mainMenuButton);

        setContentPane(panel);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text,Color color){
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 22));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);

        return button;
    }
}
