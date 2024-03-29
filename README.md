# RedWorldguardFlags
New helpful [WorldGuard](https://dev.bukkit.org/projects/worldguard) Flags provided and supported by
the [RedstoneWorld](https://redstoneworld.de) development team.

## Flags

| Flag                       | Description                                                                                                                           | Default State |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------|---------------|
| `dispense-nbt-spawneggs`   | Toggles whether spawn-eggs with custom NBT data will be dispensed                                                                     | allow         |
| `vehicle-entity-collision` | Toggles whether players or mobs can collide with vehicles                                                                             | allow         |
| `lectern-book-place`       | Toggles whether players can place books on lecterns (subordinate to the "build" flag)                                                 | allow         |
| `spawnegg-use`             | Toggles whether entities can spawn when a player uses spawn-eggs (overrides the "mob-spawning" flag, subordinate to the "build" flag) | allow         |
| `spawnegg-dispense`        | Toggles whether entities can spawn when a dispenser dispense spawn-eggs (overrides the "mob-spawning" flag)                           | allow         |

## License
This project is licensed under the permissive [Apache 2.0 License](LICENSE).

## Development

### Event handling
Note:
`event.setCancelled(false);` means that the event will continue to be processed by WorldGuard in this context.
`event.setCancelled(true);` means that the event is canceled and WorldGuard does not continue to do anything natively.