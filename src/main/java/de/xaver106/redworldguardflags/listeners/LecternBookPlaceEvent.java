package de.xaver106.redworldguardflags.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import de.xaver106.redworldguardflags.RedWorldguardFlags;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.LecternInventory;

public class LecternBookPlaceEvent implements Listener {

    private final RedWorldguardFlags plugin;

    public LecternBookPlaceEvent(RedWorldguardFlags plugin) {

        this.plugin = plugin;

    }

    @EventHandler
    public void onInteract(org.bukkit.event.player.PlayerInteractEvent event) {
        // WorldGuard Query
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(BukkitAdapter.adapt(event.getPlayer().getLocation()));

        // Check if the flag applies and if it is set to deny
        if (set.testState(null, (StateFlag) plugin.getFlags().get(StateFlag.class).get("lectern-book-place"))) {

            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
            if ((item.getType() != Material.WRITABLE_BOOK) && (item.getType() != Material.WRITTEN_BOOK)) return;

            Block block = event.getClickedBlock();
            if (block == null) return;
            if (block.getType() != Material.LECTERN) return;

            BlockState state = block.getState();
            if (!(state instanceof InventoryHolder)) return;
            InventoryHolder holder = (InventoryHolder) state;

            Inventory inventory = holder.getInventory();
            if (!(inventory instanceof LecternInventory)) return;
            LecternInventory lecternInventory = (LecternInventory) inventory;

            lecternInventory.setBook(item);
        }

    }

}