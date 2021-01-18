import java.util.ArrayList;
import java.util.Scanner;

class ArrayList2 {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int n = 100;
        System.out.println("The prime numbers less than 100 are: ");
        System.out.println(SieveOfEratosthenes(n));
        
        int g = 120;
        System.out.print(g + " = ");
        GoldbachConjecture(SieveOfEratosthenes(g), g);
        
        ArrayList<Integer> b1 = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++){
            b1.add(9);
        }
        ArrayList<Integer> b2 = new ArrayList<Integer>();
        b2.add(1); b2.add(2); b2.add(3); b2.add(4); b2.add(5); b2.add(6);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(BigInts(b1, b2));
    }
    
    public static ArrayList<Integer> SieveOfEratosthenes(int n) {
        int p = 2;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        int k = p;
        for (int i = 0; i <= n-p; i++) {
            primes.add(i, k);
            k++;
        }
        //System.out.println(primes);
        
        for (int i = 0; i < primes.size()-1; i++) {
            for (int j = primes.size()-1; j > primes.indexOf(p); j--){
                if (primes.get(j) % p == 0) primes.remove(j);
            }
            p++;
        }
        
        return primes;
    }
    
    public static void GoldbachConjecture(ArrayList<Integer> primes, int g){
        ArrayList<Integer> sums = new ArrayList<Integer>();
        
        sums.add(0);
        for (int i = 0; i < primes.size(); i++){
            if (primes.get(i) > sums.get(0)) sums.set(0, primes.get(i)); 
        }
        
        sums.add(g - sums.get(0));
        
        System.out.println(sums.get(0) + " + " + sums.get(1));
    }
    
    public static ArrayList<Integer> BigInts(ArrayList<Integer> b1, ArrayList<Integer> b2){
        ArrayList<Integer> sum = new ArrayList<Integer>();
        
        int k = 0;
        for (int i = 0; i < b1.size(); i++) {
            k = b1.get(i) + b2.get(i);
            //if (k >= 10){
            //    sum.set(i-1, sum.get(i-1)+1);
            //    k = k - 10;
            //}
            sum.add(k);
        }
        for (int i = sum.size()-1; i >= 1; i--) {
            if (sum.get(i) >= 10) {
                sum.set(i-1, sum.get(i-1)+1);
                sum.set(i, sum.get(i)-10);
            }
        }
        if (sum.get(0) >= 10) {
            sum.add(0, 1);
            sum.set(1, sum.get(1)-10);
        }
        
        return sum;
    }
}