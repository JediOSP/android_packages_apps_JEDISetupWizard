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

package com.jedi.setupwizard.setup;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.jedi.setupwizard.R;
import com.jedi.setupwizard.ui.SetupPageFragment;
import com.jedi.setupwizard.ui.SetupWizardActivity;

public class GoogleAccountPage extends Page {

    private static final String TAG = GoogleAccountPage.class.getSimpleName();

    public GoogleAccountPage(Context context, SetupDataCallbacks callbacks, int titleResourceId) {
        super(context, callbacks, titleResourceId);
    }

    @Override
    public Fragment createFragment() {
        Bundle args = new Bundle();
        args.putString(Page.KEY_PAGE_ARGUMENT, getKey());

        GoogleAccountFragment fragment = new GoogleAccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getNextButtonResId() {
        return R.string.skip;
    }

    public static class GoogleAccountFragment extends SetupPageFragment {

        @Override
        protected void setUpPage() {
            TextView summaryView = (TextView) mRootView.findViewById(android.R.id.summary);
            summaryView.setText(R.string.google_account_summary);
            mRootView.findViewById(R.id.google_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((SetupWizardActivity) getActivity()).launchGoogleAccountSetup();
                }
            });
        }

        @Override
        protected int getLayoutResource() {
            return R.layout.setup_google_account_page;
        }

        @Override
        protected int getTitleResource() {
            return R.string.setup_google_account;
        }
    }
}
