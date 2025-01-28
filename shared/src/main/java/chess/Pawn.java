package chess;

import java.util.HashSet;

public class Pawn implements PieceMoveCalculator{
    @Override
    public HashSet<ChessMove> legal_moves(ChessBoard board, ChessPosition position) {
        HashSet<ChessMove> moves = new HashSet<>();
        if (board.getPiece(position).getTeamColor()==ChessGame.TeamColor.WHITE) {
            moves.addAll(board.getPiece(position).directional_move(0, 1, board, position));
            moves.addAll(board.getPiece(position).directional_move(1, 1, board, position));
            moves.addAll(board.getPiece(position).directional_move(-1, 1, board, position));
        }
        else{
            moves.addAll(board.getPiece(position).directional_move(0, -1, board, position));
            moves.addAll(board.getPiece(position).directional_move(1, -1, board, position));
            moves.addAll(board.getPiece(position).directional_move(-1, -1, board, position));
        }
        return moves;
    }
}
