import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = new ArrayList<>();
        //for test
        shoppingList.add("Bread");
        shoppingList.add("Meat");
        shoppingList.add("Candy");
        shoppingList.add("Burger");
        shoppingList.add("Sugar");
        shoppingList.add("CheeseBurger");

        while (true) {
            System.out.println();
            System.out.println("Shopping list!  \n Add - 1, Show - 2, Delete - 3, Find - 4 , Exit  - 5 ");
            //System.out.println("Список покупок! \n Что бы добавить в список введите - 1, показать список - 2, удалить из списка - 3, найти в списке - 4 , для выхода  - 5 ");
            String input = scanner.nextLine();
            if (input.length() > 1) {
                System.out.println("Enter correctly, please!");
                continue;
            }
            if (input.equals("1")) {
                System.out.println("What do you want to add? ");
                input = scanner.nextLine();
                shoppingList.add(input);
                System.out.printf(" On shopping List now %s item('s). \n", shoppingList.size());
                System.out.println();
            }
            if (input.equals("2")) {
                showList(shoppingList);
            }
            if (input.equals("3")) {
                if (shoppingList.size() != 0) {
                    System.out.println("What do you want to delete? (enter number or name)");
                    input = scanner.nextLine();
                    int index;
                    String name;
                    try {
                        index = Integer.parseInt(input);
                        if (index <= 0 || (index - 1) >= shoppingList.size()) {
                            System.out.println("Wrong number entered!!!");
                        } else {
                            System.out.printf("%s - has been deleted!\n", shoppingList.get(index - 1));
                            shoppingList.remove(index - 1);
                            showList(shoppingList);
                        }
                    } catch (NumberFormatException e) {
                        name = input;
                        int containsOrNot = contentIndex(name, shoppingList);
                        if (containsOrNot >= 0) {
                            System.out.printf("%s - has been deleted!\n", name);
                            shoppingList.remove(containsOrNot);
                            showList(shoppingList);
                        } else {
                            System.out.println("Wrong name entered!!!");
                        }
                    }
                } else {
                    System.out.println("Shopping List is empty!");
                }
            }
            if (input.equals("4")) {
                System.out.println("What do you want to find?");
                input = scanner.nextLine();
                if (!input.equals("")) {
                    String partOf = input.toLowerCase();
                    System.out.println("Found : ");
                    int count = 0;
                    for (int i = 0; i < shoppingList.size(); i++) {
                        if (shoppingList.get(i).toLowerCase().contains(partOf)) {
                            System.out.println((i + 1) + " ." + shoppingList.get(i));
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Nothing =(");
                    }
                } else {
                    System.out.println("Wrong name entered!!!");
                }
            }
            if (input.equals("5")) {
                break;
            }
        }
    }

    public static void showList(List<String> list) {
        if (list.size() != 0) {
            int count = 1;
            for (String sp : list) {
                System.out.println(count + ". " + " " + sp);
                count++;
            }
        } else {
            System.out.println("List is empty!!!");
        }
    }

    public static int contentIndex(String srt, List<String> list) {
        int contIndx = -1;
        String str = srt.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().equals(str)) {
                contIndx = i;
            }
        }
        return contIndx;
    }
}
