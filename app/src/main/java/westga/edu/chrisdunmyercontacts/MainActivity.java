package westga.edu.chrisdunmyercontacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View v) {
        Button button = (Button) v;
        EditText name = (EditText) findViewById(R.id.nameText);
        EditText email = (EditText) findViewById(R.id.emailText);
        EditText phone = (EditText) findViewById(R.id.phoneText);
        TextView nameView = (TextView) findViewById(R.id.nameView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView phoneView = (TextView) findViewById(R.id.phoneView);
        TextView resultView  = (TextView) findViewById(R.id.resultView);
        RadioButton cellRadioButton = (RadioButton) findViewById(R.id.cellRadioButton);

        // Validate input is not empty
        if (name.getText().toString().isEmpty()) {
            resultView.setText("Missing Name!");
            resultView.setTextColor(Color.RED);
            return;
        } else if (email.getText().toString().isEmpty()) {
            resultView.setText("Missing Email!");
            resultView.setTextColor(Color.RED);
            return;
        } else if (phone.getText().toString().isEmpty()) {
            resultView.setText("Missing Phone Number!");
            resultView.setTextColor(Color.RED);
            return;
        }

        // Display Proper output
        if (cellRadioButton.isChecked()) {
            resultView.setText("Cell Phone Added!");
            resultView.setTextColor(Color.GREEN);
        } else {
            resultView.setText("Home Phone Added!");
            resultView.setTextColor(Color.GREEN);
        }
        nameView.setText("Name: " + name.getEditableText());
        emailView.setText("Email: " + email.getEditableText());
        phoneView.setText("Phone: " + phone.getEditableText());
    }
}
