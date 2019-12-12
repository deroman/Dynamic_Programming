import java.util.ArrayList;

public class Principal {

    /*
    Implementar  un  algoritmo  en  Java,  basado  en  programación  dinámica,  que
    resuelva el problema. El algoritmo implementado deberá tener a lo máximo una
    complejidad O(N2) en tiempo y una complejidad O(N) en memoria.
     */

    //No deben estar aqui
    private static String[] nums = {"13456754321","121","1234531", "93080298359740385912", "20", "243689624371649643117776", "1782", "57", "32062308550805015446", "98367962949352308226", "5", "6923241844", "73", "41860629334175935408658681", "5183349881968261379", "20102", "988218260679", "", "33084403482789926668435", "15415893665760235", "7443524", "2320","330333", "111011","1011","987654325512345678","20005","2000500"};
    private static int[] pos={2,1, 2, 13, 2, 3, 2, 2, 0, 0, 0, 9, 0, 6, 0, 0, 0, 0, 5, 16, 0,0,0,2,4,17,1,4};
    private static int[] resul={6,0, 4, 15, 1, 22, 3, 1, 13, 14, 0, 8, 1, 21, 14, 0, 8, 0, 19, 15, 5, 3,1,1,2,12,3,4};

    //La "implementado" suprime e inserta siempre, no considera solo eliminar
    public static int minCambios(String s, int k){
        //Implementar
        int i, movimientos = 0, mitad = s.length() % 2;
        ArrayList<Character> al = toArrayList(s);
        if (s.length() % 2 == 0) {
            mitad = s.length() % 2;
        }

        if (k < mitad) {
            for (i = k; i < mitad; i++) {
                if (al.get(i) != al.get(al.size() - i - 1)) {
                    al.remove(k); movimientos++;
                    al.add(i, '0'); movimientos++;
                }
            }
        }

        else {
            for (i = mitad; i >= 0; i--) {
                if (al.get(i) != al.get(al.size() - i - 1)) {
                    al.remove(k); movimientos++;
                    al.add(i, '0'); movimientos++;
                }
            }
        }

        esCapicua(al);
        return movimientos;
    }

    private static ArrayList<Character> toArrayList(String s) {
        ArrayList<Character> al = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            al.add(s.charAt(i));
        }
        return al;
    }

    private static boolean esCapicua(ArrayList<Character> al) {
        for (int i = 0; i < al.size() / 2; i++) {
            if (al.get(i) != al.get(al.size() - i - 1))
                return false;
        }
        return true;
    }

    private static void suprimir(ArrayList<Character> al, int k) {
        al.remove(k);
    }

    private static void insertar(ArrayList<Character> al, int k, char num) {
        al.add(k, num);
    }

    private static int flechaIzq(ArrayList<Character> al, int k) {
        return --k;
    }

    private static int flechaDer(ArrayList<Character> al, int k) {
        return ++k;
    }

    private static void print(ArrayList<Character> al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }

    public static void main(String[] args){
        System.out.println("TESTS");
        minCambios(nums[0], pos[0]);
        minCambios(nums[4], pos[4]);
    }

}

