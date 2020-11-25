package drinksmachine;

public interface DrinksMachine {
    void insertCoin(int numberOfCoins);
    Drink getDrink() throws NoMoneyException, EmptyException;
}
