package junit;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.PizzaSystem;
import model.Pizza;

public class OrderInterfaceTest {

	private static PizzaSystem test;

	@BeforeClass
	public static void setUpClass() throws Exception {
		test = new PizzaSystem();
	}
	
	@Before
	public void beforeTest() throws Exception{
		test.clearSystem();
	}

	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with good, but empty, inputs. This is the same as creating a blank order. Should allow.
	 */
	@Test
	public void testCreateNewOrderNoCustGoodEmptyLists() {
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with good, filled inputs. Should allow fine.
	 */
	@Test
	public void testCreateNewOrderNoCustGoodNotEmptyList() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with a null first param list. Expect null error.
	 */
	@Test
	public void testCreateNewOrderNoCustNullFirst() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(java.util.ArrayList, java.util.ArrayList)}.
	 * Test with a null second param list. Expect null error.
	 */
	@Test
	public void testCreateNewOrderNoCustNullSecond() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodEmptyLists() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodFullLists() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodNull1stList() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public void testCreateNewOrderWithCustGoodNull2ndList() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#createNewOrder(model.Customer, java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public void testCreateNewOrderWithCustBadCustomer() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#applySpecialsToOrder(model.Order)}.
	 * Test with good inputs. Should allow
	 */
	@Test
	public void testApplySpecialsToOrderGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#applySpecialsToOrder(model.Order)}.
	 * Test with null order param.
	 */
	@Test
	public void testApplySpecialsToOrderNull() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#applySpecialsToOrder(model.Order)}.
	 * Test with order not in system
	 */
	@Test
	public void testApplySpecialsToOrderNotInSystem() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with good order.
	 */
	@Test
	public void testCompleteOrderGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with null order.
	 */
	@Test
	public void testCompleteOrderNull() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with non-system order.
	 */
	@Test
	public void testCompleteOrderBadOrder() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with already completed order
	 */
	@Test
	public void testCompleteOrderCompletedOrder() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#completeOrder(model.Order)}.
	 * Test complete order with already canceled order
	 */
	@Test
	public void testCompleteOrderCanceledOrder() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with an order that is ready to be canceled.
	 */
	@Test
	public void testCancelCurrentOrderGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with a null order.
	 */
	@Test
	public void testCancelCurrentOrderNull() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with a non-system order.
	 */
	@Test
	public void testCancelCurrentOrderBadOrder() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with an order that's already canceled
	 */
	@Test
	public void testCancelCurrentOrderAlreadyCanceled() {
		
	}
	
	
	/**
	 * Test method for {@link controller.OrderInterface#cancelCurrentOrder(model.Order)}.
	 * Test with an order that's already completed
	 */
	@Test
	public void testCancelCurrentOrderAlreadyComplete() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's ready to be prepped.
	 */
	@Test
	public void testPrepOrderGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with a null order.
	 */
	@Test
	public void testPrepOrderNull() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's already been prepped.
	 */
	@Test
	public void testPrepOrderAlreadyPrepped() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's already been complete.
	 */
	@Test
	public void testPrepOrderAlreadyComplete() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#prepOrder(model.Order)}.
	 * Test with an order that's already been canceled.
	 */
	@Test
	public void testPrepOrderCanceled() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with good input.
	 */
	@Test
	public void testFindInCurrentOrdersGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with null param. 
	 */
	@Test
	public void testFindInCurrentOrdersNull() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with system order that is in another queue.
	 */
	@Test
	public void testFindInCurrentOrdersAnotherQueue() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#findInCurrentOrders(model.Order)}.
	 * Test with a non-system order.
	 */
	@Test
	public void testFindInCurrentOrdersBad() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with good inputs.
	 */
	@Test
	public void testAddPizzaToOrderGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with a null order.
	 */
	@Test
	public void testAddPizzaToOrderNullOrder() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with a non-system order.
	 */
	@Test
	public void testAddPizzaToOrderNonSystem() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addPizzaToOrder(model.Order, model.Pizza)}.
	 * Test with a null pizza.
	 */
	@Test
	public void testAddPizzaToOrderNullPizza() {
		
	}

	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with good inputs.
	 */
	@Test
	public void testAddItemToOrderGood() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with null order.
	 */
	@Test
	public void testAddItemToOrderNullOrder() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with non-system order.
	 */
	@Test
	public void testAddItemToOrderNonSystem() {
		
	}
	
	/**
	 * Test method for {@link controller.OrderInterface#addItemToOrder(model.Order, model.MenuItem)}.
	 * Test with a null item param.
	 */
	@Test
	public void testAddItemToOrderNullItem() {
		
	}
}
