public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };

        int[][] c = new int[2][2]; 

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("計算過程 c[" + i + "][" + j + "] = ");
                for (int k = 0; k < 2; k++) {
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    c[i][j] += a[i][k] * b[k][j];
                    if (k != 1) System.out.print(" + ");
                }
                System.out.println(" = " + c[i][j]);
            }
        }
        //上述的迴圈是三層迴圈
        //最外層是i,會把列數n跑完
        //中層是j,會把欄數n跑完
        //內層是k,每項的運算跑n次
        //所以時間複雜度是O(n³)

        System.out.println("\n結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
