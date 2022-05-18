package be.intecbrussel.eatables;

public class Cone implements Eatable {

    private Flavor[] balls;

    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        System.out.printf("I'm eating a cone with ");
        for (Flavor f : balls) {
            System.out.printf("%s, ",f);
        }

        System.out.println("flavor");

    }

    public enum Flavor {
        STRAWBERRY, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE
    }

}
