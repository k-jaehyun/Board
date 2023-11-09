package com.sparta.board.service;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);

        boardRepository.save(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoardList() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }


    public BoardResponseDto getBoard(Long id) {
        return new BoardResponseDto(findBoard(id));
    }

    @Transactional
    public Long updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = findBoard(id);
        if(board.getPassword().equals(requestDto.getPassword())) {
            board.update(requestDto);
        } else {
            return (long) 0;
        }

        return id;
    }

    public Long deleteBoard(Long id, String password) {
        Board board = findBoard(id);
        if(board.getPassword().equals(password)) {
            boardRepository.delete(board);
        } else {
            return (long) 0;
        }

        return id;
    }

    private Board findBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }


}
