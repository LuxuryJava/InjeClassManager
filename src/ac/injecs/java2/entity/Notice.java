package ac.injecs.java2.entity;

import ac.injecs.java2.dto.NoticeDto;

public class Notice {
    private String  title;
    private String content;

    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
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

    public static class Builder {
        private String  title;
        private String content;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Notice build() {
            Notice notice = new Notice(title, content);
            return notice;
        }
    }

    public static Notice createNotice(NoticeDto noticeDto) {
        return new Builder()
                .title(noticeDto.getTitle())
                .content(noticeDto.getContent())
                .build();
    }
}
