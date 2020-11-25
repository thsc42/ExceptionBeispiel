package person;

import drinksmachine.Drink;
import drinksmachine.DrinksMachine;
import drinksmachine.EmptyException;
import drinksmachine.NoMoneyException;

public interface Person {
    Drink buyDrink(DrinksMachine machine) throws NoMoneyException, EmptyException;
    Drink askPerson2BuyDrink(Person person, DrinksMachine machine) throws NoMoneyException, EmptyException;

    void takeMoney(int coins);
}
