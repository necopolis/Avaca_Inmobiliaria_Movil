package com.avaca.inmobiliariaandroid.ui.pago;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.inmobiliariaandroid.modelo.Contrato;
import com.avaca.inmobiliariaandroid.modelo.Pago;
import com.avaca.inmobiliariaandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class PagoViewModel extends ViewModel {
    private ApiClient api;
    private MutableLiveData<ArrayList<Pago>> pagosList;

    public PagoViewModel(){
        api=ApiClient.getApi();
    }
    public MutableLiveData<ArrayList<Pago>> getpagosList() {
        if (pagosList == null) {
            pagosList = new MutableLiveData<>();
        }
        return pagosList;
    }

    public void setpagosList(Bundle bundle) {
        this.pagosList.setValue(api.obtenerPagos((Contrato)bundle.getSerializable("contrato")));
    }
}