package com.jikexueyuan.codeadding;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTable();
    }

    private void setTable() {
        //        绑定Layout事件
        LinearLayout llNumList = (LinearLayout) findViewById(R.id.activity_main);
//        设置参数
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT
        );
//        设定边界
        params.setMargins(marginWidth(),marginWidth(),marginWidth(),marginWidth());
//        利用循环往Layout添加View
        for (int i = 0; i< 5; i++) {
//            生成一行
            LinearLayout llColumn = new LinearLayout(this);
            for (int j = 1; j <= 4; j++) {
//                生成每行元素
                TextView tvNumber = new TextView(this);
//                应用参数
                tvNumber.setLayoutParams(params);
//                设置元素内容
                tvNumber.setText(4*i + j+ "");
//                居中
                tvNumber.setGravity(Gravity.CENTER);
//                设置字体颜色
                tvNumber.setTextColor(getResources().getColor(R.color.item_text_color));
                TextPaint tp = tvNumber.getPaint();
//                设置字体大小和粗字体
                tp.setFakeBoldText(true);
                tvNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, 66);
//                设置大小
                tvNumber.setWidth(getWidth());
                tvNumber.setHeight(getWidth());
//                设置背景颜色
                tvNumber.setBackgroundColor(getResources().getColor(R.color.item_bg_color));
//                添加元素当行
                llColumn.addView(tvNumber);
            }
//            添加行到列表
            llNumList.addView(llColumn);
        }
    }

//    根据显示分辨率匹配margin
    private int marginWidth() {
        return dip2px(this,5);
    }

    public static int dip2px(Context context, float dipValue){
        final float scale = getDisplayMetrics(context).density;
        return (int) (dipValue *scale + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Context context){
        return context.getApplicationContext().getResources().getDisplayMetrics();
    }

//    根据屏幕宽度自适应宽度
    private int getWidth() {
        int width;
        DisplayMetrics disWidth = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disWidth);
        width = (int)((disWidth.widthPixels -2*getResources().getDimension(R.dimen.activity_horizontal_margin)
        - 8*marginWidth())/4);
        return width;
    }
}
