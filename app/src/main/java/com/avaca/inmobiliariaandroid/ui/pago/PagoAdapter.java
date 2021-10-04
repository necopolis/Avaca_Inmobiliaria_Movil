package com.avaca.inmobiliariaandroid.ui.pago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.inmobiliariaandroid.R;
import com.avaca.inmobiliariaandroid.modelo.Pago;
import com.avaca.inmobiliariaandroid.request.ApiClient;

import java.util.ArrayList;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.MiViewHolder> {
    private LayoutInflater Inflater;
    private Context context;
    private ArrayList<Pago> pagosList;
    private View root;
    private ApiClient api;

    public PagoAdapter(View root, ArrayList<Pago> pagos) {
        this.root = root;
        this.Inflater = LayoutInflater.from(root.getContext());
        this.context = root.getContext();
        this.pagosList = pagos;
        this.api = ApiClient.getApi();
    }

    @NonNull
    @Override
    public PagoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = Inflater.inflate(R.layout.item_pago, parent, false);
        return new PagoAdapter.MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagoAdapter.MiViewHolder holder, int position) {
        Pago pago = pagosList.get(position);
        holder.codigo.setText("Codigo de Pago: "+pago.getIdPago());
        holder.numerodePago.setText("Número de Pago: "+pago.getNumero());
        holder.codigoContrato.setText("Código Contrato: "+pago.getContrato().getIdContrato());
        holder.Monto.setText("Importe: "+pago.getImporte());
        holder.fechaPago.setText("Fecha de Pago: "+pago.getFechaDePago());
    }

    @Override
    public int getItemCount() {
        return pagosList.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder {
        private TextView codigo;
        private TextView numerodePago;
        private TextView codigoContrato;
        private TextView Monto;
        private TextView fechaPago;


        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.tvCodigoPagoDetalles);
            numerodePago = itemView.findViewById(R.id.tvNumPagoDetalles);
            codigoContrato = itemView.findViewById(R.id.tvCodigoContratoPagoDetalles);
            Monto = itemView.findViewById(R.id.tvImportePagoDetalles);
            fechaPago = itemView.findViewById(R.id.tvFechaDePagoDetalles);
        }
    }
}
