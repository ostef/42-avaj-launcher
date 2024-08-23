package avajlauncher;

import java.util.Random;

public class WeatherProvider
{
    public static final String[] WEATHERS = {
        "RAIN",
        "FOG",
        "SUN",
        "SNOW"
    };

    private static WeatherProvider instance;

    private String[] weather;
    private long seed;

    private WeatherProvider ()
    {
        this.seed = 1234567;
    }

    public static WeatherProvider get ()
    {
        if (instance == null)
            instance = new WeatherProvider ();

        return instance;
    }

    public void randomizeSeed ()
    {
        Random rng = new Random (this.seed);
        this.seed = rng.nextLong ();
    }

    public String getCurrentWeather (Coordinates coordinates)
    {
        long seed = this.seed * ((coordinates.getLongitude () * 1000 + coordinates.getLatitude ()) * 1000 + coordinates.getHeight ());

        Random rng = new Random (seed);
        int index = rng.nextInt (4);

        return this.WEATHERS[index];
    }
}
