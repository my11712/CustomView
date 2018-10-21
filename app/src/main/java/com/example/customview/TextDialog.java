package com.example.customview;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by 奇志 on 2018/10/20.
 */

public class TextDialog extends Dialog {
    public TextDialog(@NonNull Context context) {
        super(context);
    }

    public TextDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.dialog_text);
    }


}
