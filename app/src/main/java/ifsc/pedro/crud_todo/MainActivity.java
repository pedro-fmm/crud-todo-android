package ifsc.pedro.crud_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ifsc.pedro.crud_todo.controller.NotaController;
import ifsc.pedro.crud_todo.model.Nota;

public class MainActivity extends AppCompatActivity {

    NotaController notaController;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criarNota(View v) {
        Intent intent = new Intent(this, CadastrarNota.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        notaController = new NotaController(getApplicationContext());

        listView = findViewById(R.id.listView);

        ArrayAdapterNotas adapterNotas = new ArrayAdapterNotas(
                getApplicationContext(),
                R.layout.list,
                notaController.listaNotas()
        );

        listView.setAdapter(adapterNotas);
    }
}