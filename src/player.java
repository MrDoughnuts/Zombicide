import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class player
{

    public ArrayList<Integer> _weapon = new ArrayList<>();
    public ArrayList<Integer> _item = new ArrayList<>();

    public String[] _listOfWeapons = {"Frying Pan", "BaseBall Bat", "Fire Axe", "ChainSaw"};
    public location _currentLocation;

    public player()
    {

    }

    public String DisplayWeapon()
    {
        for(int i = 0; i < 4; i++)
        {
            if(i == _weapon.get(0))
            {
                return _listOfWeapons[i];
            }
        }
        return "";
    }

    public void SetWeapons(int __weapon)
    {
        ArrayList<ArrayList<Integer>> _weaponStats = new ArrayList<>();

        ArrayList<Integer> _fryingPan = new ArrayList<>();
        Collections.addAll(_fryingPan,1,6,1);

        ArrayList<Integer> _baseballBat = new ArrayList<>();
        Collections.addAll(_baseballBat,2,3,1);

        ArrayList<Integer> _fireAxe = new ArrayList<>();
        Collections.addAll(_fireAxe,1,4,2);

        ArrayList<Integer> _chainSaw = new ArrayList<>();
        Collections.addAll(_chainSaw,5,5,2);

        Collections.addAll(_weaponStats,_fryingPan,_baseballBat,_fireAxe,_chainSaw);

        for(int i = 0; i < _listOfWeapons.length; i++)
        {
            if(i == __weapon)
            {
                _weapon = _weaponStats.get(i);
            }
        }
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

    public void Move()
    {

    }

    public void Search()
    {

    }





}
