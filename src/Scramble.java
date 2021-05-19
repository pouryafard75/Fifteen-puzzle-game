/**
 * Created by pouryafard on 3/17/2017 AD.
 */
import java.util.*;
import java.util.ArrayList;
public class Scramble {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int puzz[] = new int[n * n];
        for (int i = 0; i < n * n - 1; i++) {
            puzz[i] = i + 1;
        }
        puzz[n * n - 1] = 0;
        int moves = input.nextInt();
        String backroll ="";
        Move lastMove = Move.left;
        Random rand = new Random();
        ArrayList<Move> possible = new ArrayList<>();
        for (int i = 0; i < moves; i++) {
            possible.clear();
            Move Current;
            fill(possible,lastMove, puzz,n);
            Current = possible.get(rand.nextInt(possible.size()));
            if (Current == Move.right) {
                puzz = State.right(puzz,n);
                backroll += "r";
            }
            else if (Current == Move.left) {
                puzz = State.left(puzz,n);
                backroll += "l";
            }
            else if (Current == Move.up) {
                puzz = State.up(puzz,n);
                backroll += "u";
            }
            else if (Current == Move.down) {
                puzz = State.down(puzz,n);
                backroll += "d";
            }
            else
                System.out.println("Bug");
            lastMove = Current;
        }
        new State(puzz).Print(n);
        String reverse = new StringBuffer(backroll).reverse().toString();
        char[] temp = reverse.toCharArray();
        for (int i = 0; i < reverse.length(); i++) {
            if (reverse.charAt(i) == 'u')
                temp[i] = 'd';
            else if (reverse.charAt(i) == 'd')
                temp[i] = 'u';
            else if (reverse.charAt(i) == 'r')
                temp[i] = 'l';
            else if (reverse.charAt(i) == 'l')
                temp[i] = 'r';
            else
                System.out.println("Bug");
        }
        String result = new String(temp);
        System.out.println();
        System.out.println(result.length());
        for (int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(i));
            System.out.print(" ");
        }

    }
    public static void fill(ArrayList s ,Move last,int[] puzz,int n)
    {
        if (State.Check(puzz,Move.right,n))
            s.add(Move.right);
        if (State.Check(puzz,Move.left,n))
            s.add(Move.left);
        if (State.Check(puzz,Move.up,n))
            s.add(Move.up);
        if (State.Check(puzz,Move.down,n))
            s.add(Move.down);
        ///
        if (last == Move.right)
            s.remove(Move.left);
        else if (last == Move.left)
            s.remove(Move.right);
        else if (last == Move.up)
            s.remove(Move.down);
        else if (last == Move.down)
            s.remove(Move.up);
        else
            System.out.println("Bug");
    }
}