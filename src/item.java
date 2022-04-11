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

    public item()
    {
        this._ItemName = "";
        this._ItemID = -1;
        this._ItemEffect = -1;
        this._ItemCost = -1;

    }

    public String itemFlavorText()
    {
        switch(_ItemName)
        {
            case "medkit":
                return "magics away an entire wound! (Wounds - 1)";
            case "Body Armor":
                return "Zombies are going to have a good time gnawing through this (Armor + 1)";
            case "Energy Drink":
                return "You can feel the power coursing through your veins, (Actions +1)";
            case "Smoke Grenade":
                return "Even you won't be able to see a thing after you use this baby. (Zombies will not be able to block your movement)";
            case "Acid Bomb":
                return "Who's high school science fair project was this!? (kills all the zombies in the area, doesn't add to your kill count)";
        }
        return "";
    }

    public void _UseMedkit (player _player)
    {
        if(_player._Wounds > 0)
        {
            _player._Wounds -= 1;
            System.out.println("Wow, my boo-boo went away instantly.");
            System.out.println("____________________________");

        }
        else
        {
            System.out.println("This band-aid doesn't taste half bad.");
            System.out.println("____________________________");
        }
    }

    public void _UseBodyArmor(player _player)
    {
        _player._Armor += 1;
        System.out.println("I put on some armor, I feel slightly more safe.");
        System.out.println("____________________________");
    }

    public void _UseEnergyDrink(player _player)
    {
        _player._actions += 1;
        System.out.println("My body is shaking with power");
        System.out.println("____________________________");
    }

    public void _UseSmokeGrenade(location _CurrentLocation)
    {
        _CurrentLocation._isSmoked = true;
        System.out.println("I can't see a thing, I think the exit was that way");
        System.out.println("____________________________");
    }

    public void _UseAcidBomb(location _CurrentLocation)
    {
        _CurrentLocation._walkers = 0;
        _CurrentLocation._fatties = 0;
        System.out.println("AHH, it melted the toes of my shoe as well.");
        System.out.println("____________________________");
    }


}
