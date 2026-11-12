package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PauseMenuFrame extends JFrame {
    private final Color RED = new Color(210, 55, 65);
    private final Color BLUE = new Color(45, 130, 210);
    private final Color GREEN = new Color(45, 160, 100);

    public PauseMenuFrame(Runnable resumeAction, Runnable restartAction, Runnable mainMenuAction){
        setTitle("Game Paused");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(45, 20, 75));
        panel.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 65), 5));
        panel.setLayout(new GridLayout(5, 1, 15, 15));

        JLabel title = new JLabel("GAME PAUSED", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 32));
        title.setForeground(new Color(255, 205, 65));

        JButton resumeButton = createButton("Resume", GREEN);
        JButton restartButton = createButton("Restart", BLUE);
        JButton mainMenuButton = createButton("Main Menu", RED);

        resumeButton.addActionListener(e -> resumeAction.run());
        restartButton.addActionListener(e -> restartAction.run());
        mainMenuButton.addActionListener(e -> mainMenuAction.run());

        panel.add(title);
        panel.add(resumeButton);
        panel.add(restartButton);
        panel.add(mainMenuButton);

        add(panel);
    }

    private JButton createButton(String text, Color color){
        JButton button = new JButton(text);

        button.setFont(new Font("Serif", Font.BOLD, 22));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 65), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter(){
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
