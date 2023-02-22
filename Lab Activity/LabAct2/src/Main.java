import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum number of animals: ");
        int maxSize = sc.nextInt();
        ListAnimals animalList = new ListAnimals(maxSize);
        boolean exit = false;
        while(!exit) {
            System.out.println("1. Add new animal");
            System.out.println("2. Search animal");
            System.out.println("3. Delete an animal");
            System.out.println("4. Display all animals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            int count = animalList.getCount();
            switch (choice) {
                case 1:
                    System.out.println("Enter the type of animal (cat or fish): ");
                    String animalType = sc.next();
                    System.out.println("Enter the name of the animal: ");
                    String animalName = sc.next();
                    if (animalList.searchByName(animalName) != null) {
                        System.out.println("Animal already exists!");
                        break;
                    }
                    if (animalType.equalsIgnoreCase("cat")) {
                        System.out.println(animalList.addAnimal(new Cat(animalName)));
                        count++;
                    } else if (animalType.equalsIgnoreCase("fish")) {
                        System.out.println(animalList.addAnimal(new Fish(animalName)));
                        count++;
                    } else {
                        System.out.println("Invalid Animal Type!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the animal to be searched: ");
                    String searchName = sc.next();
                    Animal temp = animalList.searchByName(searchName);
                    if (temp == null) {
                        System.out.println(searchName + " not in the list!");
                        break;
                    }
                    System.out.println(searchName + " is in the list and has " + temp.legs + " legs!");
                    break;
                case 3:
                    System.out.println("Enter the name of the animal to be deleted: ");
                    String deleteName = sc.next();
                    Animal temp1 = animalList.deleteAnimal(deleteName);
                    if (temp1 == null) {
                        System.out.println(deleteName + " not in the list!");
                        break;
                    }
                    break;
                case 4:
                    animalList.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
