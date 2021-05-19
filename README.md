# Fifteen-puzzle-game
 
The famous fifteen-puzzle-game, with a solver, verifier, scrambler.
Althogh it is called fifteen-puzzle game, the code works for the other setups such as 5x5 or any NxN.
Solver which is main, use the BFS algorithm and should be replaced with A* algorithm for better performance.

## Main.java
This is the puzzle-solver.

<b> <i> Input format:</i> </b> <br>
4 <br>
14 4 1 7 <br>
10 6 8 2 <br>
5 12 0 13 <br>
15 3 11 9 <br>

The first line indicates the number of rows (or columns since it will be an square).
The next line will show the position of every single tiles.
<b> Note that the empty tile will be shown by 0. </b>
 
You can perform right, left, up, down to change the empty tile position. 
For the example above, if operator left is called, it will change the position of 0(empty slot) and 12.

<b> <i> Output format:</i> </b> <br>
9 <br>
r u l l l d r r r
 
First line indicates numbers of moves required to solve the puzzle and the second line will be the moves in the right order.
 
# Validator.java
This is intented to get a starting puzzle and perform series of moves in order to validate the result.

<b> <i>  Input format: </i> </b> <br>
5 <br>
1 2 3 4 5 <br>
6 7 8 9 10  <br>
11 12 13 14 15  <br>
16 18 19 20 24 <br>
21 17 22 0 23 <br>
9 <br>
r u l l l d r r r <br>
The input format is quite the same as the Main.java. It takes n as number of rows, then the starting position in the following lines. Then the number of required moves and at the we have the move sequence.

<b> <i> Output format: true or false </i> </b> <br>
The output will be a boolean determining the puzzle is solved correctly or not.

# Scrambler.java
This is intented to get a scramble a solved position to create a puzzle sitution. It will only create meaningfull sequence which means "right" and "left , "up" and "down" wont be performed consecutively.

<b> <i> Input format: </i> </b> <br>
6 <br>
5 <br>
The first line indicates n, and the second line is the number of moves you want to perform on solved puzzle. 

<b> <i> Output format: </i> </b> <br>
6 <br>
1 2 3 4 5 6 <br>
7 8 9 10 0 12 <br>
13 14 15 16 11 18 <br>
19 20 21 22 17 24 <br>
25 26 27 28 23 30 <br>
31 32 33 34 29 35 <br>
5 <br>
d d d d r <br>
The output format is completely identical with Validator.java input format.
 
 
# Scrambler -> Main -> Validate
Use this order to test all the files. Scramble a puzzle, solve it, then check witt the validator.
 

 

 
 
 
 
