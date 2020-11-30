import javax.swing.*;
import java.util.Date;

public class Note {
    private String title;
    private String contentl;
    private String list;
    private Date dateTimeCreating;
    private Date dateTimeEdit;

    public Note() {
    }

    public Note(String title, String contentl, String list) {
        this.title = title;
        this.contentl = contentl;
        this.list = list;
    }

    public Note(String title, String contentl, String list, Date dateTimeCreating, Date dateTimeEdit) {
        this.title = title;
        this.contentl = contentl;
        this.list = list;
        this.dateTimeCreating = dateTimeCreating;
        this.dateTimeEdit = dateTimeEdit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentl() {
        return contentl;
    }

    public void setContentl(String contentl) {
        this.contentl = contentl;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public Date getDateTimeCreating() {
        return dateTimeCreating;
    }

    public void setDateTimeCreating(Date dateTimeCreating) {
        this.dateTimeCreating = dateTimeCreating;
    }

    public Date getDateTimeEdit() {
        return dateTimeEdit;
    }

    public void setDateTimeEdit(Date dateTimeEdit) {
        this.dateTimeEdit = dateTimeEdit;
    }

    @Override
    public String toString() {
        return "Title: " + title + '\n' +
                "Content: " + contentl + '\n' +
                "List: " + list + '\n' +
                "DateTimeCreating: " + dateTimeCreating +'\n' +
                "DateTimeEdit: " + dateTimeEdit;
    }
}
