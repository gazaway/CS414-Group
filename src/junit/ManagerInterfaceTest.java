package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.MenuItem;
import model.Order;
import model.Pizza;
import model.PizzaSize;
import model.PizzaTopping;

import org.junit.Before;
import org.junit.Test;

import controller.PizzaSystem;

/**
 * @author Jim
 *
 */
public class ManagerInterfaceTest {
	
	private PizzaSystem test;
	private ArrayList<Pizza> pizzas2;
	private ArrayList<Pizza> pizzas;
	private PizzaSize small;
	private PizzaSize large;
	private PizzaTopping[] pts = {new PizzaTopping("Ham", "") , new PizzaTopping("Bacon", ""), new PizzaTopping("Pineapple", "")};

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		test = new PizzaSystem();
		pizzas = new ArrayList<Pizza>();
		pizzas2 = new ArrayList<Pizza>();
		small = new PizzaSize((double)7, "SMALL");
		large = new PizzaSize((double)9, "LARGE");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createNewMenu()}.
	 * Create menu with good, clean environment.
	 */
	@Test
	public void testCreateNewMenuGood() {
		test.getManagerInterface().createNewMenu();
		//assert that the menu is empty in every way.
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().size() == 0);
		assertTrue(test.getPizzaStore().getMenu().getPizzaSizes().size() == 0);
		assertTrue(test.getPizzaStore().getMenu().getPizzaToppings().size() == 0);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createNewMenu()}.
	 * Create menu with a menu already created. Should simply replace, restricted via GUI.
	 */
	@Test
	public void testCreateNewMenuBad() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#clearWholeMenu()}.
	 * Test case for clear menu with menu already in place.
	 */
	@Test
	public void testClearWholeMenuGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#clearWholeMenu()}.
	 * Test case for clear menu when no menu exists.
	 */
	@Test
	public void testClearWholeMenuBad() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test method with good environment and good parameters.
	 */
	@Test
	public void testCreateSpecialWithItemGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null string. Should return error.
	 */
	@Test
	public void testCreateSpecialWithItemNullString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null MenuItem. Should return error.
	 */
	@Test
	public void testCreateSpecialWithItemNullMenuItem() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null price. Should return error.
	 */
	@Test
	public void testCreateSpecialWithItemNullPrice() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null price. Should return error.
	 */
	@Test
	public void testCreateSpecialWithItemNegativePrice() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a duplicate MenuItem. Should replace existing special's price with double given,
	 * retaining old special's name.
	 */
	@Test
	public void testCreateSpecialWithItemDuplicateItem() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Create a pizza special in a good, clean enviroment.
	 */
	@Test
	public void testCreateSpecialWithPizzaWithPizzaGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null string. Should return error.
	 */
	@Test
	public void testCreateSpecialWithPizzaNullString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null PizzaSize. Should return error.
	 */
	@Test
	public void testCreateSpecialWithPizzaNullPizzaSize() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null price. Should return error.
	 */
	@Test
	public void testCreateSpecialWithPizzaNullPrice() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a negative price. Should return error.
	 */
	@Test
	public void testCreateSpecialWithPizzaNrgativePrice() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null price. Should return error.
	 */
	@Test
	public void testCreateSpecialWithPizzaDuplicatePizza() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with an existing special, existing MenuItem, good price.
	 */
	@Test
	public void testAddItemToSpecialGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a Special that is not in the system. Should throw error.
	 */
	@Test
	public void testAddItemToSpecialBadSpecial() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a null param. Should throw error.
	 * 
	 */
	@Test
	public void testAddItemToSpecialNullSpecial() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a MenuItem not yet in the system. Should throw error.
	 */
	@Test
	public void testAddItemToSpecialBadMenuItem() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a null price.
	 */
	@Test
	public void testAddItemToSpecialNullPrice() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a negative price.
	 */
	@Test
	public void testAddItemToSpecialNegativePrice() {
		fail("Not yet implemented");
	}
		

	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with an existing Special that has an item.
	 */
	@Test
	public void testRemoveItemFromSpecialGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with a special that has no item. Should throw an error.
	 */
	@Test
	public void testRemoveItemFromSpecialBadNoItem() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with a special that that is not in the system.
	 */
	@Test
	public void testRemoveItemFromSpecialBadSpecial() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with a null param. Should throw error.
	 */
	@Test
	public void testRemoveItemFromSpecialNullSpecial() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with an existing special.
	 */
	@Test
	public void testAddPizzaToSpecialGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a special not in system. Should throw error.
	 */
	@Test
	public void testAddPizzaToSpecialBadSpecial() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null param. Should throw error.
	 * 
	 */
	@Test
	public void testAddPizzaToSpecialNullSpecial() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a pizza size that is not in system. Should throw error.
	 */
	@Test
	public void testAddPizzaToSpecialBadPizza() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null param. Should throw error.
	 */
	@Test
	public void testAddPizzaToSpecialNullPizza() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null price param. Should throw error.
	 */
	@Test
	public void testAddPizzaToSpecialNullPrice() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a negative price. Should throw error.
	 */
	@Test
	public void testAddPizzaToSpecialNegativePrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaFromSpecial(model.Special)}.
	 */
	@Test
	public void testRemovePizzaFromSpecial() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testAddItemToMenuGood() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with a negative price param. Should throw error.
	 */
	@Test
	public void testAddItemToMenuNegativeNumber() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with null price param. Should throw error.
	 */
	@Test
	public void testAddItemToMenuNullNumber() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with empty string 1st param. Should throw error.
	 */
	@Test
	public void testAddItemToMenuEmpty1stString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with null string 1st param. Should throw error.
	 */
	@Test
	public void testAddItemToMenuNull1stString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with empty string 2nd param. Should throw error.
	 */
	@Test
	public void testAddItemToMenuEmpty2ndString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromMenu(model.MenuItem)}.
	 * Test with bull string 2nd param. Should throw error.
	 */
	@Test
	public void testRemoveItemFromMenuNull2ndString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 */
	@Test
	public void testAddPizzaSizeToMenu() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testAddPizzaSizeToMenuGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a negative param. Should throw error.
	 */
	@Test
	public void testAddPizzaSizeToMenuNegNumber() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a null param. Should throw error.
	 */
	@Test
	public void testAddPizzaSizeToMenuNullNumber() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with an empty string. Should throw error.
	 */
	@Test
	public void testAddPizzaSizeToMenuEmptyString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a null string param. Should throw error.
	 */
	@Test
	public void testAddPizzaSizeToMenuNullString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test remove with good params.
	 */
	@Test
	public void testRemovePizzaSizeFromMenuGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test with size that isn't in system. Should throw error.
	 */
	@Test
	public void testRemovePizzaSizeFromMenuBadSize() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test with null param. Should throw error.
	 */
	@Test
	public void testRemovePizzaSizeFromMenuNullSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Add topping with good inputs.
	 */
	@Test
	public void testAddPizzaToppingToMenuGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with an empty first param. Should throw error.
	 */
	@Test
	public void testAddPizzaToppingToMenuEmpty1stString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a null first param. Should throw error.
	 */
	@Test
	public void testAddPizzaToppingToMenuNull1stString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with an empty 2nd string. Should throw error.
	 */
	@Test
	public void testAddPizzaToppingToMenuEmpty2ndString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a null 2nd string. Should throw error.
	 */
	@Test
	public void testAddPizzaToppingToMenuNull2ndString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with a topping that exists in the system.
	 */
	@Test
	public void testRemovePizzaToppingFromMenuGood() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with param of topping not in system. Should throw error.
	 */
	@Test
	public void testRemovePizzaToppingFromMenuBadTopping() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with param of null topping. Should throw error.
	 */
	@Test
	public void testRemovePizzaToppingFromMenuNullTopping() {
		fail("Not yet implemented");
	}
}
