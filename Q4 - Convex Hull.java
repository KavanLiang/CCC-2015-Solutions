import java.util.*;
//@author Kavan
public class Main {

	public static int K, N, M, start, end;
	public static PriorityQueue<Island> open;
	public static Island[] allIslands;
	public static boolean[] closed;
	public static Scanner sc;

	public static class Path
	{
		public int a, b, t, d;
		public Path(int nodeA, int nodeB, int time, int damage)
		{
			a = nodeA;
			b = nodeB;
			t = time;
			d = damage;
		}
	}

	public static class Island
	{
		public int ID_;
		public LinkedList<Path> paths;
		public int dp[]; //[thickness]
		public int minTime;
		boolean canAdd;
		boolean traverseable;

		public Island(int ID)
		{
			ID_ = ID;
			paths = new LinkedList<>();
			dp = new int[K];
			minTime = Integer.MAX_VALUE;
			for(int i = 0; i < dp.length; i++)
				dp[i] = Integer.MAX_VALUE;
			canAdd = true;
			traverseable = false;
		}

		public void addPath(int nextNode, int time, int damage)
		{
			paths.add(new Path(ID_, nextNode, time, damage));
		}

		public Island setAsStart()
		{
			dp = new int[K];
			minTime = 0;
			return this;
		}

		public void updateNeighbors()
		{
			ListIterator<Path> pathIter = paths.listIterator();
			while(pathIter.hasNext())
			{
				Path p = pathIter.next();
				Island test = allIslands[p.b];
				for(int currentD = 0; currentD + p.d < K; currentD++)
				{
					int checkTime = dp[currentD] + p.t;
					if(checkTime < test.dp[currentD + p.d] && checkTime >=0)
					{
						test.traverseable = true;
						test.dp[currentD + p.d] = checkTime;
						if(checkTime < test.minTime)
						{
							test.minTime = checkTime;
						}
					}
				}
				if(!closed[p.b] && test.traverseable && test.canAdd)
				{
					open.offer(test);
					test.canAdd = false;
				}
			}
			closed[ID_] = true;
		}
	}

	public static void initialize()
	{
		String[] init = sc.nextLine().split(" ");
		K = Integer.valueOf(init[0]);
		N = Integer.valueOf(init[1]);
		M = Integer.valueOf(init[2]);
		allIslands = new Island[N];
		closed = new boolean[N];
		for(int i = 0; i < allIslands.length; i++)
		{
			allIslands[i] = new Island(i);
		}
		for(int i = 0; i < M; i++)
		{
			String[] s = sc.nextLine().split(" ");
			if(Integer.valueOf(s[3]) < K)
			{
				allIslands[Integer.valueOf(s[0]) - 1].addPath(Integer.valueOf(s[1]) - 1, Integer.valueOf(s[2]), Integer.valueOf(s[3]));
				allIslands[Integer.valueOf(s[1]) - 1].addPath(Integer.valueOf(s[0]) - 1, Integer.valueOf(s[2]), Integer.valueOf(s[3]));
			}
		}
		String[] travel = sc.nextLine().split(" ");
		start = Integer.valueOf(travel[0]) - 1;
		end = Integer.valueOf(travel[1]) - 1;
		open = new PriorityQueue<>((Island a, Island b) -> a.minTime - b.minTime);
		open.offer(allIslands[start].setAsStart());
	}

	public static void convexHull()
	{
		initialize();
		while(!open.isEmpty())
		{
			Island i = open.poll();
			i.updateNeighbors();
		}
		if(allIslands[end].traverseable)
			System.out.println(allIslands[end].minTime);
		else
			System.out.println(-1);
	}
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		convexHull();
	}
}
