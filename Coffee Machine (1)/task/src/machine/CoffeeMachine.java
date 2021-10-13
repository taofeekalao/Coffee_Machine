package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static final int WATER = 400;
    static final int MILK = 540;
    static final int COFFEE_BEANS = 120;
    static final int DISPOSABLE_CUPS = 9;
    static final int MONEY = 550;

    static int volumeOfWater = 0;
    static int volumeOfMilk = 0;
    static int weightOfCoffeeBeans = 0;
    static int numberOfCups = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printCoffeeMachineState(WATER, MILK, COFFEE_BEANS, DISPOSABLE_CUPS, MONEY);

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int buyOption = scanner.nextInt();
                buyCoffee(buyOption);
                break;

            case "fill":
                takeReFillOption();
                printCoffeeMachineState(WATER + volumeOfWater, MILK + volumeOfMilk, COFFEE_BEANS + weightOfCoffeeBeans, DISPOSABLE_CUPS + numberOfCups, MONEY);
                break;

            case "take":
                giveMoney();
                printCoffeeMachineState(WATER, MILK, COFFEE_BEANS, DISPOSABLE_CUPS, 0);
                break;

            default:
                break;
        }
    }

    private static void buyCoffee(int buyOption) {
        int waterRequired;
        int milkRequired;
        int coffeeBeansRequired;
        int cost;
        int cupRequired = 1;

        switch (buyOption) {
            /*
                For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
             */
            case 1:         // espresso
                waterRequired = 250;
                milkRequired = 0;
                coffeeBeansRequired = 16;
                cost = 4;
                break;

            /*
                For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
             */
            case 2:         // latter
                waterRequired = 350;
                milkRequired = 75;
                coffeeBeansRequired = 20;
                cost = 7;
                break;

            /*
                For the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
             */
            case 3:         // cappuccino
                waterRequired = 200;
                milkRequired = 100;
                coffeeBeansRequired = 12;
                cost = 6;
                break;

            default:
                waterRequired = 0;
                milkRequired = 0;
                coffeeBeansRequired = 0;
                cost = 0;
                cupRequired = 0;
                break;
        }
        printCoffeeMachineState(WATER - waterRequired, MILK - milkRequired, COFFEE_BEANS - coffeeBeansRequired, DISPOSABLE_CUPS - cupRequired, MONEY + cost);
    }

    /*
        This method processes request to withdraw money from the machine.
     */
    private static void giveMoney() {
        System.out.printf("I gave you $%d %n", MONEY);
    }


    /*
        This method takes refill details from special staff and updates the machine.
     */
    private static void takeReFillOption() {
        System.out.println("Write how many ml of water you want to add:");
        volumeOfWater = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        volumeOfMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        weightOfCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        numberOfCups = scanner.nextInt();
    }

    /*
        This prints current state of the coffee machine
     */
    public static void printCoffeeMachineState(int water, int milk, int coffee_beans, int disposable_cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water  %n", water);
        System.out.printf("%d ml of milk  %n", milk);
        System.out.printf("%d g of coffee beans  %n", coffee_beans);
        System.out.printf("%d disposable cups  %n", disposable_cups);
        System.out.printf("$%d of money  %n", money);
    }
}