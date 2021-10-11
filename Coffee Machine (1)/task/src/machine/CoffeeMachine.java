package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static final int WATER = 200;
    static final int MILK = 50;
    static final int COFFEE_BEANS = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int volumeOfWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int volumeOfMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int weightOfCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCups = scanner.nextInt();

        int waterPossible = volumeOfWater / WATER;
        int milkPossible = volumeOfMilk / MILK;
        int coffeePossible = weightOfCoffeeBeans / COFFEE_BEANS;

        int leastQuantityPossible = waterPossible < milkPossible ? Math.min(waterPossible, coffeePossible) : Math.min(milkPossible, coffeePossible);

        if (waterPossible >= numberOfCups && milkPossible >= numberOfCups && coffeePossible >= numberOfCups
            && (waterPossible < numberOfCups + 1 || milkPossible < numberOfCups + 1 || coffeePossible < numberOfCups + 1)) {
            System.out.println("Yes, I can make that amount of coffee");
        }

        if (waterPossible < numberOfCups || milkPossible < numberOfCups || coffeePossible < numberOfCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee %n", leastQuantityPossible);
        }

        if (waterPossible > numberOfCups && milkPossible > numberOfCups && coffeePossible > numberOfCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that) %n", leastQuantityPossible - numberOfCups);
        }
    }
}