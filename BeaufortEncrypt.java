import java.util.Scanner; // Kjo eshte nje librari me emrin  Scanner qe lejon leximin e hyrjes nga tastiera

public class BeaufortEncrypt { // Krijimi i nje klase qe permban nje metode statike  BeaufortEncrypt qe do te perdoret per te enkriptuar tekstin
                            


    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Deklarohet një string ALPHABET që përmban të gjitha shkronjat e alfabetit anglez

    public static String beaufortEncrypt(String text, String key) { // Deklarohet metoda statike beaufortEncrypt që merr dy argumente: një string për të enkriptuar dhe një string për çelësin e enkriptimit.
        StringBuilder cipher = new StringBuilder(); // Krijohet një objekt i klases StringBuilder për të mbajtur tekstin e enkriptuar
        for (int i = 0; i < text.length(); i++) { // Fillon një cikël që kalon nëpër çdo karakter të tekstit për të enkriptuar
            char c0 = text.charAt(i);  // Merr karakterin aktual nga teksti i dhënë për të enkriptuar
            char c1 = key.charAt(i % key.length()); /*  Merr karakterin nga çelësi i dhënë për enkriptim. 
            Nëse gjatësia e çelësit është më e vogël se gjatësia e tekstit për të enkriptuar, çelësi përsëritet përsëri*/
            
            int start = 0; // Deklarohet një variabël start që do të përdoret për të gjetur pozicionin fillestar të karakterit aktual në alfabet nga 'A' deri ne 'Z'
            for (int j = 0; j < 26; j++) { // Fillon një cikël për të gjetur pozicionin fillestar të karakterit aktual në alfabet
                if (ALPHABET.charAt(j) == c0) { // kontrollon nëse karakteri aktual është gjetur në alfabet
                    start = j; // Nëse karakteri është gjetur, pozicioni fillestar është caktuar në vlerën e j
                    break; // stop ose del nga unaza
                }
            }
            int offset = 0; // Deklarohet një variabël offset që do të përdoret për të gjetur shkronjën e enkriptuar në alfabet
            for (int j = start; j < start + 26; j++) { // Fillon një cikël për të gjetur shkronjën e enkriptuar në alfabet
                int letter = j % 26; // Përcakton indeksin e shkronjës në alfabet duke përdorur aritmetikën modulare
                if (ALPHABET.charAt(letter) == c1) { // Kontrollon nëse është gjetur karakteri i çelësit në alfabet
                    break;
                }
                offset++; //  Nëse karakteri i çelësit është gjetur, shënon numrin e hapat që janë bërë për të gjetur shkronjën e enkriptuar.
            }
            cipher.append(ALPHABET.charAt(offset)); // Shtohet shkronja e enkriptuar në tekstin e enkriptuar
        }
        return cipher.toString(); //  Kthehen tekstin e enkriptuar ne një string
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
