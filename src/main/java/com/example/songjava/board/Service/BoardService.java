package com.example.songjava.board.Service;

import com.example.songjava.board.model.Board;
import com.example.songjava.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    /**
     * 게시글 리스트 읽기
     *
     * @return the list
     */
    public List<Board> getList() {
        return boardMapper.getList();
    }

    /**
     * 게시글 읽기
     *
     * @param boardSeq 기본키
     * @return the board
     */
    public Board get(int boardSeq) {
        return boardMapper.get(boardSeq);
    }

    /**
     * 게시글 저장
     *
     * @param param the board
     */
    public int save(Board param) {
        Board board = boardMapper.get(param.getBoardSeq());
        if (board == null) {
            boardMapper.save(param);
        }else {
            boardMapper.update(param);
        }
        return param.getBoardSeq();
    }

    /**
     * 게시글 수정
     *
     * @param board the board
     */
    public void update(Board board) {
        boardMapper.update(board);
    }

    /**
     * 게시글 삭제
     *
     * @param boardSeq 기본키
     */
    public boolean delete(int boardSeq) {
        Board board = boardMapper.get(boardSeq);
        if (board == null) {
            return false;
        }
        boardMapper.delete(boardSeq);
        return true;
    }
}
