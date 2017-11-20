package week2;

public class ex2_DisplayNum {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i <= 200; i++){
            if((i % 5 == 0 || i % 6 == 0) && (i % 30 != 0)){
                System.out.printf(i + " ");
                count++;
                if(count % 10 == 0) System.out.printf("\n");
            }
        }
    }
}
