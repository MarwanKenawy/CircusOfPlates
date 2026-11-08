package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.circus.model.GameWorld;
import eg.edu.alexu.csd.oop.circus.strategy.DifficultyStrategy;
import eg.edu.alexu.csd.oop.circus.strategy.EasyDifficulty;
import eg.edu.alexu.csd.oop.circus.strategy.HardDifficulty;
import eg.edu.alexu.csd.oop.circus.strategy.MediumDifficulty;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class MainMenu {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    // private final Color PURPLE = new Color(55, 20 , 90);
    // private final Color GOLD = new Color(255, 205 , 55);
    private final Color RED = new Color(210, 55 , 65);
    private final Color BLUE = new Color(45, 130 , 210);
    private final Color GREEN = new Color(45, 160 , 100);

    public MainMenu(){
        JFrame frame = new JFrame("Circus of Plates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        showMainMenu(frame);

        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void startGame(DifficultyStrategy difficulty, JFrame frame){
        frame.dispose();

        GameWorld world = new GameWorld(WIDTH, HEIGHT, difficulty);
        GameEngine.start("Circus of Plates", world, Color.BLACK);
    }

    private JButton createButton(String text, Color color){
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 24));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 65), 3));
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

    private void showInstructions(JFrame frame){
        InstructionsPanel instructionsPanel = new InstructionsPanel(() -> showMainMenu(frame));

        frame.setContentPane(instructionsPanel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    private void showMainMenu(JFrame frame){
        CircusMenuPanel panel = new CircusMenuPanel();
        panel.setLayout(null);

        JButton easyButton = createButton("Easy", GREEN);
        JButton mediumButton = createButton("Medium", BLUE);
        JButton hardButton = createButton("Hard", RED);
        JButton howToPlayButton = createButton("How To Play", new Color(150, 90, 180));

        easyButton.setBounds(500, 270, 230, 55);
        mediumButton.setBounds(500, 345, 230, 55);
        hardButton.setBounds(500, 420, 230, 55);
        howToPlayButton.setBounds(500, 495, 230, 55);

        easyButton.addActionListener(e -> startGame(new EasyDifficulty(), frame));
        mediumButton.addActionListener(e -> startGame(new MediumDifficulty(), frame));
        hardButton.addActionListener(e -> startGame(new HardDifficulty(), frame));
        howToPlayButton.addActionListener(e -> showInstructions(frame));

        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);
        panel.add(howToPlayButton);

        frame.setContentPane(panel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }
}
