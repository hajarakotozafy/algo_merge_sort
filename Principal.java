import java.util.Random;
import java.util.Scanner;

public class Principal {
    private static int[] creerTab(int taille) {
        int tab[] = new int[taille];
        Random random = new Random();

        for (int i = 0; i < taille; i++) {
            tab[i] = random.nextInt(100);
        }
        return tab;
    }

    private static void afficher(int[] tableau) {
        for(int i: tableau) {
            System.out.print(i + " | ");
        }
        System.out.println();
    }

    public static boolean validInput(String number){
        try {
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static int convertNumber(String number){
        return Integer.parseInt(number);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TrieSimple ts = new TrieSimple();
        TrieFusion tf = new TrieFusion();
        TrieFusionWithoutThreads tfwt = new TrieFusionWithoutThreads();

        char response = 'O';
        while (response == 'O' || response == 'o'){
            System.out.println("Veuillez entrer la taille du tableau:");
            String number = sc.nextLine();
            while(!validInput(number)){
                System.out.println("Veuillez entrer un nombre valide");
                number = sc.nextLine();
            }

            int tailleTab = convertNumber(number);

            Random random = new Random();
            int[] tabSim = new int[tailleTab];
            int[] tabFus = new int[tailleTab];
            int rand = 0;

            for (int i = 0; i < tailleTab; i++) {
                rand = random.nextInt(100);
                tabSim[i] = rand;
                tabFus[i] = rand;
            }

            
            System.out.println("=======================================================");
            System.out.println("Tableau initial");
            afficher(tabSim);
            System.out.println("=======================================================");


            long startFusion = System.currentTimeMillis();
            int[] tableauTrieF = tf.trieD(tabFus);
            long endFusion = System.currentTimeMillis();
            
            
            long startFusionWT = System.currentTimeMillis();
            int[] tableauTrieFWT = tf.trieD(tabFus);
            long endFusionWT = System.currentTimeMillis();



            long startSimple = System.currentTimeMillis();
            int[] tableauTrieS = ts.maxTab(tabSim);
            long endSimple = System.currentTimeMillis();

            System.out.println("=======================================================");
            System.out.println("Tableau avec Trie Simple");
            afficher(tableauTrieS);
            System.out.println("=======================================================");
            
            System.out.println("=======================================================");
            System.out.println("Tableau avec Trie Fusion avec Threads");
            afficher(tableauTrieF);
            System.out.println("=======================================================");
            
            
            System.out.println("=======================================================");
            System.out.println("Tableau avec Trie Fusion sans Threads");
            afficher(tableauTrieFWT);
            System.out.println("=======================================================");

            System.out.println("\n");
            System.out.println("la durée d'execution du trie simple est de: " + (double) (endSimple - startSimple)/1000 + " seconde(s)");
            System.out.println("la durée d'execution du trie fusion sans Threads est de: " + (double) (endFusionWT - startFusionWT)/1000 + " seconde(s)");
            System.out.println("la durée d'execution du trie fusion avec Threads est de: " + (double) (endFusion - startFusion)/1000 + " seconde(s)");
            System.out.println("\n");
            System.out.println("Voulez-vous reessayer un autre tri? (O/N)");
            response = sc.nextLine().charAt(0);

        }

        System.out.println("FIN DU PROGRAMME");
    }
}