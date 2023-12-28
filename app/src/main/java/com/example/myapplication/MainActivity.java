package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText prd2,prd3,TOTALL;
    TextView It1,It2,It,It4,Prcc;
    Button add,del,cler,viw,calc,updat;

    DBHelperasma Asoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Asoom=new DBHelperasma(this);

        prd2=(EditText) findViewById(R.id.Prname);
        prd3=(EditText) findViewById(R.id.Proname);
        TOTALL=(EditText) findViewById(R.id.editTextNumber);




        add=(Button) findViewById(R.id.ADD);
        del=(Button) findViewById(R.id.Delect);
        cler=(Button) findViewById(R.id.Clear);
        viw=(Button) findViewById(R.id.View);
        calc=(Button) findViewById(R.id.Calcu);
        updat=(Button) findViewById(R.id.update);



        add_Data7729();
        update_Data7729();
        delete_Data7729();
        view_Data7729();
        clear_Data7729();
        cal_Data7729();

    }
    public void add_Data7729() {

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ins = Asoom.insertData(prd2.getText().toString(), prd3.getText().toString(), TOTALL.getText().toString());
                if (ins == true) {
                    Toast.makeText(MainActivity.this, "Data add", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this, " Data not add", Toast.LENGTH_LONG).show();


            }
        });
    }
    public void delete_Data7729() {
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int delRow = Asoom.deleteData(prd2.getText().toString(), prd3.getText().toString());
                if (delRow > 0) {
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this, " not deleted", Toast.LENGTH_LONG).show();


            }
        });
    }
    public void clear_Data7729() {
        cler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prd2.setText("");
                prd3.setText("");

            }
        });
    }
    public void view_Data7729() {

        viw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Cursor rahim = Asoom.getAllData();
                    if (rahim.getCount() == 0) {
                        show_Message("Foundd Error", "Nothing  found");
                        return;
                    }
                    StringBuffer Asmaa = new StringBuffer();
                    while (rahim.moveToNext()) {

                        Asmaa.append("Product1:" + rahim.getString(0) + "\n");
                        Asmaa.append("Product2:" + rahim.getString(1) + "\n");
                        Asmaa.append("TotalSelectProduct:" + rahim.getString(2) + "\n");
                        Asmaa.append("TotalAmount:" + rahim.getString(3) + "\n");
                    }
                    show_Message("Customer Details", Asmaa.toString());
                }

            }
        });
    }
    public void cal_Data7729() {

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prd2.getText().toString().isEmpty() && prd3.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill all The Details", Toast.LENGTH_LONG).show();
                } else {
                    double FootBallPrice = 15.0;
                    double SportShoes = 20.0;
                    double total = Double.parseDouble(prd2.getText().toString());
                    double avgergee = (FootBallPrice + SportShoes);
                    TOTALL.setText(Double.toString(avgergee)
                    );


                }


            }
        });
    }
    public void update_Data7729(){
        updat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean update=Asoom.updateData(prd2.getText().toString(), prd3.getText().toString(), TOTALL.getText().toString());
                if(update==true)
                    Toast.makeText(MainActivity.this,"Data has been updated ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Is Not updated",Toast.LENGTH_LONG).show();


            }
        });


    }

    private void show_Message(String titlee, String Mass)
    {
        AlertDialog.Builder AsmaBuld = new
                AlertDialog.Builder(this);
        AsmaBuld.setCancelable(true);
        AsmaBuld.setTitle(titlee);
        AsmaBuld.setMessage(Mass);
        AsmaBuld.show();
    }
}