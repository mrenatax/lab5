import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Класс, поля которого задают поле chapter класса SpaceMarine
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    public Chapter(){}
    /**
     * @param name Поле не может быть null, Строка не может быть пустой
     * @param marinesCount Значение поля должно быть больше 0, Максимальное значение поля: 1000
     */
    public Chapter(String name, long marinesCount){
        if (isChapterNameValid(name))  throw new IllegalArgumentException("Поле name(Chapter) не может быть null, Строка не может быть пустой");
        this.name = name;
        if (isChapterMarinesCount(marinesCount))
            throw new IllegalArgumentException("Значение поля marinesCount(Chapter) должно быть больше 0, Максимальное значение поля: 1000");
        this.marinesCount = marinesCount;
    }

    /**
     * Метод возвращает значение поля name
     * @return String
     */
    public String getChapterName(){
        return name;
    }
    /**
     * Метод возвращает значение поля marinesCount
     * @return long
     */
    public long getMarinesCount(){
        return marinesCount;
    }
    /**
     * Метод устанавливает значения полей name и marinesCount, считывая сканером вводимые данные
     * @exception InputMismatchException выбрасывается при некорректном пользовательском вводе
     */
    public void setChapterFields(){
        try {
            Scanner sv = new Scanner(System.in);
            name = sv.next();
            marinesCount = sv.nextLong();
        }
        catch (InputMismatchException e){
            System.out.println("Поле заполнено некорректно: сначала String name, затем Long marinesCount. Повторите ввод");
            setChapterFields();
        }
    }
    /**
     * Метод устанавливает значения полей name и marinesCount, считывая сканером данные из скрипта
     * @exception InputMismatchException выбрасывается при некорректных данных в скрипте
     */
    public void setChapterFieldsForScript(){
        try{
            name = Commands.slmmsk.nextLine();
            marinesCount = Long.parseLong(Commands.slmmsk.nextLine());
        }catch (InputMismatchException e){
            System.out.println("Поля chapter в скрипте указаны некорректно");
        }
    }

    /**
     * Метод используется для проверки поля name на корректность
     * @param p
     * @return boolean
     */
    private  boolean isChapterNameValid(String p) { //обобщённый метод
        return ((p == null)||(p.trim().length()==0));
    }

    /**
     * Метод используется для проверки поля marinesCount на корректность
     * @param p
     * @return boolean
     */
    private boolean isChapterMarinesCount(long p){
        return ((p<0)||(p>1000));
    }
    @Override
    public String toString() {
        return ("name: "+ name + " marinesCount: " + marinesCount);    }
}
