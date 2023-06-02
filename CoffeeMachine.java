package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static int water = 400;
    public static int milk = 540;
    public static int coffee_beans = 120;
    public static int disposable_cups = 9;
    public static int money = 550;

    public static int marker = 0;
    public static Scanner scoop = new Scanner(System.in);
    public static void main(String[] args) {
        /*System.out.print("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!\n\n\n");*/
        //coffee();
        //estimate();

        while (marker == 0) action();
    }

    public static void stat(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee_beans + " g of coffee beans");
        System.out.println(disposable_cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void coffee(){
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scoop.nextInt();
        System.out.println("For " + cups + " of coffee you will need:");
        System.out.println(cups * 200 + "ml of water");
        System.out.println(cups * 50 + "ml of milk");
        System.out.println(cups * 15 + "g of coffee beans");
    }

    public static void estimate(){
        System.out.println("Write how many ml of water the coffee machine has:");
        int wtr = scoop.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int mlk = scoop.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scoop.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scoop.nextInt();
        int actualwater = wtr/200;
        int actualmilk = mlk/50;
        int actualcoffee = coffee/15;
        int actualcups = Math.min(Math.min(actualwater,actualmilk), actualcoffee);
        int diff = actualcups - cups;
        if (actualcups < cups){
            System.out.println("No, I can make only " + actualcups + " cup(s) of coffee");
        }
        if (cups < actualcups){
            System.out.println("Yes, I can make that amount of coffee (and even " + diff + " more than that");
        }
        if (cups == actualcups){
            System.out.println("Yes, I can make that amount of coffee");
        }

        disposable_cups = cups;
    }
    public static void add(){
        System.out.println("Write how many ml of water you want to add:");
        int addwater = scoop.nextInt();
        water += addwater;
        System.out.println("Write how many ml of milk you want to add:");
        int addmilk = scoop.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        milk += addmilk;
        int addbeans = scoop.nextInt();
        coffee_beans += addbeans;
        System.out.println("Write how many disposable cups you want to add");
        int addcups = scoop.nextInt();
        disposable_cups += addcups;
    }


    public static void action(){
        System.out.println("Write action (buy, fill take, remaining, exit):");
        String act = scoop.next();
        //scoop.nextLine();
        if (act.equalsIgnoreCase("buy")){
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino, back - to main menu");
            String basoo = scoop.next();
            if (basoo.equalsIgnoreCase("back"));
            else {int baso = Integer.parseInt(basoo);
                switch(baso){
                    case(1): {
                        if (water >= 250 && coffee_beans >= 16 && disposable_cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250; coffee_beans -= 16; money += 4; disposable_cups--;
                        }
                        else System.out.println("Sorry, not enough water!");
                        break;
                    }
                    case(2): {
                        if (water >= 350) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350; milk -= 75; coffee_beans -= 20; money += 7; disposable_cups--;
                        }
                        else System.out.println("Sorry, not enough water!");
                        break;
                    }
                    case(3): {
                        if (water >= 200) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200; milk -= 100; coffee_beans -= 12; money += 6; disposable_cups--;
                        }
                        else System.out.println("Sorry, not enough water!");
                        break;
                    }
                }
            }
        }
        if (act.equalsIgnoreCase("fill")){
            add();
        }

        if (act.equalsIgnoreCase("take")){
            System.out.println("I gave you $" + money);
            money -= money;
        }

        if (act.equalsIgnoreCase("remaining")){
            stat();
        }

        if (act.equalsIgnoreCase("exit")){
            marker = 1;
            System.exit(0);
        }
        //scoop.nextLine();
    }   

}
