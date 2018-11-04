package com.example.hellcat.pac1;

import android.app.Application;

import io.realm.Realm;
//Lo añadimos para poder inicializar Realm sin que nos inicialice cada vez que se reinicie la actívity.
//Se añade también en eñ android manifest.

public class MiAplicacion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }}