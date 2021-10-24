import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissedCall missedCalls = new MissedCall();
        Contacts contacts = new Contacts();
        System.out.println("Телефонная книга");
        String input = "0000";
        while (true) {
            selectingAction();
            input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if ((Integer.parseInt(input) == 1)) {
                while (true) {
                    //Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья).
                    System.out.println("Введите новый контакт в формате: Имя Фамилия Номер телефона Название группы контактов(WORK, FAMILY, FRIENDS, OTHER). Или введите 'нет'");
                    input = scanner.nextLine();
                    if ("нет".equals(input)) break;
                    contacts.addContact(input);
                    System.out.println("Контакт добавлен");
                    System.out.println("Добавить еще один контакт? Если нет введите 'нет' ");
                    input = scanner.nextLine();
                    if ("нет".equals(input)) break;
                }
                //Вывод списка контактов
                contacts.outputOfContacts();
                //Удаления контактов
                System.out.println("Желаете удалить какой либо контакт?");
                input = scanner.nextLine();
                if (!"нет".equals(input)) {
                    while (true) {
                        System.out.println("Введите контакт который желаете удалить в формате: Имя Фамилия. Или введите 'нет'");
                        input = scanner.nextLine();
                        if ("нет".equals(input)) break;
                        contacts.deletingContact(input, missedCalls);
                    }
                }
                //Вывод списка контактов
                contacts.outputOfContacts();
                input = "0";
            }
            //Добавление пропущенного вызова
            if (Integer.parseInt(input) == 2) {
                while (true) {
                    System.out.println("Введите пропущенный вызов. Или введите 'нет'");
                    input = scanner.nextLine();
                    if ("нет".equals(input)) break;
                    missedCalls.addMissedCall(input);

                }
                input = "0";
            }
            // Вывод пропущенных вызовов
            if (Integer.parseInt(input) == 3) {
                missedCalls.outputOfMissedCalls(contacts);
            }
            //Очистка пропущенных вызовов
            if (Integer.parseInt(input) == 4) {
                missedCalls.clearingListOfMissedCalls();
            }
        }
    }


    public static void selectingAction() {
        System.out.println("Введеите номер желаемого действия" +
                "\n 1. Добавить контакт" +
                "\n 2. Добавить пропущенный вызов" +
                "\n 3. Вывести все пропущенные вызовы" +
                "\n 4. Очистить пропущенные вызовы" +
                "\n Если желаете завершить программу введите end");
    }


}