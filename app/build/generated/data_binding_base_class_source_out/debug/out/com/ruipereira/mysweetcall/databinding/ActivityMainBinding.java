// Generated by view binder compiler. Do not edit!
package com.ruipereira.mysweetcall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ruipereira.mysweetcall.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btAvancado;

  @NonNull
  public final Button btEditar;

  @NonNull
  public final Button btInserir;

  @NonNull
  public final Button btMapa;

  @NonNull
  public final Button btRemover;

  @NonNull
  public final ImageButton btSortDown;

  @NonNull
  public final ImageButton btSortUp;

  @NonNull
  public final Button btVoltarMain;

  @NonNull
  public final EditText etApelido;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etLatitude;

  @NonNull
  public final EditText etLongitude;

  @NonNull
  public final EditText etMorada;

  @NonNull
  public final EditText etNasc;

  @NonNull
  public final EditText etNome;

  @NonNull
  public final EditText etTelemovel;

  @NonNull
  public final LinearLayout llBarraBotoes;

  @NonNull
  public final ListView lstvContactos;

  @NonNull
  public final TextView tvAnos;

  @NonNull
  public final TextView tvIdade;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull Button btAvancado,
      @NonNull Button btEditar, @NonNull Button btInserir, @NonNull Button btMapa,
      @NonNull Button btRemover, @NonNull ImageButton btSortDown, @NonNull ImageButton btSortUp,
      @NonNull Button btVoltarMain, @NonNull EditText etApelido, @NonNull EditText etEmail,
      @NonNull EditText etLatitude, @NonNull EditText etLongitude, @NonNull EditText etMorada,
      @NonNull EditText etNasc, @NonNull EditText etNome, @NonNull EditText etTelemovel,
      @NonNull LinearLayout llBarraBotoes, @NonNull ListView lstvContactos,
      @NonNull TextView tvAnos, @NonNull TextView tvIdade) {
    this.rootView = rootView;
    this.btAvancado = btAvancado;
    this.btEditar = btEditar;
    this.btInserir = btInserir;
    this.btMapa = btMapa;
    this.btRemover = btRemover;
    this.btSortDown = btSortDown;
    this.btSortUp = btSortUp;
    this.btVoltarMain = btVoltarMain;
    this.etApelido = etApelido;
    this.etEmail = etEmail;
    this.etLatitude = etLatitude;
    this.etLongitude = etLongitude;
    this.etMorada = etMorada;
    this.etNasc = etNasc;
    this.etNome = etNome;
    this.etTelemovel = etTelemovel;
    this.llBarraBotoes = llBarraBotoes;
    this.lstvContactos = lstvContactos;
    this.tvAnos = tvAnos;
    this.tvIdade = tvIdade;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_avancado;
      Button btAvancado = ViewBindings.findChildViewById(rootView, id);
      if (btAvancado == null) {
        break missingId;
      }

      id = R.id.bt_editar;
      Button btEditar = ViewBindings.findChildViewById(rootView, id);
      if (btEditar == null) {
        break missingId;
      }

      id = R.id.bt_inserir;
      Button btInserir = ViewBindings.findChildViewById(rootView, id);
      if (btInserir == null) {
        break missingId;
      }

      id = R.id.bt_mapa;
      Button btMapa = ViewBindings.findChildViewById(rootView, id);
      if (btMapa == null) {
        break missingId;
      }

      id = R.id.bt_remover;
      Button btRemover = ViewBindings.findChildViewById(rootView, id);
      if (btRemover == null) {
        break missingId;
      }

      id = R.id.bt_sort_down;
      ImageButton btSortDown = ViewBindings.findChildViewById(rootView, id);
      if (btSortDown == null) {
        break missingId;
      }

      id = R.id.bt_sort_up;
      ImageButton btSortUp = ViewBindings.findChildViewById(rootView, id);
      if (btSortUp == null) {
        break missingId;
      }

      id = R.id.bt_voltar_main;
      Button btVoltarMain = ViewBindings.findChildViewById(rootView, id);
      if (btVoltarMain == null) {
        break missingId;
      }

      id = R.id.et_apelido;
      EditText etApelido = ViewBindings.findChildViewById(rootView, id);
      if (etApelido == null) {
        break missingId;
      }

      id = R.id.et_email;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.et_latitude;
      EditText etLatitude = ViewBindings.findChildViewById(rootView, id);
      if (etLatitude == null) {
        break missingId;
      }

      id = R.id.et_longitude;
      EditText etLongitude = ViewBindings.findChildViewById(rootView, id);
      if (etLongitude == null) {
        break missingId;
      }

      id = R.id.et_morada;
      EditText etMorada = ViewBindings.findChildViewById(rootView, id);
      if (etMorada == null) {
        break missingId;
      }

      id = R.id.et_nasc;
      EditText etNasc = ViewBindings.findChildViewById(rootView, id);
      if (etNasc == null) {
        break missingId;
      }

      id = R.id.et_nome;
      EditText etNome = ViewBindings.findChildViewById(rootView, id);
      if (etNome == null) {
        break missingId;
      }

      id = R.id.et_telemovel;
      EditText etTelemovel = ViewBindings.findChildViewById(rootView, id);
      if (etTelemovel == null) {
        break missingId;
      }

      id = R.id.ll_barraBotoes;
      LinearLayout llBarraBotoes = ViewBindings.findChildViewById(rootView, id);
      if (llBarraBotoes == null) {
        break missingId;
      }

      id = R.id.lstv_contactos;
      ListView lstvContactos = ViewBindings.findChildViewById(rootView, id);
      if (lstvContactos == null) {
        break missingId;
      }

      id = R.id.tv_anos;
      TextView tvAnos = ViewBindings.findChildViewById(rootView, id);
      if (tvAnos == null) {
        break missingId;
      }

      id = R.id.tv_idade;
      TextView tvIdade = ViewBindings.findChildViewById(rootView, id);
      if (tvIdade == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, btAvancado, btEditar, btInserir,
          btMapa, btRemover, btSortDown, btSortUp, btVoltarMain, etApelido, etEmail, etLatitude,
          etLongitude, etMorada, etNasc, etNome, etTelemovel, llBarraBotoes, lstvContactos, tvAnos,
          tvIdade);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}