import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class maxMidSmall {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            numList.add(scanner.nextInt());
        }
        int min = 0;
        int max = 0;
        min = (int) numList.toArray()[0];
        max = (int) numList.toArray()[num-1];

        if(min > max ){
            int swap = max;
            max = min;
            min = swap;
        }
        float mid = 0;
        if(num % 2 !=0){
            mid = (int) numList.toArray()[num/2];
        }else {
            mid = (int)numList.toArray()[num/2-1]+(int)numList.toArray()[num/2];
            int n =(int) mid;
            mid /= 2;
            if (n/2<mid){
                mid =(int)mid;
            }
        }

        System.out.println(max+" "+mid+" "+min);
    }
}
