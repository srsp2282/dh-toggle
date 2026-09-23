package net.raptornet.dhtoggle;

import com.mojang.blaze3d.platform.InputConstants;
import com.seibel.distanthorizons.api.DhApi;
import com.seibel.distanthorizons.api.interfaces.config.IDhApiConfigValue;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;

import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class DhToggleClient implements ClientModInitializer {
    private static final String API_NAME = "DH Toggle";

    private static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(
                    Identifier.fromNamespaceAndPath("dhtoggle", "controls")
            );

    private static final KeyMapping TOGGLE =
            KeyMappingHelper.registerKeyMapping(
                    new KeyMapping(
                            "key.dhtoggle.toggle",
                            InputConstants.KEY_F6,
                            CATEGORY
                    )
            );

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TOGGLE.consumeClick()) {
                if (client.player == null) {
                    continue;
                }

                try {
                    if (DhApi.Delayed.configs == null) {
                        client.player.sendSystemMessage(
                                Component.literal("DH Toggle: API not ready")
                        );
                        continue;
                    }

                    IDhApiConfigValue<Boolean> rendering =
                            DhApi.Delayed.configs
                                    .graphics()
                                    .renderingEnabled();

                    boolean current = rendering.getValue();
                    boolean next = !current;

                    boolean changed = rendering.setValue(next, API_NAME);

                    if (changed) {
                        client.player.sendSystemMessage(
                                Component.literal(
                                        "Distant Horizons rendering: "
                                                + (next ? "ON" : "OFF")
                                )
                        );
                    } else {
                        client.player.sendSystemMessage(
                                Component.literal(
                                        "DH Toggle: rendering change rejected"
                                )
                        );
                    }
                } catch (Throwable t) {
                    client.player.sendSystemMessage(
                            Component.literal(
                                    "DH Toggle error: "
                                            + t.getClass().getSimpleName()
                                )
                    );

                    t.printStackTrace();
                }
            }
        });
    }
}
