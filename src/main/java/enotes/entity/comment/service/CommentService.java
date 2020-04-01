package enotes.entity.comment.service;

import enotes.entity.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    void save(Comment comment);

    long delete(Comment comment);

    long delete(long id);

    Optional<Comment> get(long id);

    void update(Comment comment);

    List<Comment> getAllComments();
}
