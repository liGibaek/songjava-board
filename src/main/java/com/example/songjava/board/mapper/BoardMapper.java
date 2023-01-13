package com.example.songjava.board.mapper;

import com.example.songjava.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getList();

    Board get(int boardSeq);

    int save(Board board);

    void update(Board board);

    void delete(int boardSeq);

}
