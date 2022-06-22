import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/** Class Main ************
 * @author Nevena Kolev
 * @version 1.0, 18-03-22
 **************************/
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String oldChecksumFile = "";
    static String newChecksumFile = "";
    //static String oldChecksumDir = "";
    //static String newChecksumDir = "";
    static String userInput = "";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MessageDigest mdigest = MessageDigest.getInstance("MD5");   // MD5 hashing algorithm to generate the checksum
        //File testDir = new File("./src/files");
        new File("./src/files").mkdir();
        File testFile = new File("./src/files/testfile.txt");
        //if (testDir.setWritable(true)) System.out.println("YESS");
        //testDir.mkdir();    // creates a directory of the given file


        do {
            System.out.println("\n\n===============================================================");
            //oldChecksumDir = MyFileHasher.getChecksum(mdigest, testDir);
            oldChecksumFile = MyFileHasher.getChecksum(mdigest, testFile);

            System.out.println("Press ENTER after you made changes. . . ");
            sc.nextLine();

            newChecksumFile = MyFileHasher.getChecksum(mdigest, testFile);
            //newChecksumFile = MyFileHasher.getChecksum(mdigest, testDir);

            System.out.println("FILE -> OLD CHECKSUM: " + oldChecksumFile);
            System.out.println("FILE -> CHECKSUM: " + newChecksumFile + "\n");
            //System.out.println("DIR  -> OLD CHECKSUM: " + oldChecksumDir);
            //System.out.println("DIR  -> CHECKSUM: " + newChecksumDir + "\n");

            if (oldChecksumFile.equals(newChecksumFile)) System.out.print("No changes have been found in the file! ");
                else System.out.print("Changes have been found in the file! ");

            //if (oldChecksumDir.equals(newChecksumDir)) System.out.print("No changes have been found in the directory! ");
            //    else System.out.print("Changes have been found in the directory! ");

            System.out.print("Do you want to try again? [y | n]: ");
            do { userInput = sc.nextLine();}
                while (!userInput.equals("y") && !userInput.equals("n"));

        } while (userInput.equals("y"));

        System.out.println("\n +°.   Goodbye!   +°.");
    }
}
