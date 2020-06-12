package domain;

public class SCT_Teacher {
    private int tid;
    private String tname;
    private String tpassword;
    private String ttel;

    @Override
    public String toString() {
        return "SCT_Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", ttel='" + ttel + '\'' +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel;
    }
}
