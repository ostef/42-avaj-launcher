package avajlauncher;

import java.lang.IllegalArgumentException;

public abstract class Flyable
{
    protected WeatherTower weatherTower;

    public void registerTower (WeatherTower tower)
    {
        if (tower == null)
            throw new IllegalArgumentException ("tower is null");

        this.weatherTower = tower;
    }

    public void unregisterTower ()
    {
        this.weatherTower = null;
    }

    public abstract void updateConditions ();

    public abstract String getFullName ();
    public abstract Coordinates getCoordinates ();
}
