package avajlauncher;

import java.lang.Exception;

public class ParseException extends Exception
{
    public ParseException () { super (); }
    public ParseException (String message) { super (message); }
    public ParseException (Throwable exception) { super (exception); }
}
