package TestModels;

import com.rometools.rome.feed.CopyFrom;
import com.rometools.rome.feed.synd.SyndCategory;

public class TestSyndCategory implements SyndCategory {

    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String s) {
        this.name = s;
    }

    @Override
    public String getTaxonomyUri() {
        return null;
    }

    @Override
    public void setTaxonomyUri(String s) {

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
