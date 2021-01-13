/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.DataConfig;
import java.sql.Date;

/**
 *
 * @author hoaktse05446
 */
public class Entry {

    private int id;
    private Category category;
    private String title;
    private String imagePath;
    private String logoPath;
    private String content;
    private Date publishedDate;

    public Entry() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImagePath(String imagePath) {
        String path = DataConfig.getImagePath();
        this.imagePath = path + "/" + imagePath;
    }

    public void setLogoPath(String logoPath) {
        String path = DataConfig.getImagePath();
        this.logoPath = path + "/" + logoPath;
    }

    public String getImageName() {
        String path = DataConfig.getImagePath() + "/";
        String name = this.imagePath.replace(path, "");
        return name;
    }

    public String getShortContent() {
        String shortContent = "";
        if (content != null) {
            shortContent = content.substring(0, content.length()/2)+"...";
        }
        return shortContent;
    }

}
