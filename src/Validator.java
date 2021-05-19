import java.util.Scanner;

/**
 * Created by pouryafard on 3/18/2017 AD.
 */
public class Validator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] puzzle = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            puzzle[i] = input.nextInt();
        }
        int num = input.nextInt();
        char[] result = new char[num];
        for (int i = 0; i < num; i++) {
            result[i] = input.next().charAt(0);
        }
        boolean validInput = true;
        for (int i = 0; i < num; i++) {
            if (result[i] == 'r')
            {
                if (State.Check(puzzle,Move.right,n))
                    puzzle = State.right(puzzle,n);
                else {
                    System.out.println("Cannot Perform right at move " + i);
                    validInput = false;
                    break;
                }
            }
            else if (result[i] == 'l')
            {
                if (State.Check(puzzle,Move.left,n))
                    puzzle = State.left(puzzle,n);
                else {
                    System.out.println("Cannot Perform left at move " + i);
                    validInput = false;
                    break;
                }
            }
            else if (result[i] == 'u')
            {
                if (State.Check(puzzle,Move.up,n))
                    puzzle = State.up(puzzle,n);
                else {
                    System.out.println("Cannot Perform up at move " + i);
                    validInput = false;
                    break;
                }
            }
            else if (result[i] == 'd')
            {
                if (State.Check(puzzle,Move.down,n))
                    puzzle = State.down(puzzle,n);
                else {
                    System.out.println("Cannot Perform down at move " + i);
                    validInput = false;
                    break;
                }
            }
            else
            {
                System.out.println("Invalid Move At " + i);
                validInput = false;
                break;
            }
        }
        System.out.println(new State(puzzle).resultCheck(n));
    }
}

