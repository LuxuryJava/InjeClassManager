package ac.injecs.java2.dto;

public class NoticeDto {
    private  String title;
    private String content;

    @Override
    public String toString() {
        return "NoticeDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return title; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
