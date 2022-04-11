import java.util.ArrayList;
import java.util.Objects;

public class location
{
    public ArrayList<location> _connectedLocations = new ArrayList<>();
    public String _locationName;
    public int _walkers;
    public int _fatties;
    public Boolean _hasPlayer = false;
    public boolean _isSmoked = false;

    public boolean _isHive = false;
    public boolean _isExit = false;
    public boolean _hasSurvivor = false;


    public item _item = new item();
    public weapon _Weapon = new weapon();


    public location(String _name)
    {
        this._locationName = _name;
    }

    public void placeObjects()
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
                    weapon._WeaponStats.get(_diceRoll).get(0),weapon._WeaponStats.get(_diceRoll).get(1),weapon.
                    _WeaponStats.get(_diceRoll).get(2));

        }

    }

    public void DisplaySearch()
    {
        if(_isExit)
            System.out.println("You have found the exit");
        if(_hasSurvivor)
            System.out.println("You have found the survivor");

        if(!Objects.equals(_item._ItemName, ""))
        {
            System.out.println("Item: " + _item._ItemName);
            System.out.println(_item.itemFlavorText());
            System.out.println("____________________________");

        }
        else if(!Objects.equals(_Weapon._WeaponName, ""))
        {
            System.out.println("Weapon: " + _Weapon.toString());
            System.out.println(_Weapon.weaponFlavorText());
            System.out.println("____________________________");
        }
        else
        {
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
                if(_walkers >0)
                {
                    MoveZombies(l,_walkers, 0);

                }
                if(_fatties > 0)
                {
                    MoveZombies(l,0,_fatties);
                }
            }
        }

        int _randomLocation = dice.RollDice(_connectedLocations.size()); //randomly moves zombies if there is no connected locations with players
        if(_walkers > 0)
        {
            MoveZombies(_connectedLocations.get(_randomLocation),dice.RollDice(_walkers),0);
        }
        if(_fatties > 0)
        {
            MoveZombies(_connectedLocations.get(_randomLocation),0,_fatties);
        }

        if(_isHive) //spawns zombies if this location is a hive
        {
            SpawnZombies();
        }

    }

    public void MoveZombies(location _location, int _WalkerAmount, int _FattiesAmount)
    {
        _location._walkers += _WalkerAmount;
        _location._fatties += _FattiesAmount;
        this._walkers = _WalkerAmount;
        this._fatties = _FattiesAmount;
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
