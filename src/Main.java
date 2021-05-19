import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int[] puzzle = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            puzzle[i] = input.nextInt();
        }
        long startTime = System.currentTimeMillis();
        long SecondsOnMill = 1000;
        int lastTurnPath = 0;
        boolean finded = false;
        HashSet<String> set = new HashSet<String>();
        Queue<State> q = new LinkedList<>();
        State base = new State(puzzle);
        set.add(base.puzzle.toString());
        q.add(base);
        int numOfstates = -1;
        System.out.println("Calculating");
        while (!q.isEmpty()) {
            State _state = q.poll();
            if (lastTurnPath != _state.Path.length())
                System.out.println("\t ->" + _state.Path.length() +"th turn");
            lastTurnPath = _state.Path.length();

            numOfstates ++;
          //  System.out.println("NumOfStates = " + numOfstates);
            if (_state.resultCheck(n))
            {
                finded = true;
                long endTime = System.currentTimeMillis();
                System.out.println(_state.Path.length());
                for (int i = 0; i < _state.Path.length(); i++) {
                    System.out.print(_state.Path.charAt(i) + " ");
                }
                System.out.println();
                System.out.println("ElapsedTime = " + (endTime-startTime  ) / SecondsOnMill + "s");

                break;
            }
            if (_state.Check(_state.puzzle,Move.right,n)) {
                if (!set.contains(new State(_state.right(_state.puzzle,n)).toString())) {
                    State temp = new State(_state.right(_state.puzzle,n),_state.Path, Move.right);
                    q.add(temp);
                    set.add(temp.toString());
                }
            }
            if (_state.Check(_state.puzzle,Move.left,n)) {
                if (!set.contains(new State(_state.left(_state.puzzle,n)).toString())) {
                    State temp = new State(_state.left(_state.puzzle, n), _state.Path, Move.left);
                    q.add(temp);
                    set.add(temp.toString());
                }

            }
            if (_state.Check(_state.puzzle,Move.up,n)) {
                if (!set.contains(new State(_state.up(_state.puzzle,n)).toString())) {
                    State temp = new State(_state.up(_state.puzzle, n), _state.Path, Move.up);
                    q.add(temp);
                    set.add(temp.toString());
                }
            }
            if (_state.Check(_state.puzzle, Move.down,n)) {
                if (!set.contains(new State(_state.down(_state.puzzle,n)).toString())) {
                    State temp = new State(_state.down(_state.puzzle, n), _state.Path, Move.down);
                    q.add(temp);
                    set.add(temp.toString());
                }
            }
        }
        if (!finded)
            System.out.println("No Match Found");
    }
}
