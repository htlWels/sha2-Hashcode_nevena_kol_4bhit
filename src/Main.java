import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/** Class Main ************
 * @author Nevena Kolev
 * @version 1.0, 18-03-22
 **************************/
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String oldChecksum = "";
    static String newChecksum = "";
    static String userInput = "";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File testFile = new File("src\\files\\testfile.txt");
        MessageDigest mdigest = MessageDigest.getInstance("MD5");   // MD5 hashing algorithm to generate the checksum

        do {
            System.out.println("\n\n===============================================================");
            oldChecksum = MyFileHasher.getChecksum(mdigest, testFile);

            System.out.println("Press ENTER after you made changes. . . ");
            sc.nextLine();

            newChecksum = MyFileHasher.getChecksum(mdigest, testFile);

            System.out.println("OLD CHECKSUM: " + oldChecksum);
            System.out.println("NEW CHECKSUM: " + newChecksum + "\n");

            if (oldChecksum.equals(newChecksum)) System.out.print("No changes have been found! ");
                else System.out.print("Changes have been found! ");

            System.out.print("Do you want to try again? [y | n]: ");
            do { userInput = sc.nextLine();}
                while (!userInput.equals("y") && !userInput.equals("n"));

        } while (userInput.equals("y"));

        System.out.println("\n +°.   Goodbye!   +°.");
    }
}
