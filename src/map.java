import java.util.ArrayList;
import java.util.Random;

public class map
{
    private location a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t = new location();
    private location[] _locations = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t};
    private ArrayList<location> _Map = new ArrayList<>();
    private String[] _locationName = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};

    public map()
    {

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
            if(randomLocation.nextInt() != i)
            {
                _Map.get(i)._connectedLocations.add(_locations[i]);
            }
        }
    }

}
