package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    private PriceList pricelist;
    private Stock stock;
    private double profit;

    public IceCreamCar() {
        this(new PriceList(), new Stock());

    }

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.pricelist = priceList;
        this.stock = stock;

    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        try {
            return prepareCone(flavors);
        } catch (NoMoreIceCreamException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private Cone prepareCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        if (stock.getCones() > 0) {
            if (stock.getBalls() >= flavors.length) {
                profit += pricelist.getBallPrice() * flavors.length;
                stock.setBalls(stock.getBalls()- flavors.length);
                return new Cone(flavors);
            }
        }
        throw new NoMoreIceCreamException();
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        try {
            return prepareRocket();
        } catch (NoMoreIceCreamException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    private IceRocket prepareRocket() throws NoMoreIceCreamException {
        if (stock.getIceRockets() > 0) {
            profit += pricelist.getRocketPrice();
            stock.setIceRockets(stock.getIceRockets()-1);
            return new IceRocket();
        }
        throw new NoMoreIceCreamException();

    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        try {
            return prepareMagnum(type);
        } catch (NoMoreIceCreamException e) {
            System.out.println(e.getMessage());
            throw e;

        }

    }

    private Magnum prepareMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        if (stock.getMagni() > 0) {
            profit += pricelist.getMagnumPrice(type);
            stock.setMagni(stock.getMagni()-1);
            return new Magnum(type);
        }
        throw new NoMoreIceCreamException();

    }

    @Override
    public double getProfit() {
        return profit;
    }
}
