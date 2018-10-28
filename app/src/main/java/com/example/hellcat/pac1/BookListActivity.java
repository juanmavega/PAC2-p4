package com.example.hellcat.pac1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hellcat.pac1.model.BookContent;
import com.example.hellcat.pac1.model.BookItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * An activity representing a list of Books. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link BookDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class BookListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private FirebaseAuth mAuth;         //añadimos las variables para firebase
    private FirebaseDatabase database;
    private String TAG="validando--->>>";

    /*
     * Crea la activity usando el layout activity_book_list. Se crea una barra superior con una toolbar
     * y un botón de acción por defecto.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*
         * Se chequea si existe el elemento book_detail_container, que nos indicará si se trata de una tablet o no.
         */
        if (findViewById(R.id.book_detail_container) != null) {
            /*
            * Busca si existe el book_detail_container que sólo estará presente en formato tablet
            * para saber si la aplicación es de tablet o no e inicializar la variable.
             */
            mTwoPane = true;
        }
        /*
         *se crea un recyclerview usando el formato book_list
         */
        View recyclerView = findViewById(R.id.book_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance ();
        validar("juanma.atlantica1@gmail.com","1234567890");
    }
private void validar (String email, String password){
        Log.d(TAG,"pasando por validar");
    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "signInWithEmail:failed", task.getException());
                    }

                    // ...
                }
            });
}
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, BookContent.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
        /*
         * Nuevas variables globales que nos darán respectivamente la lista de items, la actividad padre
         * y si la aplicación es de tablet o no.
         * Definimos par o impar como el resto de la división entera.
         */
        private final BookListActivity mParentActivity;
        private final List<BookItem> mValues;
        private final boolean mTwoPane;
        private final int PAR = 0, IMPAR = 1;
        /*
         * acciones que se llevan a cabo cuando se ha hecho click sobre uno de los elementos
         */
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 * coge el item seleccionado
                 */
                BookItem item = (BookItem) view.getTag();
                if (mTwoPane) {
                    /*
                     * si se trata de una tablet en formato horizontal usa BookDetailFragment.
                     * si no abre la nueva actividad de detalle.
                     */
                    Bundle arguments = new Bundle();
                    arguments.putString(BookDetailFragment.ARG_ITEM_ID, Integer.toString(item.getIdentificador()));
                    BookDetailFragment fragment = new BookDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.book_detail_container, fragment)
                            .commit();
                } else {
                    /*
                     * en caso de ser una aplicación no tablet
                     */
                    Context context = view.getContext();
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    /*
                     * Este era el sitio que me daba problemas y cerraba la segunda activity. El extra ha de ser un string.
                     * añade en el intent un string "item_id", con objeto de que podamos localizarlo, y un string de valor que en micaso es
                     * el número de identificador pasado a string.
                     */
                    intent.putExtra(BookDetailFragment.ARG_ITEM_ID, Integer.toString(item.getIdentificador()));

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(BookListActivity parent,
                                      List<BookItem> items,
                                      boolean twoPane) {

            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        /*
         * sobreescribimos getItemViewType para que nos devuelva si el layout va a ser par o impar.
         * Es una modificación de lo encontrado por internet, en el que nos devuelve es el tipo de item para poder seleccionar
         * el layout correspondiente.
         */
        @Override
        public int getItemViewType(int position) {
            if (position % 2 == 0)
                return PAR;
            else return IMPAR;
        }

        /*
         *  Al crear el viewholder primero chequea si es par o impar para usar el layout adecuado.
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int paroimpar = 0;
            switch (viewType) {
                case PAR:
                    paroimpar = R.layout.book_list_content;
                    break;
                case IMPAR:
                    paroimpar = R.layout.book_list_content_par;
                    break;
            }
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(paroimpar, parent, false);
            return new ViewHolder(view);
        }

        /*
         * añade en los campos text del layout título y autor.
         * Identifica el item dentro del view con su posición y activa el poder ser clickado.
         */
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getTitulo());
            holder.mContentView.setText(mValues.get(position).getAutor());
            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        /*
         * nos da el número de elementos de la lista
         */
        @Override
        public int getItemCount() {
            return mValues.size();
        }

        /*
         * Asigna a las variables qiue luego usaremos que textview vamos a usar en cada caso
         * buscándolos por su id en el xml
         */
        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
