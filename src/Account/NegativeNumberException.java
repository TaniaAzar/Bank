package Account;

public class NegativeNumberException extends RuntimeException {

    //Какая переменная (имя) оказалась неправильной
    private String valueName;

    public NegativeNumberException(String message, String valueName) {
        super(message);
        this.valueName = valueName;
    }

    public String getValueName() {
        return valueName;
    }

}
