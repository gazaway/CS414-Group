package junit;

import static org.junit.Assert.*;

import model.MenuItem;
import model.PizzaException;
import model.PizzaSize;
import model.PizzaTopping;
import model.Special;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.PizzaSystem;


public class ManagerInterfaceTest {
	
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
		test.getManagerInterface().createNewMenu();
		//create menu second time. 
		test.getManagerInterface().createNewMenu();
	}

	/**
	 * Test method for {@link controller.ManagerInterface#clearWholeMenu()}.
	 * Test case for clear menu with menu already in place.
	 */
	@Test
	public void testClearWholeMenuGood() throws PizzaException{
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
	 * Test case for clear menu when already clear menu exists. Should simply replace.
	 */
	@Test
	public void testClearWholeMenuBad() {
		//just clear it before there is a menu
		test.getManagerInterface().clearWholeMenu();
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test method with good environment and good parameters.
	 */
	@Test
	public void testCreateSpecialWithItemGood() throws PizzaException{
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
	@Test(expected=NullPointerException.class)
	public void testCreateSpecialWithItemNullString() throws PizzaException{
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
	@Test(expected=NullPointerException.class)
	public void testCreateSpecialWithItemNullMenuItem() throws PizzaException{
		//create special with null item. Should throw error. Assert it is not contained in specials.
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", null, 2.00);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithItem(java.lang.String, model.MenuItem, double)}.
	 * Test createSpecialWithItem with a null price. Should return error.
	 */
	@Test(expected=NullPointerException.class)
	public void testCreateSpecialWithItemNullPrice() throws PizzaException{
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
	public void testCreateSpecialWithItemNegativePrice() throws PizzaException{
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
	public void testCreateSpecialWithItemDuplicateItem() throws PizzaException{
		//create two specials with the same item. 
		MenuItem item = test.getManagerInterface().addItemToMenu(5.00, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 10.00);
		Special spec2 = test.getManagerInterface().createSpecialWithItem("CHEAP WINGS", item, 2.00);
		//assert that spec2 is NOT in the store specials.
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
		//assert that spec has spec2's pricing and name
		assertTrue(spec.getSpecialName().equals(spec2.getSpecialName()));
		assertTrue(spec.getSpecialPrice() == spec2.getSpecialPrice());
	}

	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Create a pizza special in a good, clean enviroment.
	 */
	@Test
	public void testCreateSpecialWithPizzaWithPizzaGood() throws PizzaException{
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", small, 3);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null string. Should return error.
	 */
	@Test(expected=NullPointerException.class)
	public void testCreateSpecialWithPizzaNullString() throws PizzaException{
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		//create special with null name. Should return error. Assert special is not contained.
		Special spec = test.getManagerInterface().createSpecialWithPizza(null, small, 3);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null PizzaSize. Should return error.
	 */
	@Test(expected=NullPointerException.class)
	public void testCreateSpecialWithPizzaNullPizzaSize() throws PizzaException{
		//Try to create with null size. Should throw error. Assert not in store specials.
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", null, 3);
		assertFalse(test.getPizzaStore().getSpecials().contains(spec));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#createSpecialWithPizza(java.lang.String, model.PizzaSize, double)}.
	 * Test createSpecialWithPizza with a null price. Should return error.
	 */
	@Test(expected=NullPointerException.class)
	public void testCreateSpecialWithPizzaNullPrice() throws PizzaException{
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
	public void testCreateSpecialWithPizzaNegativePrice() throws PizzaException{
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
	@Test
	public void testCreateSpecialWithPizzaDuplicatePizza() throws PizzaException{
		PizzaSize small = test.getManagerInterface().addPizzaSizeToMenu(11.00, "small");
		Special spec = test.getManagerInterface().createSpecialWithPizza("Cheap small", small, 10);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
		//create second special with same size. Assert that new special is not contained in specials
		Special spec2 = test.getManagerInterface().createSpecialWithPizza("Actually cheap small", small, 3);
		assertTrue(test.getPizzaStore().getSpecials().contains(spec));
		System.out.println(spec.getSpecialName());
		//assert that first special name and price changed to second special's
		assertTrue(spec.getSpecialPrice() == spec2.getSpecialPrice());
		assertTrue(spec.getSpecialName().equals(spec2.getSpecialName()));
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToSpecial(model.Special, model.MenuItem, double)}.
	 * Test with an existing special, existing MenuItem, good price.
	 */
	@Test
	public void testAddItemToSpecialGood() throws PizzaException{
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
	public void testAddItemToSpecialBadSpecial() throws PizzaException{
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
	@Test(expected=NullPointerException.class)
	public void testAddItemToSpecialNullSpecial() throws PizzaException{
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
	public void testAddItemToSpecialBadMenuItem() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		MenuItem item2 = new MenuItem(2, "Wings!", "Wings!");
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
	@Test(expected=NullPointerException.class)
	public void testAddItemToSpecialNullPrice() throws PizzaException{
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
	public void testAddItemToSpecialNegativePrice() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(7, "Wings", "Wings");
		Special spec = test.getManagerInterface().createSpecialWithItem("Wings!", item, 5);
		test.getManagerInterface().removeItemFromSpecial(spec);
		assertTrue(spec.getItem()== null);
		//add item with nrg price. Should throw error. Assert item was not set to special.
		test.getManagerInterface().addItemToSpecial(spec, item, -5);
		assertFalse(spec.getItem() == item);
	}
		

	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromSpecial(model.Special)}.
	 * Test with an existing Special that has an item.
	 */
	@Test
	public void testRemoveItemFromSpecialGood() throws PizzaException{
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
	public void testRemoveItemFromSpecialBadNoItem() throws PizzaException{
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
	public void testRemoveItemFromSpecialBadSpecial() throws PizzaException{
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
	@Test(expected=NullPointerException.class)
	public void testRemoveItemFromSpecialNullSpecial() throws PizzaException{
		//just try to run with null param. Should throw error.
		test.getManagerInterface().removeItemFromSpecial(null);
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with an existing special.
	 */
	@Test
	public void testAddPizzaToSpecialGood() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		PizzaSize size2 = test.getManagerInterface().addPizzaSizeToMenu(11.00, "medium");
		Special spec = test.getManagerInterface().createSpecialWithPizza("pizza", size, 5.00);
		test.getManagerInterface().removePizzaFromSpecial(spec);
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
	public void testAddPizzaToSpecialBadSpecial() throws PizzaException{
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
	@Test(expected=NullPointerException.class)
	public void testAddPizzaToSpecialNullSpecial() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		//attempt to add pizza to null special. Should result in error.
		test.getManagerInterface().addPizzaToSpecial(null, size, 10);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a pizza size that is not in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialBadPizza() throws PizzaException{
		PizzaSize size = new PizzaSize(2, "desc");
		PizzaSize size2 = test.getManagerInterface().addPizzaSizeToMenu(5.0, "large");
		//create special with good size
		Special spec = test.getManagerInterface().createSpecialWithPizza("string", size2, 5);
		//remove good size, try to add bad size. assert size not in special.
		test.getManagerInterface().removePizzaFromSpecial(spec);
		test.getManagerInterface().addPizzaToSpecial(spec, size, 10);
		assertFalse(spec.getSize() == size);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null param. Should throw error.
	 */
	@Test(expected=NullPointerException.class)
	public void testAddPizzaToSpecialNullPizza() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(5.0, "large");
		Special spec = test.getManagerInterface().createSpecialWithPizza("bah", size, 5);
		//remove pizza size from special. add null size. Should throw error
		test.getManagerInterface().removePizzaFromSpecial(spec);
		test.getManagerInterface().addPizzaToSpecial(spec, null, 5);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a null price param. Should throw error.
	 */
	@Test(expected=NullPointerException.class)
	public void testAddPizzaToSpecialNullPrice() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(5.0, "large");
		Special spec = test.getManagerInterface().createSpecialWithPizza("bah", size, 5);
		//remove pizza size from special. 
		test.getManagerInterface().removePizzaFromSpecial(spec);
		//try to add pizza to special with null price. Should throw error. Assert size not added
		double ba = (Double) null;
		test.getManagerInterface().addPizzaToSpecial(spec, size, ba);
		assertFalse(spec.getSize() == size);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToSpecial(model.Special, model.PizzaSize, double)}.
	 * Test with a negative price. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToSpecialNegativePrice() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(5.0, "large");
		Special spec = test.getManagerInterface().createSpecialWithPizza("bah", size, 5);
		//remove pizza size from special. 
		test.getManagerInterface().removePizzaFromSpecial(spec);
		//try to add pizza to special with neg price. Should throw error. Assert size not added
		test.getManagerInterface().addPizzaToSpecial(spec, size, -10);
		assertFalse(spec.getSize() == size);
	}


	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testAddItemToMenuGood() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(5, "chicken", "chicken");
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with a negative price param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuNegativeNumber() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(-10, "chicken", "chicken");
		assertFalse(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with null price param. Should throw error.
	 */
	@Test(expected=NullPointerException.class)
	public void testAddItemToMenuNullNumber() throws PizzaException{
		double ba = (Double) null;
		MenuItem item = test.getManagerInterface().addItemToMenu(ba, "chicken", "chicken");
		assertFalse(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with empty string 1st param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuEmpty1stString() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(5, "", "chicken");
		assertFalse(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with item already in system
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuDuplicate() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(5, "chicken", "chicken");
		MenuItem item2 = test.getManagerInterface().addItemToMenu(5, "chicken", "chicken");
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with null string 1st param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuNull1stString() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(5, null, "chicken");
		assertFalse(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addItemToMenu(double, java.lang.String, java.lang.String)}.
	 * Test with empty string 2nd param. Should be allowed, simply item with no description
	 */
	@Test
	public void testAddItemToMenuEmpty2ndString() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(5, "chicken", "");
		assertTrue(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removeItemFromMenu(model.MenuItem)}.
	 * Test with null string 2nd param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddItemToMenuNull2ndString() throws PizzaException{
		MenuItem item = test.getManagerInterface().addItemToMenu(5, "chicken", null);
		assertFalse(test.getPizzaStore().getMenu().getMenuItems().contains(item));
	}

	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testAddPizzaSizeToMenuGood() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		assertTrue(test.getPizzaStore().getMenu().getPizzaSizes().contains(size));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a negative param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuNegNumber() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(-7.00, "small");
		assertFalse(test.getPizzaStore().getMenu().getPizzaSizes().contains(size));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a null param. Should throw error.
	 */
	@Test(expected=NullPointerException.class)
	public void testAddPizzaSizeToMenuNullNumber() throws PizzaException{
		double ba = (Double) null;
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(ba, "small");
		assertFalse(test.getPizzaStore().getMenu().getPizzaSizes().contains(size));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with an empty string. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuEmptyString() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "");
		assertFalse(test.getPizzaStore().getMenu().getPizzaSizes().contains(size));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaSizeToMenu(double, java.lang.String)}.
	 * Test with a null string param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaSizeToMenuNullString() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(-7.00, null);
		assertFalse(test.getPizzaStore().getMenu().getPizzaSizes().contains(size));
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test remove with good params.
	 */
	@Test
	public void testRemovePizzaSizeFromMenuGood() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		test.getManagerInterface().removePizzaSizeFromMenu(size);
		assertFalse(test.getPizzaStore().getMenu().getPizzaSizes().contains(size));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test with size that isn't in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaSizeFromMenuBadSize() throws PizzaException{
		PizzaSize size = test.getManagerInterface().addPizzaSizeToMenu(7.00, "small");
		PizzaSize size2 = new PizzaSize(1, "");
		test.getManagerInterface().removePizzaSizeFromMenu(size2);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaSizeFromMenu(model.PizzaSize)}.
	 * Test with null param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaSizeFromMenuNullSize() throws PizzaException{
		test.getManagerInterface().removePizzaSizeFromMenu(null);
	}

	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Add topping with good inputs.
	 */
	@Test
	public void testAddPizzaToppingToMenuGood() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu("Bacon", "Bacon");
		assertTrue(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with an empty first param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuEmpty1stString() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu("", "Bacon");
		assertFalse(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a null first param. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuNull1stString() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu(null, "Bacon");
		assertFalse(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with an empty 2nd string. Should allow, simply topping with no description.
	 */
	@Test
	public void testAddPizzaToppingToMenuEmpty2ndString() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu("Bacon", "");
		assertTrue(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a null 2nd string. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddPizzaToppingToMenuNull2ndString() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu("Bacon", null);
		assertFalse(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#addPizzaToppingToMenu(java.lang.String, java.lang.String)}.
	 * Test with a pizza topping that is already in the menu. should allow, simply replace description with new.
	 */
	@Test
	public void testAddPizzaToppingToMenuDuplicate() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu("Bacon", "Bacon");
		PizzaTopping top2 = test.getManagerInterface().addPizzaToppingToMenu("Bacon", "Gourmet Bacon");
		assertTrue(test.getPizzaStore().getMenu().getPizzaToppings().contains(top2));
	}

	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with a topping that exists in the system.
	 */
	@Test
	public void testRemovePizzaToppingFromMenuGood() throws PizzaException{
		PizzaTopping top = test.getManagerInterface().addPizzaToppingToMenu("Bacon", "Bacon");
		assertTrue(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
		test.getManagerInterface().removePizzaToppingFromMenu(top);
		assertFalse(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with param of topping not in system. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaToppingFromMenuBadTopping() throws PizzaException{
		PizzaTopping top = new PizzaTopping("Bacon", "Bacon");
		//assert top is not in system. attempt to remove top from system. Should throw error
		assertFalse(test.getPizzaStore().getMenu().getPizzaToppings().contains(top));
		test.getManagerInterface().removePizzaToppingFromMenu(top);
	}
	
	/**
	 * Test method for {@link controller.ManagerInterface#removePizzaToppingFromMenu(model.PizzaTopping)}.
	 * Test with param of null topping. Should throw error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testRemovePizzaToppingFromMenuNullTopping() throws PizzaException{
		test.getManagerInterface().removePizzaToppingFromMenu(null);
	}
}
