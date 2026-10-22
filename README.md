# Water Jug Problem

A Java solution to the classic water jug puzzle. You have two jugs with given capacities and an unlimited supply of water, and you want to measure an exact amount in one jug. The program prints each step as a state `(jug1, jug2)`, starting from `(0, 0)`.

## Rules

- Fill a jug to the top.
- Empty a jug.
- Pour one jug into the other until the first is empty or the second is full.

## How it works

1. **Check the goal first.** A target amount is reachable only if it fits in its jug and is a multiple of the greatest common divisor of the two capacities. If not, the program says so instead of searching.
2. **Repeat a fixed pattern of moves.** For a target in jug 1, the program fills jug 1, pours it into jug 2, and empties jug 2 when it is full. It repeats this until jug 1 holds the target and jug 2 is empty. A target in jug 2 works the same way with the jugs swapped.

The goal has to be the target in one jug with the other jug empty, so one of the two goal values must be 0.

## Run it

```bash
javac WaterJugProblem.java
java WaterJugProblem
```

## Example

Jugs of 4 and 9 litres, goal: 2 litres in the first jug.

```
Enter maximum amount of water in first jar:4
Enter maximum amount of water in second jar:9
Enter goal state 1:2
Enter goal state 2:0
0,0
4,0
0,4
4,4
0,8
4,8
3,9
3,0
0,3
4,3
0,7
4,7
2,9
2,0
```

Jugs of 6 and 9 with a goal of 4 print `Goal is not reachable`. Any amount you can measure with these jugs is a multiple of 3, and 4 is not.
