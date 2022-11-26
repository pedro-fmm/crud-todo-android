package ifsc.pedro.crud_todo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {

    SQLiteDatabase database;

    public NotaDao(Context c) {
        database = c.openOrCreateDatabase("dbNotas", c.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas ( id INTEGER PRIMARY KEY AUTOINCREMENT, titulo varchar, texto varchar) ");
    }

    public Nota inserirNota(Nota n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        int i = (int) database.insert("notas", "null", contentValues);
        n.setId(i);

        return n;
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = database.rawQuery("SELECT * FROM NOTAS", null);
        cursor.moveToFirst();

        ArrayList<Nota> arrayList = new ArrayList<Nota>();

        while (!cursor.isAfterLast()) {

            Integer id = cursor.getInt(0);
            String titulo = cursor.getString(1);
            String texto = cursor.getString(2);

            Nota nota = new Nota(id, titulo, texto);

            arrayList.add(nota);

            cursor.moveToNext();
        }

        return arrayList;
    }

    public void excluirNota(int id) {
        database.delete("notas","id=?",new String[]{String.valueOf(id)});
    }

    public Nota updateNota(Nota nota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("texto", nota.getTexto());
        int i = (int) database.update("notas", contentValues, "id = ?", new String[]{String.valueOf(nota.getId())});

        return nota;
    }

}
