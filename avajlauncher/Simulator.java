package avajlauncher;

import java.util.Random;

public class Simulator
{
    public static void main (String[] args)
    {
        WeatherTower tower = new WeatherTower ();

        Random rng = new Random (478975);

        for (int i = 0; i < 10; i += 1)
        {
            final String[] TYPES = {"Helicopter", "JetPlane", "Baloon"};

            Coordinates coordinates = new Coordinates (rng.nextInt (1000), rng.nextInt (1000), rng.nextInt (100));

            Flyable flyable = AircraftFactory.get ().newAircraft (TYPES[rng.nextInt (3)], "Aircraft", coordinates);
            tower.register (flyable);
        }

        for (int i = 0; i < 25; i += 1)
        {
            tower.changeWeather ();
        }
    }
}
