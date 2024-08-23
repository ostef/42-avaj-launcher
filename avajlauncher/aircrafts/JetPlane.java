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
            super.logMessage ("Let's fly into the sun cuz why not.");
            break;

        case "RAIN":
            this.coordinates.setLatitude (this.coordinates.getLatitude () + 5);
            super.logMessage ("It's rainining. Better watch out for thunder.");
            break;

        case "FOG":
            this.coordinates.setLatitude (this.coordinates.getLatitude () + 1);
            super.logMessage ("It's getting foggy.");
            break;

        case "SNOW":
            this.coordinates.setHeight (this.coordinates.getHeight () - 7);
            super.logMessage ("OMG! Winter is coming!");
            break;
        }

        super.updateConditions ();
    }
}
