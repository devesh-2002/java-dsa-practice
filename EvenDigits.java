
import java.util.Scanner;
public class EvenDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for(int i= 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println(findNumbers(arr));
        input.close();
    }
    //Find numbers with even digits
    static int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0; i < nums.length;i++ ){
            if(even(nums[i])){
                count++;
            }
        }
        return count;
    }
    static boolean even(int num){
        int numberofdigits = digits(num);
        /*if(numberofdigits%2==0){
            return true;
        }*/

        return numberofdigits%2==0; //returns true or false
    }
    //Count the number of digits
    static int digits(int num){
        int count =0;
        if(num<0){
            num = num*-1;
        }
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }
}
