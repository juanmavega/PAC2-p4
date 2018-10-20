package com.example.hellcat.pac1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellcat.pac1.model.BookContent;
import com.example.hellcat.pac1.model.BookItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A fragment representing a single Book detail screen.
 * This fragment is either contained in a {@link BookListActivity}
 * in two-pane mode (on tablets) or a {@link BookDetailActivity}
 * on handsets.
 */
public class BookDetailFragment extends Fragment {
    /**
     * Definimos la constante ARG_ITEM_ID con el valor "item-id" para luego poder buscar este texto como key
     * y recuperar su valor en el map
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * la variable local mItem es el item seleccionado para visualizarse.
     */
    private BookItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BookDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        * Si existe la key procede a buscar el elemento
         */
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = BookContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            /*
            * si existe un BarLayout le asigna el título
             */
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitulo());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail, container, false);

        // Si esiste un item lo muestra, asignando valores a los campos del layout
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.txtAutor)).setText(mItem.getAutor());
            ((TextView) rootView.findViewById(R.id.txtDescripcion)).setText(mItem.getDescripcion());
            ((TextView) rootView.findViewById(R.id.txtFecha)).setText(muestraFecha(mItem.getFecha()));
            ((TextView) rootView.findViewById(R.id.txtURL)).setText(mItem.getUrl());
            /*
             * Aquí busco en los drawables la imagen sin extensión y lo pongo como resource del imageView que hay creada
             */
            int id = getResources().getIdentifier(mItem.getUrl(), "drawable", "com.example.hellcat.pac1");
            ((ImageView) rootView.findViewById(R.id.imageView)).setImageResource(id);

        }

        return rootView;
    }

    /*
     * recuperación de la fecha correcta usando calendar
     */

    public String muestraFecha(Date fecha) {
        int anyo, mes, dia;
        Calendar cal = Calendar.getInstance();
        cal.setTime(mItem.getFecha());
        anyo = cal.get(Calendar.YEAR);
        mes = cal.get(Calendar.MONTH) + 1;
        dia = cal.get(Calendar.DAY_OF_MONTH);
        return (Integer.toString(anyo) + "-" + Integer.toString(mes) + "-" + Integer.toString(dia));
        //return (Integer.toString(anyo)+" "+Integer.toString(mes)+" "+Integer.toString(dia));
    }
}
