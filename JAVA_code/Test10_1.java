import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Test10_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("EX:10");

        JLabel label = new JLabel("Press a button:");
        label.setBounds(50, 20, 200, 30); 

        JButton yesButton = new JButton("Yes");
        yesButton.setBounds(150, 60, 750, 100); 

        JButton noButton = new JButton("No");
        noButton.setBounds(150, 180, 750, 100); 
        
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(150, 300, 750, 100);
        frame.add(label);
        frame.add(yesButton);
        frame.add(noButton);
        frame.add(closeButton); 
        
        yesButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "yes");
            }
        });
        
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "no");
            }
        });
        
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
            }
        });

        frame.setSize(1000, 800); 
        frame.setVisible(true); 
    }
}