package ifsc.pedro.crud_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ifsc.pedro.crud_todo.controller.NotaController;
import ifsc.pedro.crud_todo.model.Nota;

public class DetalhesNota extends AppCompatActivity {

    NotaController notaController;
    EditText titulo, texto;
    Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_nota);
        notaController = new NotaController(getApplicationContext());
        titulo = findViewById(R.id.txtTitulo);
        texto = findViewById(R.id.txtTexto);
        nota = (Nota) getIntent().getSerializableExtra("EXTRA_MESSAGE");
        titulo.setText(nota.getTitulo());
        texto.setText(nota.getTexto());
    }

    public void alterarNota(View v) {
        Nota n = notaController.alterarNota(new Nota(nota.getId(), titulo.getText().toString(), texto.getText().toString()));
        super.finish();
    }

    public void excluirNota(View v) {
        Nota n = notaController.excluirNota(nota.getId());
        super.finish();
    }
}
