package be.intecbrussel.sellers;

public interface Profitable {

    default double getProfit(){
        return 0;
    }
}
