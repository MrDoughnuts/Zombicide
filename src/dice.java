import java.util.Random;

public class dice
{
    public static int RollDice(int _MaxNum)
    {
        Random _dice = new Random();
        return _dice.nextInt(_MaxNum);
    }
}
