import java.util.ArrayList;

public class location
{
    public ArrayList<location> _connectedLocations = new ArrayList<>();
    public String _locationName;
    public int _walkers;
    public int _fatties;
    public Boolean _hasPlayer;

    public int _BlockingEnemies;

    public int[] _item;
    public ArrayList<Integer> _weapon = new ArrayList<>();

    public location()
    {
        placeObjects();
    }

    private void placeObjects()
    {
        item _ItemList = new item();
        if(_connectedLocations.size() == 2)
        {
            _item = _ItemList._ListOfItems[dice.RollDice(_ItemList._ListOfItems.length)];
        }
        else if (_connectedLocations.size() == 1)
        {

        }
    }


}
