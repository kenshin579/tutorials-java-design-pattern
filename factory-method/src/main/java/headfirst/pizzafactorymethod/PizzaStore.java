package headfirst.pizzafactorymethod;

public abstract class PizzaStore {
    /*
    Simple Factory와 비교해보면 PizzaStore가 abstract로 정의가 되어 있고
    orderPizza부붑은 동일하다.
    */

	abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
