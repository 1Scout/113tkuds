import java.util.*;
public class F03_ConvenienceHotItems {
    
    static class Product{
        String name;
        int quantity;
        
        public Product(String name,int quantity) {
            this.name=name;
            this.quantity=quantity;
        }

        public String toString(){
            return name+" "+quantity;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入商品數量:");
        int n=scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("請輸入商品名稱與銷量:");
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ", 2);
            String name = line[0];
            int quantity = Integer.parseInt(line[1]);
            products[i] = new Product(name, quantity);
        }
        
        insertionSort(products);
        
        int limit=Math.min(n,10);
        for (int i =0;i<limit;i++) {
            System.out.println(products[i]);
        }       
        scanner.close();
    }
    
    private static void insertionSort(Product[] products) {
        int n=products.length;
        
        for (int i=1;i<n;i++) {
            Product key=products[i];
            int j=i-1;
            
            while (j>=0&&products[j].quantity<key.quantity) {
                products[j+ 1] =products[j];
                j--;
            }
            products[j + 1] = key;
        }
    }
}
/*
* Time Complexity:O(n²)
** 說明：讀取商品資料是O(n)
        插入排序是O(n²)
        輸出前10名是O(1)
        -->O(n²)
*/
