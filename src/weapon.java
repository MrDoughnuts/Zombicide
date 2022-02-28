import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class weapon
{
    public static ArrayList<String> _WeaponNames = new ArrayList<>(Arrays.asList(
                                                        "Frying Pan","Baseball Bat", "Fire Axe", "ChainSaw" ));

    public static ArrayList<Integer> _FryingPan  = new ArrayList<>(Arrays.asList(1,6,1));
    public static ArrayList<Integer> _BaseballBat  = new ArrayList<>(Arrays.asList(2,3,1));
    public static ArrayList<Integer> _FireAxe  = new ArrayList<>(Arrays.asList(1,4,2));
    public static ArrayList<Integer> _Chainsaw  = new ArrayList<>(Arrays.asList(5,5,2));

    public static ArrayList<ArrayList<Integer>> _WeaponStats = new ArrayList<ArrayList<Integer>>(
            Arrays.asList(_FryingPan,_BaseballBat,_FireAxe,_Chainsaw)
    );

    public String _WeaponName;
    public int _DiceRolls,_HitThreshold,_Dmg;

    public weapon(String _weaponName, int _diceRolls, int _hitThreshold, int _dmg)
    {
        this._WeaponName = _weaponName;
        this._DiceRolls = _diceRolls;
        this._HitThreshold = _hitThreshold;
        this._Dmg = _dmg;

    }


    public String toString()
    {
        return _WeaponName + " || dice rolls: " + _DiceRolls + " || hit thresh hold: " + _HitThreshold + " || dmg: " + _Dmg;
    }
}
