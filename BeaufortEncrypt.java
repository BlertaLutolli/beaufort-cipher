import java.util.Scanner;

public class BeaufortEncrypt {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String beaufortEncrypt(String text, String key) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c0 = text.charAt(i);
            char c1 = key.charAt(i % key.length());
            int start = 0;
            for (int j = 0; j < 26; j++) {
                if (ALPHABET.charAt(j) == c0) {
                    start = j;
                    break;
                }
            }
            int offset = 0;
            for (int j = start; j < start + 26; j++) {
                int letter = j % 26;
                if (ALPHABET.charAt(letter) == c1) {
                    break;
                }
                offset++;
            }
            cipher.append(ALPHABET.charAt(offset));
        }
        return cipher.toString();
    }
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("CipherText: ");
        String cipher = scanner.nextLine();
        System.out.print("Key: ");
        String key = scanner.nextLine();
        String message = beaufortDecrypt(cipher.toUpperCase(), key.toUpperCase());
        System.out.println("PlainText: " + message);
    }
}
