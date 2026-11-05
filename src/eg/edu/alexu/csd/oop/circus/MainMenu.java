package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.oop.circus.model.GameWorld;
import eg.edu.alexu.csd.oop.circus.strategy.DifficultyStrategy;
import eg.edu.alexu.csd.oop.circus.strategy.EasyDifficulty;
import eg.edu.alexu.csd.oop.circus.strategy.HardDifficulty;
import eg.edu.alexu.csd.oop.circus.strategy.MediumDifficulty;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class MainMenu {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private final Color PURPLE = new Color(55, 20 , 90);
    private final Color GOLD = new Color(255, 205 , 55);
    private final Color RED = new Color(210, 55 , 65);
    private final Color BLUE = new Color(45, 130 , 210);
    private final Color GREEN = new Color(45, 160 , 100);

    public MainMenu(){
        JFrame frame = new JFrame("Circus of Plates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(PURPLE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(35, 50, 35, 50));

        JLabel title = new JLabel("CIRCUS OF PLATES");
        title.setFont(new Font("Serif", Font.BOLD, 34));
        title.setForeground(GOLD);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Choose Your Difficulty");
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        subtitle.setBackground(Color.WHITE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(15));
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(35));

        JButton easyButton = createButton("Easy", GREEN);
        JButton mediumButton = createButton("Medium", BLUE);
        JButton hardButton = createButton("Hard", RED);

        easyButton.addActionListener(e -> startGame(new EasyDifficulty()));
        mediumButton.addActionListener(e -> startGame(new MediumDifficulty()));
        hardButton.addActionListener(e -> startGame(new HardDifficulty()));

        panel.add(easyButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(mediumButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(hardButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void startGame(DifficultyStrategy difficulty){
        GameWorld world = new GameWorld(WIDTH, HEIGHT, difficulty);
        GameEngine.start("Circus of Plates", world, Color.BLACK);
    }

    private JButton createButton(String text, Color color){
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 20));
        button.setBackground(Color.WHITE);
        button.setForeground(color);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(300, 55));
        button.setPreferredSize(new Dimension(300, 55));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }
}
