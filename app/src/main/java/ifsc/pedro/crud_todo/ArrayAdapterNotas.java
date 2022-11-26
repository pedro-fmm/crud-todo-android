package ifsc.pedro.crud_todo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import ifsc.pedro.crud_todo.controller.NotaController;
import ifsc.pedro.crud_todo.model.Nota;

public class ArrayAdapterNotas extends ArrayAdapter {

    Context c;
    int resource;
    ArrayList<Nota> notas;
    NotaController notaController;

    public ArrayAdapterNotas(Context c, int resource, ArrayList<Nota> objects) {
        super(c, resource, objects);
        this.c = c;
        this.resource = resource;
        this.notas = objects;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(c);
        @SuppressLint("ViewHolder") View view = inflater.inflate(resource, parent,false);

        TextView titulo = view.findViewById(R.id.txtNome);
        TextView descricao = view.findViewById(R.id.txtDescricao);

        Nota nota = (Nota) notas.get(position);

        titulo.setText("" + nota.getTitulo());
        descricao.setText("" + nota.getTexto());

        view.findViewById(R.id.btnDetalhes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetalhesNota.class);
                Nota message = notas.get(position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("EXTRA_MESSAGE", message);
                getContext().getApplicationContext().startActivity(intent);
            }
        });

        return view;
    }

}
