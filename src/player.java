import java.util.ArrayList;

public class player
{

    public ArrayList<Integer> _weapon = new ArrayList<>();
    public ArrayList<Integer> _item = new ArrayList<>();

    public String[] _listOfWeapons = {"Frying Pan", "BaseBall Bat", "Fire Axe", "ChainSaw"};
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

    public void SetWeapon(int __weapon)
    {

    }


}
