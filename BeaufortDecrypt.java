import java.util.Scanner; //Kjo është një librari me emrin Scanner që lejon leximin e hyrjes nga tastiera.

public class BeaufortDecrypt { //Krijimi i një klase që përmban një metodë statike BeaufortDecrypt që do të përdoret për të dekriptuar tekstin.
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //Deklarohet një string ALPHABET që përmban të gjitha shkronjat e alfabetit anglez.

    public static boolean isAlpha(String str) { //Definon një metode statike 'isAlpha' e cila ka nje string si argument për të treguar nëse stringu përmban shkronja alfabetike.
        return str.matches("[a-zA-Z]+"); //Verifikon nëse stringu përmban vetëm shkronja alfabtike.
    }

    public static String beaufortDecrypt(String cipher, String key) { //Deklarohet metoda statike beaufortDecrypt që merr dy argumente: një cipher për të dekriptuar dhe një string për çelësin e dekriptimit.
        StringBuilder decipher = new StringBuilder(); //Krijohet një objekt i klasës StringBuilder për të mbajtur tekstin e dekriptuar.
        for (int i = 0; i < cipher.length(); i++) { //Fillon një cikël që kalon nëpër çdo karakter të chiper për të dekriptuar.
            char c0 = cipher.charAt(i); //Merr karakterin në pozitën e caktuar 'i' nga stringu 'chiper' dhe e ruan ne c0.
            char c1 = key.charAt(i % key.length()); //Merr një karakter nga çelësi i dhëne për dekriptim.
            int offset = ALPHABET.indexOf(c1) - ALPHABET.indexOf(c0); //Përdor një strukturë 'indexOf()' për të gjetur indeksin e karakterit në stringun ALPHABET, nxjerrim distancën (offsetin) në mes c1 dhe c0.
            if (offset < 0) {
                offset += 26; //Normalizohet vlera e offset nëse vlera e tij është negative.
            }
            decipher.append(ALPHABET.charAt(offset % 26)); //Shtohet shkronja e dekriptuar në tekstin e dekriptuar.
        }
        return decipher.toString(); //Kthen tekstin e dekriptuar në një string.
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
