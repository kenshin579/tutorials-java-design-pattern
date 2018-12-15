package wiki;

public class CarBuilderImpl implements CarBuilder {
    private Car carTmp;

    public CarBuilderImpl() {
        carTmp = new Car();
    }

    @Override
    public Car build() {
        Car car = new Car();
        car.setColor(carTmp.getColor());
        car.setWheels(carTmp.getWheels());
        return car;
    }

    @Override
    public CarBuilder setColor(final String color) {
        carTmp.setColor(color);
        return this;
    }

    @Override
    public CarBuilder setWheels(final int wheels) {
        carTmp.setWheels(wheels);
        return this;
    }
}
