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
    public ArrayList<Integer> _Weapon = new ArrayList();


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
            weapon _newWeapon = new weapon();
            _Weapon = _newWeapon._weaponStats.get(dice.RollDice(_newWeapon._weaponStats.size()));
        }
        else
        {
            _Weapon.add(-1);

            int[] _noItem = {-1,-1,-1};
            _item = _noItem;
        }
    }

    public void DisplaySearch()
    {
        weapon _placedWeapon = new weapon();
        item _placedItem = new item();

        System.out.println("____________________________");
        System.out.println("Item: " + _placedItem._ListOfItemNames[_item[0]]);
        System.out.println("Weapon: " + weapon._WeaponNames[_Weapon.get(0)]);
        System.out.println("____________________________");

    }

}
