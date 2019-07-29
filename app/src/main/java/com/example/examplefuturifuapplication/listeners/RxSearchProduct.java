package com.example.examplefuturifuapplication.listeners;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;

import io.reactivex.subjects.BehaviorSubject;

public class RxSearchProduct {
    public static BehaviorSubject<String> fromSearchView(@NonNull final EditText searchView) {
        final BehaviorSubject<String> subject = BehaviorSubject.create();
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                subject.onNext(editable.toString());
            }
        });
        return subject;
    }
}
