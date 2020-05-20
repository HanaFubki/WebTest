package domain;

public class SCT_Course {
    private int cid;
    private String cname;
    private int tid;
    private int countLimit;
    private int gradeLimit;
    private int nowCount;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(int countLimit) {
        this.countLimit = countLimit;
    }

    public int getGradeLimit() {
        return gradeLimit;
    }

    public void setGradeLimit(int gradeLimit) {
        this.gradeLimit = gradeLimit;
    }

    public int getNowCount() {
        return nowCount;
    }

    public void setNowCount(int nowCount) {
        this.nowCount = nowCount;
    }

    @Override
    public String toString() {
        return "SCT_Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", tid=" + tid +
                ", countLimit=" + countLimit +
                ", gradeLimit=" + gradeLimit +
                ", nowCount=" + nowCount +
                '}';
    }
}
