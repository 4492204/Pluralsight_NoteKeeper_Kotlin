package com.example.nootkeeper_kotlin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import org.w3c.dom.Text;

import static androidx.core.content.ContextCompat.getSystemService;

public class SendDialogFragment extends DialogFragment {

    public static final String TEST_FOR_THE_SEND_DIALOG = "Test for the send dialog";
    public static final String SEND = "SEND";
    public static final String CANCEL = "CANCEL";
    private static final String CHANNEL_ID = "CHANNEL_TEST";
    public static final int notificationId = 0;
    private TextInputLayout mInput;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View inflater = requireActivity().getLayoutInflater().inflate(R.layout.send_dialog, null);

        builder.setView(inflater)
                .setPositiveButton(SEND, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mInput = inflater.findViewById(R.id.textSend);
                        Snackbar.make(getActivity().findViewById(R.id.listItems),
                                "Send dialog success " + mInput.getEditText().getText().toString(),
                                Snackbar.LENGTH_LONG).show();
                        sendNotification();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("SEND DIALOG SUCCESS")
                .setContentText("The input: " + mInput.getEditText().getText().toString())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
        notificationManager.notify(notificationId, builder.build());
    }
}
