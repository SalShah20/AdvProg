import java.util.Scanner;
public class Main 
{
    public static void main(String [ ] args)
    {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
            if (nums[i] % 10 == 7)
            {
                count ++;
                nums[i] = nums[i]/10;
                while (nums[i] % 10 != 0)
                {
                    if (nums[i] % 10 == 7)
                    {
                        count++;
                        nums[i] = nums[i]/10;
                    } 
                    else
                    {
                        nums[i] = nums[i]/10;
                    }
                } 
            }
        }
        System.out.println(count);
    }
}
