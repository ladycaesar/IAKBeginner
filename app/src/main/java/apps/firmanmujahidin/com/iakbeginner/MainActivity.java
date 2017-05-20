package apps.firmanmujahidin.com.iakbeginner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickBtn (View view){

        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.about:
               Intent i = new Intent(this, About.class);
               startActivity(i);
               break;
           case R.id.order:
               Intent j = new Intent(this, OrderActivity.class);
               startActivity(j);
               break;
           case R.id.exit:
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("Are you sure?");
               builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       finish();
                   }
               });
               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
               AlertDialog quit = builder.create();
               quit.show();
               return true;
       }
       return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }
        else if(!doubleBackToExitPressOnce){
            this.doubleBackToExitPressOnce = true;
            Toast.makeText(this,"Click Back again to exit the application", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    doubleBackToExitPressOnce = false;
                }
            },2000);
        }
        else{
            super.onBackPressed();
            return;
        }
    }
}
