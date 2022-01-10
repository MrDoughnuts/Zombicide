import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class player
{

    public static ArrayList<Integer> _weapon = new ArrayList<>();
    public static ArrayList<Integer> _item = new ArrayList<>();

    public String[] _listOfWeapons = {"Frying Pan", "BaseBall Bat", "Fire Axe", "ChainSaw"};
    public location _currentLocation;

    private String _name;
    public int _Wounds = 0;
    public int _actions;
    public int _Armor = 0;


    public player()
    {
        System.out.println("what is your name?");
        Scanner jIn = new Scanner(System.in);
        _name = jIn.nextLine();
    }


    public void Attack()
    {
        int _hits = 0;
        for(int i = 0; i < _weapon.get(0); i++)
        {
            int x = RollDie();
            if(x == _weapon.get(1))
            {
                _hits++;
            }
        }

        if(_weapon.get(3) >=2 && map.Fatties > 0)
        {
            if(map.Fatties >= _hits)
            {
                map.Fatties -= _hits;
            }
            else
            {
                _hits -= map.Fatties;
                map.Fatties = 0;
            }
        }

            if(map.walkers >= _hits)
            {
                map.walkers -= _hits;
            }
            else
            {
                _hits -= map.walkers;
                map.walkers = 0;
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
        if(_currentLocation._Weapon.get(0) >= 0)
        {
            System.out.println("Will you take the weapon? Y/N");
            Scanner jIn = new Scanner(System.in);

            

        }
        else if (_currentLocation._item[0] >= 0)
        {

        }

    }





}
