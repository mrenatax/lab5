import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Класс, поля которого задают поле coordinates класса SpaceMarine
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    private Float x; //Поле не может быть null
    private float y;
    Coordinates(){}
    /**
     * @param x Поле не может быть null
     * @param y Поле может быть любым float
     */
    public Coordinates(Float x, float y){
        if ((checker(x))||(checker(y)))
            throw new IllegalArgumentException("Поле x и y coordinates не может быть null");
        this.x = x;
        this.y = y;
    }
    /**
     * Метод возвращает значение x
     * @return Float
     */
    Float getX(){
        return x;
    }
    /**
     * Метод задаёт поля x и y класса Coordinates, используя сканер, выбрасывает исключение при некорректном вводе данных
     * @exception InputMismatchException
     */
    void setXY(){
        try {
            Scanner sv = new Scanner(System.in);
            x = sv.nextFloat();
            y = sv.nextFloat();
        }
        catch (InputMismatchException e){
            System.out.println("Данные заполнены некорректно, повторите ввод:");
            setXY();
        }
    }
    /**
     * Метод задаёт поля x и y класса Coordinates, считывая сканером данные из скрипта, выбрасывает исключение при некорректном вводе данных.
     * @exception InputMismatchException
     */
    void setXYForScript(){
        try{
            x = Float.parseFloat(Commands.slmmsk.nextLine());
            y = Float.parseFloat(Commands.slmmsk.nextLine());
            if (x == null){System.out.println("поле х заполнено некорректно, не может быть null");}
        }catch(InputMismatchException e){
            System.out.println("Поля x и у в скрипте указаны некорректно");
        }
    }
    /**
     * Метод используется для определения null поля
     */
    private <T> boolean checker(T p) {
        return (p == null);
    }
    @Override
    public String toString() {
        return ("x = " + x + " y = " + y);
    }
}
