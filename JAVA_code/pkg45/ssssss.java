package pkg45;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ssssss {

    private int rubrics = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ssssss gui = new ssssss();
            gui.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Rubrics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

  
        panel.add(createYesNoPanel("Is the case study idea innovative?"));
        panel.add(createYesNoPanel("Is there Clarity on the work and were all viva questions answered and the implementation bug-free and 100%?"));
        panel.add(createYesNoPanel("Well Formatted, Content Coverage, Grammar and Spelling?"));
        panel.add(createYesNoPanel("Friendly GUI, Handling all kinds of input and output with following minimum requirements?"));
        panel.add(createYesNoPanel("Proper usage of Object Oriented Concepts?"));
        panel.add(createYesNoPanel("Appropriate implication of the following concepts: Interface/Abstract, Exception Handling?"));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = calculateRubrics();
                JOptionPane.showMessageDialog(null, "Total Rubrics: " + total);
            }
        });

        panel.add(calculateButton);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private JPanel createYesNoPanel(String question) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(question);
        JRadioButton yesButton = new JRadioButton("Yes");
        JRadioButton noButton = new JRadioButton("No");

        ButtonGroup group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);

        panel.add(label);
        panel.add(yesButton);
        panel.add(noButton);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rubrics += 5;
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rubrics += 2;
            }
        });

        return panel;
    }

    private int calculateRubrics() {

        if (rubrics > 0) {
            rubrics += 5;
        }
        return rubrics;
    }
}




