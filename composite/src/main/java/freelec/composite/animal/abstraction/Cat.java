package freelec.composite.animal.abstraction;

import freelec.composite.animal.common.Area;
import freelec.composite.animal.common.Location;

public interface Cat {
    public void setArea(Area area);

    public void setLocation(Location location);

    public void setLife(int life);

    public void setSize(int size);

    public Area getArea();

    public Location getLocation();

    public int getLife();

    public int getSize();
}
