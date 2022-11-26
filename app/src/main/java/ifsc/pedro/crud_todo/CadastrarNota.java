package ifsc.pedro.crud_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ifsc.pedro.crud_todo.controller.NotaController;
import ifsc.pedro.crud_todo.model.Nota;

public class CadastrarNota extends AppCompatActivity {

    NotaController notaController;
    EditText titulo, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_nota);
        notaController = new NotaController(getApplicationContext());
        titulo = findViewById(R.id.txtTitulo);
        texto = findViewById(R.id.txtTexto);
    }

    public void salvarNota(View v) {
        Nota n = notaController.cadastrarNota(new Nota(titulo.getText().toString(), texto.getText().toString()));
        super.finish();
    }
}