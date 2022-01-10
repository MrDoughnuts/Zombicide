import java.util.ArrayList;
import java.util.Collections;

public class weapon
{
    public static String[] _WeaponNames = {"Frying Pan", "Baseball Bat", "Fire Axe", "Chainsaw"};

    ArrayList<ArrayList<Integer>> _weaponStats = new ArrayList<>();

    ArrayList<Integer> _fryingPan = new ArrayList<>();

    ArrayList<Integer> _baseballBat = new ArrayList<>();

    ArrayList<Integer> _fireAxe = new ArrayList<>();

    ArrayList<Integer> _chainSaw = new ArrayList<>();


    public weapon()
    {
        Collections.addAll(_fryingPan,1,6,1);
        Collections.addAll(_baseballBat,2,3,1);
        Collections.addAll(_fireAxe,1,4,2);
        Collections.addAll(_chainSaw,5,5,2);
        Collections.addAll(_weaponStats,_fryingPan,_baseballBat,_fireAxe,_chainSaw);
    }

    public static String DisplayWeapon()
    {
        for(int i = 0; i < 4; i++)
        {
            if(i == player._weapon.get(0))
            {
                return _WeaponNames[i];
            }
        }
        return "";
    }

    public void SetWeapons(int __weapon)
    {

        player._weapon = _weaponStats.get(__weapon);

    }


}
