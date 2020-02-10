package enotes.entity.comment.service;

import enotes.entity.comment.Comment;
import enotes.entity.comment.dao.CommentDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void save(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException();
        }

        commentDao.add(comment);
    }

    @Override
    public long delete(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException();
        }

        Long commentId = comment.getId();
        if (commentId == null || commentId < 1) {
            throw new IllegalArgumentException(String.format("Can't delete comment with id equals null or less than 1. Id = %d", commentId));
        }

        commentDao.delete(commentId);
        return commentId;
    }

    @Override
    public long delete(long id) {
        if (id < 1) {
            throw new IllegalArgumentException(String.format("Can't delete comment with id equals null or less than 1. Id = %d", id));
        }

        commentDao.delete(id);
        return id;
    }

    @Override
    public Optional<Comment> get(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException();
        }

        Long commentId = comment.getId();
        if (commentId == null || commentId < 1) {
            throw new IllegalArgumentException(String.format("Can't find comment with id equals null or less than 1. Id = %d", commentId));
        }

        return commentDao.find(commentId);
    }

    @Override
    public Optional<Comment> get(long id) {
        if (id < 1) {
            throw new IllegalArgumentException(String.format("Can't find comment with id less than 1. Id = %d", id));
        }

        return commentDao.find(id);
    }

    @Override
    public void update(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException();
        }

        Long commentId = comment.getId();
        if (commentId == null || commentId < 1) {
            throw new IllegalArgumentException(String.format("Can't find comment with id equals null or less than 1, updating denied. Id = %d", commentId));
        }

        commentDao.update(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.findAll();
    }
}