package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.PizzaSystem;
import model.Customer;
import model.MenuItem;
import model.Order;
import model.Pizza;
import model.PizzaException;
import model.PizzaSize;
import model.PizzaTopping;

public class OrderInterfaceTest {

	private static PizzaSystem test;
	private ArrayList<Pizza> pizzaList;
	private ArrayList<MenuItem> itemList;
	private static PizzaTopping[] toppings;
	static PizzaTopping ham = new PizzaTopping("Ham", "Ham");

	@BeforeClass
	public static void setUpClass() throws Exception {
		test = new PizzaSystem();
		toppings = new PizzaTopping[1];
		toppings[0] = ham;
	}
	
	@Before
	public void beforeTest() throws Exception{
		test.clearSystem();
		pizzaList = new ArrayList<Pizza>();
		itemList = new ArrayList<MenuItem>();
	}

	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with good, but empty, inputs. This is the same as creating a blank order. Should allow.
	 */
	@Test
	public void testCreateNewOrderNoCustGoodEmptyLists() {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with good, filled inputs. Should allow fine.
	 */
	@Test
	public void testCreateNewOrderNoCustGoodNotEmptyList() {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with a null first param list. Expect null error.
	 */
	@Test
	public void testCreateNewOrderNoCustNullFirst() {
		Order temp = test.getOrderInterface().createNewOrder(null, pizzaList);
		assertFalse(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with a null second param list. Expect null error.
	 */
	@Test
	public void testCreateNewOrderNoCustNullSecond() {
		Order temp = test.getOrderInterface().createNewOrder(itemList, null);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 * Test with good inputs, empty lists.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodEmptyLists() {
		Customer cust = test.getCustomerInterface().createNewCustProfile("Jack", "address", "phone");
		Order temp = test.getOrderInterface().createNewOrder(cust, itemList, pizzaList);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 * Test with good inputs, filled lists.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodFullLists() {
		Customer cust = test.getCustomerInterface().createNewCustProfile("Jack", "address", "phone");
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(cust, itemList, pizzaList);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 * Test with null first param list. Expect error.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodNull1stList() {
		Customer cust = test.getCustomerInterface().createNewCustProfile("Jack", "address", "phone");
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		Order temp = test.getOrderInterface().createNewOrder(cust, null, pizzaList);
		assertFalse(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 * Test with null second param list. Expect error.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodNull2ndList() {
		Customer cust = test.getCustomerInterface().createNewCustProfile("Jack", "address", "phone");
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(cust, itemList, null);
		assertFalse(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 * Test with a non-system customer. Expect error
	 */
	@Test
	public void testCreateNewOrderWithCustBadCustomer() {
		Customer cust = new Customer("Jack", "address", "phone");
		Order temp = test.getOrderInterface().createNewOrder(cust, itemList, pizzaList);
		assertFalse(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 * Test with a null customer. Expect error
	 */
	@Test
	public void testCreateNewOrderWithCustNullCustomer() {
		Order temp = test.getOrderInterface().createNewOrder(null, itemList, pizzaList);
		assertFalse(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
	}

	/**
	 * Test method for {@link controller.OrderInterface#applySpecialsToOrder(model.Order)}.
	 * Test with good inputs. Should allow 
	 */
	@Test
	public void testApplySpecialsToOrderGood() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		temp.tallyTotalPrice();
		assertTrue(temp.getPrice() == 15);
		test.getManagerInterface().createSpecialWithItem("Cheap Wings", new MenuItem(5, "wings", "wings"), 1);
		test.getOrderInterface().applySpecialsToOrder(temp);
		assertTrue(temp.getPrice() == 11);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#applySpecialsToOrder(model.Order)}.
	 * Test with null order param. Expect error
	 */
	@Test
	public void testApplySpecialsToOrderNull() throws PizzaException {
		test.getManagerInterface().createSpecialWithItem("Cheap Wings", new MenuItem(5, "wings", "wings"), 1);
		test.getOrderInterface().applySpecialsToOrder(null);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#applySpecialsToOrder(model.Order)}.
	 * Test with order not in system. Expect error
	 */
	@Test
	public void testApplySpecialsToOrderNotInSystem() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = new Order(itemList, pizzaList);
		test.getManagerInterface().createSpecialWithItem("Cheap Wings", new MenuItem(5, "wings", "wings"), 1);
		test.getOrderInterface().applySpecialsToOrder(temp);
	}

	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with good order.
	 */
	@Test
	public void testCompleteOrderGood() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.pending);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
		test.getOrderInterface().completeOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.complete);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with null order. Expect error
	 */
	@Test
	public void testCompleteOrderNull() throws PizzaException {
		test.getOrderInterface().completeOrder(null);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with non-system order.
	 */
	@Test
	public void testCompleteOrderBadOrder() throws PizzaException {
		Order temp = new Order();
		test.getOrderInterface().completeOrder(temp);
		assertFalse(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
		assertFalse(temp.getOrderStatus() == model.OrderStatus.complete);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with already completed order. Expect error.
	 */
	@Test
	public void testCompleteOrderCompletedOrder() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		assertTrue(test.getPizzaStore().getOrderQueue().getCurrentOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.pending);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
		test.getOrderInterface().completeOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.complete);
		test.getOrderInterface().completeOrder(temp);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with already canceled order
	 */
	@Test
	public void testCompleteOrderCanceledOrder() throws PizzaException {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().cancelCurrentOrder(temp);
		test.getOrderInterface().completeOrder(temp);
		assertTrue(temp.getOrderStatus() == model.OrderStatus.canceled);
		assertFalse(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
	}

	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with an order that is ready to be canceled.
	 */
	@Test
	public void testCancelCurrentOrderGood() throws PizzaException {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().cancelCurrentOrder(temp);
		assertTrue(temp.getOrderStatus() == model.OrderStatus.canceled);
		assertTrue(test.getPizzaStore().getOrderQueue().getCanceledOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with a null order. Expect error.
	 */
	@Test
	public void testCancelCurrentOrderNull() throws PizzaException {
		test.getOrderInterface().cancelCurrentOrder(null);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with a non-system order. Expect error
	 */
	@Test
	public void testCancelCurrentOrderBadOrder() throws PizzaException {
		Order temp = new Order();
		test.getOrderInterface().cancelCurrentOrder(temp);
		assertFalse(temp.getOrderStatus() == model.OrderStatus.canceled);
		assertFalse(test.getPizzaStore().getOrderQueue().getCanceledOrders().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with an order that's already canceled. Expect error
	 */
	@Test
	public void testCancelCurrentOrderAlreadyCanceled() throws PizzaException {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().cancelCurrentOrder(temp);
		test.getOrderInterface().cancelCurrentOrder(temp);
	}
	
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with an order that's already completed
	 */
	@Test
	public void testCancelCurrentOrderAlreadyComplete() throws PizzaException {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		test.getOrderInterface().completeOrder(temp);
		test.getOrderInterface().cancelCurrentOrder(temp);
		assertTrue(temp.getOrderStatus() == model.OrderStatus.complete);
		assertFalse(test.getPizzaStore().getOrderQueue().getCanceledOrders().contains(temp));
		assertTrue(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
	}

	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's ready to be prepped.
	 */
	@Test
	public void testPrepOrderGood() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's ready to be prepped, but is empty. Expect error.
	 */
	@Test
	public void testPrepOrderGoodButEmpty() throws PizzaException {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		assertFalse(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
		assertFalse(temp.getOrderStatus() == model.OrderStatus.beingMade);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with a null order. Expect error.
	 */
	@Test
	public void testPrepOrderNull() throws PizzaException {
		test.getOrderInterface().prepOrder(null);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's already been prepped. Expect error
	 */
	@Test
	public void testPrepOrderAlreadyPrepped() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
		test.getOrderInterface().prepOrder(temp);
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's already been complete. Expect error
	 */
	@Test
	public void testPrepOrderAlreadyComplete() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
		test.getOrderInterface().completeOrder(temp);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.complete);
		assertFalse(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's already been canceled. Expect error.
	 */
	@Test
	public void testPrepOrderCanceled() throws PizzaException {
		pizzaList.add(new Pizza(toppings, new PizzaSize(10, "Large")));
		itemList.add(new MenuItem(5, "wings", "wings"));
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
		test.getOrderInterface().cancelCurrentOrder(temp);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getCanceledOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.canceled);
		assertFalse(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
	}

	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with good input.
	 */
	@Test
	public void testFindInCurrentOrdersGood() throws PizzaException {
		Order temp = test.getOrderInterface().createNewOrder(itemList, pizzaList);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.beingMade);
		test.getOrderInterface().completeOrder(temp);
		test.getOrderInterface().prepOrder(temp);
		assertTrue(test.getPizzaStore().getOrderQueue().getPastOrders().contains(temp));
		assertTrue(temp.getOrderStatus() == model.OrderStatus.complete);
		assertFalse(test.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with null param. 
	 */
	@Test
	public void testFindInCurrentOrdersNull() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with system order that is in another queue.
	 */
	@Test
	public void testFindInCurrentOrdersAnotherQueue() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with a non-system order.
	 */
	@Test
	public void testFindInCurrentOrdersBad() throws PizzaException {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with good inputs.
	 */
	@Test
	public void testAddPizzaToOrderGood() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with a null order.
	 */
	@Test
	public void testAddPizzaToOrderNullOrder() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with a non-system order.
	 */
	@Test
	public void testAddPizzaToOrderNonSystem() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with a null pizza.
	 */
	@Test
	public void testAddPizzaToOrderNullPizza() throws PizzaException {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with good inputs.
	 */
	@Test
	public void testAddItemToOrderGood() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with null order.
	 */
	@Test
	public void testAddItemToOrderNullOrder() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with non-system order.
	 */
	@Test
	public void testAddItemToOrderNonSystem() throws PizzaException {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with a null item param.
	 */
	@Test
	public void testAddItemToOrderNullItem() throws PizzaException {
		
	}
}
