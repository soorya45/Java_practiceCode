import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s {
    private int attendanceMarks = 0;
    private int rubrics = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            s gui = new s();
            gui.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Rubrics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(2, 1));

        JPanel attendancePanel = createAttendancePanel();
        JPanel rubricsPanel = createRubricsPanel();

        frame.add(attendancePanel);
        frame.add(rubricsPanel);

        frame.setVisible(true);
    }

    private JPanel createAttendancePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Attendance Calculator"));
        panel.setPreferredSize(new Dimension(300, 150));

        JLabel label = new JLabel("Enter attendance percentage:");
        JTextField percentageField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");

        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = percentageField.getText();
                try {
                    int percentage = Integer.parseInt(input);
                    attendanceMarks = calculateAttendance(percentage);
                    resultArea.setText("Attendance Marks: " + attendanceMarks);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter a valid percentage.");
                }
            }
        });

        panel.add(label);
        panel.add(percentageField);
        panel.add(calculateButton);
        panel.add(resultArea);

        return panel;
    }

    private JPanel createRubricsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Rubrics Calculator"));

        panel.add(createYesNoPanel("Did you complete the course? (Add 10 marks if 'Yes')"));
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

        return panel;
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

    public int calculateAttendance(int percentage) {
        if (percentage >= 95 && percentage <= 100) {
            return 5;
        } else if (percentage >= 90 && percentage < 95) {
            return 4;
        } else if (percentage >= 85 && percentage < 90) {
            return 3;
        } else if (percentage >= 80 && percentage < 85) {
            return 2;
        } else {
            return 0;
        }
    }

    public int calculateRubrics() {
        if (rubrics > 0) {
            rubrics += 5;
        }
        return rubrics;
    }
}
