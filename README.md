# Zombie-Simulator-
Zombie Sim Game 

For this project, I have created a zombie simulation game. In essence, a zombie is
spawned in a world with humans and buildings and infects others humans, turning them into
zombies. I also have an added extra feature of a few spawning medics in the world, capable of
healing zombies, turning them back into humans. Medics are also immune to zombies(lets just
say they have some really good armor).

I have a class called city, it contains a boolean 2d array named walls, which will be true
in certain locations where there are walls, and false where they are no walls. There is a
dotpanel class that takes care of drawing dots to the screen and their various colors. There is a
helper class that helps in production of random numbers that are needed throughout the
program in various classes. All these classes are in the same package. Back to my city class, I
have three methods responsible for populating humans, zombies, and medics. They are called
populate, Zpopulate, and Mpopulate, respectively. These methods spawn their respective types
and make sure they are not spawned at a wall. All the people are generated, one zombie is
generated, and three medics are generated. A randombuildings method takes care of producing
the buildings on the map. An update method updates the state of the map, iterating through the
array lists of zombies, humans, and medics and calling move at each iteration. For zombies it
also called infect method, and for medics it called heal method. A draw method iterates through
all the objects and draws their respective coordinates and colors them accordingly (red for
zombies, blue for medics, and yellow for humans.) clearCity method clears the city and
regenerates all the objects and clears the arraylists as well.

In class Human we have a constructor and what a human needs, a xcoord, a ycoord,
and a direction. It has a move method. In it, there is a 0 in 9 chance (meaning 1 in 10) that it will
pick a random direction. It then has a 0 in 3 chance (meaning 1 in 4) of choosing up, down, left,
or right. This is represented as 0, 1, 2, and 3. For the other 9 in 10 times, it will move one space
in the direction it is moving in. In class Zombie, we have a constructor and what a zombie
needs, a xcoord, a ycoord, and a direction. It has a move method and an infect method. The
move method works like the move method in human, except instead of a 1 in 10 chance of
choosing a random direction, it has a 1 in 5 chance(yielding a 20% chance) of changing
direction. In the infect method it checks for humans in all directions around the zombie(except
diagonal.) If there is a human next to a zombie, or if there is one on top of it, that human will be
deleted and a zombie object will be created and added to the zombie array list. In class Medic,
we have a constructor and what a medic needs, a xcoord, a ycoord, and a direction. It has a
move method and a heal method. The move method works exactly like the move method in
human. The heal method will check around the medic in each direction and if there is a zombie,
it will be deleted a human object will be created in its place and will be added to the human
array list. I think this is cool because it results in a fight between the zombies and medics, for
zombies to infect humans, and for medics to heal humans. It is cool to see this play out on the
screen as well. Also, if you press M, a medic will be randomly generated in the city.

Finally, we have my ZombieSim class, which contains the main. It also created the
Jframe for the program, calls all the methods to create the city, and detects keyboard input. I
used actionlistener, keylistener, and mouselistener. If spacebar is pressed, it will clear the city
by calling a method in City called clearCity(). This clears all the arrays and regenerates new
walls, humans, zombies, etc. If M is pressed, a medic will be randomly generated in the city,
making sure to not spawn the medic in a wall. Wherever the user clicks on screen, a zombie
object is created at those coordinates and is added to the zombie array list. It is important to
note that I had to divide by the dot size in order to get the proper coordinate.
