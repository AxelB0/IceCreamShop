package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public interface IceCreamSeller extends Profitable {

    default Cone orderCone(Cone.Flavor[] flavors) {
        return new Cone(flavors);
    }

    default IceRocket orderIceRocket() {
        return new IceRocket();
    }

    default Magnum orderMagnum(Magnum.MagnumType type) {
        return new Magnum(type);
    }


}
