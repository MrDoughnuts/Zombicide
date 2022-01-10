import java.util.ArrayList;

public class item
{
    //item id, item action cost, item effect
    int[] _Medkit = {0,1,0};
    int[] _BodyArmor = {1,0,1};
    int[] _EnergyDrink = {2,0,2};
    int[] _SmokeGrenade = {3,0,3};
    int[] _AcidBomb = {4, 1, 4};

    int[][] _ListOfItems = {_Medkit,_BodyArmor,_EnergyDrink,_SmokeGrenade,_AcidBomb};
    String[] _ListOfItemNames = {"medkit", "Body Armor", "Energy Drink", "Smoke Grenade", "Acid Bomb"};

    public item()
    {

    }

    public void _UseItem(int[] _item, player _player)
    {

        _player._actions -= _item[1];
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
