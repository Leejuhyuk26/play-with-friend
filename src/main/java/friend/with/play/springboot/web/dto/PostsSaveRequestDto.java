package friend.with.play.springboot.web.dto;

import friend.with.play.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() { //빌더 활용하면 하나하나 set해줄필요가 없어서 편리하네
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
