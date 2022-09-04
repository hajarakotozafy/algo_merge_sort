public class MThread extends Thread{
    public int[] tableau;
    public int[] tTrie;
    
    MThread(int[] tab){
        this.tableau = tab;
    }

    @Override
    public void run() {
        int[] tabTrie = new int[this.tableau.length];
        int min = 200;
        int index = 0;
        for (int j = 0; j < tabTrie.length; j++) {
            for (int i = 0; i < this.tableau.length; i++) {
                    if(min > this.tableau[i]){
                        min = this.tableau[i];
                        index = i;
                    }
            }
            tabTrie[j] = min;
            min = 200;
            this.tableau[index] = 200;
        }
        this.tTrie = tabTrie;
    }
}


