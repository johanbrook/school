import java.util.*;

/**
*	Written by Erland Holmström, Chalmers University of Technology, 2011
*	Departement of Computer Science
*
*/
public class RatNumTest1 {

    private static void testa(int m, int n) {
        System.out.print("Talen är " + m + " och " + n + ".\t");
        int z = 0;
        try {
            z = RatNum.sgd(m,n);
        }
        catch (IllegalArgumentException e1) {
            if (m==0 || n==0)
                System.out.println("Korrekt IllegalArgumentException genererad");
            else 
                System.out.println("Felaktig IllegalArgumentException genererad" +
                "  *************");
            return;
        } 
        catch (Exception e2) {
            System.out.print(e2.getMessage());
            System.out.println(" Felaktig exception genererad *************"); 
            return;
        } 
        if (m==0 || n==0) {
            System.out.print("sgd borde genererat IllegalArgumentException");
            System.out.println("  *************");
            return;
        }
        int a = (m<0?-m:m), b = (n<0?-n:n),r = a % b;
        while (r != 0)
        {
            a = b; b = r; r = a % b;
        }  
        System.out.print("Ditt resultat: " + z +   
            ".\tRätt resultat: " + b + ".");
        if (z != b)
            System.out.println("  *************");
        else
            System.out.println();
    }

    public static void main (String[] arg) {
        testa(1, 1);
        testa(12, 1);
        testa(12, 2);
        testa(12, 14);
        testa(22, 14);
        testa(39, 15);
        testa(40, 12);
        testa(168, 49);
        testa(143, 7);
        testa(7, 143);
        testa(1260, 36);
        testa(36, 1260);
        testa(15775, 100);
        testa(100, 15775);
        testa(15776, 100);
        testa(15775, 12);
        testa(0, 12);
        testa(12, 0);
        testa(0, 0);
        testa(-6, 39);
        testa(39, -6);
        testa(-6, -39);                         
    }
}
