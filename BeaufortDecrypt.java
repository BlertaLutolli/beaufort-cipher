import java.util.Scanner;

public class BeaufortDecrypt {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static String beaufortDecrypt(String cipher, String key) {
        StringBuilder decipher = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            char c0 = cipher.charAt(i);
            char c1 = key.charAt(i % key.length());
            int offset = ALPHABET.indexOf(c1) - ALPHABET.indexOf(c0);
            if (offset < 0) {
                offset += 26;
            }
            decipher.append(ALPHABET.charAt(offset % 26));
        }
        return decipher.toString();
    }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Cipher Text: ");
            String cipher =
                    scanner.nextLine().toUpperCase();

            String key;
            do { System.out.println("Key:");
                key = scanner.nextLine().toUpperCase( );
                if (!isAlpha(key)) {
                    System.out.println("Error: Celesi duhet te permbaje vetem  shkronja.");
                }
        } while (!isAlpha(key));
            String message = beaufortDecrypt(cipher, key);
            System.out.println("Plain Text:" + message);
    }
}
