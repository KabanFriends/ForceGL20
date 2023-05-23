package io.github.kabanfriends.forcegl20;

import com.google.common.collect.ImmutableMap;
import io.github.kabanfriends.forcegl20.override.HintOverride;
import io.github.kabanfriends.forcegl20.override.OverrideType;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ForceGL20 {

    public static final Logger LOGGER = LoggerFactory.getLogger("ForceGL20");

    public static final ImmutableMap<Integer, HintOverride> GLFW_OVERRIDE_VALUES;
    public static final ImmutableMap<Integer, String> GLFW_HINT_NAMES;

    private static final int[] GLFW_HINT_CODES = new int[] {
            0x00020001, 0x00020002, 0x00020003, 0x00020004, 0x00020005, 0x00020006,
            0x00020007, 0x00020008, 0x00020009, 0x0002000A, 0x0002000B, 0x0002000C,
            0x00021001, 0x00021002, 0x00021003, 0x00021004, 0x00021005, 0x00021006,
            0x00021007, 0x00021008, 0x00021009, 0x0002100A, 0x0002100B, 0x0002100C,
            0x0002100D, 0x0002100E, 0x0002100F, 0x00021010, 0x00022001, 0x00022002,
            0x00022003, 0x00022004, 0x00022005, 0x00022006, 0x00022007, 0x00022008,
            0x00022009, 0x0002200A, 0x0002200B, 0x0002200C, 0x00023001, 0x00023002,
            0x00023003, 0x00024001, 0x00024002
    };

    static {
        // Window hint values to override
        ImmutableMap.Builder<Integer, HintOverride> overrideBuilder = ImmutableMap.builder();

        overrideBuilder.put(GLFW.GLFW_CONTEXT_VERSION_MAJOR, new HintOverride(OverrideType.SET_VALUE, 2));
        overrideBuilder.put(GLFW.GLFW_CONTEXT_VERSION_MINOR, new HintOverride(OverrideType.SET_VALUE, 0));
        overrideBuilder.put(GLFW.GLFW_OPENGL_PROFILE, new HintOverride(OverrideType.SET_VALUE, 0));
        overrideBuilder.put(GLFW.GLFW_OPENGL_FORWARD_COMPAT, HintOverride.DO_NOT_SET);

        GLFW_OVERRIDE_VALUES = overrideBuilder.build();

        // Make a list of Window hint names for logging
        ImmutableMap.Builder<Integer, String> nameBuilder = ImmutableMap.builder();
        List<Integer> codes = Arrays.stream(GLFW_HINT_CODES).boxed().toList();

        for (Field field : GLFW.class.getDeclaredFields()) {
            if (field.getName().equals("GLFW_OPENGL_DEBUG_CONTEXT")) { // Alias for earlier versions, ignore it
                continue;
            }
            if (field.getType() == int.class && Modifier.isPublic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    int code = (int) field.get(null);
                    if (codes.contains(code)) {
                        nameBuilder.put(code, field.getName());
                    }
                } catch (IllegalAccessException e) {
                    LOGGER.error("Failed to get field value for GLFW." + field.getName());
                }
            }
        }

        GLFW_HINT_NAMES = nameBuilder.build();
    }
}
