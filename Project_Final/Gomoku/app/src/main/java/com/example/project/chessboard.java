package com.example.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.ArrayList;

public class chessboard extends View {
    private int viewWidth;
    private float chessBoard_lineLength;
    private Bitmap whitePieces;
    private Bitmap blackPieces;
    private float ratioPieceOfLineHeight = 3 * 1.0f / 4;
    private ArrayList<Point> whiteArray = new ArrayList<>();
    private ArrayList<Point> blackArray = new ArrayList<>();
    private ArrayList<Point> undo_whiteArray = new ArrayList<>();
    private ArrayList<Point> undo_blackArray = new ArrayList<>();
    private boolean piece_is_white = true;
    private boolean game_over;
    private Paint paint = new Paint();

    public chessboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        initial_values();
    }
    private void initial_values() {
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        whitePieces = BitmapFactory.decodeResource(getResources(), R.drawable.white_piece);
        blackPieces = BitmapFactory.decodeResource(getResources(), R.drawable.black_piece);
    }
    private Point getValidPoint(int x, int y) {
        int validX = (int) (x / chessBoard_lineLength);
        int validY = (int) (y / chessBoard_lineLength);

        return new Point(validX, validY);
    }
    private void drawPiece(Canvas canvas) {
        for (int i=0, n=whiteArray.size(); i<n; i++) {
            Point whitePoint = whiteArray.get(i);
            float left = (whitePoint.x + (1 - ratioPieceOfLineHeight) / 2) * chessBoard_lineLength;
            float top = (whitePoint.y + (1 - ratioPieceOfLineHeight) / 2) * chessBoard_lineLength;
            canvas.drawBitmap(whitePieces, left, top, null);
        }
        for (int i=0, n=blackArray.size(); i<n; i++) {
            Point blackPoint = blackArray.get(i);
            float left = (blackPoint.x + (1 - ratioPieceOfLineHeight) / 2) * chessBoard_lineLength;
            float top = (blackPoint.y + (1 - ratioPieceOfLineHeight) / 2) * chessBoard_lineLength;
            canvas.drawBitmap(blackPieces, left, top, null);
        }
    }
    private void drawChessBoard(Canvas canvas) {
        int board_width = viewWidth;
        float lineLength = chessBoard_lineLength;
        for (int i=0; i<15; i++) {
            int x1 = (int) (lineLength / 2);
            int x2 = (int) (board_width - lineLength / 2);
            int y = (int) ((0.5 + i) * lineLength);
            canvas.drawLine(x1, y, x2, y, paint);
            canvas.drawLine(y, x1, y, x2, paint);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawChessBoard(canvas);
        drawPiece(canvas);
        check_full();
        game_winner();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthModel = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightModel = MeasureSpec.getMode(heightMeasureSpec);
        int width = Math.min(widthSize, heightSize);
        if (widthModel==MeasureSpec.UNSPECIFIED) {
            width = heightSize;
        } else if (heightModel==MeasureSpec.UNSPECIFIED) {
            width = widthSize;
        }
        setMeasuredDimension(width, width);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (game_over) {
            return false;
        }
        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            Point point = getValidPoint(x, y);
            if (whiteArray.contains(point) || blackArray.contains(point)) {
                return false;
            }
            if (piece_is_white) {
                whiteArray.add(point);
            } else {
                blackArray.add(point);
            }
            invalidate();
            piece_is_white = !piece_is_white;
        }
        return true;
    }
    @Override
    protected void onSizeChanged(int temp_width, int temp_height, int old_width, int old_height) {
        super.onSizeChanged(temp_width, temp_height, old_width, old_height);
        viewWidth = temp_width;
        chessBoard_lineLength = viewWidth * 1.0f / 15;
        int pieceWidth = (int) (chessBoard_lineLength * ratioPieceOfLineHeight);
        whitePieces = Bitmap.createScaledBitmap(whitePieces, pieceWidth, pieceWidth, false);
        blackPieces = Bitmap.createScaledBitmap(blackPieces, pieceWidth, pieceWidth, false);
    }
    public void start() {
        whiteArray.clear();
        blackArray.clear();
        game_over = false;
        invalidate();
    }
    public void undo_white() {
        if(whiteArray.size()!=0) {
            undo_whiteArray.add(whiteArray.remove(whiteArray.size() - 1));
            piece_is_white = true;
        }
    }
    public void undo_black() {
        if(blackArray.size()!=0)  {
            undo_blackArray.add(blackArray.remove(blackArray.size() - 1));
            piece_is_white = false;
        }
    }
    public void check_full() {
        if(whiteArray.size()+blackArray.size()==225) {
            String message = "No winner! Please start a new game.";
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
    private void game_winner() {
        checkwinner winner = new checkwinner();
        boolean white_win = winner.checkFivePieces(whiteArray);
        boolean black_win = winner.checkFivePieces(blackArray);
        if(white_win){
            game_over = true;
            String white_win_message = "Congratulations!\n\n The White Win!";
            Toast.makeText(getContext(), white_win_message, Toast.LENGTH_SHORT).show();
        }
        if(black_win){
            game_over = true;
            String black_win_message = "Congratulations!\n\n The Black Win!";
            Toast.makeText(getContext(), black_win_message, Toast.LENGTH_SHORT).show();
        }
    }
}