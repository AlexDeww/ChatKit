package com.stfalcon.chatkit.sample.features.demo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import com.stfalcon.chatkit.sample.common.data.model.Dialog;
import com.stfalcon.chatkit.sample.utils.AppUtils;

/*
 * Created by troy379 on 05.04.17.
 */
public abstract class DemoDialogsActivity extends AppCompatActivity
        implements DialogsListAdapter.OnDialogClickListener<Dialog>,
        DialogsListAdapter.OnDialogLongClickListener<Dialog> {

    protected ImageLoader imageLoader;
    protected DialogsListAdapter<Dialog> dialogsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageLoader = new ImageLoader() {
            @Override
            public void loadAvatar(@NonNull ImageView imageView, @Nullable String url, @Nullable Object payload) {
                Picasso.get().load(url).into(imageView);
            }

            @Override
            public void loadMessageImage(@NonNull ImageView imageView, @Nullable String url, @Nullable Object payload) {
                Picasso.get().load(url).into(imageView);
            }
        };
    }

    @Override
    public void onDialogLongClick(Dialog dialog) {
        AppUtils.showToast(
                this,
                dialog.getDialogName().toString(),
                false);
    }
}
