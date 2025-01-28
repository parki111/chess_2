package chess;

import java.util.HashSet;

public class Bishop implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> legal_moves(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();
        moves.addAll(board.getPiece(position).directional_move(1,1,board,position));
        moves.addAll(board.getPiece(position).directional_move(-1,1,board,position));
        moves.addAll(board.getPiece(position).directional_move(1,-1,board,position));
        moves.addAll(board.getPiece(position).directional_move(-1,-1,board,position));
        return moves;
    }
}
