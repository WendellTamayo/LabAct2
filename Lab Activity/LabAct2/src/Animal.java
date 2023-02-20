abstract class Animal {
    protected int legs;
    protected Animal(int legs) {
        this.legs = legs;
    }
    public void walk() {
        System.out.println("Animal is walking with " + legs + " legs");
    }
    public abstract void eat();

}

