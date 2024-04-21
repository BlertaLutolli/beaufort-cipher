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
            Scanner scanner = new Scanner(System.in); //Krijimi i një objekti të klases Scanner për të pranuar input-in nga përdoruesi
            System.out.println("Cipher Text: "); //Shfaqet mesazhi per te kerkuar tekstin e koduar
            String cipher = scanner.nextLine().toUpperCase(); //Merr input-in për tekstin e shifrës dhe e konverton në shkronja të mëdha (Upper Case)

            String key; //Deklarimi i variablës për ruajtjen e çelësit
            do { System.out.println("Key:"); //Fillimi i loop-it do-while për siguruar që çelësi i dhënë është vetëm tekst alfanumerik
                key = scanner.nextLine().toUpperCase( ); //Merr input-in për çelësin dhe e konverton në shkronja të mëdha
                if (!isAlpha(key)) {  //Kontrolli nëse çelësi i dhënë përmban vetëm shkronja
                    System.out.println("Error:  çelesi duhet te permbaje vetem  shkronja."); //Shfaqja e një mesazhi gabimi nëse çelësi nuk përmban vetëm shkronja
                }
        } while (!isAlpha(key)); //Përsërit loop-in do-while derisa të jepet një çelës i vlefshëm
            String message = beaufortDecrypt(cipher, key); //Dekriptimi i tekstit të shifrës duke përdorur çelësin e dhënë
            System.out.println("Plain Text:" + message); //Shfaqja e tekstit të dekriptuar të shifrës si output
    }
}
