package com.example.songjava.board.controller;

import com.example.songjava.board.Service.BoardService;
import com.example.songjava.board.config.exception.BaseException;
import com.example.songjava.board.config.http.BaseResponse;
import com.example.songjava.board.config.http.BaseResponseCode;
import com.example.songjava.board.model.Board;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Api(tags = "Board API")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final BoardService boardService;

    /**
     * 게시글 목록 읽기
     *
     * @return the list
     */
    @GetMapping
    @ApiOperation(value = "목록 조회", notes = "게시물 목록 조회")
    public BaseResponse<List<Board>> getList() {
        logger.info("getList");
        return new BaseResponse<>(boardService.getList());
    }

    /**
     * 게시글 읽기
     *
     * @param boardSeq 기본키
     * @return the board
     */
    @GetMapping("/{boardSeq}")
    @ApiOperation(value = "게시물 조회", notes = "파마리터 번호의 게시물 조회")
    public BaseResponse<Board> get(
            @ApiParam(value = "게시물 번호", example = "2", required = true)
            @PathVariable int boardSeq) {
        Board board = boardService.get(boardSeq);
        if (board == null) {
            throw new BaseException(BaseResponseCode.DATA_NOT_FOUND, new String[]{"게시물"});
        }
        return new BaseResponse<>(boardService.get(boardSeq));
    }

    /**
     * 게시글 수정, 저장
     *
     * @param param the board
     */
    @PostMapping()
    @ApiOperation(value = "게시물 등록 & 수정", notes = "신규 게시물 등록, 기존 게시물 수정")
    public BaseResponse<Integer> save(Board param) {
        //제목 필수 체크
        if (ObjectUtils.isEmpty(param.getTitle())) {
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[]{"title", "제목"});
        }
        //본문 필수 체크
        if (ObjectUtils.isEmpty(param.getContents())) {
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[]{"contents", "본문"});
        }
        boardService.save(param);
        return new BaseResponse<>(param.getBoardSeq());
    }

    /**
     * 게시글 삭제
     *
     * @param boardSeq 기본키
     */
    @DeleteMapping("/{boardSeq}")
    @ApiOperation(value = "게시물 삭제", notes = "파라미터 번호의 게시물 삭제")
    public BaseResponse<Boolean> delete(
            @ApiParam(value = "게시물 번호", example = "2", required = true)
            @PathVariable int boardSeq) {
        return new BaseResponse<>(boardService.delete(boardSeq));
    }
}
