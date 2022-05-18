package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {

    public static void main(String[] args) {


        PriceList pricelist = new PriceList();
        IceCreamSalon myIceCreamSalon = new IceCreamSalon(pricelist);

        Eatable[] myIceCreamOrder = new Eatable[3];
        Cone.Flavor[] flavor = new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE};

        myIceCreamOrder[0] = myIceCreamSalon.orderCone(flavor);
        myIceCreamOrder[1] = myIceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        myIceCreamOrder[2] = myIceCreamSalon.orderIceRocket();

        for (Eatable e : myIceCreamOrder) {
            e.eat();
        }

        System.out.println("Profit is: " + myIceCreamSalon.getProfit());
    }

}
