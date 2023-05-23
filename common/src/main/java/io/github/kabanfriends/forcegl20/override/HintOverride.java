package io.github.kabanfriends.forcegl20.override;

public class HintOverride {

    public static final HintOverride DO_NOT_SET = new HintOverride(OverrideType.DO_NOT_SET, 0);

    private final OverrideType type;
    private final int value;

    public HintOverride(OverrideType type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public OverrideType getOverrideType() {
        return type;
    }
}
