package Account;

import java.util.Map;

//класс клиент
public class Client{

    //поля класса-------------------------------------------
    private String name;
    private String surname;
    private final String number_passport;

    //конструктор с параметрами-----------------------------
    public Client(String number_passport, String name, String surname){
        setName(name);
        setSurname(surname);

        if (number_passport == null || number_passport.isEmpty()){
            throw new IllegalArgumentException("Номер паспорта не может быть пустым");
        }
        this.number_passport = number_passport;
        this.setName(name);
        this.setSurname(surname);
    }

    //-----------get and set---------------------
    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }
    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()){
            throw new IllegalArgumentException("фамилия не может быть пустым");
        }
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getNumber_passport() {
        return number_passport;
    }


    //сравнение объектов на равенство-------------------------
    @Override
    public boolean equals(Object object){
        if(object == null){ return false; }
        if (object == this){ return true; }
        if (object.getClass() != this.getClass()){ return false; }

        Client other = (Client)object;
        return this.number_passport.equals(other.number_passport);
    }

    //представление объекта в виде строки------------------
    @Override
    public String toString(){ return String.format(number_passport + " " + name + " " + surname); }
}
