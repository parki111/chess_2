package chess;
//System.out.println()

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    public Object[][] chessboard;

    public ChessBoard() {
        chessboard=new Object[8][8];
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void create_board(){
        chessboard[0][0]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.ROOK);
        chessboard[0][1]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.KNIGHT);
        chessboard[0][2]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.BISHOP);
        chessboard[0][3]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.QUEEN);
        chessboard[0][4]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.KING);
        chessboard[0][5]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.BISHOP);
        chessboard[0][6]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.KNIGHT);
        chessboard[0][7]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.ROOK);
        for (int i=0;i<8;i++){
            chessboard[1][i]= new ChessPiece(ChessGame.TeamColor.WHITE,ChessPiece.PieceType.PAWN);
        }
        chessboard[7][0]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.ROOK);
        chessboard[7][1]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.KNIGHT);
        chessboard[7][2]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.BISHOP);
        chessboard[7][3]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.QUEEN);
        chessboard[7][4]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.KING);
        chessboard[7][5]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.BISHOP);
        chessboard[7][6]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.KNIGHT);
        chessboard[7][7]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.ROOK);
        for (int i=0;i<8;i++){
            chessboard[6][i]= new ChessPiece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.PAWN);
        }
    }

    public void addPiece(ChessPosition position, ChessPiece piece) {
        chessboard[position.getRow()-1][position.getColumn()-1]=piece;
    }



    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */

    public ChessPiece getPiece(ChessPosition position) {
        return (ChessPiece) chessboard[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        chessboard = new Object[8][8];
        create_board();
    }



    @Override
    public String toString(){
        String board="\n";
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard[i][j]==null){
                    board+="|  |";
                }
                else{
                    board+="|"+chessboard[i][j].toString()+"|";
                }

            }
            board+="\n";
        }
        return board;
    }


    @Override
    public boolean equals(Object o) {
        if (this==o){return true;}
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(chessboard, that.chessboard);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(chessboard);
    }
}

