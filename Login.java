import java.io.*;
import java.util.*;

public class Login {//Task Performance for Computer Programming 2

    private static Scanner x;

    public static void main(String[] args) throws FileNotFoundException, IOException {//Natanauan, Carlos
        Scanner s = new Scanner(System.in);
        String filepath = "C:\\Users\\Benedict\\Desktop\\ComProg2\\accounts.txt";
        String username = "", password = "";
        System.out.print("Enter '1' to LOG-IN or '2' to REGISTER : ");
        try {
            int u = s.nextInt();
            s.nextLine();
            switch (u) {
                case 1:
                    System.out.println("\n" + "-----LOG-IN-----");
                    System.out.print("Enter Username: ");
                    username = s.nextLine();
                    System.out.print("Enter Password: ");
                    password = s.nextLine();
                    verifyLogIn(username, password, filepath);//will verifyLogIn the user input from the text txt file
                    break;
                case 2:
                    System.out.println("\n" + "-----REGISTER-----");
                    System.out.print("Enter Username: ");
                    username = s.nextLine();
                    System.out.print("Enter Password: ");
                    password = s.nextLine();
                    register(username, password, filepath);//will add the credentials to the txt file
                    break;
            }
            if (u != 1 && u != 2) //if input is not 1 or 2
                throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("\n" + "---Out of Range! Only '1' or '2' is accepted---");
        } catch (InputMismatchException ex) {
            System.out.println("\n" + "---Invalid Input! Only '1' or '2' is accepted---");
        }
    }

    public static void verifyLogIn(String username, String password, String filepath) {
        boolean found = false;
        String tempUser = "", tampPass = "";
        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUser = x.next();
                tampPass = x.next();
                if (tempUser.trim().equals(username.trim()) && tampPass.trim().equals(password.trim())) {
                    found = true;
                }
            }
            x.close();
            if (found == true) {
                System.out.println("\n" + "--------------" + "\n" + "Log-In Success" + "\n"
                        + "    Welcome" + "\n" + "--------------");
            } else {
                System.out.println("\n" + "-------------------------------" + "\n" + "Incorrect Username or Password" + "\n"
                        + "    Please Try Again" + "\n" + "-------------------------------");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public static void register(String username, String password, String filepath) throws IOException {
        Writer addToTxt;
        addToTxt = new BufferedWriter(new FileWriter(filepath, true));
        String reg = "\n" + username + "," + password;
        addToTxt.append(reg);//will add the username and password to the txt file
        addToTxt.close();
        System.out.println("\n" + "--------------------" + "\n" + "Registration Success" + "\n"
                + "      Welcome" + "\n" + "--------------------");
    }
}
