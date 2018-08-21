package com.example.interviewmanager.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.interviewmanager.R;

public class UpdateDialog {

    private Context mContext;

    public UpdateDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void show(String message){
        new AlertDialog.Builder(mContext)
                .setTitle(R.string.update_dialog_title)
                .setMessage(message)
                .setPositiveButton(R.string.update_dialog_download, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton(R.string.update_dialog_undownload, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }
}
