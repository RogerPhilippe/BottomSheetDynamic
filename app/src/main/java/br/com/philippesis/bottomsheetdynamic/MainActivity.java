package br.com.philippesis.bottomsheetdynamic;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;

    private LinearLayout mLayoutBottomSheetHeader;

    private LinearLayout mLayoutBottomSheetBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayoutBottomSheetHeader = findViewById(R.id.id_bottom_sheet_head);

        mLayoutBottomSheetBody = findViewById(R.id.id_recycleview_bottom_sheet);
        mLayoutBottomSheetBody.setVisibility(View.GONE);

        View bottomSheet = findViewById(R.id.id_nested_scroll_view);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        // Collapsed
                        mLayoutBottomSheetHeader.setVisibility(View.VISIBLE);
                        mLayoutBottomSheetBody.setVisibility(View.GONE);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        // Dragging...
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        // Expanded
                        mLayoutBottomSheetHeader.setVisibility(View.GONE);
                        mLayoutBottomSheetBody.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        // Hidden
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        // Settling...
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // Sliding..."
            }
        });

    }
}
