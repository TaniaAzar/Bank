package Account;

//класс клиент
public class Client {

    //поля класса-------------------------------------------
    private String name, surname, number_passport;

    //конструктор с параметрами-----------------------------
    public Client(String number_passport, String name, String surname){
        this.number_passport = number_passport;
        this.setName(name);
        this.setSurname(surname);
    }

    //-----------get and set---------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getNumber_passport() {
        return number_passport;
    }
    public void setNumber_passport(String number_passport){ this.number_passport = number_passport;}

    //сравнение объектов на равенство-------------------------
    @Override
    public boolean equals(Object object){
        if(object == null){ return false; }
        if (object == this){ return true; }
        if (object.getClass() != this.getClass()){ return false; }

        Client other = (Client)object;
        if (this.name == other.name && this.surname == other.surname && this.number_passport == other.number_passport){
            return true;
        }else { return false; }
    }
    //представление объекта в виде строки------------------
    @Override
    public String toString(){ return String.format(number_passport + " " + name + " " + surname); }
}
