/*
 * Copyright (C) 2014 Jedi Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jedi.setupwizard.ui;

import android.view.View;
import com.jedi.setupwizard.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewDialogFragment extends DialogFragment {

    public static String TAG = WebViewDialogFragment.class.getSimpleName();

    private View mRootView;
    private WebView mWebView;
    private String mUri;
    private Dialog mDialog;

    public static WebViewDialogFragment newInstance() {
        return new WebViewDialogFragment();
    }

    public WebViewDialogFragment() {

    }

    public WebViewDialogFragment setUri(String uri) {
        mUri = uri;
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mRootView = getActivity().getLayoutInflater().inflate(R.layout.terms_webview, null, false);
        mWebView = (WebView)mRootView.findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.loadUrl(mUri);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mDialog == null) {
            mDialog =new AlertDialog.Builder(getActivity())
                    .setView(mRootView)
                    .setCancelable(false)
                    .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create();
        }
        return mDialog;
    }
}

