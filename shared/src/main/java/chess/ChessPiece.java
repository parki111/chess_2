package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    public ChessGame.TeamColor piececolor;
    public ChessPiece.PieceType piecetype;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.piececolor=pieceColor;
        this.piecetype=type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {

        return this.piececolor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {

        return this.piecetype;
    }




    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */


    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> hasher = new HashSet<>();
        ChessPiece piece= board.getPiece(myPosition);
        if (piece.piecetype==ChessPiece.PieceType.ROOK){
            Rook rook=new Rook();
            hasher.addAll(rook.legal_moves(board,myPosition));
        }
        else if (piece.piecetype==ChessPiece.PieceType.KNIGHT){
            Knight knight=new Knight();
            hasher.addAll(knight.legal_moves(board,myPosition));
        }
        else if (piece.piecetype==ChessPiece.PieceType.BISHOP){
            Bishop bishop = new Bishop();
            hasher.addAll(bishop.legal_moves(board,myPosition));
        }
        else if (piece.piecetype==ChessPiece.PieceType.QUEEN)
        {
            Queen queen = new Queen();
            hasher.addAll(queen.legal_moves(board,myPosition));
        }
        else if (piece.piecetype==ChessPiece.PieceType.KING){
            King king = new King();
            hasher.addAll(king.legal_moves(board,myPosition));
        }
        else if (piece.piecetype==ChessPiece.PieceType.PAWN){
            Pawn pawn = new Pawn();
            hasher.addAll(pawn.legal_moves(board,myPosition));
        }
        return hasher;
    }


    public HashSet<ChessMove> directional_move(int x_move,int y_move, ChessBoard board,ChessPosition position){
        System.out.println(board);
        HashSet<ChessMove> moves = new HashSet<>();
        ChessPosition start_pos=position;
        int multiplier=1;
//        int row=start_pos.getRow();
//        int column=start_pos.getColumn();
        ChessPiece this_piece=board.getPiece(position);
        int i=y_move*multiplier+position.getRow();
        int j=x_move*multiplier+position.getColumn();
        boolean promotion = ((i==8 && this_piece.getTeamColor()== ChessGame.TeamColor.WHITE) || ((i==1) && this_piece.getTeamColor() == ChessGame.TeamColor.BLACK));
        boolean pawn_may_move=((start_pos.getRow()==2 && this_piece.getTeamColor()== ChessGame.TeamColor.WHITE) || ((start_pos.getRow()==7) && this_piece.getTeamColor() == ChessGame.TeamColor.BLACK));
        while(i>0 && i<9 && j>0 && j<9){
            boolean may_move_again = ((i==3 && this_piece.getTeamColor()== ChessGame.TeamColor.WHITE) || ((i==6) && this_piece.getTeamColor() == ChessGame.TeamColor.BLACK));

            ChessPiece other_piece= board.getPiece(new ChessPosition(i,j));
            if (other_piece!=null){
                if (other_piece.piececolor==this_piece.piececolor){
                    break;
                }
                else{
                    if(this_piece.getPieceType()==PieceType.PAWN){
                        if (promotion==false){
                            if(x_move!=0) {
                                moves.add(new ChessMove(start_pos, new ChessPosition(i, j), null));
                                break;
                            }
                            break;
                        }
                    }
                    else{
                        moves.add(new ChessMove(start_pos, new ChessPosition(i,j),null));
                        break;
                    }

                }
            }
            else{
                if (this_piece.getPieceType()==PieceType.PAWN){
                    if (x_move!=0)
                    {break;}
                    else if (promotion==false) {
                        moves.add(new ChessMove(start_pos, new ChessPosition(i, j), null));
                        if (pawn_may_move && may_move_again){
                            multiplier+=1;
                            i=y_move*multiplier+position.getRow();
                            j=x_move*multiplier+position.getColumn();
                            continue;
                        }
                        else{
                            break;
                        }

                    }
                }
                else{
                    moves.add(new ChessMove(start_pos, new ChessPosition(i,j),null));
                }


            }
            if (this_piece.getPieceType()==ChessPiece.PieceType.KING || this_piece.getPieceType()==ChessPiece.PieceType.KNIGHT)
            {
                break;
            }

            if (this_piece.getPieceType()==PieceType.PAWN)
            {
                if (promotion==true){
                    moves.add(new ChessMove(start_pos, new ChessPosition(i,j),PieceType.ROOK));
                    moves.add(new ChessMove(start_pos, new ChessPosition(i,j),PieceType.KNIGHT));
                    moves.add(new ChessMove(start_pos, new ChessPosition(i,j),PieceType.BISHOP));
                    moves.add(new ChessMove(start_pos, new ChessPosition(i,j),PieceType.QUEEN));
                }
                else{
                    moves.add(new ChessMove(start_pos, new ChessPosition(i,j),null));
                }
                break;

            }

            multiplier+=1;
            i=y_move*multiplier+position.getRow();
            j=x_move*multiplier+position.getColumn();
        }
        return moves;
    }





    @Override
    public String toString(){
        String new_string;
        new_string=""+piececolor.toString().charAt(0)+piecetype.toString().charAt(0);
        return new_string;
    }

    public boolean equals(Object o) {
        if (this==o){return true;}
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return piececolor == that.piececolor && piecetype == that.piecetype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(piececolor, piecetype);
    }
}


