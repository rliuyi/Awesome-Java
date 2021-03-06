package tutorials.jenkov.com.annotations;

public class Car {
    @JsonField("manufacturer")
    private final String make;

    @JsonField
    private final String model;

    private final String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
