package ac.injecs.java2.entity;

import java.time.LocalDateTime;

public class Notice {

    private Long id;

    private String writer;

    private String  title;

    private String content;

    private LocalDateTime createdTime;   // 작성 시간

    public Notice(Long id, String writer, String title, String content, LocalDateTime createdTime) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public static class Builder {
        private Long id;

        private String writer;

        private String  title;

        private String content;

        private LocalDateTime createdTime;   // 작성 시간

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder createdTime(String createdTime) {
            this.createdTime = LocalDateTime.parse(createdTime);
            return this;
        }

        public Notice build() {
            Notice notice = new Notice(id, title, writer, content, createdTime);
            return notice;
        }
    }
}
