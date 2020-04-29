import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Класс CommandControl управляет всеми применяемыми командами - обрабатывает их и выполняет, вызывая соответствующие методы
 */
public class CommandControl {
static String commandName;
static String[] commandsArray;
static ArrayList<String> history;

    /**
     * Метод Start считывает введённую пользователем команду и вызывает соответстующий метод из класса Commands; выбрасывает исключения при некорректном пользовательском вводе
     * @exception IllegalStateException в случае выбрасывания данного исключения программа завершается
     */
    public void Start()  {
            history = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            commandName = "";
            System.out.println("Введите команду для выполнения. Чтобы узнать все доступные команды введите 'help'");
            try {
                while (commandName != "exit") {
                    Commands commands = new Commands();
                    commandName = scanner.nextLine();
                    commandName = commandName.trim();
                    commandsArray = commandName.trim().split(" ", 2);
                    switch (commandsArray[0]) {
                        case "info":
                            commands.info();
                            history.add(commandName);
                            break;
                        case "help":
                            commands.help();
                            history.add(commandName);
                            break;
                        case "head":
                            commands.head();
                            history.add(commandName);
                            break;
                        case "clear":
                            commands.clear();
                            history.add(commandName);
                            break;
                        case "save":
                            commands.save();
                            history.add(commandName);
                            break;
                        case "show":
                            commands.show();
                            history.add(commandName);
                            break;
                        case "add":
                            commands.add();
                            history.add(commandName);
                            break;
                        case "update_id":
                            commands.updateId();
                            history.add(commandName);
                            break;
                        case "remove_by_id":
                            commands.removeById();
                            history.add(commandName);
                            break;
                        case "sum_of_height":
                            commands.SumOfHeight();
                            history.add(commandName);
                            break;
                        case "max_by_name":
                            commands.maxByName();
                            history.add(commandName);
                            break;
                        case "filter_greater_than_height":
                            commands.filterGreater();
                            history.add(commandName);
                            break;
                        case "remove_greater":
                            commands.removeGreater();
                            history.add(commandName);
                            break;
                        case "history":
                            history.add(commandName);
                            System.out.println(history);
                            break;
                        case "exit":
                           scanner.close();
                           break;
                        case "execute_script":
                            history.add(commandName);
                            commands.execute_script();
                            break;
                    }
                }
            }
            catch (IllegalStateException | IOException e){
                System.out.println("Программа завершена");
            }
            catch (NoSuchElementException e){
                e.getMessage();
            }
    }
}

