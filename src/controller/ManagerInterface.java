package controller;

import model.*;

public class ManagerInterface {

	private PizzaSystem parentSystem;

	public ManagerInterface(PizzaSystem system) {
		this.parentSystem = system;
	}

	public Menu createNewMenu() {
		// TODO GUI TO VERIFY
		return new Menu();
	}

	public void clearWholeMenu() {
		parentSystem.getPizzaStore().setMenu(new Menu());
	}

	public Special createSpecialWithItem(String name, MenuItem item, double price) throws PizzaException {
		Special temp = new Special(name.trim());
		if ((name.trim() == ("")) || (name == null) || (item == null) || (price < 0)|| ((Double) price == null)) {
			throw new PizzaException("Incorrect parameter createSpecialWithItem(<" + name.trim() + ">:String, <"
						+ item.getName() + ">:MenuItem, <" + price + ">:double)");
		} else {
			//if special exists in system already, find it, replace the name
			if (parentSystem.getPizzaStore().checkSpecialsForItem(item)){
				temp = parentSystem.getPizzaStore().findSpecialByItem(item);
				temp.setSpecialName(name);
				temp.setSpecialPrice(price);
			}
			else {
				temp.addItemToSpecial(item, price);
				parentSystem.getPizzaStore().getSpecials().add(temp);
			}
		}
		return temp;
	}

	public Special createSpecialWithPizza(String name, PizzaSize size, double price) throws PizzaException {
		Special temp = new Special(name);
		if ((name.trim() == ("")) || (name == null) || (size == null)
				|| !(parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(size)) || (price < 0)
				|| ((Double) price == null)) {
			throw new PizzaException("Incorrect parameter createSpecialWithPizza(<" + name.trim() + ">:String, <"
						+ size.getDesc() + ">:PizzaSize, <" + price + ">:double)");
		} else {
			//if special exists for size already, set that special's name to the new name.
			if (parentSystem.getPizzaStore().checkSpecialsForPizzaSize(size)){
				temp = parentSystem.getPizzaStore().findSpecialBySize(size);
				temp.setSpecialName(name);
			}
			else {
				temp.addPizzaToSpecial(size, price);
				parentSystem.getPizzaStore().getSpecials().add(temp);
			}
		}
		return temp;
	}

	public Special addItemToSpecial(Special special, MenuItem item, double price) throws PizzaException {
		if ((special == null) || !(parentSystem.getPizzaStore().getSpecials().contains(special)) || (item == null)
				|| !(parentSystem.getPizzaStore().getMenu().getMenuItems().contains(item)) || (price < 0)
				|| ((Double) price == null)) {
			throw new PizzaException("Incorrect parameter addItemToSpecial(<" + special.getSpecialName()
						+ ">:Special, <" + item.getDesc() + ">:MenuItem, <" + price + ">:double)");
		} else {
			// Given good params and doesn't already have item
			if (special.getItem() == null) {
				item.setPrice(price);
				special.addItemToSpecial(item, price);
				return special;
			}
			// Given good params but already has item. Create new special, add
			// to specials
			else {
				Special temp = new Special(special.getSpecialName());
				temp.addItemToSpecial(item, price);
				parentSystem.getPizzaStore().getSpecials().add(temp);
				return temp;
			}
		}
	}

	public void removeItemFromSpecial(Special special) throws PizzaException {
		if (!(parentSystem.getPizzaStore().getSpecials().contains(special)) || (special == null) || (special.getItem() == null)) {
			throw new PizzaException("Incorrect parameter removeItemFromSpecial(<" + special.getSpecialName() + ">:Special)");
		} else {
			special.removeItemFromSpecial();
		}
	}	

	public void modifySpecialPrice(Special special, double price) throws PizzaException {
		if (!(parentSystem.getPizzaStore().getSpecials().contains(special)) || (special == null) || (special.getItem() == null) || (price < 0) || (Double)price == null) {
			throw new PizzaException("Incorrect parameter removeItemFromSpecial(<" + special.getSpecialName() + ">:Special)");
		} else {
			special.setSpecialPrice(price);
		}	
	}

	public Special addPizzaToSpecial(Special special, PizzaSize size, double price) throws PizzaException {
		if ((special == null) || !(parentSystem.getPizzaStore().getSpecials().contains(special)) || (size == null)
				|| !(parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(size)) || (price < 0)
				|| ((Double) price == null)) {
			throw new PizzaException("Incorrect parameter addPizzaToSpecial(<" + special.getSpecialName()
						+ ">:Special, <" + size.getDesc() + ">:PizzaSize, <" + price + ">:double)");
		} else {
			if (special.getSize() == null) {
				size.setPrice(price);
				special.addPizzaToSpecial(size, price);
				return special;
			} else {
				Special temp = new Special("WILL GET FROM GUI");
				temp.addPizzaToSpecial(size, price);
				// TODO GUI POPUP giving options for making a new special
				// make the special using createSpecialWithPizza.
				return temp;
			}
		}
	}

	public void removePizzaFromSpecial(Special special) throws PizzaException {
		if ((special == null) || !(parentSystem.getPizzaStore().getSpecials().contains(special))) {
			throw new PizzaException("Incorrect parameter removePizzaFromSpecial(<" 
					+ special.getSpecialName() + ">:Special)");
		} else {
			special.removePizzaSizeFromSpecial();
		}
	}

	public MenuItem addItemToMenu(double price, String name, String desc) throws PizzaException{
		if ((name == null) || (name.trim() == "") || (price < 0) || ((Double) price == null) || (desc == null)) {
			throw new PizzaException("Incorrect parameter addItemToSpecial(<" + name + ">:String, <" + desc
						+ ">:String, <" + price + ">:double)");
		} else {
			MenuItem temp = new MenuItem(price, name, desc);
			if (!parentSystem.getPizzaStore().getMenu().getMenuItems().contains(temp)) {
				parentSystem.getPizzaStore().getMenu().getMenuItems().add(temp);
				return temp;
			} else {
				throw new PizzaException("Item being added to menu is already in system.");
			}
		}
	}

	public void removeItemFromMenu(MenuItem item) throws PizzaException{
		if (!(parentSystem.getPizzaStore().getMenu().getMenuItems().contains(item)) || (item == null)) {
			throw new PizzaException("Incorrect parameter removeItemFromMenu(<" + item.getDesc() + ">:Item)");
		} else {
			parentSystem.getPizzaStore().getMenu().getMenuItems().remove(item);
		}
	}

	public PizzaSize addPizzaSizeToMenu(double price, String desc) throws PizzaException{
		PizzaSize temp = new PizzaSize(price, desc);
		if (!parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(temp) && (price > 0) && !(desc.trim() == "")) {
			parentSystem.getPizzaStore().getMenu().getPizzaSizes().add(temp);
			return temp;
		} else {
			throw new PizzaException("Pizza size already in system. addPizzaSizeToMenu(double price, String desc)");
		}
	}

	public void removePizzaSizeFromMenu(PizzaSize ps) throws PizzaException{
		if (parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(ps)) {
			parentSystem.getPizzaStore().getMenu().getPizzaSizes().remove(ps);
		} 
		else {
			throw new PizzaException("Pizza size not in system. removePizzaSizeFromMenu(PizzaSize ps)");
		}
	}

	public PizzaTopping addPizzaToppingToMenu(String name, String desc) throws PizzaException {
		PizzaTopping temp = new PizzaTopping(name, desc);
		if ((parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(temp)) || (name == null)
				|| (name.trim() == "") || (desc == null)) {
			throw new PizzaException("Incorrect parameter. addPizzaToppingToMenu(String name, String desc)");
		} else {
			if (parentSystem.getPizzaStore().getMenu().getPizzaToppings().contains(temp)) {
				removePizzaToppingFromMenu(temp);
			}
			parentSystem.getPizzaStore().getMenu().getPizzaToppings().add(temp);
			return temp;
		}
	}

	public void removePizzaToppingFromMenu(PizzaTopping pt) throws PizzaException {
		if (!(parentSystem.getPizzaStore().getMenu().getPizzaToppings().contains(pt)) || (pt == null)) {
			throw new PizzaException("Incorrect parameter. addPizzaToppingToMenu(String name, String desc)");
		} else {
			parentSystem.getPizzaStore().getMenu().getPizzaToppings().remove(pt);
		}
	}
}
