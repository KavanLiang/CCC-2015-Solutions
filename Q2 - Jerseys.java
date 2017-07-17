import java.util.*;
public class Main {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int J = Integer.valueOf(sc.nextLine());
		int A = Integer.valueOf(sc.nextLine());
		int satasfied = 0;
		int[] jerseys = new int[J + 1];
		for(int i = 1; i < jerseys.length; i++)
		{
			jerseys[i] = value(sc.nextLine());
		}
		for(int i = 0; i < A; i++)
		{
			String[] s = sc.nextLine().split(" ");
			if(jerseys[Integer.valueOf(s[1])] >= value(s[0]))
			{
				jerseys[Integer.valueOf(s[1])] = -1;
				satasfied++;
			}
		}
		System.out.println(satasfied);
	}
	
	public static int value(String s)
	{
		if(s.equals("S"))
			return 0;
		else if(s.equals("M"))
			return 1;
		else if(s.equals("L"))
			return 2;
		else
			return -1;
	}
}
