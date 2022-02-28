import java.util.Scanner;

public class menu
{
    player _player = new player();
    public menu()
    {
        map _Map = new map();

        while(true)
        {
            DisplayMenu();
            int _choice = Jin.readInt();
            PlayerChoice(_choice);
        }
    }

    public void DisplayMenu()
    {
        DisplayInv();

        System.out.println("Would you like to:");
        System.out.println("1: move");
        System.out.println("2: search");
        System.out.println("3: attack");
        System.out.println("____________________________");

    }

    public void DisplayInv()
    {
        System.out.println("____________________________");
        System.out.println("Weapon: " + _player._weapon.toString());
        System.out.println("Item: " + _player._item._ItemName);
        System.out.println("____________________________");
    }



    public void PlayerChoice(int choice)
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
        }

    }

    public void DisplayConnectedLocations(location _CurrentLocation)
    {
        System.out.println("____________________________");
        System.out.println("0: Go back to " + _CurrentLocation._locationName);
        for (int i = 0; i < _CurrentLocation._connectedLocations.size(); i++)
        {
            System.out.println((i+1) + ": Go to " + _CurrentLocation._connectedLocations.get(i)._locationName);
        }
        System.out.println("____________________________");
    }

    public void move()
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



}
