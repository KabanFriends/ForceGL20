package io.github.kabanfriends.forcegl20;

import com.google.common.collect.ImmutableMap;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ForceGL20 {

    public static final Logger LOGGER = LoggerFactory.getLogger("forcegl30");

    public static final ImmutableMap<Integer, Integer> GLFW_OVERRIDE_VALUES;
    public static final ImmutableMap<Integer, String> GLFW_HINT_NAMES;

    static {
        //Window hint values to override (hints with -2 will be ignored)
        ImmutableMap.Builder<Integer, Integer> overrideBuilder = ImmutableMap.builder();

        overrideBuilder.put(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 2);
        overrideBuilder.put(GLFW.GLFW_CONTEXT_VERSION_MINOR, 0);
        overrideBuilder.put(GLFW.GLFW_OPENGL_PROFILE, 0);
        overrideBuilder.put(GLFW.GLFW_OPENGL_FORWARD_COMPAT, -2);

        GLFW_OVERRIDE_VALUES = overrideBuilder.build();

        //Make a list of Window hint names for logging
        ImmutableMap.Builder<Integer, String> nameBuilder = ImmutableMap.builder();

        nameBuilder.put(0x00020001, "GLFW_FOCUSED");
        nameBuilder.put(0x00020002, "GLFW_ICONIFIED");
        nameBuilder.put(0x00020003, "GLFW_RESIZABLE");
        nameBuilder.put(0x00020004, "GLFW_VISIBLE");
        nameBuilder.put(0x00020005, "GLFW_DECORATED");
        nameBuilder.put(0x00020006, "GLFW_AUTO_ICONIFY");
        nameBuilder.put(0x00020007, "GLFW_FLOATING");
        nameBuilder.put(0x00020008, "GLFW_MAXIMIZED");
        nameBuilder.put(0x00020009, "GLFW_CENTER_CURSOR");
        nameBuilder.put(0x0002000A, "GLFW_TRANSPARENT_FRAMEBUFFER");
        nameBuilder.put(0x0002000B, "GLFW_HOVERED");
        nameBuilder.put(0x0002000C, "GLFW_FOCUS_ON_SHOW");
        nameBuilder.put(0x00021001, "GLFW_RED_BITS");
        nameBuilder.put(0x00021002, "GLFW_GREEN_BITS");
        nameBuilder.put(0x00021003, "GLFW_BLUE_BITS");
        nameBuilder.put(0x00021004, "GLFW_ALPHA_BITS");
        nameBuilder.put(0x00021005, "GLFW_DEPTH_BITS");
        nameBuilder.put(0x00021006, "GLFW_STENCIL_BITS");
        nameBuilder.put(0x00021007, "GLFW_ACCUM_RED_BITS");
        nameBuilder.put(0x00021008, "GLFW_ACCUM_GREEN_BITS");
        nameBuilder.put(0x00021009, "GLFW_ACCUM_BLUE_BITS");
        nameBuilder.put(0x0002100A, "GLFW_ACCUM_ALPHA_BITS");
        nameBuilder.put(0x0002100B, "GLFW_AUX_BUFFERS");
        nameBuilder.put(0x0002100C, "GLFW_STEREO");
        nameBuilder.put(0x0002100D, "GLFW_SAMPLES");
        nameBuilder.put(0x0002100E, "GLFW_SRGB_CAPABLE");
        nameBuilder.put(0x0002100F, "GLFW_REFRESH_RATE");
        nameBuilder.put(0x00021010, "GLFW_DOUBLEBUFFER");
        nameBuilder.put(0x00022001, "GLFW_CLIENT_API");
        nameBuilder.put(0x00022002, "GLFW_CONTEXT_VERSION_MAJOR");
        nameBuilder.put(0x00022003, "GLFW_CONTEXT_VERSION_MINOR");
        nameBuilder.put(0x00022004, "GLFW_CONTEXT_REVISION");
        nameBuilder.put(0x00022005, "GLFW_CONTEXT_ROBUSTNESS");
        nameBuilder.put(0x00022006, "GLFW_OPENGL_FORWARD_COMPAT");
        nameBuilder.put(0x00022007, "GLFW_OPENGL_DEBUG_CONTEXT");
        nameBuilder.put(0x00022008, "GLFW_OPENGL_PROFILE");
        nameBuilder.put(0x00022009, "GLFW_CONTEXT_RELEASE_BEHAVIOR");
        nameBuilder.put(0x0002200A, "GLFW_CONTEXT_NO_ERROR");
        nameBuilder.put(0x0002200B, "GLFW_CONTEXT_CREATION_API");
        nameBuilder.put(0x0002200C, "GLFW_SCALE_TO_MONITOR");
        nameBuilder.put(0x00023001, "GLFW_COCOA_RETINA_FRAMEBUFFER");
        nameBuilder.put(0x00023002, "GLFW_COCOA_FRAME_NAME");
        nameBuilder.put(0x00023003, "GLFW_COCOA_GRAPHICS_SWITCHING");
        nameBuilder.put(0x00024001, "GLFW_X11_CLASS_NAME");
        nameBuilder.put(0x00024002, "GLFW_X11_INSTANCE_NAME");

        GLFW_HINT_NAMES = nameBuilder.build();
    }
}
