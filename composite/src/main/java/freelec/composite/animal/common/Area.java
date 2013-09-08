package freelec.composite.animal.common;

public class Area {
    private String area;

    public Area(String area) {
        this.area = area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return this.area;
    }
}
