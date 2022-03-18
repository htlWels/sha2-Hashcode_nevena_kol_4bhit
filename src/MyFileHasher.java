import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/** Class MyFileHasher ******
 * @author Nevena Kolev
 * @version 1.0, 18-03-2022
 ****************************/
public class MyFileHasher {
    public static String getChecksum(MessageDigest digest, File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);    // needed to read the file content
        byte[] byteArray = new byte[1024];      // Create byte array to read data in chunks
        int bytesCount = 0;

        // read the data from file and update that data in the message digest
        while ((bytesCount = fis.read(byteArray)) != -1) { digest.update(byteArray, 0, bytesCount);}
        fis.close();

        byte[] hashcode = digest.digest();
        return getHexFormat(hashcode);
    }

    public static String getHexFormat(byte[] decimalArray) {
        StringBuilder sb = new StringBuilder();

        for (byte b : decimalArray)
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));

        return sb.toString();
    }
}
