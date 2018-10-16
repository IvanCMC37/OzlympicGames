# OzlympicGames

All participants including athletes and officials have a unique ID. Their personal information is also stored
including name, age and the state (of Australia) they represent. Assume gender is NOT recorded and NOT
relevant.

There are three sports in the Ozlympic: swimming, cycling and running. There are four types of athletes,
swimmers, cyclists, sprinters (who can compete in swimming, cycling and running respectively) and
superAthletes who can compete in all three games.

Points will be rewarded to the winners of games. In each game, a first place worth 5, a second place attracts 2
points and a third place is 1 point. No points for the rest. Each athlete might have points carried over from the
previous games. Each athlete should have a compete() method which will randomly generate a time
between 10 to 20 seconds for running, 100 to 200 seconds for swimming and 500 to 800 seconds for cycling.

Each game has a unique game ID such as &quot;S01&quot;, &quot;C02&quot; ...&quot;R05&quot;. Each game has one official as the referee.
Assume each game can have at most 8 athletes to compete. A game will be cancelled unless there are more than
4 participants. Official is the one that can summarise the score each game.

A user can predict the winner for each game. User’s prediction is limited to only one athlete in one game. If the
prediction is correct, then a congratulation message will be generated.

## Driver Class
The driver class is where user interaction occurs, and it should utilise other classes to manage the games. It
should support the following functionalities:

● Select a game to run

    NOTE: you can re-run a game meaning a game does not check whether it has happened before or not.
  
    However when a game is run again, the user prediction of that game should be reset.
  
● Allow the user to predict the winner of that game

● Start the game and award points to top 3 athletes according to their finishing time.

● Display a congratulation message if the user prediction is correct.

● Display the final result of all games including the name of the referee for each game.

● Display the points of athletes.

## Design

