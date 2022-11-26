package ifsc.pedro.crud_todo.controller;

import android.content.Context;

import java.util.ArrayList;

import ifsc.pedro.crud_todo.model.Nota;
import ifsc.pedro.crud_todo.model.NotaDao;

public class NotaController {

    Context mContext;
    NotaDao notaDao;

    public NotaController(Context c) {
        mContext = c;
        notaDao = new NotaDao(c);
    }

    public Nota cadastrarNota(Nota n) {
        return notaDao.inserirNota(n);
    }

    public ArrayList<Nota> listaNotas() {
        return notaDao.getListaNotas();
    }

    public Nota alterarNota(Nota nota) {
        notaDao.updateNota(nota);

        return null;
    }

    public Nota excluirNota(Integer id) {
        notaDao.excluirNota(id);

        return null;
    }
}
