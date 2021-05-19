/**
 * Created by pouryafard on 3/17/2017 AD.
 */

enum Move
{
    right,
    left,
    down,
    up
};
public class State {

    int[] puzzle;
    String Path = "";

    public static int[] right(int[] puzzle,int n) {
        int[] arr = new int[n*n];
        Copy(arr,puzzle);
        int ZeroIndex = FindZero(puzzle);
        if (ZeroIndex % n == n - 1) {
            System.out.println("BugR");

        }
        else {
            arr[ZeroIndex] = arr[ZeroIndex + 1];
            arr[ZeroIndex + 1] = 0;
        }
        return arr;
    }

    public static int[] left(int[] puzzle,int n) {
        int[] arr = new int[n * n];
        Copy(arr, puzzle);
        int ZeroIndex = FindZero(puzzle);
        if (ZeroIndex % n == 0) {
            System.out.println("BugL");
          //  new Scanner(System.in).nextInt();
        }
        else {
            arr[ZeroIndex] = arr[ZeroIndex - 1];
            arr[ZeroIndex - 1] = 0;
        }
        return arr;


    }
    public static void Copy(int[] des, int[] src )
    {

        for (int i = 0; i < src.length; i++) {
            des[i] = src[i];

        }
        
    }
    public static int[] up(int[] puzzle,int n) {
        int[] arr = new int[n * n];
        Copy(arr, puzzle);
        int ZeroIndex = FindZero(puzzle);
        if (ZeroIndex < n) {
            System.out.println("BugU");
         //   new Scanner(System.in).nextInt();
        }
        else {
            arr[ZeroIndex] = arr[ZeroIndex - n];
            arr[ZeroIndex - n] = 0;
        }
        return arr;

    }

    public static  int[] down(int[] puzzle,int n) {
        int[] arr = new int[n * n];
        Copy(arr, puzzle);
        int ZeroIndex = FindZero(puzzle);
        if (ZeroIndex > ((n * (n - 1)) - 1)) {
            System.out.println("BugD");
           // new Scanner(System.in).nextInt();
        }
        else {
            arr[ZeroIndex] = arr[ZeroIndex + n];
            arr[ZeroIndex + n] = 0;
        }
        return arr;

    }

    public static boolean Check(int[] puzzle, Move m, int n) {
        int ZeroIndex = FindZero(puzzle);
        if (m == Move.right) {
            if (ZeroIndex % n == n - 1)
                return false;
            else
                return true;
        }
        else if (m == Move.left) {
            if (ZeroIndex % n == 0)
                return false;
            else
                return true;
        }
        else if (m == Move.up) {
            if (ZeroIndex < n)
                return false;
            else
                return true;
        }
        else //  m = move.down
        {
            if (ZeroIndex > ((n * (n - 1)) - 1))
                return false;
            else
                return true;
        }
    }
    private static int  FindZero(int[] puz)
    {
        int ZeroIndex = -1;
        for (int i = 0; i < puz.length; i++) {
            if (puz[i] == 0)
            {
                ZeroIndex = i;
                break;
            }
        }
        return ZeroIndex;
    }


    State(int[] s,String p, Move m)
    {
        puzzle = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            puzzle[i] = s[i];
        }
        Path = p + m.name().charAt(0);
    }
    State(int[] s)
    {

        puzzle = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            puzzle[i] = s[i];
        }
    }

    public boolean resultCheck(int n)
    {
        boolean res = true;
        for (int i = 0; i < n*n -1; i++) {
            if (puzzle[i] != i + 1) {
                res = false;
                break;
            }
        }
        if (puzzle[n*n - 1] != 0)
            res = false;
        return  res;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < puzzle.length; i++) {
            res += puzzle[i];
            res +=",";
        }
        return  res;
    }
    public void Print(int n)
    {
        System.out.println(n);
        for (int i = 0; i < puzzle.length ; i++) {
            if(i % n == 0 & i != 0)
                System.out.println();
            System.out.print(puzzle[i]);
            System.out.print(" ");
        }
    }

}