package com.sitdikovrm.followme.fragment;

import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class IODialogFragment extends DialogFragment {

    protected static final String CREDENTIALS = "credentials";

    protected ProgressDialog dialog;

    public void sendException(final Exception ex) {
        dialog.dismiss();
        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();
    }
}
