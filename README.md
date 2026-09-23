# DH Toggle

[![Build](https://github.com/srsp2282/dh-toggle/actions/workflows/build.yml/badge.svg)](https://github.com/srsp2282/dh-toggle/actions/workflows/build.yml)
[![Latest release](https://img.shields.io/github/v/release/srsp2282/dh-toggle)](https://github.com/srsp2282/dh-toggle/releases/latest)
[![License](https://img.shields.io/github/license/srsp2282/dh-toggle)](LICENSE)

DH Toggle is a tiny client-side Fabric mod that adds a normal, remappable Minecraft keybind for toggling **Distant Horizons LOD rendering**.

The default key is **F6**.

## Download

Download the latest JAR from the [Releases page](https://github.com/srsp2282/dh-toggle/releases/latest).

For v1.0.0, place `dh-toggle-1.0.0.jar` in your Minecraft instance's `mods` directory.

## Why?

[Distant Horizons](https://modrinth.com/mod/distanthorizons) includes a debug rendering toggle, but that debug keybind did not respond correctly in the Minecraft 26.3 setup that prompted this project.

DH Toggle registers a normal Fabric/Minecraft keybinding instead and toggles Distant Horizons through its public API.

The original use case was working around an underground rendering artifact seen with Distant Horizons and Complementary Shaders while keeping shaders enabled for cave lighting and glowing ores.

## What it does

Press **F6** to toggle Distant Horizons LOD rendering:

- Distant Horizons LOD rendering turns OFF
- Press F6 again to turn it back ON
- Normal Minecraft rendering remains unchanged
- Shader packs remain enabled
- Distant Horizons remains loaded
- A chat message confirms the new DH rendering state

The keybind appears under:

`Options -> Controls -> Key Binds -> DH Toggle`

and can be reassigned like any normal Minecraft control.

## Compatibility

v1.0.0 was built and tested with:

| Component | Version |
| --- | --- |
| Minecraft | 26.3 |
| Fabric Loader | 0.19.5 |
| Fabric API | 0.161.0+26.3 |
| Distant Horizons | 3.3.2 |
| Java | 25 |
| Iris | 1.11.6 |
| Complementary Unbound | r5.9.3 |

Other versions may work, but they have not been tested.

## Requirements

- Minecraft 26.3
- Fabric Loader
- Fabric API
- Distant Horizons

## Installation

1. Install Fabric Loader, Fabric API, and Distant Horizons.
2. Download DH Toggle from the [latest release](https://github.com/srsp2282/dh-toggle/releases/latest).
3. Copy the DH Toggle JAR into the Minecraft instance's `mods` directory.
4. Launch Minecraft.
5. Press **F6**, or rebind the control under `Options -> Controls -> Key Binds -> DH Toggle`.

## Building from source

Java 25 is required.

```bash
./gradlew clean build
```

The finished mod will be written to:

```text
build/libs/dh-toggle-1.0.0.jar
```

The build fetches Distant Horizons only as a compile-time dependency. Distant Horizons itself is **not** bundled into the resulting JAR.

## Issues

If the mod does not work with a particular Minecraft or Distant Horizons version, please [open an issue](https://github.com/srsp2282/dh-toggle/issues) and include the relevant versions and launcher log.

## License

DH Toggle is released under the [MIT License](LICENSE).

Distant Horizons is a separate project and is not included in or distributed with DH Toggle.
