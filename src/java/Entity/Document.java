package Entity;

public class Document extends BaseEntity {
    private String title;
    private String description;
    private String fileName;

    public Document() {}

    public Document(String title, String description, String fileName, int id, String name) {
        super(id, name);
        this.title = title;
        this.description = description;
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Document{" + "title=" + title + ", description=" + description + ", fileName=" + fileName + '}';
    }
}
