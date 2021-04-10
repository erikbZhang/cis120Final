Welcome to Spy, a RPG game about infiltrating and invading a hostile monster group! You're tasked with finding
items that will help you on your journey to spy and relay information back to the rebel group.

No additional libraries need to be downloaded.

Also, play with sound on! At least for a bit before it gets annoying:).

=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: erikz
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays were used in the Inventory. Inventory was displayed to the user in a
  3x2 grid. The number of items was static, so it made sense to use a 2D array to
  display the items as the size of the array wouldn't have to be adjusted. Each level,
  two items or columns were filled.

  2. Collections were used throughout the homework. Items, inventoryItems and characters
  were both stored in an ArrayList, which was used because the list is always kept  small
  and there could be duplicates of items and characters (multiple enemies (bouncers), etc.).
  Also, the main point of the list is simply to store and access data, which I think an
  ArrayList is most appropriate to use for.

  3. My game had a Save and Quit and load option. It writes save data onto an existing file
  save.txt (seperated by newlines) and also loads the position of the user by parsing that file,
   getting the items in the inventory, the items that still aren't picked up in the level, and the
   stopwatch time. In addition, file was used for sounds as well as images!

  4. The class structure in the game is fairly simple. Character.java is the superclass of all
   characters in the game (with the exception of the player), and I made sure to fulfill the feedback
   given in the GradeScope. Characters such as Leader and Boss override  the drawMe/hitbox/dialogue
   methods.  Movement is different for two of the characters (the rebel leader in the beginning,
   who gets closer to the player and the boss at the end who paces back and forth), and hence
   the drawMe() and getX() methods are overridden, as the functions are significantly different
   than those in the superclass. All Character classes are dynamically dispatched as well.
   The inheritance for the Item superclass is far more simple, with no overridden methods as all
    items function more or less the same.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
Game - Main class of the project.
Screen - Where almost all of the code is stored, everything is drawn, and
most of the logic is written.
Stopwatch - class created to time the player.
Character - class that all characters extend.
Boss - final character extending character.
Bouncer - dummy character (not interactable) extending character.
Leader - first character extending character.
Player - player class, with different images drawn based on which way the
player is facing.
Item - class that all items extend.
Book - individual item class.
Costume - individual item class.
Key - individual item class.
Knife - individual item class.
Map - individual item class.
Secrets - individual item class.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
Trying to figure out how to properly save from files and deal for whitespaces
took a bit of time.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
I think the functionality is well done, and most things that should be private
methods are private. If I had to refactor, I would add some way to model the
state of the game, to allow for easier testing.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
My AP CS teacher in high school had helpful snippets of code for starting JFrame
games and projects, and I used it here.