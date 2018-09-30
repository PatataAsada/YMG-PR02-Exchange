package es.iessaladillo.yeraymoreno.ymg_pr02_money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText txtCuantity;

    private RadioButton rbFromDollar;
    private RadioButton rbFromEuro;
    private RadioButton rbFromPound;

    private RadioButton rbToDollar;
    private RadioButton rbToEuro;
    private RadioButton rbToPound;

    private ImageView imgFrom;
    private ImageView imgTo;

    private Button btnExchange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        txtCuantity = findViewById(R.id.txtCuantity);

        rbFromDollar = findViewById(R.id.rbFromDollar);
        rbToDollar = findViewById(R.id.rbToDollar);

        rbFromEuro = findViewById(R.id.rbFromEuro);
        rbToEuro = findViewById(R.id.rbToEuro);

        rbFromPound = findViewById(R.id.rbFromPound);
        rbToPound = findViewById(R.id.rbToPound);

        imgFrom = findViewById(R.id.imgFrom);
        imgTo = findViewById(R.id.imgTo);

        btnExchange = findViewById(R.id.btnExchange);

        //Listeners
        //Dollar listeners
            //From Dollar
        rbFromDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbToDollar.setEnabled(false);
                rbToEuro.setEnabled(true);
                rbToPound.setEnabled(true);
                imgFrom.setImageResource(R.drawable.ic_dollar);
            }
        });
            //ToDollar
        rbToDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbFromDollar.setEnabled(false);
                rbFromEuro.setEnabled(true);
                rbFromPound.setEnabled(true);
                imgTo.setImageResource(R.drawable.ic_dollar);
            }
        });
        //Euro Listeners
            //FromEuro
        rbFromEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbToDollar.setEnabled(true);
                rbToEuro.setEnabled(false);
                rbToPound.setEnabled(true);
                imgFrom.setImageResource(R.drawable.ic_euro);
            }
        });
            //ToEuro
        rbToEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbFromDollar.setEnabled(true);
                rbFromEuro.setEnabled(false);
                rbFromPound.setEnabled(true);
                imgTo.setImageResource(R.drawable.ic_euro);
            }
        });
        //Pound Listeners
            //FromPound
        rbFromPound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbToDollar.setEnabled(true);
                rbToEuro.setEnabled(true);
                rbToPound.setEnabled(false);
                imgFrom.setImageResource(R.drawable.ic_pound);
            }
        });
            //ToPound
        rbToPound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rbFromDollar.setEnabled(true);
                rbFromEuro.setEnabled(true);
                rbFromPound.setEnabled(false);
                imgTo.setImageResource(R.drawable.ic_pound);
            }
        });
        btnExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCuantity.getText().toString().equals("")){
                    txtCuantity.setText(R.string.default_txt_cuantity);
                }
            }
        });
    }

}
