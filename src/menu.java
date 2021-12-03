public class menu
{
    player _player = new player();
    public menu()
    {

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
        System.out.println("Weapon: " + _player.DisplayWeapon());
        System.out.println("Item: " + _player._item);
        System.out.println("____________________________");
    }

    public void PlayerChoice(int choice)
    {
        If(choice == 1)
        {
            _player.Move(location _nextLocation);
        }
        else if(choice == 2)
        {
            _player.Search();
        }
        else if(choice == 3)
        {
            _player.Attack();
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
        DisplayConnectedLocations();

    }
}
