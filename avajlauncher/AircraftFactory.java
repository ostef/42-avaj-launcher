package avajlauncher;

import java.lang.IllegalArgumentException;

import avajlauncher.aircrafts.*;

public class AircraftFactory
{
    public static final String[] AIRCRAFT_TYPES = {
        "Helicopter", "JetPlane", "Baloon"
    };

    private static AircraftFactory instance;

    private long idCounter;

    private AircraftFactory () {}

    public static AircraftFactory get ()
    {
        if (instance == null)
            instance = new AircraftFactory ();

        return instance;
    }

    public Flyable newAircraft (String type, String name, Coordinates coordinates)
    {
        this.idCounter += 1;

        if (type.equals ("Helicopter"))
            return new Helicopter (this.idCounter, name, coordinates);
        if (type.equals ("JetPlane"))
            return new JetPlane (this.idCounter, name, coordinates);
        if (type.equals ("Baloon"))
            return new Baloon (this.idCounter, name, coordinates);

        throw new IllegalArgumentException ("Unknown aircraft type " + type);
    }
}

