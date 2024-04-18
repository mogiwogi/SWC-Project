import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FrontPage {
    private JFrame frame;
    private JPanel panel;
    private JButton proceedButton;
    
    
    public FrontPage() {
        frame = new JFrame("Galaxia Bookings");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel greetingLabel = new JLabel("Welcome to Galaxia!");
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(greetingLabel, BorderLayout.NORTH);
        
        ImageIcon logo = new ImageIcon("C:/Users/alifa/lab session 1/pojek.jpeg");
        JLabel logoLabel = new JLabel(logo);
        panel.add(logoLabel, BorderLayout.CENTER);
        
        proceedButton = new JButton("Proceed");
        panel.add(proceedButton, BorderLayout.CENTER);
        
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GalacticTicketingSystem();
            }
        });
        panel.add(proceedButton);
        
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        
    }
    public void actionPerformed(ActionEvent e) 
    {
    if( e.getSource() == proceedButton) {
        frame.dispose();
        new GalacticTicketingSystem();    
    }
}
     public static void main(String[] args) {
         FrontPage frontPage = new FrontPage();
     }
    
    
}