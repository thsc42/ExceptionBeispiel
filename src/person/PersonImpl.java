package person;

import drinksmachine.Drink;
import drinksmachine.DrinksMachine;
import drinksmachine.EmptyException;
import drinksmachine.NoMoneyException;

public class PersonImpl implements Person {
    private int coins = 0;

    @Override
    public Drink buyDrink(DrinksMachine machine) throws NoMoneyException, EmptyException {
        // maybe another one has already inserted money.. try
        try {
            return machine.getDrink();
        } catch (EmptyException e) {
            // I cannot do anything - communicate that problem
            throw e;
        } catch (NoMoneyException e) {
            // nice try - but there wasn't any money in the machine - insert a coin
            if(this.coins < 1) {
                // I have no coin
                throw new NoMoneyException();
            }

            // I have money - insert
            machine.insertCoin(this.coins--);

            // recovered
        }

        // now: no try - catch - there is no way for a useful handling of this exception
        return machine.getDrink();
    }

    @Override
    public Drink askPerson2BuyDrink(Person person, DrinksMachine machine) throws NoMoneyException, EmptyException {
        try {
            return person.buyDrink(machine);
        } catch (EmptyException e) {
            // I cannot do anything - communicate that problem
            throw e;
        } catch (NoMoneyException e) {
            // nice try - but there wasn't any money in the machine - insert a coin
            if(this.coins < 1) {
                // I have no coin
                throw new NoMoneyException();
            }

            // I have money - give it
            person.takeMoney(this.coins--);
            // recovered
        }

        // now: no try - catch - there is no way for a useful handling of this exception
        return person.buyDrink(machine);
    }

    @Override
    public void takeMoney(int coins) {
        this.coins += coins;
    }
}
