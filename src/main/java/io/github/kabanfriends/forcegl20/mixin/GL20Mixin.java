package io.github.kabanfriends.forcegl20.mixin;

import io.github.kabanfriends.forcegl20.ForceGL20;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Window.class)
public class GL20Mixin {

    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V", remap = false))
    private void windowHintOverride(int hint, int value) {
        if (ForceGL20.GLFW_OVERRIDE_VALUES.containsKey(hint)) {
            int original = value;

            String hintName = "Unknown";
            if (ForceGL20.GLFW_HINT_NAMES.containsKey(hint)) {
                hintName = ForceGL20.GLFW_HINT_NAMES.get(hint);
            }

            value = ForceGL20.GLFW_OVERRIDE_VALUES.get(hint);
            ForceGL20.LOGGER.info("Overriding " + hintName + ": " + original + " -> " + (value == -2 ? "None" : value));
            if (value == -2) {
                return;
            }
        }
        GLFW.glfwWindowHint(hint, value);
    }
}
