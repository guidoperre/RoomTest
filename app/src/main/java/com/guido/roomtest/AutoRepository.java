package com.guido.roomtest;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AutoRepository {

    //Declaro el dao de autos
    private AutoDAO autoDAO;

    //Declaro el livedata de autos
    private LiveData<List<Auto>> dataList;

    public AutoRepository(Application application){
        //Instancio la db
        AppDatabase database = AppDatabase.getDatabase(application.getApplicationContext());
        if (database != null){
            //Instancio el dao de autos
            autoDAO = database.autoDAO();
            //Instancio el livedata
            dataList = autoDAO.getLiveData();
        }
    }

    //Getter de el livedata
    public LiveData<List<Auto>> get(){ return dataList; }

    //Funcion para insertar
    public void insertAuto(Auto auto) {
        //Ejecuto un hilo en segundo plano
        new InsertAutoAsyncTask(autoDAO).execute(auto);
    }

    //Clase que extiende async task <PARAMETRO, Void, RETORNO>
    private static class InsertAutoAsyncTask extends AsyncTask<Auto, Void, Void> {

        private final AutoDAO autoDAO;

        //En el constructor de la clase le pido el DAO de autos
        InsertAutoAsyncTask(AutoDAO autoDAO){
            this.autoDAO = autoDAO;
        }

        @Override
        protected Void doInBackground(Auto... autos) {
            Long id = autoDAO.insert(autos[0]);
            return null;
        }
    }

}
