package net.labymod.addons.Wector11211.AntiChatClose;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;

import java.util.List;

public class AntiChatCloseAddon extends LabyModAddon {
    public static AntiChatCloseAddon INSTANCE;
    private boolean addonEnabled;

    public static AntiChatCloseAddon getInstance(){
        return INSTANCE;
    }
    public boolean isEnabled(){
        return this.addonEnabled;
    }


    @Override
    public void onEnable() {
        INSTANCE = this;
    }

    @Override
    public void loadConfig() {
        this.addonEnabled = getConfig().has( "enabled" ) ? getConfig().get("enabled").getAsBoolean() : true;
    }

    @Override
    protected void fillSettings(List<SettingsElement> options) {
        options.add(new BooleanElement("Enabled",this, new ControlElement.IconData(Material.LEVER),"enabled", this.addonEnabled));
    }

}
