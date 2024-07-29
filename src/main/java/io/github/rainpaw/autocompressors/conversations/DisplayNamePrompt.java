package io.github.rainpaw.autocompressors.conversations;

import io.github.rainpaw.autocompressors.guis.CompressorEditGUI;
import io.github.rainpaw.autocompressors.items.ModifiableCompressor;
import org.bukkit.ChatColor;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;

public class DisplayNamePrompt extends StringPrompt {

    private final Player player;

    private final ModifiableCompressor compressor;

    private final CompressorEditGUI editGUI;

    @Override
    public String getPromptText(ConversationContext context) {
        return "§aEnter new display name, with \"&\" for color codes, or type \"exit\" to quit:";
    }

    @Override
    public Prompt acceptInput(ConversationContext context, String input) {
        compressor.setDisplayName(ChatColor.translateAlternateColorCodes('&', input));
        editGUI.refreshGUI();
        editGUI.open(player);
        return null;
    }

    public DisplayNamePrompt(Player player, ModifiableCompressor compressor, CompressorEditGUI editGUI) {
        this.editGUI = editGUI;
        this.player = player;
        this.compressor = compressor;
    }
}
