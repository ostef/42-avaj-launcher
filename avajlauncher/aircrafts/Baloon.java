package avajlauncher.aircrafts;

import avajlauncher.Coordinates;
import avajlauncher.Aircraft;

public class Baloon extends Aircraft
{
    public Baloon (long id, String name, Coordinates coordinates)
    {
        super (id, name, coordinates);
    }

    @Override
    public String getType ()
    {
        return "Baloon";
    }

    @Override
    public void updateConditions ()
    {
        String weather = this.weatherTower.getWeather (this.coordinates);

        switch (weather)
        {
        case "SUN":
            this.coordinates.setLongitude (this.coordinates.getLongitude () + 2);
            this.coordinates.setHeight (this.coordinates.getHeight () + 4);
            super.logMessage ("This is hot.");
            break;

        case "RAIN":
            this.coordinates.setHeight (this.coordinates.getHeight () - 5);
            super.logMessage ("It's rainin'!");
            break;

        case "FOG":
            this.coordinates.setHeight (this.coordinates.getHeight () - 3);
            super.logMessage ("Can't see sh*t in here!");
            break;

        case "SNOW":
            this.coordinates.setHeight (this.coordinates.getHeight () - 15);
            super.logMessage ("My rotor is going to freeze!");
            break;
        }

        super.updateConditions ();
    }
}
