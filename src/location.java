import java.util.ArrayList;

public class location
{
    public ArrayList<location> _connectedLocations = new ArrayList<>();
    public String _locationName;
    public int _walkers;
    public int _fatties;
    public Boolean _hasPlayer;

    public int _BlockingEnemies;

    public location()
    {
        placeObjects();
    }

    private void placeObjects()
    {

    }


}
