package com.example.amine_mbarek_lsi3_mesure_glycemie.vue;import androidx.appcompat.app.AlertDialog;import androidx.appcompat.app.AppCompatActivity;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.EditText;import android.widget.RadioButton;import android.widget.SeekBar;import android.widget.TextView;import android.widget.Toast;import com.example.amine_mbarek_lsi3_mesure_glycemie.R;import com.example.amine_mbarek_lsi3_mesure_glycemie.controller.Controller;public class MainActivity extends AppCompatActivity {    private EditText value;    private RadioButton rbtOui;    private RadioButton rbtNon;    private SeekBar seekBar;    private Button btn;    private TextView txt;    private TextView txtshow;    private Controller controller; // Ajouter une instance de la classe Controller.    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        init();        // Initialisez l'instance de Controller.        controller = new Controller();    }    private void init() {        value = findViewById(R.id.value);        rbtOui = findViewById(R.id.rbtOui);        rbtNon = findViewById(R.id.rbtNon);        seekBar = findViewById(R.id.seekbar);        btn = findViewById(R.id.btn);        txt = findViewById(R.id.tvage);        txtshow = findViewById(R.id.text3);        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {                Log.i("Information", "onProgressChanged " + progress);                txt.setText("Votre âge : " + progress);            }            public void onStartTrackingTouch(SeekBar seekBar) {            }            public void onStopTrackingTouch(SeekBar seekBar) {            }        });        btn.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                int age = seekBar.getProgress();                String glucose = value.getText().toString();                boolean isFasting = rbtOui.isChecked();                if (age == 0 && glucose.isEmpty()){                    Toast.makeText(getApplicationContext(), "Please enter a valid age and value", Toast.LENGTH_SHORT).show();                }else if (age == 0) {                    Toast.makeText(getApplicationContext(), "Please enter a valid age", Toast.LENGTH_SHORT).show();                } else if (glucose.isEmpty()) {                    Toast.makeText(getApplicationContext(), "Please enter a valid value", Toast.LENGTH_SHORT).show();                } else {                    // Appelez la méthode createPatient() du Controller pour initialiser le modèle.                    float glucoseValue = Float.parseFloat(value.getText().toString());                    controller.createPatient(age,glucoseValue, isFasting);                    // Obtenez la réponse en appelant la méthode getResponse() du Controller.                    String response = controller.getResponse();                    // Affichez la réponse dans le TextView approprié.                    txtshow.setText(response);                }            }        });    }}