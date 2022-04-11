public class menu
{

    map _Map;
    player _player;

    private int _zombiesObjective = 999999999;
    public menu()
    {
        _Map = new map();
        _player = new player(_Map._locations[dice.RollDice(20)]);
        SetObjective();

        while(true)
        {
            if(_player._Wounds <3)
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
            else
            {
                System.out.println("u are dead");
                System.exit(1);
            }

        }
    }

    private void SetObjective()
    {
        int _objective = dice.RollDice(3);

        switch(_objective)
        {

            //kill zombies
            case 0:
                _zombiesObjective = dice.RollDiceMin(10,20);
                System.out.println("Objective: Kill " + _zombiesObjective + " zombies");
                break;
            case 1: //exit spot objective
                _Map.SetExit();
                System.out.println("Objective: Find the exit");
                break;
            case 2: //rescue objective
                _Map.SetSurvivor();
                System.out.println("Find the survivor");
                break;
        }
    }

    private void DisplayMenu()
    {
        //_Map.DisplayMap(); cheater code

        DisplayStatus();

        System.out.println("Would you like to:");
        System.out.println("1: move");
        System.out.println("2: search");
        System.out.println("3: attack");
        System.out.println("4: use item");
        System.out.println("5: end turn");
        System.out.println("____________________________");

    }

    private void DisplayStatus()
    {
        System.out.println(_player._name);
        System.out.println("Zombies Killed: " + _player._zombiesKilled);
        System.out.println("Action points: " + _player._actions);
        System.out.println("Wounds: " + _player._Wounds);
        System.out.println("Armor: " + _player._Armor);
        System.out.println("Weapon: " + _player._weapon.toString());
        System.out.println("Item: " + _player._item._ItemName);

        System.out.println();
        System.out.println("Current location:" + _player._currentLocation._locationName);
        System.out.println();
        if(_player._currentLocation._hasSurvivor)
        {
            System.out.println("There is a survivor here, search to save them");
        }
        if(_player._currentLocation._isExit)
        {
            System.out.println("The exit is here, search to escape");
        }
        System.out.println("Walkers: " + _player._currentLocation._walkers);
        System.out.println("Fatties: " + _player._currentLocation._fatties);
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
            case 3: _player.Attack(_zombiesObjective);
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
        System.out.println("Current location: " + _CurrentLocation._locationName);
        for (int i = 0; i < _CurrentLocation._connectedLocations.size(); i++)
        {
            System.out.println((i) + ": Go to " + _CurrentLocation._connectedLocations.get(i)._locationName);
        }
        System.out.println("____________________________");
    }

    private void move()
    {
        int _locationChoice;
        DisplayConnectedLocations(_player._currentLocation);

        int _costToMove = _player._currentLocation._fatties + _player._currentLocation._walkers + 1;
        System.out.println("cost to move " + _costToMove);

        _locationChoice = Jin.readInt("Where would you like to go?");
        if(_costToMove <= _player._actions || _player._currentLocation._isSmoked)
        {
            try
            {

                _player.Move(_player._currentLocation._connectedLocations.get(_locationChoice));
                if(_player._currentLocation._isSmoked)
                {
                    _player._actions -= 1;
                }
                else
                {
                    _player._actions -= _costToMove;
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                System.out.println("invalid input");
            }
        }
        else
        {
            System.out.println("not enough action points");
        }
    }

    private void ZombiePhase()
    {
        for(int i = 0; i < _player._currentLocation._walkers + _player._currentLocation._fatties; i++)
        {
            if(dice.RollDice(10) > 7)
            {
                if(_player._Armor > 0)
                {
                    _player._Armor -= 1;
                }
                _player._Wounds += 1;

                System.out.println("You got hit!");
            }
            else
            {
                System.out.println("You dodged by the skin of your teeth.");
            }
        }

        for(location l: _Map._locations )
        {
            l.EndTurn();
        }
    }
}
