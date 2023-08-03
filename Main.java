package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();

        boolean flag = true;
        while(flag) {
            System.out.println("""
                    Available actions:\s
                    0 - to shut down
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove any item(s) (comma delimited list)
                    Enter a number for which action you want to do:""");
            String closeInput = scanner.nextLine();
            if (Objects.equals(closeInput, "0")) {
                flag = false;
            }

            if (Objects.equals(closeInput, "1")) {
                System.out.println("Add item(s) to list (comma delimited list): ");
                String input = scanner.nextLine();
                String[] temp = input.split(",");
                for (String i : temp) {
                    String trimmed = i.trim();
                    if (groceryList.contains(trimmed)){
                        continue;
                    }
                    groceryList.add(trimmed);
                }
                groceryList.sort(Comparator.naturalOrder());
                System.out.println(groceryList);
            }

            if (Objects.equals(closeInput, "2")) {
                System.out.println("Remove item(s) to list (comma delimited list): ");
                String input = scanner.nextLine();
                String[] temp = input.split(",");
                for (String i : temp) {
                    String trimmed = i.trim();
                    groceryList.remove(trimmed);
                }
                groceryList.sort(Comparator.naturalOrder());
                System.out.println(groceryList);
            }

        }
        System.out.println("Program ended\nFinal grocery list: " + groceryList);
    }
}
