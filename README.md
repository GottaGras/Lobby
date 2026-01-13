# Lobby Plugin

A comprehensive Minecraft Spigot plugin that provides spawn protection, global utilities, and a game selector for multi-server environments.

## Overview

The Lobby plugin is designed for Minecraft servers running Spigot 1.21. It protects the spawn area from modifications, provides utility features for players, and includes an intuitive game selector for connecting to different game servers via BungeeCord.

**Version:** 1.1.0  
**Author:** 19HAuLit  
**Repository:** [GitHub](https://github.com/GottaGras/Lobby)

## Features

### 🛡️ Spawn Protection
- Prevents players from breaking blocks in the spawn area
- Blocks item placement in protected zones
- Prevents item dropping in protected areas
- Customizable protection messages

### 🌍 Global Management
- Automatic spawn point assignment for new and disconnected players
- Configurable join and leave messages with player name substitution
- World rule management (auto-save, daylength, weather, etc.)

### 🎮 Game Selector
- Intuitive game selector item (Compass by default)
- Quick access menu to join multiple game servers
- Configurable games with custom icons and descriptions
- Supports BungeeCord for seamless server connections

## Installation

### Requirements
- Java 21 or higher
- Spigot 1.21.9 or compatible version
- Maven (for building)

### Building from Source

```bash
mvn clean package
```

The compiled JAR file will be generated in the `target/` directory.

### Deployment

1. Copy the compiled JAR to your Spigot `plugins` folder
2. Restart your server
3. The plugin will generate a default `config.yml` in `plugins/Lobby/`
4. Customize the configuration as needed
5. Restart the server to apply changes

## Configuration

The plugin uses a `config.yml` file located in the `plugins/Lobby/` directory. Below is an overview of the main sections:

### Global Settings

```yaml
global:
  prefix: "&8[&bGotta&6Gras&8] &f"  # Chat prefix
  join-messages:
    welcome: "&6Bienvenue &e{player} &6sur le lobby GottaGras!"
    leave: "&e{player} &6a quitté le lobby."
  spawn:
    world: "world"
    x: 0.5
    y: 256.0
    z: 0.5
    yaw: 0.0
    pitch: 0.0
```

**Parameters:**
- `prefix`: Chat prefix for plugin messages (supports color codes)
- `join-messages.welcome`: Message sent when a player joins (use `{player}` for player name)
- `join-messages.leave`: Message sent when a player leaves
- `spawn`: Default spawn location coordinates and orientation

### Protection Settings

```yaml
protection:
  messages:
    deny-break: "&6Protection &8» &eDésolé, tu ne peux pas modifier le lobby."
    deny-place: "&6Protection &8» &eLa construction est interdite ici."
    deny-drop: "&6Protection &8» &eTu ne peux pas jeter d'objets ici."
```

**Parameters:**
- `deny-break`: Message shown when a player tries to break a block
- `deny-place`: Message shown when a player tries to place a block
- `deny-drop`: Message shown when a player tries to drop an item

### Game Selector Configuration

```yaml
selector:
  item:
    material: "COMPASS"
    name: "&6Navigateur de jeux"
    slot: 4
    lore:
      - "&7Permet de naviguer entre"
      - "&7les différents serveurs."
  games:
    - name: "&aBingo"
      icon: "PAPER"
      server: "bingo"
      slot: 7
      lore:
        - "&7Complète ta grille d'objets"
        - "&7le plus vite possible !"
```

**Item Parameters:**
- `material`: Item type for the game selector
- `name`: Display name of the selector item
- `slot`: Hotbar slot (0-8) or inventory position
- `lore`: Item description lines

**Game Parameters:**
- `name`: Display name in the selector menu
- `icon`: Item icon for the game
- `server`: BungeeCord server name to connect to
- `slot`: Inventory slot position for the game icon
- `lore`: Game description lines

**Color Codes:**
- `&0` to `&9`, `&a` to `&f`: Color codes
- `&l`: Bold
- `&o`: Italic
- `&n`: Underline

## Architecture

### Core Components

#### `Main.java`
The main plugin class that initializes all managers and listeners.

#### Features
- **Protection Module** (`ProtectionManager`, `ProtectionListener`)
  - Manages spawn area protection
  - Prevents block breaking, placement, and item dropping

- **Global Module** (`GlobalManager`, `GlobalListener`)
  - Handles player join/leave events
  - Manages spawn point teleportation
  - Controls world rules

- **Selector Module** (`SelectorManager`, `SelectorListener`)
  - Manages the game selector UI
  - Handles BungeeCord connections

#### Utilities
- **BungeeUtils**: Handles BungeeCord plugin channel communication
- **WorldUtils**: Manages world rules and properties
- **ItemUtils**: Item creation and manipulation
- **PlayerUtils**: Player-related utilities
- **ChatUtils**: Chat message formatting and color code handling

## Dependencies

### Direct Dependencies
- **Spigot API 1.21.9**: Minecraft server plugin framework

The project uses Maven for dependency management. All dependencies are automatically resolved during the build process.

## Development

### Project Structure

```
src/
├── main/
│   ├── java/net/gottagras/
│   │   ├── Main.java
│   │   ├── features/
│   │   │   ├── global/
│   │   │   ├── protection/
│   │   │   └── selector/
│   │   └── utils/
│   └── resources/
│       ├── plugin.yml
│       └── config.yml
└── pom.xml
```

### Building
```bash
mvn clean package
```

### Code Standards
- Java 21 compatible
- Follows Minecraft plugin development best practices
- Event-driven architecture
- Configuration-based customization

## Troubleshooting

### Plugin not loading
1. Ensure Spigot version is 1.21 or compatible
2. Check server logs for error messages
3. Verify Java version is 21 or higher

### Game selector not working
1. Verify BungeeCord is properly configured
2. Check that server names in config match your BungeeCord setup
3. Ensure the plugin channel is registered

### Protection not working
1. Verify spawn coordinates are correct in config
2. Check that players are within the protection zone
3. Review permission settings if using a permission plugin

## License

This project is part of the GottaGras network. Check the repository for license information.

## Support

For issues, questions, or feature requests, please visit the [GitHub repository](https://github.com/GottaGras/Lobby).

---

**Last Updated:** January 2026
