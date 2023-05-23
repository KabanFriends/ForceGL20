# ForceGL20
A Minecraft mod for [Fabric](https://fabricmc.net/) & [Forge](https://files.minecraftforge.net/net/minecraftforge/forge/) that forces the game to use OpenGL 2.0.

## Why?
Since Minecraft 1.17, Mojang changed the required OpenGL version to 3.2.  
This means that players with an old graphic card that doesn't support OpenGL 3.2 can no longer play the game.  
This Minecraft mod makes the game work again for those players by reverting the OpenGL GLFW hints to how it was in Minecraft 1.16.

## But does it work?
As far as I tested, there have been no issues. However, you must remember that this mod forces the game to run on an unsupported OpenGL version. There may be unexpected issues with other mods or resource packs.  
**While it is fine to use this mod to run newer versions of Minecraft, please do consider upgrading to a newer graphic card as soon as possible.**

## I found an issue!
Due to the statement above (that you are running the game on an unsupported OpenGL), I cannot provide support for issues you may experience in this mod. This mod simply changes the OpenGL version and does not apply any other changes to the game's code.

## Compiling the mod
If you want to compile ForceGL20 by yourself, use the following command:
```
./gradle build  
```
