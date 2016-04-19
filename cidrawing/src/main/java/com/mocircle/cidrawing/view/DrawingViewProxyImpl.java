package com.mocircle.cidrawing.view;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.mocircle.cidrawing.DrawingContext;
import com.mocircle.cidrawing.board.ElementManager;
import com.mocircle.cidrawing.element.DrawElement;

public class DrawingViewProxyImpl implements DrawingViewProxy {

    private DrawingView drawingView;
    private DrawingContext context;
    private ElementManager elementManager;

    public  DrawingViewProxyImpl(DrawingView drawingView, DrawingContext context, ElementManager elementManager) {
        this.drawingView = drawingView;
        this.context = context;
        this.elementManager = elementManager;
    }

    @Override
    public void onDraw(Canvas canvas) {
        DrawElement[] elements = elementManager.getVisibleElements();
        if (elements.length > 0) {
            for (DrawElement element : elements) {
                element.drawToCanvas(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (context.getDrawingMode() != null) {
            boolean result = context.getDrawingMode().onTouchEvent(event);
            if (result) {
                drawingView.notifyViewUpdated();
            }
            return result;
        }
        return false;
    }
}