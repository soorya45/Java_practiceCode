import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Test10_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Application");

        frame.setLayout(new GridLayout(3, 1, 1, 1));
        JLabel UL = new JLabel("Username:");
        JTextField UF = new JTextField();
        JLabel PL = new JLabel("Password:");
        JTextField PF = new JTextField();
        JButton LB = new JButton("Login");
        frame.add(UL);
        frame.add(UF);
        frame.add(PL);
        frame.add(PF);
        frame.add(LB);
        LB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                String u = UF.getText();
                String p = PF.getText();

                if (u.equals("Soorya") && p.equals("1023")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed");
                }
            }
        });

        frame.pack();
        frame.setSize(1000, 800); 
        frame.setVisible(true);
    }
}
