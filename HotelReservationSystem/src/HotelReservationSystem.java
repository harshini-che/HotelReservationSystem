//Harshini Chellasamy

/* The Northwoods Hotel Reservation Company wishes to have a program (written in JAVA)
 * that will allow their clients to access a hotel reservation system. 
 * The system will allow the customer to enter their name, the hotel that the Company offers their 
 * clients and its location, the type of room, the number of days to reserve the room, 
 * and to have any discount apply to the total cost of their reservation.
 * 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HotelReservationSystem extends JFrame implements ActionListener {
    
   //instantiate all items for GUI
  private static final long serialVersionUID = 1L;
  JLabel custnamelabel, roomtypeslabel, locationlabel, hoteldropdownlabel, paymentmethodlabel, numberofnightslabel, discountlabel;
  JLabel blanklabel0, blanklabel, blanklabel1, blanklabel2, blanklabel3, blanklabel4, blanklabel5, blanklabel6, blanklabel7, blanklabel8, blanklabel9, blanklabel10, blanklabel11, blanklabel12 ; 
  JButton b1, b2;
  JTextField custnametxtfield, numberofnightstxtfield, total;
  JMenuBar menuBar = new JMenuBar();
  JMenu mnFile = new JMenu("File");
  JMenuItem mntmExit = new JMenuItem("Exit");
  JMenu mnHelp = new JMenu("Help");
  JMenuItem mntmLogIn = new JMenuItem("Log In");
  JMenuItem mntmAbout = new JMenuItem("About");   
  String[] hotels = new String[] {"Ritz Carlton", "Comfort Inn", "Hyatt", "The View Hotel", "Grand Hotel", "Plaza Hotel"};
  String[] locations = new String [] {"Chicago, IL", "Madison, WI", "Los Angeles, CA", "Sussex, UK", "Mackinac, MI", "New York, NY"};

  private JRadioButton visa;
  private JRadioButton mastercard; 
  private JRadioButton paypal;
  private JRadioButton senior;
  private JRadioButton student; 
  private JRadioButton birthday;
  private JRadioButton corporate;
  private JRadioButton none; 
  private ButtonGroup payment; 
  private ButtonGroup discount; 
  
  private JRadioButton singlebed; 
  private JRadioButton doublebed; 
  private JRadioButton suite;
  private ButtonGroup roomtype;
  
  
  JComboBox<String> hoteldropdown, locationdropdown;


  //add items to GUI
  public HotelReservationSystem() {
    custnamelabel = new JLabel(" Customer Name");
    blanklabel0 = new JLabel ("  ");
    blanklabel = new JLabel("  ");
    blanklabel1 = new JLabel("  ");
    blanklabel2 = new JLabel("  ");
    blanklabel3 = new JLabel("  ");
    blanklabel4 = new JLabel("  ");
    blanklabel5 = new JLabel("  ");
    blanklabel6 = new JLabel("  ");
    blanklabel7 = new JLabel("  ");
    blanklabel8= new JLabel("  ");
    blanklabel9 = new JLabel("  ");
    blanklabel10 = new JLabel("  ");
    blanklabel11 = new JLabel("  ");
    blanklabel12 = new JLabel("  ");

    roomtypeslabel = new JLabel(" Select a Room Type");
    locationlabel = new JLabel(" Select a Location");
    hoteldropdownlabel = new JLabel(" Select a Hotel");
    paymentmethodlabel = new JLabel(" Select a Payment Method");
    numberofnightslabel = new JLabel(" Enter # of Nights to book");
    discountlabel = new JLabel(" Select an Applicable Discount");

    b1 = new JButton("MAKE RESERVATION");
    b2 = new JButton("EXIT");
  
    custnametxtfield = new JTextField(10);
    numberofnightstxtfield = new JTextField(10);

    visa = new JRadioButton("Visa", true);
    mastercard = new JRadioButton("Mastercard", false);
    paypal = new JRadioButton("Paypal", false);
    payment = new ButtonGroup();
    payment.add(visa);
    payment.add(mastercard);
    payment.add(paypal);
    
    none = new JRadioButton("No Discount", true);
    senior = new JRadioButton("Senior - 20% OFF", false);
    student = new JRadioButton("Student - 10% OFF", false);
    birthday = new JRadioButton("Birthday - 15% OFF", false);
    corporate = new JRadioButton("Corporate - 25% OFF", false);
    discount = new ButtonGroup();
    discount.add(senior);
    discount.add(student);
    discount.add(corporate);
    discount.add(birthday);
    discount.add(none);
    
    singlebed = new JRadioButton("Single Bed - $100/night", true);
    doublebed = new JRadioButton("Double Bed - $200/night", false);
    suite = new JRadioButton("Suite - $300/night", false);
    roomtype = new ButtonGroup();
    roomtype.add(singlebed);
    roomtype.add(doublebed);
    roomtype.add(suite);

    hoteldropdown = new JComboBox<>(hotels);
    locationdropdown = new JComboBox<>(locations);

    add(menuBar);
    menuBar.add(mnFile);
    mnFile.add(mntmLogIn);
    mnFile.add(mntmExit);
    menuBar.add(mnHelp);
    mnHelp.add(mntmAbout);
    setJMenuBar(menuBar);
   
    add(custnamelabel);
    add(custnametxtfield);
    add(hoteldropdownlabel);
    add(hoteldropdown);
    add(locationlabel);
    add(locationdropdown);
    add(numberofnightslabel);
    add(numberofnightstxtfield);
    add(roomtypeslabel);
    add(blanklabel);
    add(singlebed);
    add(blanklabel1);
    add(doublebed);
    add(blanklabel0);
    add(suite);
    add(blanklabel2);
    add(paymentmethodlabel);
    add(blanklabel3);
    add(visa);
    add(blanklabel4);
    add(mastercard);
    add(blanklabel5);
    add(paypal);
    add(blanklabel6);
    add(discountlabel);
    add(blanklabel7);
    add(none);
    add(blanklabel8);
    add(senior);
    add(blanklabel9);
    add(student);
    add(blanklabel10);
    add(birthday);
    add(blanklabel11);
    add(corporate);
    add(blanklabel12);

    add(b1);
    add(b2);
    
    //actions for clicking things 
    b1.addActionListener(this);
    b2.addActionListener(e -> System.exit(0));
    mntmExit.addActionListener(e -> System.exit(0));
    mntmAbout.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0){
	   JOptionPane.showMessageDialog(null, "The Hotel Reservation Program was Developed by Harshini Chellasamy in 2019.\nUse this program to make a reservation.",
	   "About", JOptionPane.PLAIN_MESSAGE);} 
	 });
    mntmLogIn.addActionListener(new ActionListener(){
	public void actionPerformed (ActionEvent arg1) {
		JOptionPane.showMessageDialog(null, "Login Entry: pwd = harshini", "", JOptionPane.PLAIN_MESSAGE);
		String password = JOptionPane.showInputDialog(null, "Enter Password: ");
			if (password.equals("harshini")){
				JOptionPane.showMessageDialog(null, "Correct Password! Continue.");
			}
			else {
			JOptionPane.showMessageDialog(null, "Incorrect Password. Try again later.");
			}
	}
    });
    
    //set panel dimensions
    setSize(600,300);
    setLayout(new GridLayout(19,2));
    setTitle("Hotel Reservation System");
  }
  
  //check what is selected 
  public void actionPerformed(ActionEvent ae){
    float price = 0;
    String username = "", hotel = "", location = "", nights= "", room = "", discountmsg = "", message = "";
    double discount = 1;
 
    if (senior.isSelected() == true) {
	discount = 0.2;
	discountmsg = "20% OFF applied";

    }
    if (student.isSelected() == true) {
	discount = 0.1;
	discountmsg = "10% OFF applied";

    }
    if (birthday.isSelected() == true) {
	discount = 0.15;
	discountmsg = "15% OFF applied";

    }
    if (corporate.isSelected() == true) {
	discount = 0.25;
	discountmsg = "25% OFF applied";
    }
    if(none.isSelected() == true) {
	discount = 0; 
	discountmsg = "No discount applied";

    }
    if(singlebed.isSelected() == true) {
	price = 100;
	room = "Single Bed Room";
    }
    if(doublebed.isSelected() == true) {
	price = 200;
	room = "Double Bed Room";

    }
    if(suite.isSelected() == true) {
	price = 300;
	room = "Suite Room";
    }
   
    nights=numberofnightstxtfield.getText();
    int numbernights = Integer.parseInt(nights);
    

    double totalprice = ((price*numbernights)-(price*numbernights*discount));
    double priceaftertax = totalprice+(totalprice*0.1);
    
    
    //output data
    if(ae.getSource() == b1) {
      username = custnametxtfield.getText();
      nights = numberofnightstxtfield.getText();
      hotel = hoteldropdown.getSelectedItem().toString();
      location = locationdropdown.getSelectedItem().toString();
      message = "Thanks for your reservation " + username + "!\n"+"\nHotel: "+hotel+"\nLocation: "+location+"\nRoom Type: "+room+"\nCost Per Night: "+price+"\nDiscount: "+discountmsg+"\nSales Tax: 10%\nYour total is $" + priceaftertax;
    } 
    
    JOptionPane.showMessageDialog(null, "Summary: \n\n" + message, "\nOrder Summary", JOptionPane.PLAIN_MESSAGE);
  }
  
  //main method
  public static void main(String args[]) {
    HotelReservationSystem a = new HotelReservationSystem();
    a.setVisible(true);
    a.setLocation(200,200);
  }
}