package headfirst.pizzasimple;

public class PizzaTestDrive {

    public static void main(String[] args) {
        // SimplePizzaFactory 객체를 생성만 함 (동작은 없음)
        SimplePizzaFactory factory = new SimplePizzaFactory();
        // PizzaStore 객체만 생성함 (초기화)
        PizzaStore store = new PizzaStore(factory);

        // 실제 동작이 이루어짐
        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");

        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "\n");
    }
}
