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
    // Metoda që verifikon nëse një string përmban vetëm shkronja
    public static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("PlainText: ");
        String message = scanner.nextLine();

        String key;
        do {
            System.out.print("Key: ");
            key = scanner.nextLine();
            if (!isAlpha(key)) {
                System.out.println("Error: Celesi duhet te permbaje vetem shkronja.");
            }
        } while (!isAlpha(key));

        String cipher = beaufortEncrypt(message.toUpperCase(), key.toUpperCase());
        System.out.println("CipherText: " + cipher);
    }
}
