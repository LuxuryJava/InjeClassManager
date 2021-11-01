package ac.injecs.java2.constant;

public enum FrameConstant {
    WIDTH(1200), HEIGHT(600);

    private int value;
    FrameConfig(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
