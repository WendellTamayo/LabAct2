import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // Display a menu with the following choice 1. Add an animal 2. Delete an animal 3. Display all animals 4. Exit
         // Add an animal: Ask the user to enter the type of animal (cat, dog, or bird) and the name of the animal.
            // Delete an animal: Ask the user to enter the name of the animal to be deleted.
            // Display all animals: Display all the animals in the list.
            // Exit: Exit the program.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum number of animals: ");
        int maxSize = sc.nextInt();
        ListAnimals animalList = new ListAnimals(maxSize);

        while(true) {
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
                    if (count != 0 && animalList.searchByName(animalName) != null) {
                        System.out.println("Animal already exists!");
                        break;
                    }
                    if (animalType.equalsIgnoreCase("cat")) {
                        animalList.addAnimal(new Cat(animalName));
                        count++;
                    } else if (animalType.equalsIgnoreCase("fish")) {
                        animalList.addAnimal(new Fish(animalName));
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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
