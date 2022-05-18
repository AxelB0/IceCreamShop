package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller{

    private PriceList pricelist;
    private Stock stock;
    private double profit;

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {

    }

    public Cone prepareCone(Cone.Flavor[] flavors){

    }

    @Override
    public IceRocket orderIceRocket() {

    }

    public IceRocket prepareRocket(){

    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {

    }

    public Magnum prepareMagnum(Magnum.MagnumType type){

    }

    @Override
    public double getProfit() {
        return profit;
    }
}
