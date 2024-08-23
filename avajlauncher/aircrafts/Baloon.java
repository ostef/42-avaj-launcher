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
            super.logMessage ("Let's enjoy the good weather and take some pics.");
            break;

        case "RAIN":
            this.coordinates.setHeight (this.coordinates.getHeight () - 5);
            super.logMessage ("Damn you rain! You messed up my baloon.");
            break;

        case "FOG":
            this.coordinates.setHeight (this.coordinates.getHeight () - 3);
            super.logMessage ("Ain't gonna see nothin' with that fog.");
            break;

        case "SNOW":
            this.coordinates.setHeight (this.coordinates.getHeight () - 15);
            super.logMessage ("It's snowing. We're gonna crash!");
            break;
        }

        super.updateConditions ();
    }
}
