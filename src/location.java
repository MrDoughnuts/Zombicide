import java.util.ArrayList;

public class location
{
    public ArrayList<location> _connectedLocations = new ArrayList<>();
    public String _locationName;
    public int _walkers;
    public int _fatties;
    public Boolean _hasPlayer;

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

}
