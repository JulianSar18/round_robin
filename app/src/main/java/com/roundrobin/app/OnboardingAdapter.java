package com.roundrobin.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

    private List<Onboardingitem> onboardingitems;

    public OnboardingAdapter(List<Onboardingitem> onboardingitems) {
        this.onboardingitems = onboardingitems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingitems.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingitems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {

        private TextView texTitle;
        private TextView textDescription;
        private ImageView imageOnboarding;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            texTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.texDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboardiong);
        }

        void setOnboardingData(Onboardingitem onboardingitem){
            texTitle.setText(onboardingitem.getTitle());
            textDescription.setText(onboardingitem.getDescription());
            imageOnboarding.setImageResource(onboardingitem.getImage());
        }
    }
}