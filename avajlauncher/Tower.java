package avajlauncher;

import java.lang.IllegalArgumentException;
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
        if (flyable == null)
            throw new IllegalArgumentException ("Registering null flyable");

        if (this.observers.contains (flyable))
            throw new IllegalArgumentException ("Registering flyable " + flyable.getFullName () + " to tower but it is already registered");

        this.observers.add (flyable);
    }

    public void unregister (Flyable flyable)
    {
        if (!this.observers.contains (flyable))
            throw new IllegalArgumentException ("Unregistering flyable " + flyable.getFullName () + " to tower but it is not registered");

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
