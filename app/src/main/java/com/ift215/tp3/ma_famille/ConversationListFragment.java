package com.ift215.tp3.ma_famille;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.view.View.OnClickListener;

/**
 * Fragment containing Feed view
 */
public class ConversationListFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ConversationListFragment newInstance(int sectionNumber) {
        ConversationListFragment fragment = new ConversationListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conversations_list, container, false);

        FrameLayout message_container1 = (FrameLayout) rootView.findViewById(R.id.message_container1);

        message_container1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OnConversationClick();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public ConversationListFragment() {
    }

    /**
     * Chargement de la conversation au click
     */
    public void OnConversationClick() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, ConversationFragment.newInstance(0))
                .commit();
    }

}
