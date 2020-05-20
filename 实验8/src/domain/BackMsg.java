package domain;

import java.util.List;

public class BackMsg {
    public boolean flag;
    public String msg;
    public Object data;
    public List<Object> list;

    @Override
    public String toString() {
        return "BackMsg{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", list=" + list +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
