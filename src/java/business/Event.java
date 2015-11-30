/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import com.sun.xml.internal.ws.util.StringUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author William Reithmeyer
 */
@Entity
@Table(name = "event")
public class Event {


    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "event_title")
    private String title;
    @Column (name = "event_desc")
    private String description;
    @Column (name = "event_image_url")
    private String featuringImage = "";
    @Column (name = "event_date")
    private String date;
    @Column (name = "event_creator")
    private String creator;

    public Event() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeaturingImage() {
        return featuringImage;
    }

    public void setFeaturingImage(String featuringImage) {
        this.featuringImage = featuringImage;
    }

    public Date getDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
        return format.parse(this.date);
    }
    
    public String getDateAsString() throws ParseException {
        
        return this.date;
    }
    
    public String getDateDay() throws ParseException {
        SimpleDateFormat day = new SimpleDateFormat("MMM dd");
        
        return day.format(this.getDate());
    }
    
    public String getDateTime() throws ParseException {
        SimpleDateFormat day = new SimpleDateFormat("hh:mm aaa");
        
        return day.format(this.getDate());
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreator() {
        return StringUtils.capitalize(creator);
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    private Object Calendar(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
