package es.iessaladillo.yeraymoreno.ymg_pr02_money;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Float.valueOf;

public class MainActivity extends AppCompatActivity {

    private EditText txtCuantity;

    private RadioGroup rgFrom;
    private RadioButton rbFromDollar;
    private RadioButton rbFromEuro;
    private RadioButton rbFromPound;

    private RadioGroup rgTo;
    private RadioButton rbToDollar;
    private RadioButton rbToEuro;
    private RadioButton rbToPound;

    private ImageView imgFrom;
    private ImageView imgTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        // TE RECOMIENDO QUE USES ActivityCompat.requireViewById(), LANZA UNA EXCEPCIÓN SI EL
        // ID NO SE ENCUENTRA, EN VEZ DE RETORNAR NULL. ASÍ ESTÁS SEGURO DE QUE LA VARIABLE NO ES
        // NULL.
        txtCuantity = findViewById(R.id.txtAmount);

        rgFrom = findViewById(R.id.rgFrom);
        rgTo = findViewById(R.id.rgTo);

        rbFromDollar = findViewById(R.id.rbFromDollar);
        rbToDollar = findViewById(R.id.rbToDollar);

        rbFromEuro = findViewById(R.id.rbFromEuro);
        rbToEuro = findViewById(R.id.rbToEuro);

        rbFromPound = findViewById(R.id.rbFromPound);
        rbToPound = findViewById(R.id.rbToPound);

        imgFrom = findViewById(R.id.imgFrom);
        imgTo = findViewById(R.id.imgTo);

        Button btnExchange = findViewById(R.id.btnExchange);

        //Listeners
        //Dollar listeners
            //From Dollar
        // POR QUÉ NO USAS LAMBDAS?
        rbFromDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbToDollar.setEnabled(false);
                rbToEuro.setEnabled(true);
                rbToPound.setEnabled(true);
                imgFrom.setImageResource(R.drawable.ic_dollar);
                // AGREGO ESTA LINEA PARA QUE PASE TESTS
                imgFrom.setTag(R.drawable.ic_dollar);
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
                // AGREGO ESTA LINEA PARA QUE PASE TESTS
                imgTo.setTag(R.drawable.ic_dollar);
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
                // AGREGO ESTA LINEA PARA QUE PASE TESTS
                imgFrom.setTag(R.drawable.ic_euro);
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
                // AGREGO ESTA LINEA PARA QUE PASE TESTS
                imgTo.setTag(R.drawable.ic_euro);
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
                // AGREGO ESTA LINEA PARA QUE PASE TESTS
                imgFrom.setTag(R.drawable.ic_pound);
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
                // AGREGO ESTA LINEA PARA QUE PASE TESTS
                imgTo.setTag(R.drawable.ic_pound);
            }
        });
        btnExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exchange();
            }
        });
        // AGREGO ESTAS LINEAS PARA QUE PASE TESTS
        imgFrom.setTag(R.drawable.ic_euro);
        imgTo.setTag(R.drawable.ic_dollar);
    }

    private void exchange() {
        RadioButton from;
        RadioButton to;
        String value = txtCuantity.getText().toString();
        float eur_dol = (float) 1.17; // LO CAMBIO PARA QUE PASE TEST
        float dol_eur = (float) 0.86;
        float dol_pou = (float) 0.77;
        float pou_dol = (float) 1.30;
        float pou_eur = (float) 1.12;
        float eur_pou = (float) 0.89;
        float result;
        String message="";

        // USA TextUtis.equals() EN VEZ DE equals(), YA QUE GESTIONA AUTOMÁTICAMENTE EL NULL.
        if(txtCuantity.getText().toString().equals("")){
            txtCuantity.setText(R.string.default_txt_cuantity);
        }else{
            from = findViewById(rgFrom.getCheckedRadioButtonId());
            to = findViewById(rgTo.getCheckedRadioButtonId());

            // USA Code -> Reformat code... PARA QUE EL CÓDIGO TE QUEDE BONITO.
            if (from.getId()==rbFromDollar.getId()){
                if (to.getId()==rbToEuro.getId()){
                    result = valueOf(value)*dol_eur;
                    message = value+" $ = "+result+" €";
                }else{
                    result = valueOf(value)*dol_pou;
                    message = value+" $ = "+result+" £";
                }
            }
            if (from.getId()==rbFromEuro.getId()){
                if (to.getId()==rbToDollar.getId()){
                    result = valueOf(value)*eur_dol;
                    message = value+" € = "+result+" $";
                }else{
                    result = valueOf(value)*eur_pou;
                    message = value+" € = "+result+" £";
                }
            }
            if (from.getId()==rbFromPound.getId()){
                if (to.getId()==rbToEuro.getId()){
                    result = valueOf(value)*pou_eur;
                    message = value+" £ = "+result+" €";
                }else{
                    result = valueOf(value)*pou_dol;
                    message = value+" £ = "+result+" $";
                }
            }

        }
        // USA UN RECURSO DE CADENA CON PARÁMETROS EN VEZ DE TENER QUE ANDAR CONCATENANDO.
        // LOS VALORES DE MONEDA SUELEN MOSTRASRSE SÓLO CON DOS DECIMALES.
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
