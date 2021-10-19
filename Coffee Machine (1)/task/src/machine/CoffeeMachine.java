package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int volumeOfWater = 0;
    static int volumeOfMilk = 0;
    static int weightOfCoffeeBeans = 0;
    static int numberOfCups = 0;

    static int runningWater = 400;
    static int runningMilk = 540;
    static int runningCoffeeBeans = 120;
    static int runningCups = 9;
    static int runningCash = 550;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        boolean proceed = true;

        while (proceed) {
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    String response = scanner.next();
                    if (response.equals("back")){
                        break;
                    } else {
                        int buyOption = Integer.parseInt(response);
                        buyCoffee(buyOption);
                    }
                    break;

                case "fill":
                    takeReFillOption();
                    calculateCurrentResource(volumeOfWater, volumeOfMilk, weightOfCoffeeBeans, numberOfCups, 0);
                    break;

                case "take":
                    giveMoney();
                    break;

                case "remaining":
                    printCoffeeMachineState(runningWater, runningMilk, runningCoffeeBeans, runningCups, runningCash);
                    break;

                case "exit":
                    proceed = false;
                    break;
                default:
                    break;
            }
            if (proceed) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                action = scanner.next();
            }

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
        if (runningWater < waterRequired) {
            System.out.println("Sorry, not enough water!");
        } else if ( runningMilk < milkRequired){
            System.out.println("Sorry, not enough milk!");
        } else if (runningCoffeeBeans < coffeeBeansRequired) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            calculateCurrentResource(-waterRequired, - milkRequired, -coffeeBeansRequired, -cupRequired, cost);
        }
    }

    /*
        This method processes request to withdraw money from the machine.
     */
    private static void giveMoney() {
        System.out.printf("I gave you $%d %n", runningCash);
        runningCash = 0;
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

    private static void calculateCurrentResource(int waterRequired, int milkRequired, int coffeeBeansRequired, int cupRequired, int cost) {
        runningWater += waterRequired;
        runningMilk += milkRequired;
        runningCoffeeBeans += coffeeBeansRequired;
        runningCups += cupRequired;
        runningCash += cost;
    }
}