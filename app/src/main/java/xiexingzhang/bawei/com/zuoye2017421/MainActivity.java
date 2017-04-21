package xiexingzhang.bawei.com.zuoye2017421;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private TextView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        View view = View.inflate(this, R.layout.win, null);
        final PopupWindow window = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setFocusable(true);
        window.setTouchable(true);
        close = (TextView)view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window.dismiss();
            }
        });
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("zzz", "--按下--");
                        window.showAsDropDown(lv);
//                      lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//                          @Override
//                          public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                              return true;
//                          }
//                      });
                        break;
                    case MotionEvent.ACTION_MOVE:
//					Log.d("zzz", "--滑动--");
                        //以控件左上角为原点，计算出来的坐标值
                        float x = event.getX();
                        float y = event.getY();
                        //以屏幕左上角为原点，计算出来的坐标值
                        float rx = event.getRawX();
                        float ry = event.getRawY();
                        Log.d("zzz", "x:" + x + " y:" + y);
                        Log.d("zzz", "rx:" + rx + " ry:" + ry);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("zzz", "--抬起--");
                        break;
                }
                //false:代表自己不处理此事件，向上一层传递  true:自己消费此事件，不向上传递
                return true;
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Toast.makeText(this, "ok", Toast.LENGTH_LONG).show();
        }
        return super.onTouchEvent(event);
    }
}

