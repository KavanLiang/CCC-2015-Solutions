import java.util.*;
public class Main {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> nums = new Stack<>();
		int sum = 0;
		for(int x = 0; x < K; x++)
		{
			int n = sc.nextInt();
			if(n == 0 && !nums.isEmpty())
				sum -= nums.pop();
			else
			{
				nums.push(n);
				sum += n;
			}
		}
		System.out.println(sum);
	}
}
