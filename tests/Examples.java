import drinksmachine.DrinksMachine;
import drinksmachine.DrinksMachineImpl;
import drinksmachine.EmptyException;
import drinksmachine.NoMoneyException;
import org.junit.Assert;
import org.junit.Test;
import person.Person;
import person.PersonImpl;

public class Examples {
    @Test(expected=EmptyException.class)
    public void emptyMachine() throws NoMoneyException, EmptyException {
        DrinksMachine machine = new DrinksMachineImpl(false);
        Person bob = new PersonImpl();

        try {
            Assert.assertNotNull(bob.buyDrink(machine));
        } catch (NoMoneyException e) {
            System.out.println("not enough money");
            throw e;
        } catch (EmptyException e) {
            System.out.println("machine is empty");
            throw e;
        }
    }

    @Test(expected=NoMoneyException.class)
    public void bobHasNoMoney() throws NoMoneyException, EmptyException {
        DrinksMachine machine = new DrinksMachineImpl(true);
        Person bob = new PersonImpl();

        try {
            Assert.assertNotNull(bob.buyDrink(machine));
        } catch (NoMoneyException e) {
            System.out.println("not enough money");
            throw e;
        } catch (EmptyException e) {
            System.out.println("machine is empty");
            throw e;
        }
    }

    @Test
    public void bobHasMoney() throws NoMoneyException, EmptyException {
        DrinksMachine machine = new DrinksMachineImpl(true);
        Person bob = new PersonImpl();
        bob.takeMoney(1);

        try {
            Assert.assertNotNull(bob.buyDrink(machine));
        } catch (NoMoneyException e) {
            System.out.println("not enough money");
            throw e;
        } catch (EmptyException e) {
            System.out.println("machine is empty");
            throw e;
        }
    }

    @Test
    public void aliceAsksBobToBuy() throws NoMoneyException, EmptyException {
        DrinksMachine machine = new DrinksMachineImpl(true);
        Person bob = new PersonImpl();
        Person alice = new PersonImpl();

        alice.takeMoney(1);

        try {
            Assert.assertNotNull(alice.askPerson2BuyDrink(bob, machine));
        } catch (NoMoneyException e) {
            System.out.println("not enough money");
            throw e;
        } catch (EmptyException e) {
            System.out.println("machine is empty");
            throw e;
        }
    }
}
