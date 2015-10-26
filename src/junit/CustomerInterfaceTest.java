package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.PizzaSystem;
import model.ContactInfo;
import model.Customer;
import model.PizzaException;

public class CustomerInterfaceTest {
	
	private static PizzaSystem test;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new PizzaSystem();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		test.clearSystem();
	}

	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with good inputs.
	 */
	@Test
	public void testCreateNewCustProfileGood() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with an empty 1st string. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateNewCustProfileEmpty1st() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("", "Some place", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with null first param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateNewCustProfileNull1st() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile(null, "Some place", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with empty second param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateNewCustProfileEmpty2nd() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with null second param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateNewCustProfileNull2nd() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", null, "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with empty third param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateNewCustProfileEmpty3rd() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#createNewCustProfile(java.lang.String, java.lang.String, java.lang.String)}.
	 * Test with null third param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testCreateNewCustProfileNull3rd() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", null);
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	

	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerName(model.Customer, java.lang.String)}.
	 * Test with good params.
	 */
	@Test
	public void testEditCustomerNameGood() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerName(temp, "Wayne");
		assertTrue(temp.getName().equals("Wayne"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerName(model.Customer, java.lang.String)}.
	 * Test with a null customer param. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerNameNullCustomer() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerName(null, "Wayne");
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerName(model.Customer, java.lang.String)}.
	 * Test with a customer not in system. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerNameBadCustomer() throws PizzaException{
		Customer temp = new Customer("John", "Some place", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerName(temp, "Wayne");
		assertFalse(temp.getName().equals("Wayne"));
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerName(model.Customer, java.lang.String)}.
	 * Test with an empty string param. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerNameEmptyString() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerName(temp, "");
		assertTrue(temp.getName().equals("John"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerName(model.Customer, java.lang.String)}.
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerNameNullString() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerName(temp, null);
		assertTrue(temp.getName().equals("John"));
	}

	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerAddress(model.Customer, java.lang.String)}.
	 * Test with good inputs.
	 */
	@Test
	public void testEditCustomerAddressGood() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerAddress(temp, "this place");
		assertTrue(temp.getAddress().equals("this place"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerAddress(model.Customer, java.lang.String)}.
	 * Test with a null customer param. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerAddressNullCustomer() throws PizzaException{
		test.getCustomerInterface().editCustomerAddress(null, "this place");
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerAddress(model.Customer, java.lang.String)}.
	 * Test with a customer not in system. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerAddressBadCustomer() throws PizzaException{
		Customer temp = new Customer("John", "Some place", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerAddress(temp, "this place");
		assertFalse(temp.getAddress().equals("this place"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerAddress(model.Customer, java.lang.String)}.
	 * Test with a null string. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerAddressNullString() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerAddress(temp, null);
		assertFalse(temp.getAddress().equals("this place"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerAddress(model.Customer, java.lang.String)}.
	 * Test with an empty string. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerAddressEmptyString() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerAddress(temp, "");
		assertTrue(temp.getAddress().equals("Some place"));
	}

	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerPhone(model.Customer, java.lang.String)}.
	 * Test with good inputs.
	 */
	@Test
	public void testEditCustomerPhoneGood() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerPhone(temp, "this phone");
		assertTrue(temp.getPhone().equals("this phone"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerPhone(model.Customer, java.lang.String)}.
	 * Test with a non-system customer. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerPhoneBadCustomer() throws PizzaException{
		Customer temp = new Customer("John", "Some place", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerPhone(temp, "this phone");
		assertFalse(temp.getPhone().equals("this phone"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerPhone(model.Customer, java.lang.String)}.
	 * Test with a null customer. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerPhoneNullCustomer() throws PizzaException{
		test.getCustomerInterface().editCustomerPhone(null, "this phone");
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerPhone(model.Customer, java.lang.String)}.
	 * Test with an empty string param.
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerPhoneEmptyString() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerPhone(temp, "");
		assertTrue(temp.getPhone().equals("phone"));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#editCustomerPhone(model.Customer, java.lang.String)}.
	 * Test with a null string param. Expect error
	 */
	@Test(expected=model.PizzaException.class)
	public void testEditCustomerPhoneNullString() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().editCustomerPhone(temp, null);
		assertTrue(temp.getPhone().equals("phone"));
	}

	/**
	 * Test method for {@link controller.CustomerInterface#addNewContactInfo(model.Customer, model.ContactInfo)}.
	 * Test with good params.
	 */
	@Test
	public void testAddNewContactInfoGood() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		ContactInfo ci = new ContactInfo();
		test.getCustomerInterface().addNewContactInfo(temp, ci);
		assertTrue(temp.getContactInfo().equals(ci));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#addNewContactInfo(model.Customer, model.ContactInfo)}.
	 * Test with non-system customer. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddNewContactInfoBadCustomer() throws PizzaException{
		Customer temp = new Customer("John", "Some place", "phone");
		assertFalse(test.getPizzaStore().getCustomers().contains(temp));
		ContactInfo ci = new ContactInfo();
		test.getCustomerInterface().addNewContactInfo(temp, ci);
		assertFalse(temp.getContactInfo().equals(ci));
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#addNewContactInfo(model.Customer, model.ContactInfo)}.
	 * Test with null customer param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddNewContactInfoNullCustomer() throws PizzaException{
		ContactInfo ci = new ContactInfo();
		test.getCustomerInterface().addNewContactInfo(null, ci);
	}
	
	/**
	 * Test method for {@link controller.CustomerInterface#addNewContactInfo(model.Customer, model.ContactInfo)}.
	 * Test with null ContactInfo param. Expect error.
	 */
	@Test(expected=model.PizzaException.class)
	public void testAddNewContactInfoNullCI() throws PizzaException{
		Customer temp = test.getCustomerInterface().createNewCustProfile("John", "Some place", "phone");
		assertTrue(test.getPizzaStore().getCustomers().contains(temp));
		test.getCustomerInterface().addNewContactInfo(temp, null);
	}
}
