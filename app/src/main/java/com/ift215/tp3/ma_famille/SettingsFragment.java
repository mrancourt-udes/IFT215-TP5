package com.ift215.tp3.ma_famille;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment containing Feed view
 */
public class SettingsFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SettingsFragment newInstance(int sectionNumber) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        TextView fullName = (TextView) rootView.findViewById(R.id.full_name);
        TextView email = (TextView) rootView.findViewById(R.id.email);

        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                getString(R.string.user_profile_file_key), Context.MODE_PRIVATE
        );

        String fullNameStr = sharedPref.getString(getString(R.string.first_name), "") + " " +
                sharedPref.getString(getString(R.string.last_name), "");

        String emailStr = sharedPref.getString(getString(R.string.email), "");

        fullName.setText(fullNameStr);
        email.setText(emailStr);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public SettingsFragment() {
    }
}
