package avajlauncher.aircrafts;

import avajlauncher.Coordinates;
import avajlauncher.Aircraft;

public class JetPlane extends Aircraft
{
    public JetPlane (long id, String name, Coordinates coordinates)
    {
        super (id, name, coordinates);
    }

    @Override
    public String getType ()
    {
        return "JetPlane";
    }

    @Override
    public void updateConditions ()
    {
        String weather = this.weatherTower.getWeather (this.coordinates);

        switch (weather)
        {
        case "SUN":
            this.coordinates.setLatitude (this.coordinates.getLatitude () + 10);
            this.coordinates.setHeight (this.coordinates.getHeight () + 2);
            super.logMessage ("This is hot.");
            break;

        case "RAIN":
            this.coordinates.setLatitude (this.coordinates.getLatitude () + 5);
            super.logMessage ("It's rainin'!");
            break;

        case "FOG":
            this.coordinates.setLatitude (this.coordinates.getLatitude () + 1);
            super.logMessage ("Can't see sh*t in here!");
            break;

        case "SNOW":
            this.coordinates.setHeight (this.coordinates.getHeight () - 7);
            super.logMessage ("My rotor is going to freeze!");
            break;
        }

        super.updateConditions ();
    }
}
