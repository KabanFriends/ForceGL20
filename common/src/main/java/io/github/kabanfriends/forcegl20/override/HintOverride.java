package io.github.kabanfriends.forcegl20.override;

public class HintOverride {

    private final OverrideType type;
    private final int value;

    public HintOverride(OverrideType type, int value) {
        this.type = type;
        this.value = value;
    }

    public HintOverride(OverrideType type) {
        this(type, 0);
    }

    public int getValue() {
        return value;
    }

    public OverrideType getOverrideType() {
        return type;
    }
}
