# DH Toggle

A tiny Fabric client mod that adds a normal Minecraft keybind for toggling Distant Horizons LOD rendering.

The default key is **F6**.

## Why?

Distant Horizons has its own debug F6 rendering toggle, but that debug keybind does not function correctly in the Minecraft 26.3 setup this project was created for.

DH Toggle instead registers a normal Fabric/Minecraft keybinding and toggles Distant Horizons through its public API.

The original use case was working around an underground rendering artifact between Distant Horizons and Complementary Shaders while keeping shaders enabled for cave lighting and glowing ores.

## Behavior

Press **F6**:

- Distant Horizons LOD rendering OFF
- Press again to turn LOD rendering back ON
- Normal Minecraft rendering remains unchanged
- Shader packs remain enabled
- Distant Horizons itself remains loaded

The keybind appears under:

`Options -> Controls -> Key Binds -> DH Toggle`

and can be reassigned like any normal Minecraft control.

## Tested With

- Minecraft 26.3
- Fabric Loader 0.19.5
- Fabric API 0.161.0+26.3
- Distant Horizons 3.3.2
- Java 25
- Iris 1.11.6
- Complementary Unbound r5.9.3

## Requirements

- Minecraft 26.3
- Fabric Loader
- Fabric API
- Distant Horizons

## Building

Java 25 is required.

    ./gradlew clean build

The finished mod will be in:

    build/libs/dh-toggle-1.0.0.jar

Distant Horizons is fetched only as a compile-time dependency and is not bundled into the resulting JAR.

## Installation

Copy:

    dh-toggle-1.0.0.jar

into the Minecraft instance's `mods` directory.

Distant Horizons must also be installed.

## License

MIT.

Distant Horizons is a separate project and is not included in this repository or distributed inside DH Toggle.
