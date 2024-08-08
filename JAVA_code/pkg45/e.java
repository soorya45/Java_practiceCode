package pkg45;

import pkg45.ssssss; // Importing ssssss class from pkg45 package
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class e {
    private static int attendanceMarks;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Combined Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(2, 1));

        JPanel attendancePanel = createAttendancePanel(); // Create the panel for attendance calculations
        JPanel ia3Panel = createIA3Panel();

        frame.add(attendancePanel);
        frame.add(ia3Panel);

        frame.setVisible(true);
    }

    private static JPanel createAttendancePanel() {
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
                    attendanceMarks = calculateAttendance(percentage); // Update the class variable
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

    private static JPanel createIA3Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("60 mark calculation"));

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(0, 2));
        subPanel.setBackground(new Color(240, 240, 240));

        JLabel qaLabel = new JLabel("Enter QA mark:");
        JTextField qaField = new JTextField();
        JLabel ia1Label = new JLabel("Enter IA1 mark:");
        JTextField ia1Field = new JTextField();
        JLabel ia2Label = new JLabel("Enter IA2 mark:");
        JTextField ia2Field = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBackground(new Color(0, 123, 255));
        calculateButton.setForeground(Color.WHITE);

        JTextArea resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(255, 255, 210));
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qa = Integer.parseInt(qaField.getText());
                int ia1 = Math.round(0.375f * Integer.parseInt(ia1Field.getText()));
                int ia2 = Math.round(0.375f * Integer.parseInt(ia2Field.getText()));
                int Total;

                if (attendanceMarks == 0) {
                    Total = 0;
                } else {
                    Total = qa + ia1 + ia2 + attendanceMarks;
                }

                resultArea.setText("Total Marks: " + Total);
            }
        });

        subPanel.add(qaLabel);
        subPanel.add(qaField);
        subPanel.add(ia1Label);
        subPanel.add(ia1Field);
        subPanel.add(ia2Label);
        subPanel.add(ia2Field);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.add(calculateButton);

        panel.add(subPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.EAST);

        return panel;
    }

    private static int calculateAttendance(int percentage) {
        int attendanceMarks;

        if (percentage >= 95 && percentage <= 100) {
            attendanceMarks = 5;
        } else if (percentage >= 90 && percentage < 95) {
            attendanceMarks = 4;
        } else if (percentage >= 85 && percentage < 90) {
            attendanceMarks = 3;
        } else if (percentage >= 80 && percentage < 85) {
            attendanceMarks = 2;
        } else {
            attendanceMarks = 0;
        }

        return attendanceMarks;
    }
}

