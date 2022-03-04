import java.util.ArrayList;
import java.util.Random;

public class map
{
    private location a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t;
    public  location[] _locations = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t};
    private final ArrayList<location> _Map = new ArrayList<>();
    private final String[] _locationName = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};


    public map()
    {
        GenerateLocations();
        GenerateMap();
    }

    public void GenerateLocations()
    {
        for(int i = 0; i<_locations.length; i++)
        {
            _locations[i] = new location();
        }
    }

    public void GenerateMap()
    {
        for(int i = 0; i < _locations.length; i++) //adds locations to the map and gives it a name
        {
            _Map.add(_locations[i]);
            _locations[i]._locationName = _locationName[i];
        }

        for (int i = 0; i < _Map.size(); i++)  //connects the locations
        {
            Random randomLocation = new Random();
            int x = randomLocation.nextInt(20);
            if(x != i)
            {
                _Map.get(i)._connectedLocations.add(_locations[x]);
                _Map.get(x)._connectedLocations.add(_locations[i]);
            }
        }

        for( int i = 0; i < _Map.size(); i++) //parses out locations with more than 3 connected locations
        {
            if(_Map.get(i)._connectedLocations.size() > 3)
            {
                int _numOfConnectedLocations = 0;
                int _mostConnectedLocationIndex = -1;
                for(int a = 0; a < _Map.get(i)._connectedLocations.size(); a++)
                {
                    if(_Map.get(i)._connectedLocations.get(a)._connectedLocations.size() > _numOfConnectedLocations)
                    {
                        _numOfConnectedLocations = _Map.get(i)._connectedLocations.get(a)._connectedLocations.size();
                        _mostConnectedLocationIndex = a;
                    }
                }
                _Map.get(i)._connectedLocations.remove(_mostConnectedLocationIndex);
            }
        }

        for(int i = 0; i<3; i++) //sets 3 hives
        {
            if(_locations[i]._connectedLocations.size() > 3 )
            {
                _locations[i]._isHive = true;
            }
        }

        _locations[dice.RollDice(20)]._isExit = true; //sets one location at random to be the exit location
    }

}
