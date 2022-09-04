import java.util.Random;
import java.util.Scanner;

public class TrieSimple {
    public static int[] maxTab(int[] tab) {
        int[] tabTrie = new int[tab.length];
        int min = 200;
        int index = 0;
        for (int j = 0; j < tabTrie.length; j++) {
            for (int i = 0; i < tab.length; i++) {
                    if(min > tab[i]){
                        min = tab[i];
                        index = i;
                    }
            }
            tabTrie[j] = min;
            min = 200;
            tab[index] = 200;
        }
        return tabTrie;
    }

}
    // public static boolean validInput(String number){
    //     try {
    //         Integer.parseInt(number);
    //         return true;
    //     }catch (Exception e){
    //         return false;
    //     }
    // }

    // public static int convertNumber(String number){
    //     return Integer.parseInt(number);
    // }
    // private static void afficher(int[] tab) {
    //     int taille = tab.length;
    //     for (int i = 0; i < taille; i++) {
    //         System.out.print(tab[i] + "\t");
    //     }
    // }
    // private static int[] creerTab(int tailleTab){
    //     int[] tab = new int[tailleTab];
    //     Random random = new Random();
    //     int i = 0;
    //     while(i<tab.length){
    //         tab[i] = random.nextInt(20);
    //         i++;
    //     }
    //     return tab;
    // }

    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     char response = 'O';
    //     while (response == 'O' || response == 'o'){
    //         System.out.println("Veuillez entrer la taille du tableau:");
    //         String number = sc.nextLine();
    //         while(!validInput(number)){
    //             System.out.println("Veuillez entrer un nombre valide");
    //             number = sc.nextLine();
    //         }

    //         int tailleTab = convertNumber(number);
    //         int[] tableau = creerTab(tailleTab);
            
    //         System.out.println("=======================================================");
    //         System.out.println("Tableau initial");
    //         afficher(tableau);
    //         System.out.println("=======================================================");

    //         long start = System.currentTimeMillis();
    //         int[] tableauTrie = maxTab(tableau);
    //         long end = System.currentTimeMillis();

    //         System.out.println("=======================================================");
    //         System.out.println("Tableau trié");
    //         afficher(tableauTrie);
    //         System.out.println("=======================================================");

    //         System.out.println("\n");
    //         System.out.println("la durée d'execution du trie simple est de: " + (double) (end - start)/1000);
    //         System.out.println("\n");
    //         System.out.println("Voulez-vous reessayer un autre tri? (O/N)");
    //         response = sc.nextLine().charAt(0);

    //     }

    //     System.out.println("Ok bye");
    // }