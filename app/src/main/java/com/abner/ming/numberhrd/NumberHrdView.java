package com.abner.ming.numberhrd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by AbnerMing on 2018/1/19.
 * 数字华容道，灵感来自最强大脑
 */

public class NumberHrdView extends View{
    private int floatX_6,floatY_6,floatX,floatY;
    public NumberHrdView(Context context) {
        super(context);
        initView(context);
    }

    public NumberHrdView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NumberHrdView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context) {
        setBackgroundColor(Color.parseColor("#222222"));
        iniPaint();
    }

    /**
     * 初始化画笔，共八个格子
     * */
    private Paint mPaintRect,mPaintText,mPaint1,mPaint2,mPaint3,mPaint4,mPaint5,mPaint6,mPaint7,mPaint8,mPaint9;
    private void iniPaint() {
        mPaintRect=new Paint();
        mPaintRect.setAntiAlias(true);
        mPaintRect.setColor(Color.WHITE);
        mPaintRect.setStrokeWidth(2);
        mPaintRect.setStyle(Paint.Style.STROKE);

        mPaintText=new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setStrokeWidth(2);
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setTextSize(36);

        mPaint1=new Paint();
        createPaint(mPaint1);
        mPaint2=new Paint();
        createPaint(mPaint2);
        mPaint3=new Paint();
        createPaint(mPaint3);
        mPaint4=new Paint();
        createPaint(mPaint4);
        mPaint5=new Paint();
        createPaint(mPaint5);
        mPaint6=new Paint();
        createPaint(mPaint6);
        mPaint7=new Paint();
        createPaint(mPaint7);
        mPaint8=new Paint();
        createPaint(mPaint8);
        mPaint9=new Paint();
        createPaint(mPaint9);


    }

    private void createPaint(Paint paint){
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
    }

    private Canvas canvas;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        onDrawRect();
        onRectLine();

    }


    /**
     * 记录每个格子移动的左上右下
     * */

    private int rect0_x_0,rect0_x_1,rect0_y_0,rect0_y_1;//空隙位置
    private int rect1_x_0,rect1_x_1,rect1_y_0,rect1_y_1,rect1_x_t,rect1_y_t;
    private int rect2_x_0,rect2_x_1,rect2_y_0,rect2_y_1,rect2_x_t,rect2_y_t;
    private int rect3_x_0,rect3_x_1,rect3_y_0,rect3_y_1,rect3_x_t,rect3_y_t;
    private int rect4_x_0,rect4_x_1,rect4_y_0,rect4_y_1,rect4_x_t,rect4_y_t;
    private int rect5_x_0,rect5_x_1,rect5_y_0,rect5_y_1,rect5_x_t,rect5_y_t;
    private int rect6_x_0,rect6_x_1,rect6_y_0,rect6_y_1,rect6_x_t,rect6_y_t;
    private int rect7_x_0,rect7_x_1,rect7_y_0,rect7_y_1,rect7_x_t,rect7_y_t;
    private int rect8_x_0,rect8_x_1,rect8_y_0,rect8_y_1,rect8_x_t,rect8_y_t;

    private int textMargin=10;
    private void onRectLine() {
        rect1=new Rect(rect1_x_0,rect1_y_0,rect1_x_1,rect1_y_1);
        mPaint1.setColor(Color.parseColor(numbercolor[0]));
        canvas.drawRect(rect1,mPaint1);
        canvas.drawText(number[0],rect1_x_t-textMargin,rect1_y_t+textMargin,mPaintText);

        rect2=new Rect(rect2_x_0,rect2_y_0,rect2_x_1,rect2_y_1);
        mPaint2.setColor(Color.parseColor(numbercolor[1]));
        canvas.drawRect(rect2,mPaint2);
        canvas.drawText(number[1],rect2_x_t-textMargin,rect2_y_t+textMargin,mPaintText);

        rect3=new Rect(rect3_x_0,rect3_y_0,rect3_x_1,rect3_y_1);
        mPaint3.setColor(Color.parseColor(numbercolor[2]));
        canvas.drawRect(rect3,mPaint3);
        canvas.drawText(number[2],rect3_x_t-textMargin,rect3_y_t+textMargin,mPaintText);

        rect4=new Rect(rect4_x_0,rect4_y_0,rect4_x_1,rect4_y_1);
        mPaint4.setColor(Color.parseColor(numbercolor[3]));
        canvas.drawRect(rect4,mPaint4);
        canvas.drawText(number[3],rect4_x_t-textMargin,rect4_y_t+textMargin,mPaintText);

        rect5=new Rect(rect5_x_0,rect5_y_0,rect5_x_1,rect5_y_1);
        mPaint5.setColor(Color.parseColor(numbercolor[4]));
        canvas.drawRect(rect5,mPaint5);
        canvas.drawText(number[4],rect5_x_t-textMargin,rect5_y_t+textMargin,mPaintText);

        rect6=new Rect(rect6_x_0,rect6_y_0,rect6_x_1,rect6_y_1);
        mPaint6.setColor(Color.parseColor(numbercolor[5]));
        canvas.drawRect(rect6,mPaint6);
        canvas.drawText(number[5],rect6_x_t-textMargin,rect6_y_t+textMargin,mPaintText);


        rect7=new Rect(rect7_x_0,rect7_y_0,rect7_x_1,rect7_y_1);
        mPaint7.setColor(Color.parseColor(numbercolor[6]));
        canvas.drawRect(rect7,mPaint7);
        canvas.drawText(number[6],rect7_x_t-textMargin,rect7_y_t+textMargin,mPaintText);


        rect8=new Rect(rect8_x_0,rect8_y_0,rect8_x_1,rect8_y_1);
        mPaint8.setColor(Color.parseColor(numbercolor[7]));
        canvas.drawRect(rect8,mPaint8);
        canvas.drawText(number[7],rect8_x_t-textMargin,rect8_y_t+textMargin,mPaintText);
    }

    private int padding=10;

    private Rect rect1,rect2,rect3,rect4,rect5,rect6,rect7,rect8;
    private void onDrawRect() {
        Rect rect=new Rect(padding,padding,mWidth-padding,mHeight-padding);
        canvas.drawRect(rect,mPaintRect);
        int floatX=mWidth/3;
        int floatY=mHeight/3;
        for (int a=1;a<=3;a++){
            int y=floatY*a+padding;
            int x=floatX*a+padding;
            canvas.drawLine(padding,y,mWidth-padding,y,mPaintRect);
            canvas.drawLine(x,padding,x,mHeight-padding,mPaintRect);
        }

    }
    private int mWidth,mHeight;

    private  int number_1_left=padding,number_1_right=floatX+padding,number_1_top=padding,number_1_bottom=floatY+padding;
    private  int number_2_left=padding+floatX,number_2_right=floatX*2+padding,number_2_top=padding,number_2_bottom=floatY+padding;
    private  int number_3_left=padding+floatX*2,number_3_right=mWidth-padding,number_3_top=padding,number_3_bottom=floatY+padding;
    private  int number_4_left=padding,number_4_right=floatX+padding,number_4_top=floatY+padding,number_4_bottom=floatY*2+padding;
    private  int number_5_left=padding+floatX,number_5_right=floatX*2+padding,number_5_top=floatY+padding,number_5_bottom=floatY*2+padding;
    private  int number_6_left=padding+floatX*2,number_6_right=mWidth-padding,number_6_top=floatY+padding,number_6_bottom=floatY*2+padding;
    private  int number_7_left=padding,number_7_right=floatX+padding,number_7_top=floatY*2+padding,number_7_bottom=mHeight-padding;
    private  int number_8_left=padding+floatX,number_8_right=floatX*2+padding,number_8_top=floatY*2+padding,number_8_bottom=mHeight-padding;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
        mWidth=getMeasuredWidth();
        mHeight=getMeasuredHeight();
        floatX_6=mWidth/6;
        floatY_6=mHeight/6;
        floatX=mWidth/3;
        floatY=mHeight/3;

        //初始化每个格子
        createView_1();
        createView_2();
        createView_3();
        createView_4();
        createView_5();
        createView_6();
        createView_7();
        createView_8();
        createView_9(padding+floatX*2,mWidth-padding,padding+floatY*2,mHeight-padding);
        number_1_left=padding;number_1_right=floatX+padding;number_1_top=padding;number_1_bottom=floatY+padding;
        number_2_left=padding+floatX;number_2_right=floatX*2+padding;number_2_top=padding;number_2_bottom=floatY+padding;
        number_3_left=padding+floatX*2;number_3_right=mWidth-padding;number_3_top=padding;number_3_bottom=floatY+padding;
        number_4_left=padding;number_4_right=floatX+padding;number_4_top=floatY+padding;number_4_bottom=floatY*2+padding;
        number_5_left=padding+floatX;number_5_right=floatX*2+padding;number_5_top=floatY+padding;number_5_bottom=floatY*2+padding;
        number_6_left=padding+floatX*2;number_6_right=mWidth-padding;number_6_top=floatY+padding;number_6_bottom=floatY*2+padding;
        number_7_left=padding;number_7_right=floatX+padding;number_7_top=floatY*2+padding;number_7_bottom=mHeight-padding;
        number_8_left=padding+floatX;number_8_right=floatX*2+padding;number_8_top=floatY*2+padding;number_8_bottom=mHeight-padding;
    }

    /**
     * 每次移动格子，记录空白格子的位置
     * */
    private void createView_9(int num1,int num2,int num3,int num4) {
        Log.i("createView_9",num1+"==="+num2+"==="+num3+"==="+num4);
        rect0_x_0=num1;
        rect0_x_1=num2;
        rect0_y_0=num3;
        rect0_y_1=num4;
    }

    /**
     * 第一个格子的位置
     * */
    private void createView_1() {
        rect1_x_0=padding;
        rect1_x_1=floatX+padding;
        rect1_y_0=padding;
        rect1_y_1=floatY+padding;
        rect1_x_t=(floatX+padding)/2;
        rect1_y_t=(floatY+padding)/2;
    }
    /**
     * 第二个格子的位置
     * */
    private void createView_2() {
        rect2_x_0=padding+floatX;
        rect2_x_1=floatX*2+padding;
        rect2_y_0=padding;
        rect2_y_1=floatY+padding;
        rect2_x_t=(floatX*2+padding)-floatX_6;
        rect2_y_t=(floatY+padding)/2;
    }
    /**
     * 第三个格子的位置
     * */
    private void createView_3() {
        rect3_x_0=padding+floatX*2;
        rect3_x_1=mWidth-padding;
        rect3_y_0=padding;
        rect3_y_1=floatY+padding;
        rect3_x_t=(mWidth-padding)-floatX_6;
        rect3_y_t=(floatY+padding)/2;
    }
    /**
     * 第四个格子的位置
     * */
    private void createView_4() {
        rect4_x_0=padding;
        rect4_x_1=floatX+padding;
        rect4_y_0=padding+floatY;
        rect4_y_1=floatY*2+padding;
        rect4_x_t=(floatX+padding)/2;
        rect4_y_t=(floatY*2+padding)-floatY_6;
    }
    /**
     * 第五个格子的位置
     * */
    private void createView_5() {
        rect5_x_0=padding+floatX;
        rect5_x_1=floatX*2+padding;
        rect5_y_0=padding+floatY;
        rect5_y_1=floatY*2+padding;
        rect5_x_t=(floatX*2+padding)-floatX_6;
        rect5_y_t=(floatY*2+padding)-floatY_6;
    }
    /**
     * 第六个格子的位置
     * */
    private void createView_6(){
        rect6_x_0=padding+floatX*2;
        rect6_x_1=mWidth-padding;
        rect6_y_0=padding+floatY;
        rect6_y_1=floatY*2+padding;
        rect6_x_t=(mWidth-padding)-floatX_6;
        rect6_y_t=(floatY*2+padding)-floatY_6;
    }
    /**
     * 第七个格子的位置
     * */
    private void createView_7(){
        rect7_x_0=padding;
        rect7_x_1=floatX+padding;
        rect7_y_0=padding+floatY*2;
        rect7_y_1=mHeight-padding;
        rect7_x_t=(floatX+padding)/2;
        rect7_y_t=(mHeight-padding)-floatY_6;
    }
    /**
     * 第八个格子的位置
     * */
    private void createView_8() {
        rect8_x_0=padding+floatX;
        rect8_x_1=floatX*2+padding;
        rect8_y_0=padding+floatY*2;
        rect8_y_1=mHeight-padding;
        rect8_x_t=(floatX*2+padding)-floatX_6;
        rect8_y_t=(mHeight-padding)-floatY_6;
    }

    private int downX,downY,upX,upY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i("Scroll2048",MainActivity.isStart+"== ");
        if(!MainActivity.isStart){
           // return true;
        }
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX= (int) event.getX();
                downY= (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                upX= (int) event.getX();
                upY= (int) event.getY();
                //如果不是大于空白格子，那么就不移动
                boolean isScroll=upX>rect0_x_0&&upX<rect0_x_1&&upY>rect0_y_0&&upY<rect0_y_1;
                if(!isScroll){
                    return true;
                }
                //如果移动的距离大于一格半，那么就不移动，必须在一格半之内
                if(Math.abs(upX-downX)>floatX+floatX/2||Math.abs(upY-downY)>floatY/2+floatY){
                    return true;
                }
                if(!MainActivity.isStart){
                    listener.toast();
                    return true;
                }

                if(downX>rect1_x_0&&downX<rect1_x_1&&downY>rect1_y_0&&downY<rect1_y_1) {//移动了1号
                    Log.i("Scroll2048","111111");
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            resert_down_1_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            resert_down_1_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            resert_up_1_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            resert_up_1_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            resert_left_1_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            resert_left_1_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            resert_right_1_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            resert_right_1_2();
                        }
                    }


                }else if(downX>rect2_x_0&&downX<rect2_x_1&&downY>rect2_y_0&&downY<rect2_y_1) {//移动了2号
                    Log.i("Scroll2048","222222");
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            resert_down_2_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            resert_down_2_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            resert_up_2_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            resert_up_2_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            resert_left_2_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            resert_left_2_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            resert_right_2_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            resert_right_2_2();
                        }
                    }


                }else if(downX>rect3_x_0&&downX<rect3_x_1&&downY>rect3_y_0&&downY<rect3_y_1) {//移动了3号
                    Log.i("Scroll2048","333333");
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            resert_down_3_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            resert_down_3_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            resert_up_3_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            resert_up_3_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            resert_left_3_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            resert_left_3_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            resert_right_3_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            resert_right_3_2();
                        }
                    }


                }else if(downX>rect4_x_0&&downX<rect4_x_1&&downY>rect4_y_0&&downY<rect4_y_1) {//移动了4号
                    Log.i("Scroll2048","4444");
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            resert_down_4_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            resert_down_4_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            resert_up_4_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            resert_up_4_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            resert_left_4_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            resert_left_4_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            resert_right_4_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            resert_right_4_2();
                        }
                    }


                }else if(downX>rect5_x_0&&downX<rect5_x_1&&downY>rect5_y_0&&downY<rect5_y_1) {//移动了5号
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            Log.i("Scroll2048","555555---第一行往下");
                            resert_down_5_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            Log.i("Scroll2048","555555---第二行往下");
                            resert_down_5_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            Log.i("Scroll2048","555555---第三行往上");
                            resert_up_5_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            Log.i("Scroll2048","555555---第二行往上");
                            resert_up_5_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            Log.i("Scroll2048","555555---第一纵行往右滑动");
                            resert_left_5_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            Log.i("Scroll2048","555555---第二纵行往右滑动");
                            resert_left_5_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            Log.i("Scroll2048","555555---第三纵行往左滑动");
                            resert_right_5_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            Log.i("Scroll2048","555555---第二纵行往左滑动");
                            resert_right_5_2();
                        }
                    }



                }else if(downX>rect6_x_0&&downX<rect6_x_1&&downY>rect6_y_0&&downY<rect6_y_1){//移动了6号
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            Log.i("Scroll2048","666666---第一行往下");
                            resert_down_6_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            Log.i("Scroll2048","666666---第二行往下");
                            resert_down_6_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            Log.i("Scroll2048","666666---第三行往上");
                            resert_up_6_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            Log.i("Scroll2048","666666---第二行往上");
                            resert_up_6_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            Log.i("Scroll2048","666666---第一纵行往右滑动");
                            resert_left_6_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            Log.i("Scroll2048","666666---第二纵行往右滑动");
                            resert_left_6_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            Log.i("Scroll2048","666666---第三纵行往左滑动");
                            resert_right_6_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            Log.i("Scroll2048","666666---第二纵行往左滑动");
                            resert_right_6_2();
                        }
                    }

                }else if(downX>rect7_x_0&&downX<rect7_x_1&&downY>rect7_y_0&&downY<rect7_y_1){//移动了7号
                    Log.i("Scroll2048","7777");
                    //判断是横向还是纵向移动
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            resert_down_7_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            resert_down_7_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            resert_up_7_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            resert_up_7_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            resert_left_7_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            resert_left_7_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第三纵行往左滑动
                            resert_right_7_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            resert_right_7_2();
                        }
                    }

                }else if(downX>rect8_x_0&&downX<rect8_x_1&&downY>rect8_y_0&&downY<rect8_y_1){//移动了8号
                    //判断是横向还是纵向移动
                    if(Math.abs(upY-downY)>floatY/2&&Math.abs(upX-downX)<floatX/2){
                        //纵向移动
                        if(upY>downY&&upY>floatY+padding&&upY<floatY*2+padding) {//第一行往下
                            Log.i("Scroll2048","8888---第一行往下");
                            resert_down_8_1();
                        }else if(upY>downY&&upY>floatY*2+padding&&upY<mHeight-padding){//第二行往下
                            Log.i("Scroll2048","8888---第二行往下");
                            resert_down_8_2();
                        }else if(upY<downY&&upY>floatY+padding&&upY<floatY*2+padding){//第三行往上
                            Log.i("Scroll2048","8888---第三行往上");
                            resert_up_8_1();
                        }else if(upY<downY&&upY>padding&&upY<floatY+padding){//第二行往上
                            Log.i("Scroll2048","8888---第二行往上");
                            resert_up_8_2();
                        }
                    }else if(Math.abs(upX-downX)>floatX/2&&Math.abs(upY-downY)<floatY/2){
                        //横向移动
                        if(upX>downX&&upX>floatX+padding&&upX<floatX*2+padding){//第一纵行往右滑动
                            Log.i("Scroll2048","8888---第一纵行往右滑动");
                            resert_left_8_1();
                        }else if(upX>downX&&upX>floatX*2+padding&&upX<mWidth-padding){//第二纵行往右滑动
                            Log.i("Scroll2048","8888---第二纵行往右滑动");
                            resert_left_8_2();
                        }else if(upX<downX&&upX<mWidth-padding&&upX>floatX+padding){//第一纵行往左滑动
                            Log.i("Scroll2048","8888---第一纵行往右滑动");
                            resert_right_8_1();
                        }else if(upX<downX&&upX<floatX+padding&&upX>padding){//第二纵行往左滑动
                            Log.i("Scroll2048","8888---第二纵行往右滑动");
                            resert_right_8_2();
                        }
                    }
                }
                invalidate();
                successNumber();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX= (int) event.getX();
                int moveY= (int) event.getY();

                break;
        }
        return true;
    }
    /**
     * 以下是记录每个格子移动后的位置，及空白格子的位置，都是重复性的代码
     * */
    /**---------------------------------------------------------------第一格-----------------------------------------------------*/
    private void resert_right_1_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_1_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_1_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_1_7();
        }
    }

    private void resert_right_1_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_1_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_1_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_1_8();
        }

    }

    //第2格第1竖行向右边移动
    private void resert_left_1_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_1_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_1_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_1_8();
        }
    }
    //第2格第2竖行向右边移动
    private void resert_left_1_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_1_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_1_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_1_9();
        }
    }

    //第2格第2行向上移动
    private void resert_up_1_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_1_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_1_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_1_3();
        }
    }
    //第2格第3行向上移动
    private void resert_up_1_1() {
        if(upX>padding&&upX<floatX+padding){//第2格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_1_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第3格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_1_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第5格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_1_6();
        }
    }

    //第2格第1行向下移动
    private void resert_down_1_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_1_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_1_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_1_6();
        }
    }
    //第2格第2行向下移动
    private void resert_down_1_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_1_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_1_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_1_9();
        }
    }
    //第2格移动到第1格
    private void view_1_1(){
        rect1_x_0=padding;
        rect1_x_1=floatX+padding;
        rect1_y_0=padding;
        rect1_y_1=floatY+padding;
        rect1_x_t=(floatX+padding)/2;
        rect1_y_t=(floatY+padding)/2;
    }
    //第2格移动到第2格
    private void view_1_2(){
        rect1_x_0=padding+floatX;
        rect1_x_1=floatX*2+padding;
        rect1_y_0=padding;
        rect1_y_1=floatY+padding;
        rect1_x_t=(floatX*2+padding)-floatX_6;
        rect1_y_t=(floatY+padding)/2;
    }
    //第2格移动到第2格
    private void view_1_3(){
        rect1_x_0=padding+floatX*2;
        rect1_x_1=mWidth-padding;
        rect1_y_0=padding;
        rect1_y_1=floatY+padding;
        rect1_x_t=(mWidth-padding)-floatX_6;
        rect1_y_t=(floatY+padding)/2;
    }
    //第6格移动到第2格
    private void view_1_4(){
        rect1_x_0=padding;
        rect1_x_1=floatX+padding;
        rect1_y_0=padding+floatY;
        rect1_y_1=floatY*2+padding;
        rect1_x_t=(floatX+padding)/2;
        rect1_y_t=(floatY*2+padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_1_5(){
        rect1_x_0=padding+floatX;
        rect1_x_1=floatX*2+padding;
        rect1_y_0=padding+floatY;
        rect1_y_1=floatY*2+padding;
        rect1_x_t=(floatX*2+padding)-floatX_6;
        rect1_y_t=(floatY*2+padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_1_6(){
        rect1_x_0=padding+floatX*2;
        rect1_x_1=mWidth-padding;
        rect1_y_0=padding+floatY;
        rect1_y_1=floatY*2+padding;
        rect1_x_t=(mWidth-padding)-floatX_6;
        rect1_y_t=(floatY*2+padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_1_7(){
        rect1_x_0=padding;
        rect1_x_1=floatX+padding;
        rect1_y_0=padding+floatY*2;
        rect1_y_1=mHeight-padding;
        rect1_x_t=(floatX+padding)/2;
        rect1_y_t=(mHeight-padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_1_8(){
        rect1_x_0=padding+floatX;
        rect1_x_1=floatX*2+padding;
        rect1_y_0=padding+floatY*2;
        rect1_y_1=mHeight-padding;
        rect1_x_t=(floatX*2+padding)-floatX_6;
        rect1_y_t=(mHeight-padding)-floatY_6;
    }
    //第2格移动到第9格
    private void view_1_9(){
        rect1_x_0=padding+floatX*2;
        rect1_x_1=mWidth-padding;
        rect1_y_0=padding+floatY*2;
        rect1_y_1=mHeight-padding;
        rect1_x_t=(mWidth-padding)-floatX_6;
        rect1_y_t=(mHeight-padding)-floatY_6;
    }
    /**---------------------------------------------------------------第二格-----------------------------------------------------*/
    private void resert_right_2_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_2_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_2_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_2_7();
        }
    }

    private void resert_right_2_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_2_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_2_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_2_8();
        }

    }

    //第2格第1竖行向右边移动
    private void resert_left_2_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_2_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_2_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_2_8();
        }
    }
    //第2格第2竖行向右边移动
    private void resert_left_2_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_2_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_2_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_2_9();
        }
    }

    //第2格第2行向上移动
    private void resert_up_2_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_2_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_2_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_2_3();
        }
    }
    //第2格第3行向上移动
    private void resert_up_2_1() {
        if(upX>padding&&upX<floatX+padding){//第2格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_2_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第3格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_2_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第5格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_2_6();
        }
    }

    //第2格第1行向下移动
    private void resert_down_2_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_2_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_2_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_2_6();
        }
    }
    //第2格第2行向下移动
    private void resert_down_2_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_2_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_2_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_2_9();
        }
    }
    //第2格移动到第1格
    private void view_2_1(){
        rect2_x_0=padding;
        rect2_x_1=floatX+padding;
        rect2_y_0=padding;
        rect2_y_1=floatY+padding;
        rect2_x_t=(floatX+padding)/2;
        rect2_y_t=(floatY+padding)/2;
    }
    //第2格移动到第2格
    private void view_2_2(){
        rect2_x_0=padding+floatX;
        rect2_x_1=floatX*2+padding;
        rect2_y_0=padding;
        rect2_y_1=floatY+padding;
        rect2_x_t=(floatX*2+padding)-floatX_6;
        rect2_y_t=(floatY+padding)/2;
    }
    //第2格移动到第2格
    private void view_2_3(){
        rect2_x_0=padding+floatX*2;
        rect2_x_1=mWidth-padding;
        rect2_y_0=padding;
        rect2_y_1=floatY+padding;
        rect2_x_t=(mWidth-padding)-floatX_6;
        rect2_y_t=(floatY+padding)/2;
    }
    //第6格移动到第2格
    private void view_2_4(){
        rect2_x_0=padding;
        rect2_x_1=floatX+padding;
        rect2_y_0=padding+floatY;
        rect2_y_1=floatY*2+padding;
        rect2_x_t=(floatX+padding)/2;
        rect2_y_t=(floatY*2+padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_2_5(){
        rect2_x_0=padding+floatX;
        rect2_x_1=floatX*2+padding;
        rect2_y_0=padding+floatY;
        rect2_y_1=floatY*2+padding;
        rect2_x_t=(floatX*2+padding)-floatX_6;
        rect2_y_t=(floatY*2+padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_2_6(){
        rect2_x_0=padding+floatX*2;
        rect2_x_1=mWidth-padding;
        rect2_y_0=padding+floatY;
        rect2_y_1=floatY*2+padding;
        rect2_x_t=(mWidth-padding)-floatX_6;
        rect2_y_t=(floatY*2+padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_2_7(){
        rect2_x_0=padding;
        rect2_x_1=floatX+padding;
        rect2_y_0=padding+floatY*2;
        rect2_y_1=mHeight-padding;
        rect2_x_t=(floatX+padding)/2;
        rect2_y_t=(mHeight-padding)-floatY_6;
    }
    //第2格移动到第2格
    private void view_2_8(){
        rect2_x_0=padding+floatX;
        rect2_x_1=floatX*2+padding;
        rect2_y_0=padding+floatY*2;
        rect2_y_1=mHeight-padding;
        rect2_x_t=(floatX*2+padding)-floatX_6;
        rect2_y_t=(mHeight-padding)-floatY_6;
    }
    //第2格移动到第9格
    private void view_2_9(){
        rect2_x_0=padding+floatX*2;
        rect2_x_1=mWidth-padding;
        rect2_y_0=padding+floatY*2;
        rect2_y_1=mHeight-padding;
        rect2_x_t=(mWidth-padding)-floatX_6;
        rect2_y_t=(mHeight-padding)-floatY_6;
    }
    /**---------------------------------------------------------------第三格-----------------------------------------------------*/
    private void resert_right_3_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_3_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_3_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_3_7();
        }
    }

    private void resert_right_3_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_3_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_3_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_3_8();
        }

    }

    //第3格第1竖行向右边移动
    private void resert_left_3_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_3_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_3_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_3_8();
        }
    }
    //第3格第2竖行向右边移动
    private void resert_left_3_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_3_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_3_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_3_9();
        }
    }

    //第3格第2行向上移动
    private void resert_up_3_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_3_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_3_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_3_3();
        }
    }
    //第3格第3行向上移动
    private void resert_up_3_1() {
        if(upX>padding&&upX<floatX+padding){//第3格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_3_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第3格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_3_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第5格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_3_6();
        }
    }

    //第3格第1行向下移动
    private void resert_down_3_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_3_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_3_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_3_6();
        }
    }
    //第3格第2行向下移动
    private void resert_down_3_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_3_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_3_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_3_9();
        }
    }
    //第3格移动到第1格
    private void view_3_1(){
        rect3_x_0=padding;
        rect3_x_1=floatX+padding;
        rect3_y_0=padding;
        rect3_y_1=floatY+padding;
        rect3_x_t=(floatX+padding)/2;
        rect3_y_t=(floatY+padding)/2;
    }
    //第3格移动到第2格
    private void view_3_2(){
        rect3_x_0=padding+floatX;
        rect3_x_1=floatX*2+padding;
        rect3_y_0=padding;
        rect3_y_1=floatY+padding;
        rect3_x_t=(floatX*2+padding)-floatX_6;
        rect3_y_t=(floatY+padding)/2;
    }
    //第3格移动到第3格
    private void view_3_3(){
        rect3_x_0=padding+floatX*2;
        rect3_x_1=mWidth-padding;
        rect3_y_0=padding;
        rect3_y_1=floatY+padding;
        rect3_x_t=(mWidth-padding)-floatX_6;
        rect3_y_t=(floatY+padding)/2;
    }
    //第6格移动到第3格
    private void view_3_4(){
        rect3_x_0=padding;
        rect3_x_1=floatX+padding;
        rect3_y_0=padding+floatY;
        rect3_y_1=floatY*2+padding;
        rect3_x_t=(floatX+padding)/2;
        rect3_y_t=(floatY*2+padding)-floatY_6;
    }
    //第3格移动到第3格
    private void view_3_5(){
        rect3_x_0=padding+floatX;
        rect3_x_1=floatX*2+padding;
        rect3_y_0=padding+floatY;
        rect3_y_1=floatY*2+padding;
        rect3_x_t=(floatX*2+padding)-floatX_6;
        rect3_y_t=(floatY*2+padding)-floatY_6;
    }
    //第3格移动到第3格
    private void view_3_6(){
        rect3_x_0=padding+floatX*2;
        rect3_x_1=mWidth-padding;
        rect3_y_0=padding+floatY;
        rect3_y_1=floatY*2+padding;
        rect3_x_t=(mWidth-padding)-floatX_6;
        rect3_y_t=(floatY*2+padding)-floatY_6;
    }
    //第3格移动到第3格
    private void view_3_7(){
        rect3_x_0=padding;
        rect3_x_1=floatX+padding;
        rect3_y_0=padding+floatY*2;
        rect3_y_1=mHeight-padding;
        rect3_x_t=(floatX+padding)/2;
        rect3_y_t=(mHeight-padding)-floatY_6;
    }
    //第3格移动到第3格
    private void view_3_8(){
        rect3_x_0=padding+floatX;
        rect3_x_1=floatX*2+padding;
        rect3_y_0=padding+floatY*2;
        rect3_y_1=mHeight-padding;
        rect3_x_t=(floatX*2+padding)-floatX_6;
        rect3_y_t=(mHeight-padding)-floatY_6;
    }
    //第3格移动到第9格
    private void view_3_9(){
        rect3_x_0=padding+floatX*2;
        rect3_x_1=mWidth-padding;
        rect3_y_0=padding+floatY*2;
        rect3_y_1=mHeight-padding;
        rect3_x_t=(mWidth-padding)-floatX_6;
        rect3_y_t=(mHeight-padding)-floatY_6;
    }
    /**---------------------------------------------------------------第四格-----------------------------------------------------*/
    private void resert_right_4_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_4_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_4_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_4_7();
        }
    }

    private void resert_right_4_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_4_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_4_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_4_8();
        }

    }

    //第4格第1竖行向右边移动
    private void resert_left_4_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_4_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_4_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_4_8();
        }
    }
    //第4格第2竖行向右边移动
    private void resert_left_4_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_4_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_4_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_4_9();
        }
    }

    //第4格第2行向上移动
    private void resert_up_4_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_4_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_4_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_4_3();
        }
    }
    //第4格第3行向上移动
    private void resert_up_4_1() {
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_4_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第4格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_4_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第5格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_4_6();
        }
    }

    //第4格第1行向下移动
    private void resert_down_4_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_4_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_4_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_4_6();
        }
    }
    //第4格第2行向下移动
    private void resert_down_4_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_4_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_4_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_4_9();
        }
    }
    //第4格移动到第1格
    private void view_4_1(){
        rect4_x_0=padding;
        rect4_x_1=floatX+padding;
        rect4_y_0=padding;
        rect4_y_1=floatY+padding;
        rect4_x_t=(floatX+padding)/2;
        rect4_y_t=(floatY+padding)/2;
    }
    //第4格移动到第2格
    private void view_4_2(){
        rect4_x_0=padding+floatX;
        rect4_x_1=floatX*2+padding;
        rect4_y_0=padding;
        rect4_y_1=floatY+padding;
        rect4_x_t=(floatX*2+padding)-floatX_6;
        rect4_y_t=(floatY+padding)/2;
    }
    //第4格移动到第3格
    private void view_4_3(){
        rect4_x_0=padding+floatX*2;
        rect4_x_1=mWidth-padding;
        rect4_y_0=padding;
        rect4_y_1=floatY+padding;
        rect4_x_t=(mWidth-padding)-floatX_6;
        rect4_y_t=(floatY+padding)/2;
    }
    //第6格移动到第4格
    private void view_4_4(){
        rect4_x_0=padding;
        rect4_x_1=floatX+padding;
        rect4_y_0=padding+floatY;
        rect4_y_1=floatY*2+padding;
        rect4_x_t=(floatX+padding)/2;
        rect4_y_t=(floatY*2+padding)-floatY_6;
    }
    //第4格移动到第4格
    private void view_4_5(){
        rect4_x_0=padding+floatX;
        rect4_x_1=floatX*2+padding;
        rect4_y_0=padding+floatY;
        rect4_y_1=floatY*2+padding;
        rect4_x_t=(floatX*2+padding)-floatX_6;
        rect4_y_t=(floatY*2+padding)-floatY_6;
    }
    //第4格移动到第4格
    private void view_4_6(){
        rect4_x_0=padding+floatX*2;
        rect4_x_1=mWidth-padding;
        rect4_y_0=padding+floatY;
        rect4_y_1=floatY*2+padding;
        rect4_x_t=(mWidth-padding)-floatX_6;
        rect4_y_t=(floatY*2+padding)-floatY_6;
    }
    //第4格移动到第4格
    private void view_4_7(){
        rect4_x_0=padding;
        rect4_x_1=floatX+padding;
        rect4_y_0=padding+floatY*2;
        rect4_y_1=mHeight-padding;
        rect4_x_t=(floatX+padding)/2;
        rect4_y_t=(mHeight-padding)-floatY_6;
    }
    //第4格移动到第4格
    private void view_4_8(){
        rect4_x_0=padding+floatX;
        rect4_x_1=floatX*2+padding;
        rect4_y_0=padding+floatY*2;
        rect4_y_1=mHeight-padding;
        rect4_x_t=(floatX*2+padding)-floatX_6;
        rect4_y_t=(mHeight-padding)-floatY_6;
    }
    //第4格移动到第9格
    private void view_4_9(){
        rect4_x_0=padding+floatX*2;
        rect4_x_1=mWidth-padding;
        rect4_y_0=padding+floatY*2;
        rect4_y_1=mHeight-padding;
        rect4_x_t=(mWidth-padding)-floatX_6;
        rect4_y_t=(mHeight-padding)-floatY_6;
    }
    /**---------------------------------------------------------------第五格-----------------------------------------------------*/
    private void resert_right_5_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_5_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_5_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_5_7();
        }
    }

    private void resert_right_5_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_5_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_5_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_5_8();
        }

    }

    //第5格第1竖行向右边移动
    private void resert_left_5_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_5_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_5_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_5_8();
        }
    }
    //第5格第2竖行向右边移动
    private void resert_left_5_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_5_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_5_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_5_9();
        }
    }

    //第5格第2行向上移动
    private void resert_up_5_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_5_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_5_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_5_3();
        }
    }
    //第5格第3行向上移动
    private void resert_up_5_1() {
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_5_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_5_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第5格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_5_6();
        }
    }

    //第5格第1行向下移动
    private void resert_down_5_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_5_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_5_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_5_6();
        }
    }
    //第5格第2行向下移动
    private void resert_down_5_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_5_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_5_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_5_9();
        }
    }
    //第5格移动到第1格
    private void view_5_1(){
        rect5_x_0=padding;
        rect5_x_1=floatX+padding;
        rect5_y_0=padding;
        rect5_y_1=floatY+padding;
        rect5_x_t=(floatX+padding)/2;
        rect5_y_t=(floatY+padding)/2;
    }
    //第5格移动到第2格
    private void view_5_2(){
        rect5_x_0=padding+floatX;
        rect5_x_1=floatX*2+padding;
        rect5_y_0=padding;
        rect5_y_1=floatY+padding;
        rect5_x_t=(floatX*2+padding)-floatX_6;
        rect5_y_t=(floatY+padding)/2;
    }
    //第5格移动到第3格
    private void view_5_3(){
        rect5_x_0=padding+floatX*2;
        rect5_x_1=mWidth-padding;
        rect5_y_0=padding;
        rect5_y_1=floatY+padding;
        rect5_x_t=(mWidth-padding)-floatX_6;
        rect5_y_t=(floatY+padding)/2;
    }
    //第6格移动到第4格
    private void view_5_4(){
        rect5_x_0=padding;
        rect5_x_1=floatX+padding;
        rect5_y_0=padding+floatY;
        rect5_y_1=floatY*2+padding;
        rect5_x_t=(floatX+padding)/2;
        rect5_y_t=(floatY*2+padding)-floatY_6;
    }
    //第5格移动到第5格
    private void view_5_5(){
        rect5_x_0=padding+floatX;
        rect5_x_1=floatX*2+padding;
        rect5_y_0=padding+floatY;
        rect5_y_1=floatY*2+padding;
        rect5_x_t=(floatX*2+padding)-floatX_6;
        rect5_y_t=(floatY*2+padding)-floatY_6;
    }
    //第5格移动到第5格
    private void view_5_6(){
        rect5_x_0=padding+floatX*2;
        rect5_x_1=mWidth-padding;
        rect5_y_0=padding+floatY;
        rect5_y_1=floatY*2+padding;
        rect5_x_t=(mWidth-padding)-floatX_6;
        rect5_y_t=(floatY*2+padding)-floatY_6;
    }
    //第5格移动到第5格
    private void view_5_7(){
        rect5_x_0=padding;
        rect5_x_1=floatX+padding;
        rect5_y_0=padding+floatY*2;
        rect5_y_1=mHeight-padding;
        rect5_x_t=(floatX+padding)/2;
        rect5_y_t=(mHeight-padding)-floatY_6;
    }
    //第5格移动到第5格
    private void view_5_8(){
        rect5_x_0=padding+floatX;
        rect5_x_1=floatX*2+padding;
        rect5_y_0=padding+floatY*2;
        rect5_y_1=mHeight-padding;
        rect5_x_t=(floatX*2+padding)-floatX_6;
        rect5_y_t=(mHeight-padding)-floatY_6;
    }
    //第5格移动到第9格
    private void view_5_9(){
        rect5_x_0=padding+floatX*2;
        rect5_x_1=mWidth-padding;
        rect5_y_0=padding+floatY*2;
        rect5_y_1=mHeight-padding;
        rect5_x_t=(mWidth-padding)-floatX_6;
        rect5_y_t=(mHeight-padding)-floatY_6;
    }
    /**---------------------------------------------------------------第六格-----------------------------------------------------*/
    private void resert_right_6_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_6_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_6_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_6_7();
        }
    }

    private void resert_right_6_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_6_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_6_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_6_8();
        }

    }

    //第6格第1竖行向右边移动
    private void resert_left_6_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_6_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_6_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_6_8();
        }
    }
    //第6格第2竖行向右边移动
    private void resert_left_6_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_6_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_6_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_6_9();
        }
    }

    //第6格第2行向上移动
    private void resert_up_6_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_6_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_6_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_6_3();
        }
    }
    //第6格第3行向上移动
    private void resert_up_6_1() {
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_6_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_6_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_6_6();
        }
    }

    //第6格第1行向下移动
    private void resert_down_6_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_6_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_6_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_6_6();
        }
    }
    //第6格第2行向下移动
    private void resert_down_6_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_6_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_6_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_6_9();
        }
    }
    //第6格移动到第1格
    private void view_6_1(){
        rect6_x_0=padding;
        rect6_x_1=floatX+padding;
        rect6_y_0=padding;
        rect6_y_1=floatY+padding;
        rect6_x_t=(floatX+padding)/2;
        rect6_y_t=(floatY+padding)/2;
    }
    //第6格移动到第2格
    private void view_6_2(){
        rect6_x_0=padding+floatX;
        rect6_x_1=floatX*2+padding;
        rect6_y_0=padding;
        rect6_y_1=floatY+padding;
        rect6_x_t=(floatX*2+padding)-floatX_6;
        rect6_y_t=(floatY+padding)/2;
    }
    //第6格移动到第3格
    private void view_6_3(){
        rect6_x_0=padding+floatX*2;
        rect6_x_1=mWidth-padding;
        rect6_y_0=padding;
        rect6_y_1=floatY+padding;
        rect6_x_t=(mWidth-padding)-floatX_6;
        rect6_y_t=(floatY+padding)/2;
    }
    //第6格移动到第4格
    private void view_6_4(){
        rect6_x_0=padding;
        rect6_x_1=floatX+padding;
        rect6_y_0=padding+floatY;
        rect6_y_1=floatY*2+padding;
        rect6_x_t=(floatX+padding)/2;
        rect6_y_t=(floatY*2+padding)-floatY_6;
    }
    //第6格移动到第5格
    private void view_6_5(){
        rect6_x_0=padding+floatX;
        rect6_x_1=floatX*2+padding;
        rect6_y_0=padding+floatY;
        rect6_y_1=floatY*2+padding;
        rect6_x_t=(floatX*2+padding)-floatX_6;
        rect6_y_t=(floatY*2+padding)-floatY_6;
    }
    //第6格移动到第6格
    private void view_6_6(){
        rect6_x_0=padding+floatX*2;
        rect6_x_1=mWidth-padding;
        rect6_y_0=padding+floatY;
        rect6_y_1=floatY*2+padding;
        rect6_x_t=(mWidth-padding)-floatX_6;
        rect6_y_t=(floatY*2+padding)-floatY_6;
    }
    //第6格移动到第6格
    private void view_6_7(){
        rect6_x_0=padding;
        rect6_x_1=floatX+padding;
        rect6_y_0=padding+floatY*2;
        rect6_y_1=mHeight-padding;
        rect6_x_t=(floatX+padding)/2;
        rect6_y_t=(mHeight-padding)-floatY_6;
    }
    //第6格移动到第6格
    private void view_6_8(){
        rect6_x_0=padding+floatX;
        rect6_x_1=floatX*2+padding;
        rect6_y_0=padding+floatY*2;
        rect6_y_1=mHeight-padding;
        rect6_x_t=(floatX*2+padding)-floatX_6;
        rect6_y_t=(mHeight-padding)-floatY_6;
    }
    //第6格移动到第9格
    private void view_6_9(){
        rect6_x_0=padding+floatX*2;
        rect6_x_1=mWidth-padding;
        rect6_y_0=padding+floatY*2;
        rect6_y_1=mHeight-padding;
        rect6_x_t=(mWidth-padding)-floatX_6;
        rect6_y_t=(mHeight-padding)-floatY_6;
    }

    /**---------------------------------------------------------------第七格-----------------------------------------------------*/
    private void resert_right_7_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_7_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_7_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_7_7();
        }
    }

    private void resert_right_7_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_7_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_7_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_7_8();
        }

    }

    //第7格第1竖行向右边移动
    private void resert_left_7_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_7_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_7_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_7_8();
        }
    }
    //第7格第2竖行向右边移动
    private void resert_left_7_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_7_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_7_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_7_9();
        }
    }

    //第7格第2行向上移动
    private void resert_up_7_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_7_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_7_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_7_3();
        }
    }
    //第7格第3行向上移动
    private void resert_up_7_1() {
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_7_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_7_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_7_6();
        }
    }

    //第7格第1行向下移动
    private void resert_down_7_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_7_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_7_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_7_6();
        }
    }
    //第7格第2行向下移动
    private void resert_down_7_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_7_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_7_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_7_9();
        }
    }
    //第7格移动到第1格
    private void view_7_1(){
        rect7_x_0=padding;
        rect7_x_1=floatX+padding;
        rect7_y_0=padding;
        rect7_y_1=floatY+padding;
        rect7_x_t=(floatX+padding)/2;
        rect7_y_t=(floatY+padding)/2;
    }
    //第7格移动到第2格
    private void view_7_2(){
        rect7_x_0=padding+floatX;
        rect7_x_1=floatX*2+padding;
        rect7_y_0=padding;
        rect7_y_1=floatY+padding;
        rect7_x_t=(floatX*2+padding)-floatX_6;
        rect7_y_t=(floatY+padding)/2;
    }
    //第7格移动到第3格
    private void view_7_3(){
        rect7_x_0=padding+floatX*2;
        rect7_x_1=mWidth-padding;
        rect7_y_0=padding;
        rect7_y_1=floatY+padding;
        rect7_x_t=(mWidth-padding)-floatX_6;
        rect7_y_t=(floatY+padding)/2;
    }
    //第7格移动到第4格
    private void view_7_4(){
        rect7_x_0=padding;
        rect7_x_1=floatX+padding;
        rect7_y_0=padding+floatY;
        rect7_y_1=floatY*2+padding;
        rect7_x_t=(floatX+padding)/2;
        rect7_y_t=(floatY*2+padding)-floatY_6;
    }
    //第7格移动到第5格
    private void view_7_5(){
        rect7_x_0=padding+floatX;
        rect7_x_1=floatX*2+padding;
        rect7_y_0=padding+floatY;
        rect7_y_1=floatY*2+padding;
        rect7_x_t=(floatX*2+padding)-floatX_6;
        rect7_y_t=(floatY*2+padding)-floatY_6;
    }
    //第7格移动到第6格
    private void view_7_6(){
        rect7_x_0=padding+floatX*2;
        rect7_x_1=mWidth-padding;
        rect7_y_0=padding+floatY;
        rect7_y_1=floatY*2+padding;
        rect7_x_t=(mWidth-padding)-floatX_6;
        rect7_y_t=(floatY*2+padding)-floatY_6;
    }
    //第7格移动到第7格
    private void view_7_7(){
        rect7_x_0=padding;
        rect7_x_1=floatX+padding;
        rect7_y_0=padding+floatY*2;
        rect7_y_1=mHeight-padding;
        rect7_x_t=(floatX+padding)/2;
        rect7_y_t=(mHeight-padding)-floatY_6;
    }
    //第7格移动到第7格
    private void view_7_8(){
        rect7_x_0=padding+floatX;
        rect7_x_1=floatX*2+padding;
        rect7_y_0=padding+floatY*2;
        rect7_y_1=mHeight-padding;
        rect7_x_t=(floatX*2+padding)-floatX_6;
        rect7_y_t=(mHeight-padding)-floatY_6;
    }
    //第7格移动到第9格
    private void view_7_9(){
        rect7_x_0=padding+floatX*2;
        rect7_x_1=mWidth-padding;
        rect7_y_0=padding+floatY*2;
        rect7_y_1=mHeight-padding;
        rect7_x_t=(mWidth-padding)-floatX_6;
        rect7_y_t=(mHeight-padding)-floatY_6;
    }
    /**---------------------------------------------------------------第八格-----------------------------------------------------*/
    private void resert_right_8_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_8_1();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,floatY+padding,floatY*2+padding);
            view_8_4();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,floatY*2+padding,mHeight-padding);
            view_8_7();
        }
    }

    private void resert_right_8_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_8_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY+padding,floatY*2+padding);
            view_8_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX*2,mWidth-padding,floatY*2+padding,mHeight-padding);
            view_8_8();
        }

    }

    //第八格第1竖行向右边移动
    private void resert_left_8_1() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_8_2();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_8_5();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding,floatX+padding,floatY*2+padding,mHeight-padding);
            view_8_8();
        }
    }
    //第八格第2竖行向右边移动
    private void resert_left_8_2() {
        if(upY>padding&&upY<floatY+padding){
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_8_3();
        }else if(upY>floatY+padding&&upY<floatY*2+padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_8_6();
        }else if(upY>floatY*2+padding&&upY<mHeight-padding){
            createView_9(padding+floatX,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_8_9();
        }
    }

    //第八格第2行向上移动
    private void resert_up_8_2() {
        if(upX>padding&&upX<floatX+padding){//第1格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_8_1();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第2格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_8_2();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第3格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_8_3();
        }
    }
    //第八格第3行向上移动
    private void resert_up_8_1() {
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding+floatY*2,mHeight-padding);
            view_8_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(floatX+padding,floatX*2+padding,padding+floatY*2,mHeight-padding);
            view_8_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY*2,mHeight-padding);
            view_8_6();
        }
    }

    //第八格第1行向下移动
    private void resert_down_8_1(){
        if(upX>padding&&upX<floatX+padding){//第4格
            createView_9(padding,floatX+padding,padding,floatY+padding);
            view_8_4();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第5格
            createView_9(padding+floatX,floatX*2+padding,padding,floatY+padding);
            view_8_5();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第6格
            createView_9(padding+floatX*2,mWidth-padding,padding,floatY+padding);
            view_8_6();
        }
    }
    //第八格第2行向下移动
    private void resert_down_8_2() {
        if(upX>padding&&upX<floatX+padding){//第7格
            createView_9(padding,floatX+padding,padding+floatY,floatY*2+padding);
            view_8_7();
        }else if(upX>floatX+padding&&upX<floatX*2+padding){//第8格
            createView_9(padding+floatX,floatX*2+padding,padding+floatY,floatY*2+padding);
            view_8_8();
        }else if(upX>floatX*2+padding&&upX<mWidth-padding){//第9格
            createView_9(floatX*2+padding,mWidth-padding,padding+floatY,floatY*2+padding);
            view_8_9();
        }
    }
    //第8格移动到第1格
    private void view_8_1(){
        rect8_x_0=padding;
        rect8_x_1=floatX+padding;
        rect8_y_0=padding;
        rect8_y_1=floatY+padding;
        rect8_x_t=(floatX+padding)/2;
        rect8_y_t=(floatY+padding)/2;
    }
    //第8格移动到第2格
    private void view_8_2(){
        rect8_x_0=padding+floatX;
        rect8_x_1=floatX*2+padding;
        rect8_y_0=padding;
        rect8_y_1=floatY+padding;
        rect8_x_t=(floatX*2+padding)-floatX_6;
        rect8_y_t=(floatY+padding)/2;
    }
    //第8格移动到第3格
    private void view_8_3(){
        rect8_x_0=padding+floatX*2;
        rect8_x_1=mWidth-padding;
        rect8_y_0=padding;
        rect8_y_1=floatY+padding;
        rect8_x_t=(mWidth-padding)-floatX_6;
        rect8_y_t=(floatY+padding)/2;
    }
    //第8格移动到第4格
    private void view_8_4(){
        rect8_x_0=padding;
        rect8_x_1=floatX+padding;
        rect8_y_0=padding+floatY;
        rect8_y_1=floatY*2+padding;
        rect8_x_t=(floatX+padding)/2;
        rect8_y_t=(floatY*2+padding)-floatY_6;
    }
    //第8格移动到第5格
    private void view_8_5(){
        rect8_x_0=padding+floatX;
        rect8_x_1=floatX*2+padding;
        rect8_y_0=padding+floatY;
        rect8_y_1=floatY*2+padding;
        rect8_x_t=(floatX*2+padding)-floatX_6;
        rect8_y_t=(floatY*2+padding)-floatY_6;
    }
    //第8格移动到第6格
    private void view_8_6(){
        rect8_x_0=padding+floatX*2;
        rect8_x_1=mWidth-padding;
        rect8_y_0=padding+floatY;
        rect8_y_1=floatY*2+padding;
        rect8_x_t=(mWidth-padding)-floatX_6;
        rect8_y_t=(floatY*2+padding)-floatY_6;
    }
    //第8格移动到第7格
    private void view_8_7(){
        rect8_x_0=padding;
        rect8_x_1=floatX+padding;
        rect8_y_0=padding+floatY*2;
        rect8_y_1=mHeight-padding;
        rect8_x_t=(floatX+padding)/2;
        rect8_y_t=(mHeight-padding)-floatY_6;
    }
    //第8格移动到第8格
    private void view_8_8(){
        rect8_x_0=padding+floatX;
        rect8_x_1=floatX*2+padding;
        rect8_y_0=padding+floatY*2;
        rect8_y_1=mHeight-padding;
        rect8_x_t=(floatX*2+padding)-floatX_6;
        rect8_y_t=(mHeight-padding)-floatY_6;
    }
    //第8格移动到第9格
    private void view_8_9(){
        rect8_x_0=padding+floatX*2;
        rect8_x_1=mWidth-padding;
        rect8_y_0=padding+floatY*2;
        rect8_y_1=mHeight-padding;
        rect8_x_t=(mWidth-padding)-floatX_6;
        rect8_y_t=(mHeight-padding)-floatY_6;
    }

    private String[] number={"5","2","6","7","4","1","8","3"};
    private String[] numbercolor={"#548B54","#87CEFA","#CD0000","#8B0000","#B3EE3A","#8B795E","#CDAD00","#48D1CC"};
    private int numberType=1;
    public void setNumberData(int type,String[] number,String[] numbercolor){
        numberType=type;
        this.number=number;
        this.numbercolor=numbercolor;
        invalidate();
    }
    /**
     * 回调成功
     * */
    public void setOnSuccess(OnSuccessListener listener){
        this.listener=listener;
    }
    private OnSuccessListener listener;
    public interface OnSuccessListener{
        void success(int state);

        void toast();
    }

    /**
     * 分为六种情况成功
     * */
    private void successNumber(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                successNumberType();
            }
        },500);

    }



    private void successNumberType() {
        switch (numberType){
            case 5://"8","6","3","1","5","7","2","4"
                Log.i("successNumberType",number_1_left+"==="+number_1_right+"==="+number_1_top+"==="+number_1_bottom);
                if(rect1.top==number_8_top&&rect1.bottom==number_8_bottom&&rect1.left==number_8_left&&rect1.right==number_8_right
                        &&rect2.top==number_6_top&&rect2.bottom==number_6_bottom&&rect2.left==number_6_left&&rect2.right==number_6_right
                        &&rect3.top==number_3_top&&rect3.bottom==number_3_bottom&&rect3.left==number_3_left&&rect3.right==number_3_right
                        &&rect4.top==number_1_top&&rect4.bottom==number_1_bottom&&rect4.left==number_1_left&&rect4.right==number_1_right
                        &&rect5.top==number_5_top&&rect5.bottom==number_5_bottom&&rect5.left==number_5_left&&rect5.right==number_5_right
                        &&rect6.top==number_7_top&&rect6.bottom==number_7_bottom&&rect6.left==number_7_left&&rect6.right==number_7_right
                        &&rect7.top==number_2_top&&rect7.bottom==number_2_bottom&&rect7.left==number_2_left&&rect7.right==number_2_right
                        &&rect8.top==number_4_top&&rect8.bottom==number_4_bottom&&rect8.left==number_4_left&&rect8.right==number_4_right){
                    listener.success(numberType);
                }
                break;
            case 3://"6","1","4","3","8","2","7","5"
                if(rect1.top==number_6_top&&rect1.bottom==number_6_bottom&&rect1.left==number_6_left&&rect1.right==number_6_right
                        &&rect2.top==number_1_top&&rect2.bottom==number_1_bottom&&rect2.left==number_1_left&&rect2.right==number_1_right
                        &&rect3.top==number_4_top&&rect3.bottom==number_4_bottom&&rect3.left==number_4_left&&rect3.right==number_4_right
                        &&rect4.top==number_3_top&&rect4.bottom==number_3_bottom&&rect4.left==number_3_left&&rect4.right==number_3_right
                        &&rect5.top==number_8_top&&rect5.bottom==number_8_bottom&&rect5.left==number_8_left&&rect5.right==number_8_right
                        &&rect6.top==number_2_top&&rect6.bottom==number_2_bottom&&rect6.left==number_2_left&&rect6.right==number_2_right
                        &&rect7.top==number_7_top&&rect7.bottom==number_7_bottom&&rect7.left==number_7_left&&rect7.right==number_7_right
                        &&rect8.top==number_5_top&&rect8.bottom==number_5_bottom&&rect8.left==number_5_left&&rect8.right==number_5_right){
                    listener.success(numberType);
                }
                break;
            case 1://"5","2","6","7","4","1","8","3"
                Log.i("successNumberType",
                        rect1.left+"==="+rect1.right+"==="+rect1.top+"==="+rect1.bottom+
                                "==="+ rect2.left+"==="+rect2.right+"==="+rect2.top+"==="+rect2.bottom
                );
                Log.i("successNumberType",
                        number_1_left+"==="+number_1_right+"==="+number_1_top+"==="+number_1_bottom+
                        "==="+ number_2_left+"==="+number_2_right+"==="+number_2_top+"==="+number_2_bottom
                );
                if(rect1.top==number_5_top&&rect1.bottom==number_5_bottom&&rect1.left==number_5_left&&rect1.right==number_5_right
                        &&rect2.top==number_2_top&&rect2.bottom==number_2_bottom&&rect2.left==number_2_left&&rect2.right==number_2_right
                        &&rect3.top==number_6_top&&rect3.bottom==number_6_bottom&&rect3.left==number_6_left&&rect3.right==number_6_right
                        &&rect4.top==number_7_top&&rect4.bottom==number_7_bottom&&rect4.left==number_7_left&&rect4.right==number_7_right
                        &&rect5.top==number_4_top&&rect5.bottom==number_4_bottom&&rect5.left==number_4_left&&rect5.right==number_4_right
                        &&rect6.top==number_1_top&&rect6.bottom==number_1_bottom&&rect6.left==number_1_left&&rect6.right==number_1_right
                        &&rect7.top==number_8_top&&rect7.bottom==number_8_bottom&&rect7.left==number_8_left&&rect7.right==number_8_right
                        &&rect8.top==number_3_top&&rect8.bottom==number_3_bottom&&rect8.left==number_3_left&&rect8.right==number_3_right){
                    Log.i("successNumberType","111111,success");
                    listener.success(numberType);
                }
                break;
            case 4://"李","周","孙","郑","吴","钱","王","赵"
                if(rect1.top==number_4_top&&rect1.bottom==number_4_bottom&&rect1.left==number_4_left&&rect1.right==number_4_right
                        &&rect2.top==number_5_top&&rect2.bottom==number_5_bottom&&rect2.left==number_5_left&&rect2.right==number_5_right
                        &&rect3.top==number_3_top&&rect3.bottom==number_3_bottom&&rect3.left==number_3_left&&rect3.right==number_3_right
                        &&rect4.top==number_7_top&&rect4.bottom==number_7_bottom&&rect4.left==number_7_left&&rect4.right==number_7_right
                        &&rect5.top==number_6_top&&rect5.bottom==number_6_bottom&&rect5.left==number_6_left&&rect5.right==number_6_right
                        &&rect6.top==number_2_top&&rect6.bottom==number_2_bottom&&rect6.left==number_2_left&&rect6.right==number_2_right
                        &&rect7.top==number_8_top&&rect7.bottom==number_8_bottom&&rect7.left==number_8_left&&rect7.right==number_8_right
                        &&rect8.top==number_1_top&&rect8.bottom==number_1_bottom&&rect8.left==number_1_left&&rect8.right==number_1_right){
                    listener.success(numberType);
                }
                break;
            case 6://"郑","吴","孙","周","李","赵","王","钱"
                if(rect1.top==number_7_top&&rect1.bottom==number_7_bottom&&rect1.left==number_7_left&&rect1.right==number_7_right
                        &&rect2.top==number_6_top&&rect2.bottom==number_6_bottom&&rect2.left==number_6_left&&rect2.right==number_6_right
                        &&rect3.top==number_3_top&&rect3.bottom==number_3_bottom&&rect3.left==number_3_left&&rect3.right==number_3_right
                        &&rect4.top==number_5_top&&rect4.bottom==number_5_bottom&&rect4.left==number_5_left&&rect4.right==number_5_right
                        &&rect5.top==number_4_top&&rect5.bottom==number_4_bottom&&rect5.left==number_4_left&&rect5.right==number_4_right
                        &&rect6.top==number_1_top&&rect6.bottom==number_1_bottom&&rect6.left==number_1_left&&rect6.right==number_1_right
                        &&rect7.top==number_8_top&&rect7.bottom==number_8_bottom&&rect7.left==number_8_left&&rect7.right==number_8_right
                        &&rect8.top==number_2_top&&rect8.bottom==number_2_bottom&&rect8.left==number_2_left&&rect8.right==number_2_right){
                    listener.success(6);
                }
                break;
            case 2://"赵","李","王","周","钱","郑","吴","孙"
                if(rect1.top==number_1_top&&rect1.bottom==number_1_bottom&&rect1.left==number_1_left&&rect1.right==number_1_right
                        &&rect2.top==number_4_top&&rect2.bottom==number_4_bottom&&rect2.left==number_4_left&&rect2.right==number_4_right
                        &&rect3.top==number_8_top&&rect3.bottom==number_8_bottom&&rect3.left==number_8_left&&rect3.right==number_8_right
                        &&rect4.top==number_5_top&&rect4.bottom==number_5_bottom&&rect4.left==number_5_left&&rect4.right==number_5_right
                        &&rect5.top==number_2_top&&rect5.bottom==number_2_bottom&&rect5.left==number_2_left&&rect5.right==number_2_right
                        &&rect6.top==number_7_top&&rect6.bottom==number_7_bottom&&rect6.left==number_7_left&&rect6.right==number_7_right
                        &&rect7.top==number_6_top&&rect7.bottom==number_6_bottom&&rect7.left==number_6_left&&rect7.right==number_6_right
                        &&rect8.top==number_3_top&&rect8.bottom==number_3_bottom&&rect8.left==number_3_left&&rect8.right==number_3_right){
                    listener.success(numberType);
                }
                break;
        }
    }
}
