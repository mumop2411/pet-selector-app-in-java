package PetDisplayApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetDisplayApp {
    private JFrame frame;
    private JPanel panel;
    private ButtonGroup petGroup;
    private JLabel imageLabel;

    public PetDisplayApp() {
        frame = new JFrame("Pet Display App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        petGroup = new ButtonGroup();

        JPanel radioButtonPanel = new JPanel(new GridLayout(5, 1)); // Panel to hold radio buttons vertically

        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(dogButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);

        radioButtonPanel.add(birdButton);
        radioButtonPanel.add(catButton);
        radioButtonPanel.add(dogButton);
        radioButtonPanel.add(rabbitButton);
        radioButtonPanel.add(pigButton);

        panel.add(radioButtonPanel, BorderLayout.WEST);

        imageLabel = new JLabel();
        panel.add(imageLabel, BorderLayout.CENTER);

        ActionListener petSelectionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                if (selectedButton.isSelected()) {
                    String selectedPet = selectedButton.getText();
                    displayPetImage(selectedPet);
                }
            }
        };

        birdButton.addActionListener(petSelectionListener);
        catButton.addActionListener(petSelectionListener);
        dogButton.addActionListener(petSelectionListener);
        rabbitButton.addActionListener(petSelectionListener);
        pigButton.addActionListener(petSelectionListener);

        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private void displayPetImage(String pet) {
        String imagePath = "images/"; // Update this to the correct path
        ImageIcon icon = new ImageIcon(imagePath + pet + ".jpg");
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PetDisplayApp();
            }
        });
    }
}