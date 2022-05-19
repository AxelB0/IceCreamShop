package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

import java.util.Scanner;


public class IceCreamAppV2 {

    public static void main(String[] args) throws NoMoreIceCreamException {

        int number = 0;

        PriceList priceList = new PriceList();
        Stock stock = new Stock();
        Scanner keyboardReader = new Scanner(System.in);
        Eatable[] myIceCream = new Eatable[100];
        int counter = 0;

        IceCreamCar myIceCreamCar = new IceCreamCar(priceList, stock);

        do {
            System.out.println("Well hello there, would you like some icecream? 1 = YES");
            if (keyboardReader.nextInt() != 1) {
                System.out.println("Thank you, come again!");
                for (int index =0; index<counter;index++){
                    myIceCream[index].eat();

                }
                System.out.println("Profit totals: " + myIceCreamCar.getProfit());
                System.exit(0);
            }

            System.out.println("What would you like?\n1 = Cone\n2 = IceRocket\n3 = Magnum");

            switch (keyboardReader.nextInt()) {
                case 1:
                    System.out.println("How many balls would you like? 1 - 5");
                    int amountOfBalls = keyboardReader.nextInt();
                    Cone.Flavor[] flavors = new Cone.Flavor[amountOfBalls];

                    for (int index = 0; index < amountOfBalls; index++) {
                        System.out.println("What flavor would you like?\n1 = STRAWBERRY\n2 = BANANA\n3 = CHOCOLATE\n4 = VANILLA\n5 = LEMON\n6 = STRACIATELLA\n7 = MOKKA\n8 = PISTACHE");
                        flavors[index] = IceCreamAppV2.flavorPickerCone(keyboardReader.nextInt());
                        keyboardReader.nextLine();
                    }
                    try {
                        myIceCream[counter++] = myIceCreamCar.orderCone(flavors);
                        System.out.println("A cone for you, you're welcome!");
                    } catch (NoMoreIceCreamException e) {

                    }
                    break;

                case 2:
                    System.out.println("One IceRocket, coming your way!");
                    try {
                        myIceCream[counter++] = myIceCreamCar.orderIceRocket();

                    } catch (NoMoreIceCreamException e) {

                    }
                    break;

                case 3:
                    System.out.println("What flavor would you like?\n1 = MILKCHOCOLATE\n2 = WHITECHOCOLATE\n3 = BLACKCHOCOLATE\n4 = ALPINENUTS\n5 = ROMANTICSTRAWBERRIES");
                    try {
                        myIceCream[counter++] = myIceCreamCar.orderMagnum(flavorPickerMagnum(keyboardReader.nextInt()));
                        System.out.println("Here you go, one Magnum!");
                    } catch (NoMoreIceCreamException e) {

                    }
                    break;

                default:
                    System.out.println("That wasn't an option, sorry.");
                    break;
            }
        } while (number == 0);


    }

    public static Cone.Flavor flavorPickerCone(int flavor) {
        switch (flavor) {
            case 1:
                return Cone.Flavor.STRAWBERRY;
            case 2:
                return Cone.Flavor.BANANA;
            case 3:
                return Cone.Flavor.CHOCOLATE;
            case 4:
                return Cone.Flavor.VANILLA;
            case 5:
                return Cone.Flavor.LEMON;
            case 6:
                return Cone.Flavor.STRACIATELLA;
            case 7:
                return Cone.Flavor.MOKKA;
            case 8:
                return Cone.Flavor.PISTACHE;
            default:
                return Cone.Flavor.VANILLA;
        }
    }

    public static Magnum.MagnumType flavorPickerMagnum(int flavor) {

        switch (flavor) {
            case 1:
                return Magnum.MagnumType.MILKCHOCOLATE;
            case 2:
                return Magnum.MagnumType.WHITECHOCOLATE;
            case 3:
                return Magnum.MagnumType.BLACKCHOCOLATE;
            case 4:
                return Magnum.MagnumType.ALPINENUTS;
            case 5:
                return Magnum.MagnumType.ROMANTICSTRAWBERRIES;
            default:
                return Magnum.MagnumType.MILKCHOCOLATE;
        }
    }


}
