package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {

    public static void main(String[] args) throws NoMoreIceCreamException {


        PriceList pricelist = new PriceList();
        IceCreamSeller iceCreamSeller = new IceCreamSalon(pricelist);

        Eatable[] myIceCreamOrder = new Eatable[3];
        Cone.Flavor[] flavor = new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE};


            myIceCreamOrder[0] = iceCreamSeller.orderCone(flavor);
            myIceCreamOrder[1] = iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS);
            myIceCreamOrder[2] = iceCreamSeller.orderIceRocket();


        for (Eatable e : myIceCreamOrder) {
            e.eat();
        }

        System.out.println("Profit is: " + iceCreamSeller.getProfit());
    }

}
