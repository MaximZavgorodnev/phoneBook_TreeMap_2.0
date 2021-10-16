import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MissedCall {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    // Добавление пропущенных вызовов
    public void addMissedCall(String input, Map<String, Contact> cont) {
        Boolean pust = true;
        LocalDateTime timeMessageCall = LocalDateTime.now();
        if (!(cont.size() == 0)) {
            // Проверка на совпадение контакта
            Iterator<Map.Entry<String, Contact>> itr = cont.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, Contact> entry = itr.next(); //полученный контакт
                Contact contactNew = entry.getValue();
                if (contactNew.phone.equals(input)) {
                    Contact k = cont.get(input);
                    String nameMassageCall = k.name + " " + k.surname;
                    missedCalls.put(timeMessageCall, nameMassageCall);
                    pust = false;
                    break;
                }
            }
        } else {
            missedCalls.put(timeMessageCall, input);
        }
        if (pust) {
            missedCalls.put(timeMessageCall, input);
        }
    }


    //Очистка пропущенных вызовов
    public void clearingListOfMissedCalls() {
        missedCalls.clear();
        output();
        System.out.println("Список пут.");
    }

    //Вывод пропущенных вызовов
    public void output() {
        System.out.println("Пропущенные вызовы:");
        for (Map.Entry<LocalDateTime, String> item2 : missedCalls.entrySet()) {
            int h = item2.getKey().getHour();
            int m = item2.getKey().getMinute();
            int ms = item2.getKey().getSecond();
            LocalDate date = item2.getKey().toLocalDate();
            System.out.println(h + ":" + m + ":" + ms + "  " + date + "  " + item2.getValue());
        }
    }
}
