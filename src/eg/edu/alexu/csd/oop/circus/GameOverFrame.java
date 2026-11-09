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
                String title = "GAME OVER";

                int titleWidth = g2.getFontMetrics().stringWidth(title);
                int titleX = (800 - titleWidth) / 2;

                g2.setColor(new Color(60, 20, 20));
                g2.drawString(title, titleX + 4, 134);

                g2.setColor(GOLD);
                g2.drawString(title, titleX, 130);

                g2.setFont(new Font("Serif", Font.BOLD, 45));

                int starOffset = titleWidth / 2 + 45;

                g2.drawString("★", 400 - starOffset, 135);
                g2.drawString("★", 400 + starOffset - 40, 135);

                g2.setFont(new Font("Serif", Font.BOLD, 25));
                g2.setColor(Color.WHITE);
                g2.drawString(reason, 190, 210);

                int panelX = 200;
                int panelY = 250;
                int panelWidth = 400;
                int panelHeight = 110;

                g2.setColor(new Color(120, 65, 20));
                g2.fillRoundRect(panelX - 6, panelY - 6, panelWidth + 12, panelHeight + 12, 30, 30);
                
                g2.setColor(GOLD);
                g2.fillRoundRect(panelX, panelY, panelWidth, panelHeight, 25, 25);

                g2.setColor(new Color(75, 25, 65));
                g2.fillRoundRect(panelX + 7, panelY + 7, panelWidth - 14, panelHeight - 14, 20, 20);

                g2.setFont(new Font("Serif", Font.BOLD, 25));
                g2.setColor(GOLD);
                g2.drawString("YOUR FINAL SCORE", 290, 290);

                g2.setFont(new Font("Serif", Font.BOLD, 42));
                g2.setColor(Color.WHITE);
                String scoreText = String.valueOf(score);
                int scoreWidth = g2.getFontMetrics().stringWidth(scoreText);
                g2.drawString(scoreText, 400 - scoreWidth / 2, 340);

                g2.setFont(new Font("Serif", Font.ITALIC, 23));
                g2.setColor(Color.WHITE);

                String message = "Better luck next time!";
                int messageWidth = g2.getFontMetrics().stringWidth(message);

                g2.drawString(message, (800 - messageWidth) / 2, 390);

                g2.dispose();
            }
        };

        JButton playAgainButton = createButton("Play Again", RED);
        JButton mainMenuButton = createButton("Main Menu", BLUE);

        playAgainButton.setBounds(200, 410, 180, 55);
        mainMenuButton.setBounds(420, 410, 180, 55);

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
        button.setBorder(javax.swing.BorderFactory.createLineBorder(GOLD, 3));
        button.setBorderPainted(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override 
            public void mouseEntered(java.awt.event.MouseEvent e){
                button.setBackground(color.brighter());
            }

            @Override 
            public void mouseExited(java.awt.event.MouseEvent e){
                button.setBackground(color);
            }
        });

        return button;
    }
}
