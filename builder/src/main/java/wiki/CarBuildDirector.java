package wiki;

public class CarBuildDirector {
    private CarBuilder builder;

    public CarBuildDirector(final CarBuilder builder) {
        this.builder = builder;
    }

    public Car construct() {
        return builder.setWheels(4)
                .setColor("Red")
                .build();
    }

    public static void main(final String[] arguments) {
        final CarBuilder carBuilder = new CarBuilderImpl();

        final CarBuildDirector carBuildDirector = new CarBuildDirector(carBuilder);

        System.out.println(carBuildDirector.construct());
    }

}
