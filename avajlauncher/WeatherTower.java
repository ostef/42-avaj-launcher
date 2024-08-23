package avajlauncher;

public class WeatherTower extends Tower
{
    public WeatherTower ()
    {
        super ();
    }

    @Override
    public void register (Flyable flyable)
    {
        super.register (flyable);
        flyable.registerTower (this);
        System.out.println ("Tower says: " + flyable.getFullName () + " registered to weather tower.");
    }

    @Override
    public void unregister (Flyable flyable)
    {
        super.unregister (flyable);
        flyable.unregisterTower ();
        System.out.println ("Tower says: " + flyable.getFullName () + " unregistered from weather tower.");
    }

    public String getWeather (Coordinates coordinates)
    {
        return WeatherProvider.get ().getCurrentWeather (coordinates);
    }

    public void changeWeather ()
    {
        WeatherProvider.get ().randomizeSeed ();
        this.conditionChanged ();
    }
}
