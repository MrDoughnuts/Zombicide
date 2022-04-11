import java.util.Random;

public class dice
{
    public static int RollDice(int _MaxNum)
    {
        Random _dice = new Random();
        return _dice.nextInt(0,_MaxNum);
    }

    public static int RollDiceMin(int _minNum, int _maxNum)
    {
        Random _dice = new Random();
        return _dice.nextInt(_minNum,_maxNum);
    }
}
