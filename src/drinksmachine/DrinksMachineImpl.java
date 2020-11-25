package drinksmachine;

import java.util.ArrayList;
import java.util.List;

public class DrinksMachineImpl implements DrinksMachine {
    private List<Drink> drinks = new ArrayList();
    private int coins = 0;

    public DrinksMachineImpl(boolean filled) {
        if(filled) {
            // example - create drink
            Drink exampleDrink = new SugarWaterWithCoffein();

            // put into machine
            this.drinks.add(exampleDrink);
        }
    }

    @Override
    public void insertCoin(int numberOfCoins) {
        this.coins += numberOfCoins;
    }

    @Override
    public Drink getDrink() throws NoMoneyException, EmptyException {
        // must no be empty
        if(this.drinks == null || this.drinks.isEmpty()) {
            throw new EmptyException();
        }

        // each drinks cost one coin
        if(this.coins < 1) {
            throw new NoMoneyException();
        }

        // we have drinks - we have got at least one coin

        // take money
        this.coins--;

        // take drink out of our storage
        Drink drink = this.drinks.remove(0);

        // return drink object - simulated bottle
        return drink;
    }
}
