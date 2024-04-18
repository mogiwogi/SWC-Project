import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    
    public class GalacticTicketingSystem extends JFrame implements ActionListener {
        private JComboBox<String> departureComboBox;
        private JComboBox<String> destinationComboBox;
        private JComboBox<String> foodComboBox;
        private JButton bookTicketButton;
        private JTextField nameTextField;
        private JTextField emailTextField;
        private JRadioButton oneWayRadioButton;
        private JRadioButton roundTripRadioButton;
    
        public GalacticTicketingSystem() {
            setTitle("Galactic Ticketing System");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("Departure:"), gbc);
            departureComboBox = new JComboBox<>(new String[]{"Earth", "Mars", "Venus", "Jupiter"});
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(departureComboBox, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(new JLabel("Destination:"), gbc);
            destinationComboBox = new JComboBox<>(new String[]{"Earth", "Mars", "Venus", "Jupiter"});
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(destinationComboBox, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(new JLabel("Food:"), gbc);
            foodComboBox = new JComboBox<>(new String[]{"None", "Burrito (5$)", "Burger (4$)", "Pizza (3.5$)", "Nasi Lemak (3$)", "Sate (2$)", "Roti Canai (1$)"});
            gbc.gridx = 1;
            gbc.gridy = 2;
            add(foodComboBox, gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            add(new JLabel("Ticket Type:"), gbc);
            oneWayRadioButton = new JRadioButton("One Way");
            roundTripRadioButton = new JRadioButton("Round Trip");
            ButtonGroup ticketTypeGroup = new ButtonGroup();
            ticketTypeGroup.add(oneWayRadioButton);
            ticketTypeGroup.add(roundTripRadioButton);
            JPanel ticketTypePanel = new JPanel();
            ticketTypePanel.add(oneWayRadioButton);
            ticketTypePanel.add(roundTripRadioButton);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            add(ticketTypePanel, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            add(new JLabel("Name:"), gbc);
            nameTextField = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 4;
            add(nameTextField, gbc);
                
            gbc.gridx = 0;
            gbc.gridy = 5;
            add(new JLabel("Email:"), gbc);
            emailTextField = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 5;
            add(emailTextField, gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            bookTicketButton = new JButton("Book Ticket");
            bookTicketButton.addActionListener(this);
            add(bookTicketButton, gbc);
    
            setVisible(true);
        }
    
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == bookTicketButton) {
                String departure = (String) departureComboBox.getSelectedItem();
                String destination = (String) destinationComboBox.getSelectedItem();
                String passengerName = nameTextField.getText();
                String passengerEmail = emailTextField.getText();
                String selectedFood = (String) foodComboBox.getSelectedItem();
                String ticketType = oneWayRadioButton.isSelected() ? "One Way" : "Round Trip";
                double ticketCost = calculateTicketCost(departure, destination, ticketType);
    
                String summary = "Passenger: " + passengerName + "\n" +
                        "Email: " + passengerEmail + "\n" +
                        "Departure: " + departure + "\n" +
                        "Destination: " + destination + "\n" +
                        "Ticket type: " + ticketType + "\n" +
                        "Food: " + selectedFood + "\n" +
                        "Cost: $" + String.format("%.2f", ticketCost) + "\n" + "\n" + "Are you sure this is the correct details?";
                        
    
                int option = JOptionPane.showConfirmDialog(this, summary, "Booking Summary", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(this, "Ticket booked successfully!\n\nTicket details will be sent to your email.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Booking canceled.", "Cancellation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    
        private double calculateTicketCost(String departure, String destination, String ticketType) {
            double baseCost = 100.0;
            double distanceFactor = 1.0;
            if (departure.equals("Earth") && destination.equals("Mars")) {
                distanceFactor = 1.5;
            } else if (departure.equals("Earth") && destination.equals("Venus")) {
                distanceFactor = 1.5; 
            }
             else if (departure.equals("Earth") && destination.equals("Jupiter")) {
                 distanceFactor = 2.0; 
            }
            else if (departure.equals("Mars") && destination.equals("Jupiter")) {
                 distanceFactor = 1.5;
            }
            else if (departure.equals("Mars") && destination.equals("Venus")) {
                 distanceFactor = 2.0;
            }
            else if (departure.equals("Mars") && destination.equals("Earth")) {
                 distanceFactor = 1.5;
            }
            else if (departure.equals("Venus") && destination.equals("Jupiter")) {
                 distanceFactor = 2.5;
            }
            else if (departure.equals("Venus") && destination.equals("Earth")) {
                 distanceFactor = 1.5;
            }
            else if (departure.equals("Venus") && destination.equals("Mars")) {
                 distanceFactor = 2.0;
            }
            else if (departure.equals("Jupiter") && destination.equals("Earth")) {
                 distanceFactor = 2.0;
            }
            else if (departure.equals("Jupiter") && destination.equals("Mars")) {
                 distanceFactor = 1.5;
            }
            else if (departure.equals("Jupiter") && destination.equals("Venus")) {
                 distanceFactor = 2.5;
            }
            else{
              JOptionPane.showMessageDialog(this, "We only provide transportation between planets!"+"\nPleace cancel the ticket and redo.", "Announcement", JOptionPane.INFORMATION_MESSAGE);  
              return -1;
            }
        
            String selectedFood = (String) foodComboBox.getSelectedItem();
        
            if (selectedFood.equals("Burrito")) {
                baseCost += 5;
            }
            else if (selectedFood.equals("Nasi Lemak")) {
                baseCost += 3;
            }
            else if (selectedFood.equals("Sate")) {
                baseCost += 2;
            }
            else if (selectedFood.equals("Roti Canai")) {
                baseCost += 1;
            }
            else if (selectedFood.equals("Pizza")) {
                baseCost += 3.5;
            }
            else if (selectedFood.equals("Burger")) {
                baseCost += 4;
            }
            else if (selectedFood.equals("None")) {
                baseCost += 0;
            }
        
            double ticketCost = baseCost * distanceFactor;
            if (ticketType.equals("Round Trip")) {
                ticketCost *= 2; 
            }
            return ticketCost;
        }

    
        public static void main(String[] args) {
            new GalacticTicketingSystem();
        }
    }