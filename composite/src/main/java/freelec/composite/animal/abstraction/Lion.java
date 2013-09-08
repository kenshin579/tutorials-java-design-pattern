package freelec.composite.animal.abstraction;

import freelec.composite.animal.common.Area;
import freelec.composite.animal.common.Location;

public class Lion implements Cat {

    private Area area;
    private Location location;
    private int life;
    private int size;

    public Lion(Area area, Location location, int life, int size) {
        this.area = area;
        this.location = location;
        this.life = life;
        this.size = size;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
