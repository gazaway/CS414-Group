package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.MenuItem;
import model.Order;
import model.Pizza;
import model.PizzaSize;
import model.PizzaTopping;
import model.Special;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.PizzaSystem;


public class ManagerInterfaceTest {
	
	private static PizzaSystem test;
	private static ArrayList<Pizza> pizzas2;
	private static ArrayList<Pizza> pizzas;
	private static PizzaTopping ham;
	private static PizzaTopping bacon;
	private static PizzaTopping pineApple;
	private static PizzaTopping[] pts = { ham, bacon, pineApple};

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
		test = new PizzaSystem();
		pizzas2 = new ArrayList<Pizza>();
		pizzas = new ArrayList<Pizza>();
		ham = new PizzaTopping("Ham", "");
		bacon = new PizzaTopping("Bacon", "");
		pineApple = new PizzaTopping("Pineapple", "");
	}
	
	@Before
	public void beforeTest() throws Exception{
		test.clearSystem();
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
	@Test(expected=model.PizzaException.class)
	public void testCreateNewMenuBad() {
		test.getManagerInterface().createNewMenu();
		//create menu second time. Should throw error.
		test.getManagerInterface().createNewMenu();
	}

	/**
	 * Test method for {@link controller.ManagerInterface#clearWholeMenu()}.
	 * Test case for clear menu with menu already in place.
	 */
	@Test
	public void testClearWholeMenuGood() {
		//create a menu. Add item to it. Assert item stays.
		test.getManagerInterface().createNewMenu();
		test.getManagerInterface().addItemToMenu(5.00, "Chicken Wings", "Don't order them, they make people fat. People like me");
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().size() == 1);
		//clear menu. Assert menu is empty.
		test.getManagerInterface().clearWholeMenu();
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().size() == 0);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#clearWholeMenu()}.
	 * Test case for clear menu when no menu exists.
	 */
	@Test(expected=model.PizzaException.class)
	public void testClearWholeMenuBad() {
		//just clear it before there is a menu
		test.getManagerInterface().clearWholeMenu();
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test method with good environment and good parameters.
	 */
	@Test
	public void testCreateSpecialWithItemGood() {
		//create menu item, add it to the menu. Assert menu contains the item.
		MenuItem item = test.getManagerInterface().addItemToMenu(5.00, "Wings", "Wings");
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().contains(item));
		//create the special, add it to the menu. Assert the special is recorded.
		Special spec = test.getManagerInterface().createSpecialWithItem("Cheap Wings!", item, 2.00);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null string. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithItemNullString() {
		//create menu item, add it to the menu. Assert menu contains the item.
		MenuItem item = test.getManagerInterface().addItemToMenu(5.00, "Wings", "Wings");
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().contains(item));
		//create the special with null name. Should throw error. Assert it is not contained in specials.
		Special spec = test.getManagerInterface().createSpecialWithItem(null, item, 2.00);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));	
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null MenuItem. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithItemNullMenuItem() {
		//create special with null item. Should throw error. Assert it is not contained in specials.
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", null, 2.00);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null price. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithItemNullPrice() {
		MenuItem item = test.getManagerInterface().addItemToMenu(5.00, "Wings", "Wings");
		double ha = (Double) null;
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, ha);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a negative price. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithItemNegativePrice() {
		MenuItem item = test.getManagerInterface().addItemToMenu(5.00, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, -10.00);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a duplicate MenuItem. Should replace existing special's price with double given,
	 * replacing old special's name.
	 */
	@Test
	public void testCreateSpecialWithItemDuplicateItem() {
		//create two specials with the same item. 
		MenuItem item = test.getManagerInterface().addItemToMenu(5.00, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 10.00);
		Special spec2 = test.getManagerInterface().createSpecialWithItem("CHEAP WINGS", item, 2.00);
		//assert that spec2 is NOT in the store specials.
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
		assertFalse(test.getPizzaStore().getSpecials().contains(spec2));
		//assert that spec has spec2's pricing and name
		assertTrue(spec.getSpecialName().equals(spec2.getSpecialName()));
		assertTrue(spec.getSpecialPrice() == spec2.getSpecialPrice());
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Create a pizza special in a good, clean enviroment.
	 */
	@Test
	public void testCreateSpecialWithPizzaWithPizzaGood() {
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", small, 3);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null string. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithPizzaNullString() {
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		//create special with null name. Should return error. Assert special is not contained.
		Special spec = test.getManagerInterface().createSpecialWithPizza(null, small, 3);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null PizzaSize. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithPizzaNullPizzaSize() {
		//Try to create with null size. Should throw error. Assert not in store specials.
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", null, 3);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null price. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithPizzaNullPrice() {
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		double ha = (Double) null;
		//create special with null double. assert that special is not contained in specials.
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", small, ha);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a negative price. Should return error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithPizzaNegativePrice() {
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		//create special with negative double. assert that special is not contained in specials.
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", small, -10);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a duplicate pizza size. Should retain same special, but change 
	 * size price to new given price and change name to new given name.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateSpecialWithPizzaDuplicatePizza() {
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(11.00, "small");
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", small, 10);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
		//create second special with same size. Assert that new special is not contained in specials
		Special spec2 = test.getManagerInterface().createSpecialWithPizza("Actually cheap small", small, 3);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
		assertFalse(test.getPizzaStore().getSpecials().contains(spec2));
		//assert that first special name and price changed to second special's
		assertTrue(spec.getSpecialPrice() == spec2.getSpecialPrice());
		assertTrue(spec.getSpecialName().equals(spec2.getSpecialName()));
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with an existing special, existing MenuItem, good price.
	 */
	@Test
	public void testAddItemToSpecialGood() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		MenuItem item2 = test.getManagerInterface().addItemToMenu(3, "Pop", "Pop");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		test.getManagerInterface().addItemToSpecial(spec, item2, 1);
		assertTrue(spec.getItem() == item2);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a Special that is not in the system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToSpecialBadSpecial() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = new Special("plub");
		assertTrue(spec.getItem()== null);
		//add menu item to non-menu special. Should throw error. 
		test.getManagerInterface().addItemToSpecial(spec, item, 1);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a null param. Should throw error.
	 * 
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToSpecialNullSpecial() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		//add non-menu item to special. Should throw error. 
		test.getManagerInterface().addItemToSpecial(spec, null, 1);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a MenuItem not yet in the system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToSpecialBadMenuItem() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		MenuItem item2 = new MenuItem(2, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		//add non-menu item to special. Should throw error. Assert item2 is not in special.
		test.getManagerInterface().addItemToSpecial(spec, item2, 1);
		assertFalse(spec.getItem() == item2);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a null price.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToSpecialNullPrice() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		double ha = (Double) null;
		//add item with null price. Should throw error. Assert item was not set to special.
		test.getManagerInterface().addItemToSpecial(spec, item, ha);
		assertFalse(spec.getItem() == item);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with a negative price.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToSpecialNegativePrice() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		//add item with nrg price. Should throw error. Assert item was not set to special.
		test.getManagerInterface().addItemToSpecial(spec, item, 05);
		assertFalse(spec.getItem() == item);
	}
		

	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with an existing Special that has an item.
	 */
	@Test
	public void testRemoveItemFromSpecialGood() {
		//create special with good items.
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		//remove item from special, verify special's item is null
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with a special that has no item. Should throw an error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemoveItemFromSpecialBadNoItem() {
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		//try to remove again. Should throw error
		test.getManagerInterface().removeItemFromSpecial(spec);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with a special that that is not in the system.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemoveItemFromSpecialBadSpecial() {
		//create non-system special. Add system menu item 
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = new Special("Wings!");
		spec.addItemToSpecial(item, 5.00);
		//try to remove item from non-system special. Should throw error. Assert special not in system
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with a null param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemoveItemFromSpecialNullSpecial() {
		//just try to run with null param. Should throw error.
		test.getManagerInterface().removeItemFromSpecial(null);
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with an existing special.
	 */
	@Test
	public void testAddPizzaToSpecialGood() {
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		PizzaSize size2 = test.getManagerInterface().addPizzaSizeToMenu(11.00, "medium");
		Special spec = test.getManagerInterface().createSpecialWithPizza("pizza", size, 5.00);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getSize() == null);
		//add new size to special. Assert new size is recorded.
		test.getManagerInterface().addPizzaToSpecial(spec, size2, 7.00);
		assertTrue(spec.getSize() == size2);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a special not in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialBadSpecial() {
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		//create non-system special. Try adding system pizza size to non-system special. Should throw error.
		Special spec = new Special("Rawr");
		test.getManagerInterface().addPizzaToSpecial(spec, size, 5);
		//assert special not in system.
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null param. Should throw error.
	 * 
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialNullSpecial() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a pizza size that is not in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialBadPizza() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialNullPizza() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null price param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialNullPrice() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a negative price. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialNegativePrice() {
		
	}


	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testAddItemToMenuGood() {
		
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with a negative price param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuNegativeNumber() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with null price param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuNullNumber() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with empty string 1st param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuEmpty1stString() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with null string 1st param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuNull1stString() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with empty string 2nd param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuEmpty2ndString() {
		
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromMenu(model.MenuItem)}.
	 * Test with bull string 2nd param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemoveItemFromMenuNull2ndString() {
		
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenu() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testAddPizzaSizeToMenuGood() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a negative param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuNegNumber() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a null param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuNullNumber() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with an empty string. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuEmptyString() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a null string param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuNullString() {
		
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test remove with good params.
	 */
	@Test
	public void testRemovePizzaSizeFromMenuGood() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test with size that isn't in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaSizeFromMenuBadSize() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test with null param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaSizeFromMenuNullSize() {
		
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Add topping with good inputs.
	 */
	@Test
	public void testAddPizzaToppingToMenuGood() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with an empty first param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuEmpty1stString() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a null first param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuNull1stString() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with an empty 2nd string. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuEmpty2ndString() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a null 2nd string. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuNull2ndString() {
		
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with a topping that exists in the system.
	 */
	@Test
	public void testRemovePizzaToppingFromMenuGood() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with param of topping not in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaToppingFromMenuBadTopping() {
		
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with param of null topping. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaToppingFromMenuNullTopping() {
		
	}
}
