public class Contact {
    private String name;
    private String surname;
    private String phone;
    private Enum group;


    public Contact(String name, String surname, String phone, Enum group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "\n[Контакт] " + ": " + name + " " + surname + "/ Номер телефона: " + phone + " " + group;
    }
}