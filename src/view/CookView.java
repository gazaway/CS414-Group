package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.MenuItem;
import model.Order;
import model.OrderStatus;
import model.Pizza;
import controller.PizzaSystem;

public class CookView{

	private JFrame frame;
	private PizzaSystem parentSystem;
	private JLabel waitingForPrepLabel;
	private JLabel beingPreppedLabel;
	private JLabel alreadyMadeLabel;
	private JPanel queueTextPanel;
	private JPanel itemsPanel;
	private JPanel pizzasPanel;
	private JButton prepNextOrderButton;
	private JButton completeOrderButton;
	private JPanel bottomButtonPanel;
	private JPanel orderPanel;
	private Order currentOrder;
	private JLabel orderStatusLabel;
	private JPanel orderMiddleManPanel;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CookView window = new CookView(parentSystem);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param pizzaSystem 
	 */
	public CookView(PizzaSystem pizzaSystem) {
		parentSystem = pizzaSystem;
		initialize();
		frame.addWindowListener( new Terminator(pizzaSystem));
		frame.setDefaultLookAndFeelDecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		currentOrder = new Order();
		orderStatusLabel = new JLabel();
		currentOrder.setOrderStatus(OrderStatus.noneSelected);
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setBounds(100, 100, 800, 500);
		orderPanel = new JPanel(new GridLayout(2,1));
		orderPanel.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createTitledBorder("Order"), 
	            BorderFactory.createEmptyBorder(20,20,20,20)));
		orderMiddleManPanel = new JPanel(new BorderLayout());
		itemsPanel = new JPanel(new GridLayout());
		pizzasPanel = new JPanel(new GridLayout());
		alreadyMadeLabel = new JLabel();
		beingPreppedLabel = new JLabel();
		waitingForPrepLabel = new JLabel();
		queueTextPanel = new JPanel(new GridLayout(1, 3));
		bottomButtonPanel = new JPanel(new GridLayout(1,2, 5, 5));
		Font f = new Font("Arial", Font.BOLD, 12);
		drawQueueTextPanel();
		alreadyMadeLabel.setFont(f);
		waitingForPrepLabel.setFont(f);
		beingPreppedLabel.setFont(f);
		prepNextOrderButton = new JButton("Prep Next Order");
		completeOrderButton = new JButton("Complete Current Order");
		bottomButtonPanel.add(prepNextOrderButton);
		bottomButtonPanel.add(completeOrderButton);
		itemsPanel = new JPanel(new GridLayout());
		pizzasPanel = new JPanel(new GridLayout());
		queueTextPanel.add(waitingForPrepLabel);
		queueTextPanel.add(beingPreppedLabel);
		queueTextPanel.add(alreadyMadeLabel);
		frame.add(bottomButtonPanel, BorderLayout.SOUTH);
		frame.add(orderPanel);
		frame.add(queueTextPanel, BorderLayout.NORTH);
		prepNextOrderButton.addActionListener(new NextPrepHandler());
		completeOrderButton.addActionListener(new CompletePrepHandler());
		drawOrderPanel();
	}
	
	private void drawOrderPanel(){
		itemsPanel.setLayout(new GridLayout(currentOrder.getItems().size(), 1));
		for (MenuItem mi : currentOrder.getItems()){
			itemsPanel.add(new JLabel(mi.toString()));
		}
		if (currentOrder.getItems().isEmpty() && !(currentOrder.getOrderStatus() == OrderStatus.noneSelected)){
			itemsPanel.add(new JLabel("[None]"));
		}
		pizzasPanel.setLayout(new GridLayout(currentOrder.getPizzas().size(), 1));
		for (Pizza pi : currentOrder.getPizzas()){
			pizzasPanel.add(new JLabel(pi.toString()));
		}
		if (currentOrder.getPizzas().isEmpty() && !(currentOrder.getOrderStatus() == OrderStatus.noneSelected)){
			pizzasPanel.add(new JLabel("[None]"));
		}
		itemsPanel.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createTitledBorder("Regular Menu Items"), 
	            BorderFactory.createEmptyBorder(5,5,5,5)));
		pizzasPanel.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createTitledBorder("Pizzas"), 
	            BorderFactory.createEmptyBorder(5,5,5,5)));
		orderStatusLabel.setText("Order Status: " + currentOrder.getOrderStatus());
		orderMiddleManPanel.add(orderStatusLabel, BorderLayout.NORTH);
		orderMiddleManPanel.add(itemsPanel, BorderLayout.CENTER);
		orderPanel.add(orderMiddleManPanel);
		orderPanel.add(pizzasPanel);
	}
	
	private void clearOrderPanel() {
		orderPanel.removeAll();
		itemsPanel.removeAll();
		pizzasPanel.removeAll();
		drawOrderPanel();
		frame.repaint();
	}

	private void drawQueueTextPanel() {
		alreadyMadeLabel.setText("This store has completed "
				+ parentSystem.getPizzaStore().getOrderQueue().getPastOrders().size() + " order(s) so far.");
		beingPreppedLabel.setText("There are "
				+ parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().size() + " orders being prepped.");
		waitingForPrepLabel.setText("There are "
				+ parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().size()
				+ " orders waiting to be prepped.");
	}
	
	private class NextPrepHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (!parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().isEmpty()){
				if ((currentOrder.getOrderStatus() == OrderStatus.noneSelected)){
					currentOrder = parentSystem.getOrderInterface().grabNextOrder();
					drawQueueTextPanel();
					drawOrderPanel();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Finish current order before prepping another.");
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "There are no pending orders to prep.");
			}
		}
	}
	
	private class CompletePrepHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if ((parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(currentOrder))){
				parentSystem.getOrderInterface().completeOrder(currentOrder);
				currentOrder = new Order();
				currentOrder.setOrderStatus(OrderStatus.noneSelected);
				clearOrderPanel();
				drawQueueTextPanel();
			}
			else {
				JOptionPane.showMessageDialog(frame, "You have to prep the order before completing it.");
			}
		}
	}
}
