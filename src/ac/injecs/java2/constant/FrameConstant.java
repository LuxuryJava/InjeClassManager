package ac.injecs.java2.constant;

public enum FrameConstant {
    WIDTH(1200), HEIGHT(600);

    private int value;
    FrameConstant(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
