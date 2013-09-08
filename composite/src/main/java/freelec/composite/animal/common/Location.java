package freelec.composite.animal.common;

public class Location {
    String location;

    public Location(String location) {
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return this.location;
    }
}
