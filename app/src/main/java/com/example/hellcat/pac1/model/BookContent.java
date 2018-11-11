package com.example.hellcat.pac1.model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Creamos la clase BookContent para los procedimientos de creación
 * de la lista de BookItem y su Map
 */
public class BookContent {

    /**
     * Creación de ITEMS como objeto que podrá ser accedido por el resto de clases como variable constante.
     * Es la lista de BookItems usada en el recyclerview
     */
    //ya no lo usamos en Realm
    //public static final List<BookItem> ITEMS = new ArrayList<BookItem>();
    private String TAG = "validando--->>>";

    /**
     * Como lo anterior, pero en Map se añade una key para fácil localización de un item determinado por su valor de key
     */
    //ya no lo usamos en Realm
    //public static final Map<String, BookItem> ITEM_MAP = new HashMap<String, BookItem>();

    static public Date creaDate(Integer anyo, Integer mes, Integer dia) {
        Log.d("validando--->>>", "paso por creadate");
        // al final ha sido posible solucionar el tema del año, pero seguía dando problema los meses que cuentan desde 0,
        // así que se corrige. No se deja tal cual porque si metemos un mes doce hace que la cuenta de años avance uno.

        Calendar cal = Calendar.getInstance();
        cal.set(anyo, mes - 1, dia);
        //Salida al log paera localizar los problemas de fecha
        //Date fecha = cal.getTime();
        //Log.e("Pruebas date    ", cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH));
        //Log.e("Pruebas date dos", new SimpleDateFormat("yyyy-MMM-dd").format(fecha));

        Log.d("validando--->>>", "salgo de creadate");
        return cal.getTime();

    }

    /*
     * rutina que añade los items a la lista ITEMS y al Map ITEM_MAP
     *
     */
    public static void addItem(final BookItem item) {
        //coje la instancia por defecto de realm creada en el Aplication de inicio
        Realm realm=Realm.getDefaultInstance();
        //Incorpora el item, que ya tiene formato realm a la base de datos. Primero compruebo si existe, y si no lo añado.
        RealmResults<BookItem> result = realm.where(BookItem.class)
                .equalTo("titulo", item.getTitulo())
                .findAll();
        if (result.isEmpty()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealm(item);
                }
            });
        }
        //cierro la transacción?
        realm.close();
        //Creación de las listas de items desde Firebase. Sistema antiguo.
        /*
        Log.d("validando--->>>", "paso por additem");
        ITEMS.add(item);
        ITEM_MAP.put(Integer.toString(item.getIdentificador()), item);

        Log.d("validando--->>>", "salgo de additem");
        */
    }

    //Genera la lista de libros de la base de datos. Lo paso as lista.
    public static List<BookItem> getBooks(){

        Realm realm=Realm.getDefaultInstance();
        RealmResults<BookItem> listaLibros = realm.where(BookItem.class)
                .sort("titulo", Sort.ASCENDING)
                .findAll();
        List <BookItem> results = realm.copyFromRealm(listaLibros);
        realm.close();
        return results;      //devuelve la lista de libros
    }

    //comprueba la existencia de un libro.
    public static boolean exists(BookItem bookItem) {

        Realm realm=Realm.getDefaultInstance();
        RealmResults<BookItem> result = realm.where(BookItem.class)
                .equalTo("titulo", bookItem.getTitulo())
                .findAll();
        realm.close();
        return !result.isEmpty();   // si está vacio devuelve exist igual a false y viceversa.
    }
}