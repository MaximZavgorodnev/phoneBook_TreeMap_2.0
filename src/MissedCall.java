import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MissedCall {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    // Добавление пропущенных вызовов
    public void addMissedCall(String input) {
        LocalDateTime timeMessageCall = LocalDateTime.now();
        missedCalls.put(timeMessageCall, input);
    }


    //Очистка пропущенных вызовов
    public void clearingListOfMissedCalls() {
        missedCalls.clear();
        System.out.println("Список пут.");
    }

    //Вывод пропущенных вызовов
    public void outputOfMissedCalls(Contacts contacts) {
        System.out.println("Пропущенные вызовы:");

        //Перебор пропущенных номеров
        for (Map.Entry<LocalDateTime, String> entryTreeMap : missedCalls.entrySet()) {
            String value = entryTreeMap.getValue();
            LocalDateTime key = entryTreeMap.getKey();

            if (!(contacts.contacts.isEmpty())) {
                // Проверка на совпадение контакта
                Iterator<Map.Entry<String, Contact>> itr = contacts.contacts.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<String, Contact> entry = itr.next(); //полученный контакт
                    Contact contactNew = entry.getValue();
                    if (contactNew.getPhone().equals(value)) {
                        Contact k = contacts.contacts.get(value);
                        String nameMassageCall = k.getName() + " " + k.getSurname();
                        missedCalls.put(key, nameMassageCall);
//                    } else {
//                        System.out.println(key + " 1 " + value);
//                        missedCalls.put(key, value);
                    }
                }
//            } else {
//                System.out.println(key + " 2 " + value);
//                missedCalls.put(key, value);
            }
        }

        for (Map.Entry<LocalDateTime, String> item2 : missedCalls.entrySet()) {
            int h = item2.getKey().getHour();
            int m = item2.getKey().getMinute();
            int ms = item2.getKey().getSecond();
            LocalDate date = item2.getKey().toLocalDate();
            System.out.println(h + ":" + m + ":" + ms + "  " + date + "  " + item2.getValue());
        }
    }
}
