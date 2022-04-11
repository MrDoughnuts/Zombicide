import java.util.ArrayList;
import java.util.Random;

public class map
{
    private location a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t;
    public  location[] _locations = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t};
    private final ArrayList<location> _Map = new ArrayList<>();
    private final String[] _locationName = {"A High School","Hospital","Police Station","Cookie Factory","Hotel","Skate Park",
                                            "Playground","Shooting Range","Mall","Grocery Store","Lamp Shop",
                                            "GameStop","7-Eleven","McDonald's","Taco Bell","Bar","Stadium","Race track",
                                            "Military base","KFC"};


    public map()
    {
        GenerateLocations();
        GenerateMap();
    }

    public void GenerateLocations()
    {
        for(int i = 0; i<_locations.length; i++)
        {
            _locations[i] = new location(_locationName[i]);

        }
    }

    public void GenerateMap()
    {
        for(int i = 0; i < _locations.length; i++) //adds locations to the map
        {
            _Map.add(_locations[i]);
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

        int i = 0;
        do
        {
            int x = dice.RollDice(20);
                i++;
                _locations[x]._isHive = true;
        }while(i<3);


        for(location l: _locations)
        {
            l.placeObjects();
        }

    }

    public void SetExit()
    {
        _locations[dice.RollDice(20)]._isExit = true; //sets one location at random to be the exit location
    }

    public void SetSurvivor()
    {
        _locations[dice.RollDice(20)]._hasSurvivor = true; //sets one location at random to be the exit location

    }

    public void DisplayMap()
    {
        for(location l: _locations)
        {
            System.out.println(l._locationName + " walkers: " + l._walkers + " fatties: " + l._fatties + " is hive: "
                            + l._isHive + " Has player: " + l._hasPlayer + " is exit: " + l._isExit +
                            " weapon: " + l._Weapon._WeaponName +  " Item: " + l._item._ItemName);
        }
    }

}
