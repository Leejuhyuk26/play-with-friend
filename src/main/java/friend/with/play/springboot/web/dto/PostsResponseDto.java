package friend.with.play.springboot.web.dto;

import friend.with.play.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto { //응답을 주는 Dto 라서 entity 값을 DTO에 받는 메소드만 있음

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
