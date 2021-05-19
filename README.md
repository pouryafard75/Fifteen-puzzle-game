# Fifteen-puzzle-game
 
The famous fifteen-puzzle-game, with a solver, verifier, scrambler.
Althogh it is called fifteen-puzzle game, the code works for the other setups such as 5x5 or any NxN.
Solver which is main, use the BFS algorithm and should be replaced with A* algorithm for better performance.

## Main.java
<b>  <i>
 Input format:
</i> </b>

4
14 4 1 7
10 6 8 2
5 12 0 13
15 3 11 9

The first line indicates the number of rows (or columns since it will be an square).
The next line will show the position of every single tiles.
<b> Note that the empty tile will be shown by 0.
 
You can perform right, left, up, down to change the empty tile position. 
For the example above, if operator left is called, it will change the position of 0(empty slot) and 12.

<b>  <i>
Output format:
</i> </b>
9
r u l l l d r r r
 
First line indicates numbers of moves required to solve the puzzle and the second line will be the moves in the right order.
 
## Validator.java
<b>  <i>
 Input format:
</i> </b>

 
It takes an input puzzle and perform series of moves on it. The output will be a boolean determining the puzzle is solved correctly or not.
The input format is quite the same as the Main.java. It takes n as number of rows, then the starting position in the following lines. Then the number of required moves and at the we have the move sequence.

5
1 2 3 4 5 
6 7 8 9 10 
11 12 13 14 15 
16 18 19 20 24 
21 17 22 0 23
 
 
 
 