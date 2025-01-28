package chess;

import java.util.HashSet;

public interface PieceMoveCalculator {
    public HashSet<ChessMove> legal_moves(ChessBoard board, ChessPosition position);
}
