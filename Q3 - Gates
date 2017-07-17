import java.util.*;
public class Main {
	
	public static int G;
	public static int P;
	public static int[] planes;
	public static boolean[] gates;
	public static Scanner sc;
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		gates();
	}
	
	
	public static void initialize()
	{
		G = sc.nextInt();
		P = sc.nextInt();
		planes = new int[P];
		gates = new boolean[G + 1];
		for(int x = 0; x < planes.length; x++)
			planes[x] = sc.nextInt();	
	}
	
	public static void gates()
	{
		initialize();
		int sum = 0;
		for(int x = 0; x < planes.length; x++)
		{
			if(planes[x] <= G)
			{
				if(!gates[planes[x]])
				{
					gates[planes[x]] = true;
					sum++;
				}
				else
				{
					for(int index = planes[x]; index >= 1; index--)
					{
						if(!gates[index])
						{
							gates[index] = true;
							sum++;
							break;
						}
						else if(index <= 1)
						{
							System.out.println(sum);
							return;
						}
							
					}
				}
			}
			else
			{
				System.out.println(sum);
				return;
			}
		}
		System.out.println(sum);
	}
}
