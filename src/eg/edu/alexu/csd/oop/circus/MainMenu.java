package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.circus.model.GameWorld;
import eg.edu.alexu.csd.oop.circus.strategy.DifficultyStrategy;
import eg.edu.alexu.csd.oop.circus.strategy.EasyDifficulty;
import eg.edu.alexu.csd.oop.circus.strategy.HardDifficulty;
import eg.edu.alexu.csd.oop.circus.strategy.MediumDifficulty;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class MainMenu {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public MainMenu(){
        JFrame frame = new JFrame("Circus of Plates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");

        easyButton.addActionListener(e -> startGame(new EasyDifficulty()));
        mediumButton.addActionListener(e -> startGame(new MediumDifficulty()));
        hardButton.addActionListener(e -> startGame(new HardDifficulty()));

        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void startGame(DifficultyStrategy difficulty){
        GameWorld world = new GameWorld(WIDTH, HEIGHT, difficulty);
        GameEngine.start("Circus of Plates", world, Color.BLACK);
    }
}
