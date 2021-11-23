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
            player.Move();
        }
        else if(choice == 2)
        {
            player.Search();
        }
        else if(choice == 3)
        {
            player.Attack();
        }
    }


}
