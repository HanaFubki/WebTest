package domain;

public class SCT_Choice {
    private int sid;
    private int cid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "SCT_Choice{" +
                "sid=" + sid +
                ", cid=" + cid +
                '}';
    }
}
