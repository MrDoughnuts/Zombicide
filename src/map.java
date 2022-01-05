import java.util.ArrayList;
import java.util.Random;

public class map
{
    private location a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t;
    private final location[] _locations = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t};
    private final ArrayList<location> _Map = new ArrayList<>();
    private final String[] _locationName = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};


    public map()
    {
        GenerateLocations();
        GenerateMap();
    }

    public void GenerateLocations()
    {
        for(location i : _locations)
        {
            i = new location();
        }
    }

    public void GenerateMap()
    {
        for(int i = 0; i < _locations.length; i++)
        {
            _Map.add(_locations[i]);
            _locations[i]._locationName = _locationName[i];
        }

        for (int i = 0; i < _Map.size(); i++)
        {
            Random randomLocation = new Random();
            int x = randomLocation.nextInt(20);
            if(x != i)
            {
                _Map.get(i)._connectedLocations.add(_locations[x]);
                _Map.get(x)._connectedLocations.add(_locations[i]);
            }
        }

        for( int i = 0; i < _Map.size(); i++)
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
    }

}
