package util;

import java.time.LocalDate;
import java.util.Scanner;

public class InputUtil {
    public static int requiredInputInt(String msg){
        try{
            Scanner scanner=new Scanner(System.in);
            System.out.print(msg);
            return scanner.nextInt();
        }catch (Exception ex){
            System.out.println("Wrong option...");
        }
        return 0;

    }
    public static String  requiredInputString(String msg){
        Scanner scanner=new Scanner(System.in);
        System.out.print(msg);
        return scanner.nextLine();
    }
    public static LocalDate requiredInputDate(String msg){
        while(true){
            try{
                Scanner scanner=new Scanner(System.in);
                System.out.print(msg);
                return LocalDate.parse(scanner.next());
            }catch (Exception ex){
                System.out.println("Wrong Value!!!");
            }
        }
    }
}
