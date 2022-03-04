import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class player
{

    public weapon _weapon;
    public item _item;

    public String[] _listOfWeapons = {"Frying Pan", "BaseBall Bat", "Fire Axe", "ChainSaw"};
    public location _currentLocation;

    private String _name;
    public int _Wounds = 0;
    public int _actions = 3;
    public int _Armor = 0;


    public player()
    {

        _name = Jin.readLine("what is your name?");
    }


    public void Attack()
    {
        int _hits = 0;
        for(int i = 0; i < _weapon._DiceRolls; i++)
        {
            int x = RollDie();
            if(x == _weapon._HitThreshold)
            {
                _hits++;
            }
        }

        if(_weapon._Dmg >=2 && _currentLocation._fatties > 0)
        {
            if(_currentLocation._fatties >= _hits)
            {
                _currentLocation._fatties -= _hits;
            }
            else
            {
                _hits -= _currentLocation._fatties;
                _currentLocation._fatties = 0;
            }
        }

            if(_currentLocation._walkers >= _hits)
            {
                _currentLocation._walkers -= _hits;
            }
            else
            {
                _hits -= _currentLocation._walkers;
                _currentLocation._walkers = 0;
            }


    }

    public int RollDie()
    {
        Random _random = new Random();
        return _random.nextInt(1,7);
    }

    public void Move(location _nextLocation)
    {
        _currentLocation = _nextLocation;
    }

    public void Search()
    {
        _currentLocation.DisplaySearch();

        System.out.println("____________________________");
        if(_currentLocation._Weapon != null)
        {
            System.out.println("Will you take the weapon? Y/N");
            Scanner jIn = new Scanner(System.in);
            if(jIn.next() == "Y")
            {
                this._weapon = _currentLocation._Weapon;
                _currentLocation._Weapon = null;
            }
        }
        else if (_currentLocation._item != null)
        {
            System.out.println("Will you take the item? Y/N");
            Scanner jIn = new Scanner(System.in);
            if(jIn.next() == "Y")
            {
                this._item = _currentLocation._item;
                _currentLocation._item = null;
            }

        }

    }

    public void _UseItem()
    {
        switch (_item._ItemID)
        {
            case 1: _item._UseMedkit(this);
            break;
            case 2: _item._UseBodyArmor(this);
            break;
            case 3: _item._UseEnergyDrink(this);
            break;
            case 4: _item._UseSmokeGrenade(_currentLocation);
            break;
            case 5: _item._UseAcidBomb(_currentLocation);
            break;


        }
    }


}
