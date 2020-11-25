VIT-SoftwareDev
Live Programming Round: Software Engineer Role

Note: After submitting the test, please fill out the following form: https://docs.google.com/forms/d/e/1FAIpQLSfveUrSe0zCqALDqMYK8iRb3tKpdN9NeSzjnf4LOyMNECaQZQ/viewform
Updated FAQ:
1. Am I supposed to upload just the client or server code?
Ans: Commit all your code into your repository(this includes both client and server) along with the instructions.
Test Instructions & prerequisites:
Be familiar with git and it’s commands.
Have a development environment with any database and any REST/Chat client building utilities/frameworks pre-installed.
Fork from github repository.
The problem statement and further instructions will be added to the README.md file and committed in the main repository.
During the round, commit into your repositories at least once an hour.
Submit your solution as a pull request (Name of Pull Request should be your reg no.) with proper documentation to this repo.
Further Instructions:
1. Make sure the name of the pull request you submit starts with your registration number. 2. The README.md in your repo must contain explanations/documentations to be able to describe your approach and progress. 3. Your individual commits will be seen to track progress. Write commit messages appropriately. 4. For any queries, contact us on recruitment@hitwicket.com. (We are available on Google Chat)
Summary:
A chat service with a cricket game.
Level 1: Make a basic architecture for a chat service which will respond on certain commands and print out the game status for you.

A game mode of ‘PvE’ is to be made in the form of a match. The match lasts for an over. The user has to play every ball by writing a set of commands sent as chat messages. 1 batsman and 1 bowler ‘skill’ details will be provided. These skills determine the likelihood of an outcome of a played ball (basically a matchup prototype of that in Superstars).

Level 2: Persist data in a database.

The user can choose a batsman from a set of batsmen before starting a match. The ‘PvE’ mode now lasts for 3 overs. Every over is bowled by a bowler corresponding to a predefined ‘bowling order’.

Level 3: Add multiplayer support for the above game

The ‘PvP’ game mode. It will become a turn based game This should include 2 clients connecting to the same server, and run through the same 3 over match as mentioned in in level 2, with the following modifications:

Both innings of the match will be played. A target score set in the first innings will be chased in the second innings by the opponent. The user flow highlighted below will be followed for both innings: Bowling client will select a ball to bowl while the batting client waits for this selection. Once ball is selected, Batting client will get the options for the shot (same as in Level 1)

Expectations and what will you be graded on:
Modular, scalable code. Well structured code and folder structure. Handling exceptions and edge cases gracefully.
Tables:
https://docs.google.com/spreadsheets/d/1UdcmcUPb-62olm6LGgG1d_8o0eLcaDAwPQc_vbx_ohY/edit?usp=sharing
Probability Formula:

Probability of shot = (((shot_modifier - ball_modifier) * 100) / shot_modifier)

Effect of Player Type:

Batsmen and bowlers both will have a playing style, namely passive and aggressive. The following boosts are to be applied on the shot and ball modifiers:

Passive Batting: 20% boost to shot modifier for all shots that award 0,1,2 runs Aggressive Batting: 20% boost to shot modifier for all shots that award 4,6 runs

Passive Bowling: 20% boost to ball modifiers for Slower Ball, Bouncer, and Out-swinger Aggressive Bowling: 20% boost to ball modifiers for Full Toss, Yorker and In-swinger

Flow of the game:
PvE (Player vs Enemy game mode) After the mode select is pressed, User should get a random generated bowler/ list of bowlers (Including passive and aggressive) he is going to face, and then choose the batsman the user wants to use (passive or aggressive). Once the selection is done, the match starts and the player faces any random ball (mentioned in the tables above), and the possible shots for the random ball are to be listed from the table given above, with the shot success probability calculated and listed in front of them.

The UI should look something like this:

Current Runs: 0
Runs on last ball: 0
Current Ball : (Ball name)
Possible Shots:
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)

Choose a shot:

Now the server waits for an input from the user to choose a shot (Input should be the shot name), and it will reply if the shot was a success or a miss (Calculated by the probability formula provided) and it’ll proceed to show the next ball (randomly selected by server) in a UI something like this:

YOU HIT A (Number of runs) OR *You missed”

Current Runs: (number of runs)
Runs on last ball: (outcome of last ball)
Current Ball : (Ball name)
Possible Shots:
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)
(shot_name) - (runs) - (probability)

Choose a shot:

Once the used has played the over/overs his final score should be printed out

PvP (Player vs Player game mode)
Similar to PvE with the follow changes in user-flow:
Player 1 starts PvP mode and is asked to wait for Player 2 to connect. Player 2 then connects to the server, selects PvP mode and the match starts automatically.

[This UI only serves the purpose of a reference]

Server: “Select a game mode (PvP/PvE)”
Client #1’s Input: PvP

Server: “Waiting for an opponent...”

[Client #2 connects, selects PvP mode]

Server: “Opponent found, match starting in 3...2…1”
.
.

During match
For the bowling client, the UI should look something like this:

“First Innings, Player 1 has to set a target score”
Current Runs: 0
Runs on last ball: 0
Balls:
Full toss,
Yorker,
Out-swinger,
In-swinger,
Bouncer,
Slower Ball

Choose a ball:

Input should be Ball name

After having chosen the ball, the server responds with a message to wait while the other player finishes their turn.

“First Innings, Player 1 has to set a target score”
Current Runs: 0
Runs on last ball: 0
Current Ball : the ball that you selected
Waiting for the opponent to play their turn . . .

For the batting client, the UI should look something like this:

[same as level 1 and 2’s batting UI]

For the second innings, display the target score which is to be chased by Player 2.

