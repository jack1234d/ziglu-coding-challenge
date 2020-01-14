package TestModels;

import com.rometools.rome.feed.CopyFrom;
import com.rometools.rome.feed.synd.SyndContent;

public class TestSyndContent implements SyndContent {

    private String type;
    private String value;
    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String s) {

    }

    @Override
    public String getMode() {
        return null;
    }

    @Override
    public void setMode(String s) {

    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String s) {
        this.value = s;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public Class<? extends CopyFrom> getInterface() {
        return null;
    }

    @Override
    public void copyFrom(CopyFrom copyFrom) {

    }
}
