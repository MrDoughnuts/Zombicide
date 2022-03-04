import java.util.ArrayList;

public class location
{
    public ArrayList<location> _connectedLocations = new ArrayList<>();
    public String _locationName;
    public int _walkers;
    public int _fatties;
    public Boolean _hasPlayer;
    public boolean _isHive = false;
    public boolean _isExit = false;

    public int _BlockingEnemies;

    public item _item = null;
    public weapon _Weapon = null;


    public location()
    {
        placeObjects();
    }

    private void placeObjects()
    {
        if(_connectedLocations.size() == 2)
        {
            int _diceRoll = dice.RollDice(item._listOfItems.size());
            _item = new item(item._listOfItemNames.get(_diceRoll),item._listOfItems.get(_diceRoll).get(0),
                    item._listOfItems.get(_diceRoll).get(1),item._listOfItems.get(_diceRoll).get(2));
        }
        else if (_connectedLocations.size() == 1)
        {
            int _diceRoll = dice.RollDice(weapon._WeaponNames.size());
            _Weapon = new weapon(weapon._WeaponNames.get(_diceRoll),
                    weapon._WeaponStats.get(_diceRoll).get(1),weapon._WeaponStats.get(_diceRoll).get(2),weapon.
                    _WeaponStats.get(_diceRoll).get(3));
        }

    }

    public void DisplaySearch()
    {

        if(_item != null && _Weapon != null)
        {
            System.out.println("____________________________");
            System.out.println("Item: " + _item._ItemName);
            System.out.println("Weapon: " + _Weapon.toString());
            System.out.println("____________________________");

        }
        else
        {
            System.out.println("____________________________");
            System.out.println("You found nothing");
            System.out.println("____________________________");

        }

    }

    public void DisplayConnectedLocations()
    {
        for(int i = 0; i<3; i++)
        {
            if(_connectedLocations.get(i) != null)
            {
                System.out.println(String.valueOf(i) + ") " + _connectedLocations.get(i)._locationName);
            }
        }
    }

    public void EndTurn()
    {
        for(location l: _connectedLocations)//moves zombies towards the player if they are in a connected location
        {
            if(l._hasPlayer)
            {
                MoveZombies(l);
            }
        }

        int _randomLocation = dice.RollDice(4); //randomly moves zombies if there is no connected locations with players
        if(_randomLocation != 3)
        {
            MoveZombies(_connectedLocations.get(_randomLocation));
        }

        if(_isHive) //spawns zombies if this location is a hive
        {
            SpawnZombies();
        }

    }

    public void MoveZombies(location _location)
    {
        _location._walkers = this._walkers;
        _location._fatties = this._fatties;
        this._walkers = 0;
        this._fatties = 0;
    }

    public void SpawnZombies()
    {
        int _zombiesSpawned = dice.RollDice(6);
        for(int i = 0; i <_zombiesSpawned; i++)
        {
            if(dice.RollDice(2) == 1)
            {
                this._fatties += 1;
            }
            else
            {
                this._walkers += 1;
            }
        }
    }
}
