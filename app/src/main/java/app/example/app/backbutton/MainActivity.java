package app.example.app.backbutton;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleClicktoExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



//    @Override
//    public void onBackPressed(){
//       if(doubleClicktoExit){
//           super.onBackPressed();
//       }
//
//       doubleClicktoExit = true;
//        Toast.makeText(getApplicationContext(), "Press again to exit from the app!", Toast.LENGTH_SHORT).show();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                doubleClicktoExit = false;
//            }
//        },2000);
//    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        switch (event.getKeyCode()){  //back button code is 4
            case KeyEvent.KEYCODE_BACK:
                if(doubleClicktoExit){
                    finish();
                }else{
                    doubleClicktoExit = true;
                    Toast.makeText(getApplicationContext(), "Press again to exit from the app!", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            doubleClicktoExit = false;
                        }
                    },2000);
                }
                break;
             default:
                 Toast.makeText(getApplicationContext(), "You Pressed Key: "+event.getKeyCode(), Toast.LENGTH_SHORT).show();
                 break;
        }
        return  true;
    }
}
