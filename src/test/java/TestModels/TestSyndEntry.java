package TestModels;

import com.rometools.rome.feed.CopyFrom;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndLink;
import com.rometools.rome.feed.synd.SyndPerson;
import org.jdom2.Element;

import java.util.Date;
import java.util.List;

public  class TestSyndEntry implements SyndEntry {

    private String link;
    private String title;
    private SyndContent description;
    private List<SyndCategory> categories;
    private Date publicationDate;

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public void setUri(String s) {

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String s) {
        this.title = s;
    }

    @Override
    public SyndContent getTitleEx() {
        return null;
    }

    @Override
    public void setTitleEx(SyndContent syndContent) {

    }

    @Override
    public String getLink() {
        return this.link;
    }

    @Override
    public void setLink(String s) {
        this.link = s;
    }

    @Override
    public List<SyndLink> getLinks() {
        return null;
    }

    @Override
    public void setLinks(List<SyndLink> list) {

    }

    @Override
    public SyndContent getDescription() {
        return description;
    }

    @Override
    public void setDescription(SyndContent syndContent) {
        this.description = syndContent;
    }

    @Override
    public List<SyndContent> getContents() {
        return null;
    }

    @Override
    public void setContents(List<SyndContent> list) {

    }

    @Override
    public List<SyndEnclosure> getEnclosures() {
        return null;
    }

    @Override
    public void setEnclosures(List<SyndEnclosure> list) {

    }

    @Override
    public Date getPublishedDate() {
        return publicationDate;
    }

    @Override
    public void setPublishedDate(Date date) {
        this.publicationDate = date;
    }

    @Override
    public Date getUpdatedDate() {
        return null;
    }

    @Override
    public void setUpdatedDate(Date date) {

    }

    @Override
    public List<SyndPerson> getAuthors() {
        return null;
    }

    @Override
    public void setAuthors(List<SyndPerson> list) {

    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public void setAuthor(String s) {

    }

    @Override
    public List<SyndPerson> getContributors() {
        return null;
    }

    @Override
    public void setContributors(List<SyndPerson> list) {

    }

    @Override
    public List<SyndCategory> getCategories() {
        return categories;
    }

    @Override
    public void setCategories(List<SyndCategory> list) {
        this.categories = list;
    }

    @Override
    public SyndFeed getSource() {
        return null;
    }

    @Override
    public void setSource(SyndFeed syndFeed) {

    }

    @Override
    public Object getWireEntry() {
        return null;
    }

    @Override
    public Module getModule(String s) {
        return null;
    }

    @Override
    public List<Module> getModules() {
        return null;
    }

    @Override
    public void setModules(List<Module> list) {

    }

    @Override
    public List<Element> getForeignMarkup() {
        return null;
    }

    @Override
    public void setForeignMarkup(List<Element> list) {

    }

    @Override
    public String getComments() {
        return null;
    }

    @Override
    public void setComments(String s) {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public SyndLink findRelatedLink(String s) {
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