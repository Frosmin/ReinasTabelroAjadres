public class ReinasBck {

    public static boolean cantidadReinas(int[][] m, int n, int col) {
        if (choqueReinas(m, n) == false)
         
            return false;

        if (col >= n) {
            imprimirMatriz(m, n);
            return true;
        } else {
            for (int j = 0; j < n; j++) {
                m[j][col] = 1;
                if (cantidadReinas(m, n, col + 1) == true)
                    return true;
                m[j][col] = 0;
            }
            return false;
        }
    }


    static boolean choqueReinas(int[][] m, int N) {
        for (int fil = 0; fil < N; fil++) {
            for (int col = 0; col < N; col++) {
                int i, j;
                if (m[fil][col] == 1) {
                    for (i = 0; i < col; i++)
                        if (m[fil][i] == 1)
                            return false;
                    for (i = fil - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
                        if (m[i][j] == 1)
                            return false;
                    for (i = fil + 1, j = col - 1; j >= 0 && i < N; i++, j--)
                        if (m[i][j] == 1)
                            return false;
                }
            }
        }
        return true;
    }


    static void imprimirMatriz(int[][] m, int N) {
        for (int fil = 0; fil < N; fil++) {
           // System.out.print("" + (fil + 1));
            for (int col = 0; col < N; col++)
                System.out.print("  " + m[fil][col] + "");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int [][] matriz = new int[n][n];
        cantidadReinas(matriz, n, 0);
    }
}
