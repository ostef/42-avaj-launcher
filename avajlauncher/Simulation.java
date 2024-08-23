package avajlauncher;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Simulation
{
    private WeatherTower tower;
    private int simulationCycles;

    private Simulation ()
    {
        this.tower = new WeatherTower ();
    }

    private void initFromFile (String filename) throws FileNotFoundException, IOException, ParseException
    {
        BufferedReader reader = new BufferedReader (new FileReader (filename));

        List<String> lines;

        try
        {
            String line = reader.readLine ();
            this.simulationCycles = Integer.parseInt (line);
        }
        catch (java.lang.NumberFormatException e)
        {
            throw new ParseException ("Could not parse cycle count number: " + e.getMessage ());
        }

        lines = reader.lines ().toList ();

        List<String> aircraft_types = Arrays.asList (AircraftFactory.AIRCRAFT_TYPES);
        List<String[]> line_tokens = new ArrayList<String[]> ();
        for (String line : lines)
        {
            String[] tokens = line.split ("\\s+");

            if (tokens.length != 5)
                throw new ParseException ("Invalid aircraft line, expected format TYPE NAME LONGITUDE LATITUDE HEIGHT got '" + line + "'");

            if (!aircraft_types.contains (tokens[0]))
                throw new ParseException ("Invalid aircraft type " + tokens[0]);

            try
            {
                Coordinates coords = new Coordinates (
                    Integer.parseInt (tokens[2]),
                    Integer.parseInt (tokens[3]),
                    Integer.parseInt (tokens[4])
                );
            }
            catch (java.lang.NumberFormatException e)
            {
                throw new ParseException ("Could not parse aircraft coordinates: " + line);
            }

            line_tokens.add (tokens);
        }

        for (String []tokens : line_tokens)
        {
            try
            {
                Coordinates coords = new Coordinates (
                    Integer.parseInt (tokens[2]),
                    Integer.parseInt (tokens[3]),
                    Integer.parseInt (tokens[4])
                );

                Flyable aircraft = AircraftFactory.get ().newAircraft (tokens[0], tokens[1], coords);
                this.tower.register (aircraft);
            }
            catch (Exception e)
            {
                throw new ParseException ("Could not create or register aircraft: " + e.getMessage ());
            }
        }
    }

    private void run ()
    {
        for (int i = 0; i < this.simulationCycles; i += 1)
        {
            this.tower.changeWeather ();
        }
    }

    public static void main (String[] args)
    {
        if (args.length < 1)
        {
            System.err.println ("Error: You need to provide a file to parse");
            System.exit (1);
        }

        if (args.length > 1)
        {
            System.err.println ("Error: Too many arguments");
            System.exit (1);
        }

        Simulation sim = new Simulation ();

        try
        {
            sim.initFromFile (args[0]);
        }
        catch (FileNotFoundException e)
        {
            System.err.println ("Error: Could not open file '" + args[0] + "'");
            System.exit (1);
        }
        catch (IOException e)
        {
            System.err.println ("IO Error: " + e.getMessage ());
            System.exit (1);
        }
        catch (ParseException e)
        {
            System.err.println ("Parse Error: " + e.getMessage ());
            System.exit (1);
        }

        sim.run ();
    }
}
