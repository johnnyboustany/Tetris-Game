# Tetris-Game Project

## Overview:

The App class instantiates the PaneOrganizer, which in turn
instantiates the BorderPane. It also instantiates a vanilla Pane (boardPane)
and an HBox, and  respectively sets them to the top and bottom of the BorderPane. The button
added to the HBox is associated with a QuitHandler, allowing the user to exit from the game.
The top-level logic class Game is also instantiated and boardPane is passed in.
This allows the Game class to graphically add various nodes to the boardPane.

In the Game constructor, it instantiates the 2D board array which uses instances from the
TetrisSquare to represent the board. Through a helper method, it adds squares logically
and graphically to the board to make the border. A starting piece is placed at the top
of the board.

Game has a TimeHandler private class which controls the y-movement/falling of the piece,
adds landed squares to the board, creates new pieces, clears full lines,
and checks if the game is over at every time step of the timeline. A KeyHandler private class
allows the user to move the piece using the LEFT and RIGHT keys, rotate it with the UP key,
pause and unpause the game with P key, and make the piece drop to the lowest possible position
with the SPACE key. A label is added to the boardPane in the handle method of the KeyHandler
when the game is paused and removed when it is un-paused. A label is added to the boardPane
in the handle method of the TimeHandler when the game is over.

## Design Choices:

The TetrisSquare class is wrapped around a rectangle but has extra functionalities.
It adds a stroke border to the rectangle and also has helper methods that add and remove
the rectangle from a pane, set and return its location and and set its color.
Multiple instances of TetrisSquare are contained by the Game class to create the board border
and also contained by the Piece class to create the 4-square piece.

The factory pattern is used in order to generate a randomly-selected piece
through switch statements in the Piece class. The Piece
class uses two arrays: a 1D array of TetrisSquares that holds the 4 squares of the piece,
and a 2D array of coordinates that helps form each unique piece. Furthermore, the Piece class
has important helper methods that allow the piece to move
and rotate without moving to square-occupied positions on the board.
The 2D Board Array is passed into the Piece class to allow it to verify whether proposed
new positions of piece squares are null. The class also has a helper method that adds
the squares of the piece to the board array. This method is used when the piece lands and can
no longer move downwards (due to the non-null bottom border). Lastly, the dropToLowest
helper method uses a while loop to move the piece down until its proposed new location
is no longer valid and is occupied by squares. This method is used in the Game class
when a space bar is pressed.

A boolean variable is used to make the P key pause the timeline on the first press
and play the timeline on the second press, and so on. Another boolean variable is used in an
if statement to disable all the keys other than P when when the timeline is
paused. When the gameIsOver helper method returns true, the TimeHandler stops the timeline
and an if statement disables all keys in the handle method of the KeyHandler.

The clearLines helper method in the TimeHandler private class uses the rowIsFull helper method
to check for any full rows. If a full row is found, it first removes every square
of the row graphically from the boardPane. It goes through the square in each column
of the row: if the  square above it isn't null, then that square is graphically
moved down a row. Regardless of whether the position above is null or not, it is
moved logically down a row.
