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
            Scanner scanner = new Scanner(System.in); // Krijimi i një objekti të klases Scanner për të pranuar input-in nga përdoruesi
            System.out.println("Cipher Text: "); //Shfaqet mesazhi per te kerkuar tekstin e koduar
            String cipher = scanner.nextLine().toUpperCase(); // Merr input-in për tekstin e shifrës dhe e konverton në shkronja të mëdha (Upper Case)

            String key; // Deklarimi i variablës për ruajtjen e çelësit
            do { System.out.println("Key:"); // Fillimi i loop-it do-while për siguruar që çelësi i dhënë është vetëm tekst alfanumerik
                key = scanner.nextLine().toUpperCase( ); // Merr input-in për çelësin dhe e konverton në shkronja të mëdha
                if (!isAlpha(key)) {  // Kontrolli nëse çelësi i dhënë përmban vetëm shkronja
                    System.out.println("Error:  çelesi duhet te permbaje vetem  shkronja."); // Shfaqja e një mesazhi gabimi nëse çelësi nuk përmban vetëm shkronja
                }
        } while (!isAlpha(key)); // Përsërit loop-in do-while derisa të jepet një çelës i vlefshëm
            String message = beaufortDecrypt(cipher, key); // Dekriptimi i tekstit të shifrës duke përdorur çelësin e dhënë
            System.out.println("Plain Text:" + message); // Shfaqja e tekstit të dekriptuar të shifrës si output
    }
}
