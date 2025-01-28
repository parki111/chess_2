package chess;

import java.util.Objects;

/**
 * Represents moving a chess piece on a chessboard
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessMove {
    public ChessPosition start_pos;
    public ChessPosition end_pos;
    public ChessPiece.PieceType promotion;

    public ChessMove(ChessPosition startPosition, ChessPosition endPosition,
                     ChessPiece.PieceType promotionPiece) {
        this.start_pos=startPosition;
        this.end_pos=endPosition;
        this.promotion=promotionPiece;
    }

    /**
     * @return ChessPosition of starting location
     */
    public ChessPosition getStartPosition() {
        return this.start_pos;
    }

    /**
     * @return ChessPosition of ending location
     */
    public ChessPosition getEndPosition() {
        return this.end_pos;
    }

    /**
     * Gets the type of piece to promote a pawn to if pawn promotion is part of this
     * chess move
     *
     * @return Type of piece to promote a pawn to, or null if no promotion
     */
    public ChessPiece.PieceType getPromotionPiece() {
        return this.promotion;
    }








    @Override
    public boolean equals(Object o) {
        if (this==o){return true;}
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessMove chessMove = (ChessMove) o;
        return Objects.equals(start_pos, chessMove.start_pos) && Objects.equals(end_pos, chessMove.end_pos) && promotion == chessMove.promotion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start_pos, end_pos, promotion);
    }
}






