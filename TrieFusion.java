import java.util.Random;
import java.util.Scanner;

public class TrieFusion {
    public static int[] trieD(int[] tableau) {
        if(tableau.length <= 1) {
            return tableau;
        }

        int centre = tableau.length / 2;
        int[] moitieGauche = new int[centre];
        int[] moitieDroite;

        if(tableau.length % 2 == 0) {
            moitieDroite = new int[centre];
        } else {
            moitieDroite = new int[centre + 1];
        }

        for(int i=0 ; i < centre ; i++) {
            moitieGauche[i] = tableau[i];
        }

        for(int j=0 ; j < moitieDroite.length ; j++) {
            moitieDroite[j] = tableau[centre + j];
        }

        int[] resultat = new int[tableau.length];
        // moitieGauche = trieD(moitieGauche);
        // moitieDroite = trieD(moitieDroite);

        MThread thread1 = new MThread(moitieGauche);
        MThread thread2 = new MThread(moitieDroite);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            } catch (InterruptedException ignored) {
        }
        moitieGauche = thread1.tTrie;
        moitieDroite = thread2.tTrie;
        

        resultat = fusion(moitieGauche, moitieDroite);
        return resultat;
    }

    private static int[] fusion(int[] gauche, int[] droite) {
        int[] resultat = new int[gauche.length + droite.length];
        int indiceG, indiceD, indiceR;
        indiceG = indiceD = indiceR = 0;

        while(indiceG < gauche.length || indiceD < droite.length) {
            if(indiceG < gauche.length && indiceD < droite.length) {
                if(gauche[indiceG] < droite[indiceD]) {
                    resultat[indiceR++] = gauche[indiceG++];
                } else {
                    resultat[indiceR++] = droite[indiceD++];
                }
            }
            else if(indiceG < gauche.length) {
                resultat[indiceR++] = gauche[indiceG++];
            }
            else if(indiceD < droite.length) {
                resultat[indiceR++] = droite[indiceD++];
            }
        }
        return resultat;
    }
}
    // private static int[] creerTab(int taille) {
    //     int tab[] = new int[taille];
    //     Random random = new Random();

    //     for (int i = 0; i < taille; i++) {
    //         tab[i] = random.nextInt(100);
    //     }
    //     return tab;
    // }

    // private static void afficher(int[] tableau) {
    //     for(int i: tableau) {
    //         System.out.print(i + " ");
    //     }
    //     System.out.println();
    // }

    // public static void main(String args[]) {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Entrer la taille du tableau");
    //     int taille = scanner.nextInt();
    //     int[] tab = creerTab(taille);
    //     System.out.println("=======================================================");
    //     System.out.println("Tableau initial: ");
    //     afficher(tab);
    //     System.out.println("=======================================================");
    //     long start = System.currentTimeMillis();
    //     tab = trieD(tab);
    //     long end = System.currentTimeMillis();
    //     System.out.println("\n");
    //     System.out.println("=======================================================");
    //     System.out.println("Tableau trié: ");
    //     afficher(tab);
    //     System.out.println("=======================================================");
    //     System.out.println("\n");
    //     System.out.println("la durée d'execution du trie sans thread est de: " + (double) (end - start)/1000);
    // }