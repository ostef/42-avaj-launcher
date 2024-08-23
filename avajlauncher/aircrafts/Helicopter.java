package avajlauncher.aircrafts;

import avajlauncher.Coordinates;
import avajlauncher.Aircraft;

public class Helicopter extends Aircraft
{
    public Helicopter (long id, String name, Coordinates coordinates)
    {
        super (id, name, coordinates);
    }

    @Override
    public String getType ()
    {
        return "Helicopter";
    }

    @Override
    public void updateConditions ()
    {
        String weather = this.weatherTower.getWeather (this.coordinates);

        switch (weather)
        {
        case "SUN":
            this.coordinates.setLongitude (this.coordinates.getLongitude () + 10);
            this.coordinates.setHeight (this.coordinates.getHeight () + 2);
            super.logMessage ("This is hot.");
            break;

        case "RAIN":
            this.coordinates.setLongitude (this.coordinates.getLongitude () + 5);
            super.logMessage ("It's rainin'!");
            break;

        case "FOG":
            this.coordinates.setLongitude (this.coordinates.getLongitude () + 1);
            super.logMessage ("Can't see sh*t in here!");
            break;

        case "SNOW":
            this.coordinates.setHeight (this.coordinates.getHeight () - 12);
            super.logMessage ("My rotor is going to freeze!");
            break;
        }

        super.updateConditions ();
    }
}
