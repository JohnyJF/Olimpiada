import java.util.*;
import java.io.*;

public class MainClass { 

    private static List<Integer> values = new LinkedList<Integer>();

    public static void main (String[] args) {
        Problema1();
    }

    private static void Problema1() {
        try {
            File source = new File("IO_files/12-cufar.in");
            Scanner sc = new Scanner(source);

            int p = 0, n = 0;   //p is useless
            if (sc.hasNextLine()) {
                p = Integer.parseInt(sc.next());
                n = Integer.parseInt(sc.next());
			}

			long s = 0;	//final result

			if (p == 1) {
				int v = Integer.parseInt(sc.next());
                int k = Integer.parseInt(sc.next());

				s = PrimeFactors(v, k);
				sc.close();
			}
            else if (p == 2) {
				for (int i = 0; i < n; i++) {
					int v = Integer.parseInt(sc.next());
					int k = Integer.parseInt(sc.next());

					values.add(PrimeFactors(v, k));
				}
				sc.close();
				
				for (int val : values)
					s += val;
			}
				
            File output = new File("cufar.out");
            PrintWriter pw = new PrintWriter(output);
            pw.println(s);
            pw.close();

        }
        catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }

    private static int PrimeFactors(int n, int k) {
        List<Integer> divisors = new LinkedList<Integer>();

        while (n % 2 == 0) {
            n /= 2;
            if (!divisors.contains(2))
                divisors.add(2);
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                n /= i;
                if (!divisors.contains(i))
                divisors.add(i);
            }
        }

        if (n > 2)
            divisors.add(n);

		//System.out.println(divisors.get(k - 1));
		return divisors.get(k - 1);
    }
} 
