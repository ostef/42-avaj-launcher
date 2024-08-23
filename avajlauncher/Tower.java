package avajlauncher;

import java.util.List;
import java.util.ArrayList;

public class Tower
{
    private List<Flyable> observers;

    protected Tower ()
    {
        this.observers = new ArrayList<Flyable> ();
    }

    public void register (Flyable flyable)
    {
        this.observers.add (flyable);
    }

    public void unregister (Flyable flyable)
    {
        this.observers.remove (flyable);
    }

    protected void conditionChanged ()
    {
        for (int i = 0; i < this.observers.size (); i += 1)
        {
            observers.get (i).updateConditions ();
        }
    }
}
