public class ListAnimals {
    private Animal[] animal;
    private int count;

    public ListAnimals(int maxArray) {
        animal = new Animal[maxArray];
        setCount(0);
    }
    public Animal[] getAnimal() {
        return animal;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean addAnimal(Animal a) {
        if (a instanceof Pet pet) {
            if (searchByName(pet.getName()) == null) {
                if (count < animal.length) {
                    animal[count] = a;
                    setCount(getCount() + 1);
                    return true;
                }
            }
        }
        return false;
    }
    public Animal searchByName(String name) {
        for (int i = 0; i < count; i++) {
            if (animal[i] instanceof Pet pet) {
                if (pet.getName().equals(name)) {
                    return animal[i];
                }
            }
        }
        return null;
    }
    public Animal deleteAnimal(String name) {
        Animal a = searchByName(name);
        if (a != null) {
            for (int i = 0; i < count; i++) {
                if (animal[i] == a) {
                    for(int j = i; j < count - 1; j++) {
                        animal[j] = animal[j + 1];
                    }
                    animal[count - 1] = null;
                    count--;
                    return a;
                }
            }
        }
        return  null;
    }
    public void display() {
        for (Animal a : animal) {
            if (a instanceof Pet pet) {
                System.out.println(pet.getName());
            }
        }
    }
}
