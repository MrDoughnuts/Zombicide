import java.util.Scanner;

public class menu
{
    player _player = new player();
    map _Map;
    public menu()
    {
        _Map = new map();

        while(true)
        {
            if(_player._actions > 0)
            {
                DisplayMenu();
                int _choice = Jin.readInt();
                PlayerChoice(_choice);
            }
            else
            {
                ZombiePhase();
                _player._actions = 3;
            }
        }
    }

    private void DisplayMenu()
    {
        DisplayInv();

        System.out.println("Would you like to:");
        System.out.println("1: move");
        System.out.println("2: search");
        System.out.println("3: attack");
        System.out.println("4: use item");
        System.out.println("5: end turn");
        System.out.println("____________________________");

    }

    private void DisplayInv()
    {
        System.out.println("____________________________");
        System.out.println("Weapon: " + _player._weapon.toString());
        System.out.println("Item: " + _player._item._ItemName);
        System.out.println("____________________________");
    }



    private void PlayerChoice(int choice)
    {
        switch(choice)
        {
            case 1: move();
            break;
            case 2: _player.Search();
            break;
            case 3: _player.Attack();
            break;
            case 4: _player._UseItem();
            break;
            case 5: ZombiePhase();
                    _player._actions = 3;
            break;
        }

    }

    private void DisplayConnectedLocations(location _CurrentLocation)
    {
        System.out.println("____________________________");
        System.out.println("0: Go back to " + _CurrentLocation._locationName);
        for (int i = 0; i < _CurrentLocation._connectedLocations.size(); i++)
        {
            System.out.println((i+1) + ": Go to " + _CurrentLocation._connectedLocations.get(i)._locationName);
        }
        System.out.println("____________________________");
    }

    private void move()
    {
        int _locationChoice;
        DisplayConnectedLocations(_player._currentLocation);
        _locationChoice = Jin.readInt("Where would you like to go?");
        try
        {
            _player.Move(_player._currentLocation._connectedLocations.get(_locationChoice));
        }
        catch(Exception e)
        {
            System.out.println("invalid input");
        }
    }

    private void ZombiePhase()
    {
        for(int i = 0; i < _player._currentLocation._walkers + _player._currentLocation._fatties; i++)
        {
            if(dice.RollDice(10) > 7)
            {
                _player._Wounds += 1;
            }
        }

        for(location l: _Map._locations )
        {
            l.EndTurn();
        }
    }
}
