import java.util.*;
public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char[][] map=new char[10][10];
        for(int i=0;i<10;i++) {
            Arrays.fill(map[i], '#');
        }

        System.out.println("請輸入幾個座標:");
        int m=scanner.nextInt();
        for(int i=0;i<m;i++) {
            System.out.println("請輸入X軸:");
            int x=scanner.nextInt();
            System.out.println("請輸入y軸:");
            int y=scanner.nextInt();
            if (y>=0&&x<10&&y>=0&&y<10) {
                map[x][y]='*';
            }
        }

        for (int i=0;i<10;i++) {
            System.out.println(new String(map[i]));
        }
    }
}
