package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon() {
    }

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public double getProfit() {
        return totalProfit;

    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        totalProfit += priceList.getBallPrice() * flavors.length;
        return new Cone(flavors);

    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        totalProfit += priceList.getRocketPrice();
        return new IceRocket();

    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        totalProfit += priceList.getMagnumPrice(type);
        return new Magnum(type);
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }

}
