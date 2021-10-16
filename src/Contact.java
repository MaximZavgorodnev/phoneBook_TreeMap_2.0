public class Contact {
    protected String name;
    protected String surname;
    protected String phone;
    private Enum group;


    public Contact(String name, String surname, String phone, Enum group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    @Override
    public String toString() {
        return "\n[Контакт] " + ": " + name + " " + surname + "/ Номер телефона: " + phone + " " + group;
    }
}