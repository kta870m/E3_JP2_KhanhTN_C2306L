package Entity;

public enum RoomType {
    Q("Queen"),S("Single"),D("Double"),Qd("Quad"),T("Triple");
    private String lable;

    RoomType(String lable) {
        this.lable = lable;
    }
    public String getLable() {
        return lable;
    }
}
