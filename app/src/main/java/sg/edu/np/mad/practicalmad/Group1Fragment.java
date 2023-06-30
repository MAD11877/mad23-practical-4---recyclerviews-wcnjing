package sg.edu.np.mad.practicalmad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Group1Fragment extends Fragment {

    public Group1Fragment() {
        // Required empty public constructor
    }

    public static Group1Fragment newInstance() {
        return new Group1Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group1, container, false);
    }
}
