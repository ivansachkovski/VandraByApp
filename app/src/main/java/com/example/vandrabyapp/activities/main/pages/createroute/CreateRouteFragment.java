package com.example.vandrabyapp.activities.main.pages.createroute;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.MainActivity;
import com.example.vandrabyapp.activities.main.pages.createroute.subpages.CreateRouteSubpage1Fragment;
import com.example.vandrabyapp.activities.main.pages.createroute.subpages.CreateRouteSubpage2Fragment;
import com.example.vandrabyapp.activities.main.pages.createroute.subpages.CreateRouteSubpage3Fragment;

public class CreateRouteFragment extends Fragment implements CreateRouteFragmentContract.View {

    private static final String CREATE_ROUTE_SUBPAGE_1_FRAGMENT_TAG = "CreateRouteSubpage1Fragment";
    private static final String CREATE_ROUTE_SUBPAGE_2_FRAGMENT_TAG = "CreateRouteSubpage2Fragment";
    private static final String CREATE_ROUTE_SUBPAGE_3_FRAGMENT_TAG = "CreateRouteSubpage3Fragment";

    CreateRouteFragmentPresenter presenter;

    private CreateRouteFragment() {
        presenter = new CreateRouteFragmentPresenter(this);
    }

    public static CreateRouteFragment newInstance() {
        return new CreateRouteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_route, null);

        // Open start create route page
        openSubpage1();

        return view;
    }

    private void loadFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void openSubpage1() {
        loadFragment(CreateRouteSubpage1Fragment.newInstance(presenter), CREATE_ROUTE_SUBPAGE_1_FRAGMENT_TAG);
    }

    @Override
    public void openSubpage2() {
        loadFragment(CreateRouteSubpage2Fragment.newInstance(presenter), CREATE_ROUTE_SUBPAGE_2_FRAGMENT_TAG);
    }

    @Override
    public void openSubpage3() {
        loadFragment(CreateRouteSubpage3Fragment.newInstance(presenter), CREATE_ROUTE_SUBPAGE_3_FRAGMENT_TAG);
    }

    @Override
    public void openSaveRouteDialog() {
        // Create custom dialog
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.activity_main_create_route_save_route_dialog);
        //dialog.getWindow().setBackgroundDrawable();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        // Attach listener to 'Save' button
        Button buttonSaveRoute = dialog.findViewById(R.id.button_save);
        buttonSaveRoute.setOnClickListener(v -> {
            // Save route
            TextView editRouteName = dialog.findViewById(R.id.edit_route_name);
            presenter.saveRoute(editRouteName.getText().toString());

            // Close dialog
            dialog.dismiss();

            // Open Profile page
            MainActivity mainActivity = (MainActivity) getActivity();
            assert mainActivity != null;
            mainActivity.openProfilePage();
        });

        // Show custom dialog
        dialog.show();
    }
}