package friend.with.play.springboot.service.posts;

import friend.with.play.springboot.domain.posts.Posts;
import friend.with.play.springboot.domain.posts.PostsRepository;
import friend.with.play.springboot.web.dto.PostsResponseDto;
import friend.with.play.springboot.web.dto.PostsSaveRequestDto;
import friend.with.play.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){  //데이터를 변경시킬일이 없는 조회는 @Transactional 이 사실상 필요없다.
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }
}
