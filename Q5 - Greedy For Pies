import java.util.*;
import java.io.*;

/**
 *
 * @author Kavan
 */

public class Main{

    private static int N, M;
    private static Integer[] A, B;
    private static int[][][][] dp;
    private static final int OFFSET = 1;
    /**
     * @param args the command line arguments
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(GreedyForPies());
        // TODO code application logic here
    }
    
    
    public static int GreedyForPies() throws NumberFormatException, IOException
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(sc.readLine());
        A = new Integer[N];
        for(int a = 0; a < N; a++)
        {
            A[a] = Integer.valueOf(sc.readLine());
        }
        M = Integer.valueOf(sc.readLine());
        B = new Integer[M];
        for(int b = 0; b < M; b++)
        {
            B[b] = Integer.valueOf(sc.readLine());
        }
        Arrays.sort(B, Collections.reverseOrder());
        dp = new int[N + OFFSET][M + OFFSET][M + OFFSET][2];
        return GFPArrays(0, 0, M, OFFSET);
    }
    
    private static int GFPArrays(int aIndex, int bIndex, int bLength, int canTake)//somewhat faster with arrays
    {
        if(dp[aIndex][bIndex][bLength][canTake] != 0)
            return dp[aIndex][bIndex][bLength][canTake];
        if(aIndex >= A.length)
        {
            if(bIndex < bLength)
            {
                if(canTake != 0)
                {
                    return dp[aIndex][bIndex][bLength][canTake] = B[bIndex] + GFPArrays(aIndex, bIndex + OFFSET, bLength, 0);
                }
                else
                {
                    return dp[aIndex][bIndex][bLength][canTake] = GFPArrays(aIndex, bIndex, bLength - OFFSET, OFFSET);
                }
            }
            else
            {
                return dp[aIndex][bIndex][bLength][canTake] = 0;
            }
        }
        if(canTake != 0)
        {
            dp[aIndex][bIndex][bLength][canTake] = Math.max(A[aIndex] + GFPArrays(aIndex + OFFSET, bIndex, bLength, 0), GFPArrays(aIndex + OFFSET, bIndex, bLength, OFFSET));
            if(bIndex < bLength)
                dp[aIndex][bIndex][bLength][canTake] = Math.max(dp[aIndex][bIndex][bLength][canTake], B[bIndex] + GFPArrays(aIndex, bIndex + OFFSET, bLength, 0));
        }
        else
        {
            dp[aIndex][bIndex][bLength][canTake] = GFPArrays(aIndex + OFFSET, bIndex, bLength, OFFSET);
            if(bIndex < bLength)
                dp[aIndex][bIndex][bLength][canTake] = Math.max(dp[aIndex][bIndex][bLength][canTake], GFPArrays(aIndex, bIndex, bLength - 1, OFFSET));
        }
        return dp[aIndex][bIndex][bLength][canTake];
    }
}
