// Generated by view binder compiler. Do not edit!
package com.ruipereira.mysweetcall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ruipereira.mysweetcall.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetalheBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btLigar;

  @NonNull
  public final Button btVoltar;

  @NonNull
  public final TextView etDetApelido;

  @NonNull
  public final TextView etDetEmail;

  @NonNull
  public final TextView etDetLatitude;

  @NonNull
  public final TextView etDetLongitude;

  @NonNull
  public final TextView etDetMorada;

  @NonNull
  public final TextView etDetNasc;

  @NonNull
  public final TextView etDetNome;

  @NonNull
  public final TextView etDetTelemovel;

  @NonNull
  public final ImageView ivDetFoto;

  @NonNull
  public final TextView tvAnos;

  @NonNull
  public final TextView tvDetIdade;

  private ActivityDetalheBinding(@NonNull LinearLayout rootView, @NonNull Button btLigar,
      @NonNull Button btVoltar, @NonNull TextView etDetApelido, @NonNull TextView etDetEmail,
      @NonNull TextView etDetLatitude, @NonNull TextView etDetLongitude,
      @NonNull TextView etDetMorada, @NonNull TextView etDetNasc, @NonNull TextView etDetNome,
      @NonNull TextView etDetTelemovel, @NonNull ImageView ivDetFoto, @NonNull TextView tvAnos,
      @NonNull TextView tvDetIdade) {
    this.rootView = rootView;
    this.btLigar = btLigar;
    this.btVoltar = btVoltar;
    this.etDetApelido = etDetApelido;
    this.etDetEmail = etDetEmail;
    this.etDetLatitude = etDetLatitude;
    this.etDetLongitude = etDetLongitude;
    this.etDetMorada = etDetMorada;
    this.etDetNasc = etDetNasc;
    this.etDetNome = etDetNome;
    this.etDetTelemovel = etDetTelemovel;
    this.ivDetFoto = ivDetFoto;
    this.tvAnos = tvAnos;
    this.tvDetIdade = tvDetIdade;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetalheBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetalheBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detalhe, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetalheBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_ligar;
      Button btLigar = ViewBindings.findChildViewById(rootView, id);
      if (btLigar == null) {
        break missingId;
      }

      id = R.id.bt_voltar;
      Button btVoltar = ViewBindings.findChildViewById(rootView, id);
      if (btVoltar == null) {
        break missingId;
      }

      id = R.id.et_det_apelido;
      TextView etDetApelido = ViewBindings.findChildViewById(rootView, id);
      if (etDetApelido == null) {
        break missingId;
      }

      id = R.id.et_det_email;
      TextView etDetEmail = ViewBindings.findChildViewById(rootView, id);
      if (etDetEmail == null) {
        break missingId;
      }

      id = R.id.et_det_latitude;
      TextView etDetLatitude = ViewBindings.findChildViewById(rootView, id);
      if (etDetLatitude == null) {
        break missingId;
      }

      id = R.id.et_det_longitude;
      TextView etDetLongitude = ViewBindings.findChildViewById(rootView, id);
      if (etDetLongitude == null) {
        break missingId;
      }

      id = R.id.et_det_morada;
      TextView etDetMorada = ViewBindings.findChildViewById(rootView, id);
      if (etDetMorada == null) {
        break missingId;
      }

      id = R.id.et_det_nasc;
      TextView etDetNasc = ViewBindings.findChildViewById(rootView, id);
      if (etDetNasc == null) {
        break missingId;
      }

      id = R.id.et_det_nome;
      TextView etDetNome = ViewBindings.findChildViewById(rootView, id);
      if (etDetNome == null) {
        break missingId;
      }

      id = R.id.et_det_telemovel;
      TextView etDetTelemovel = ViewBindings.findChildViewById(rootView, id);
      if (etDetTelemovel == null) {
        break missingId;
      }

      id = R.id.iv_det_foto;
      ImageView ivDetFoto = ViewBindings.findChildViewById(rootView, id);
      if (ivDetFoto == null) {
        break missingId;
      }

      id = R.id.tv_anos;
      TextView tvAnos = ViewBindings.findChildViewById(rootView, id);
      if (tvAnos == null) {
        break missingId;
      }

      id = R.id.tv_det_idade;
      TextView tvDetIdade = ViewBindings.findChildViewById(rootView, id);
      if (tvDetIdade == null) {
        break missingId;
      }

      return new ActivityDetalheBinding((LinearLayout) rootView, btLigar, btVoltar, etDetApelido,
          etDetEmail, etDetLatitude, etDetLongitude, etDetMorada, etDetNasc, etDetNome,
          etDetTelemovel, ivDetFoto, tvAnos, tvDetIdade);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
