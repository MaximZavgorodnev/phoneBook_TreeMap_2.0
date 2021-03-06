import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Contacts {
    Map<String, Contact> contacts = new HashMap<>();

    //    Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья).
    public void addContact(String newContact) {
        String[] parts = newContact.split(" ");
        String name = parts[0];
        String surname = parts[1];
        String phone = parts[2];
        String gropi = parts[3];
        Enum group = Group.valueOf(gropi);
        Contact cont = new Contact(name, surname, phone, group);
        contacts.put(phone, cont);
    }

    // Вывод контактов
    public void outputOfContacts() {
        System.out.println("Список контактов в телефонной книге:");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println();
    }
//    Удаление контакта по имени и фамилии.
    public void deletingContact(String nameSurnameContact, MissedCall missedCalls) {
        String[] parts = nameSurnameContact.split(" ");
        String name = parts[0];
        //перебор контактов
        Iterator<Map.Entry<String, Contact>> itr = contacts.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Contact> entry = itr.next(); //полученный контакт
            Contact contactNew = entry.getValue();
            if (contactNew.getName().equals(name)) {
                for (Map.Entry<LocalDateTime, String> entryTreeMap : missedCalls.missedCalls.entrySet()) {
                    String nameMassageCall = contactNew.getName() + " " + contactNew.getSurname();
                    String value = entryTreeMap.getValue();
                    LocalDateTime key = entryTreeMap.getKey();
                    if (value.equals(nameMassageCall)) {
                        missedCalls.missedCalls.put(key, contactNew.getPhone());
                    }
                }
                System.out.println("найден контакт");
                String k = entry.getKey();
                System.out.println(contacts.remove(k));
                System.out.println("Контакт удален");
                break;
            }
        }


    }
}
