package avajlauncher;

public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates (int longitude, int latitude, int height)
    {
        longitude = longitude % 360;
        if (longitude < 0)
            longitude += 360;

        latitude = latitude % 180;
        if (latitude < 0)
            latitude += 180;

        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude () { return this.longitude; };
    public int getLatitude () { return this.latitude; };
    public int getHeight () { return this.height; };

    public void setLongitude (int value)
    {
        value = value % 360;
        if (value < 0)
            value += 360;

        this.longitude = value;
    }

    public void setLatitude (int value)
    {
        value = value % 180;
        if (value < 0)
            value += 180;

        this.latitude = value;
    }

    public void setHeight (int value)
    {
        this.height = value;
    }
}
