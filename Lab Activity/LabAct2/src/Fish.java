public class Fish extends Animal implements Pet{
    private String name;
    public Fish(String name) {
        super(0);
        this.name = name;
    }
    public Fish() {
        this("");
    }
    @Override
    public void eat() {
        System.out.println("Fish is eating");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Fish is playing");
    }
}
