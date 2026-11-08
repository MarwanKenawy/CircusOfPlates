package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class InstructionsPanel extends CircusMenuPanel {
    public InstructionsPanel(Runnable backAction){
        setLayout(null);
        JLabel title = new JLabel("HOW TO PLAY");
        title.setFont(new Font("Serif", Font.BOLD, 38));
        title.setForeground(new Color(255, 205, 65));
        title.setBounds(350, 100, 400, 55);

        JPanel instructionsBox = new JPanel();
        instructionsBox.setLayout(new BoxLayout(instructionsBox, BoxLayout.Y_AXIS));
        instructionsBox.setBackground(new Color(45, 20, 65));
        instructionsBox.setBorder(new LineBorder(new Color(255, 205, 65), 3));

        JLabel instructions = new JLabel(
            "<html>"
            + "<div style='text-align:center; width:300px;'>"
            + "<h2 style='color:#ffcd41;'>GAME RULES</h2>"
            + "<p style='color:white;'>"
            + "<b>1. Movement</b><br>"
            + "Use LEFT and RIGHT arrow keys to move the clown."
            + "</p>"
            + "<p style='color:white;'>"
            + "<b>2. Catch Shapes</b><br>"
            + "Catch the falling plates and rings."
            + "</p>"
            + "<p style='color:white;'>"
            + "<b>3. Match Colors</b><br>"
            + "Collect three shapes of the same color to score."
            + "</p>"
            + "<p style='color:white;'>"
            + "<b>4. Avoid Bombs!</b><br>"
            + "Hitting a bomb ends the game."
            + "</p>"
            + "<p style='color:white;'>"
            + "<b>5. Beat the Clock</b><br>"
            + "Get the highest score within 60 seconds!"
            + "</p>"
            + "</div></html>"
        );

        instructions.setFont(new Font("SansSerif", Font.PLAIN, 15));
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        instructionsBox.add(Box.createVerticalStrut(10));
        instructionsBox.add(instructions);
        instructionsBox.setBounds(350, 170, 370, 340);

        JButton backButton = new JButton("BACK TO MENU");

        backButton.setFont(new Font("Serif", Font.BOLD, 20));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(210, 55, 65));
        backButton.setFocusPainted(false);
        backButton.setBorder(new LineBorder(new Color(255, 205, 65), 3));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBounds(420, 530, 230, 45);

        backButton.addActionListener(e -> backAction.run());

        add(title);
        add(instructionsBox);
        add(backButton);
    }
}
