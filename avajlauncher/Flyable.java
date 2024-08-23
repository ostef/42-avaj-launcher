package avajlauncher;

public abstract class Flyable
{
    protected WeatherTower weatherTower;

    public void registerTower (WeatherTower tower)
    {
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
