import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class player
{

    public weapon _weapon;
    public item _item;

    public String[] _listOfWeapons = {"Frying Pan", "BaseBall Bat", "Fire Axe", "ChainSaw"};
    public location _currentLocation;

    public String _name = "";
    public int _Wounds = 0;
    public int _actions = 3;
    public int _Armor = 0;

    public int _zombiesKilled = 0;



    public player(location _startingLocation)
    {

        _name = Jin.readLine("what is your name?");
        _weapon = new weapon(weapon._WeaponNames.get(0),weapon._FryingPan.get(0),weapon._FryingPan.get(1),weapon._FryingPan.get(2));
        _item = new item("no item", -1,-1,-1);
        SpawnIn(_startingLocation);
    }

    private void SpawnIn(location _startingLocation)
    {
        _currentLocation = _startingLocation;
        _startingLocation._hasPlayer = true;

    }

    public void Attack(int _zombieObjective)
    {
        int _hits = 0;
        for(int i = 0; i < _weapon._DiceRolls; i++)
        {
            int x = RollDie();
            if(x == _weapon._HitThreshold)
            {
                System.out.println("Hit");
                _hits++;
            }
            else
            {
                System.out.println("Miss");
            }
        }

        if(_weapon._Dmg >=2 && _currentLocation._fatties > 0)
        {
            if(_currentLocation._fatties >= _hits)
            {
                _currentLocation._fatties -= _hits;
                _zombiesKilled += _hits;
                System.out.println("you killed " + _hits + " fatties");
            }
            else
            {
                System.out.println("you killed " + _currentLocation._fatties + " fatties");

                _zombiesKilled += _currentLocation._fatties;
                _hits -= _currentLocation._fatties;
                _currentLocation._fatties = 0;
            }
        }

            if(_currentLocation._walkers >= _hits)
            {
                System.out.println("you killed " + _hits + " walkers");
                _currentLocation._walkers -= _hits;
                _zombiesKilled += _hits;
            }
            else
            {
                System.out.println("you killed " + _currentLocation._walkers + " fatties");

                _zombiesKilled += _currentLocation._walkers;
                _hits -= _currentLocation._walkers;
                _currentLocation._walkers = 0;
            }

            System.out.println("Your current kills is now: " + _zombiesKilled);
            if(_zombiesKilled >= _zombieObjective)
            {
                System.out.println("You Won!!!");
                System.exit(1);
            }

        _actions -= 1;

    }

    public int RollDie()
    {
        Random _random = new Random();
        return _random.nextInt(1,10); //changed to 6 sided die because game was too hard
    }

    public void Move(location _nextLocation)
    {
        _currentLocation._hasPlayer = false;
        _currentLocation = _nextLocation;
        _nextLocation._hasPlayer = true;
    }

    public void Search()
    {
        if(_currentLocation._walkers + _currentLocation._fatties == 0)
        {
            if(_actions > 0)
            {
                _currentLocation.DisplaySearch();

                char _response;

                if(_currentLocation._isExit || _currentLocation._hasSurvivor)
                {
                    System.out.println("you win");
                    System.exit(1);
                }
                if(_currentLocation._Weapon._WeaponName != "")
                {
                    _response = Jin.readChar("Will you take the weapon? Y/N");
                    if(_response == 'Y' || _response == 'y')
                    {
                        this._weapon = _currentLocation._Weapon;
                        _currentLocation._Weapon = null;
                    }
                }
                else if (_currentLocation._item._ItemName != "")
                {
                    _response = Jin.readChar("Will you take the item? Y/N");
                    if(_response == 'Y' || _response == 'y')
                    {
                        this._item = _currentLocation._item;
                        _currentLocation._item = null;
                    }

                }
                else
                {
                    System.out.println("You found nothing");
                }

                _actions -= 1;

            }
            else
            {
                System.out.println("not enough actions");
            }
        }
        else
        {
            System.out.println("Defeat the zombies in this zone first");
        }
    }

    public void _UseItem()
    {
        switch (_item._ItemID)
        {
            case 0: _item._UseMedkit(this);
            break;
            case 1: _item._UseBodyArmor(this);
            break;
            case 2: _item._UseEnergyDrink(this);
            break;
            case 3: _item._UseSmokeGrenade(_currentLocation);
            break;
            case 4: _item._UseAcidBomb(_currentLocation);
            break;
        }
    }


}
