package avajlauncher;

public class Aircraft extends Flyable
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft (long id, String name, Coordinates coordinates)
    {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions ()
    {
        if (this.coordinates.getHeight () > 100)
            this.coordinates.setHeight (100);

        if (this.coordinates.getHeight () <= 0)
        {
            this.logMessage ("landing.");
            this.coordinates.setHeight (0);
            this.weatherTower.unregister (this);
        }
    }

    public String getType ()
    {
        return "Aircraft";
    }

    @Override
    public String getFullName ()
    {
        return this.getType () + "#" + this.name + "(" + this.id + ")";
    }

    protected void logMessage (String message)
    {
        System.out.println (this.getFullName () + " " + message);
    }

    @Override
    public Coordinates getCoordinates () { return this.coordinates; }
}
