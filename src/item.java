import java.util.ArrayList;
import java.util.Arrays;

public class item
{
    //item id, item action cost, item effect

    public static ArrayList<Integer> _medkit = new ArrayList<>(Arrays.asList(0,1,0));
    public static ArrayList<Integer> _bodyArmor = new ArrayList<>(Arrays.asList(1,0,1));
    public static ArrayList<Integer> _energyDrink = new ArrayList<>(Arrays.asList(2,0,2));
    public static ArrayList<Integer> _smokeGrenade = new ArrayList<>(Arrays.asList(3,0,3));
    public static ArrayList<Integer> _acidBomb = new ArrayList<>(Arrays.asList(4, 1, 4));


    public static ArrayList<ArrayList<Integer>> _listOfItems = new ArrayList<>(Arrays.asList(_medkit,_bodyArmor,_energyDrink,_smokeGrenade,_acidBomb));
    public static ArrayList<String> _listOfItemNames = new ArrayList<>(Arrays.asList("medkit", "Body Armor", "Energy Drink", "Smoke Grenade", "Acid Bomb"));


    public String _ItemName;
    public int _ItemID,_ItemCost,_ItemEffect;

    public item(String _itemName, int _itemID,int _itemCost, int _itemEffect)
    {
        this._ItemID = _itemID;
        this._ItemName = _itemName;
        this._ItemCost = _itemCost;
        this._ItemEffect = _itemEffect;
    }


    public void _UseMedkit (player _player)
    {
        _player._Wounds -= 1;
    }

    public void _UseBodyArmor(player _player)
    {
        _player._Armor += 1;
    }

    public void _UseEnergyDrink(player _player)
    {
        _player._actions += 1;
    }

    public void _UseSmokeGrenade(location _CurrentLocation)
    {
        _CurrentLocation._BlockingEnemies = 0;
    }

    public void _UseAcidBomb(location _CurrentLocation)
    {
        _CurrentLocation._walkers = 0;
        _CurrentLocation._fatties = 0;

    }


}
