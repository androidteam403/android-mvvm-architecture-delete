package com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.thresholdsoft.abn.R;
import com.thresholdsoft.abn.databinding.AdapterNewsFeedBinding;
import com.thresholdsoft.abn.mvvm.ui.main.ui.newsfeed.NewsFeedNavigator;

import java.util.List;


public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {
    private Context context;
    private List<NewsFeedModel> newsFeedModelList;
    private NewsFeedNavigator newsFeedNavigator;

    public NewsFeedAdapter(Context context, List<NewsFeedModel> newsFeedModelList, NewsFeedNavigator newsFeedNavigator) {
        this.context = context;
        this.newsFeedModelList = newsFeedModelList;
        this.newsFeedNavigator = newsFeedNavigator;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterNewsFeedBinding newsFeedBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_news_feed, parent, false);
        return new NewsFeedAdapter.ViewHolder(newsFeedBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsFeedModel newsFeedModel = newsFeedModelList.get(position);
        holder.newsFeedBinding.setModel(newsFeedModel);
        if (position == 0) {
            holder.newsFeedBinding.textNews.setVisibility(View.VISIBLE);
        } else {
            holder.newsFeedBinding.textNews.setVisibility(View.GONE);
        }
        if (newsFeedModel.isExpanded()) {
            holder.newsFeedBinding.mainHeader.setVisibility(View.GONE);
            holder.newsFeedBinding.newsDetatial.setVisibility(View.VISIBLE);
        } else {
            holder.newsFeedBinding.mainHeader.setVisibility(View.VISIBLE);
            holder.newsFeedBinding.newsDetatial.setVisibility(View.GONE);
        }
        spanableString(holder.newsFeedBinding);
        holder.itemView.setOnClickListener(view -> {
            if (newsFeedNavigator != null && !newsFeedModel.isExpanded) {
                newsFeedNavigator.onItemClick(position);
            }
        });
        holder.newsFeedBinding.closeExpandedView.setOnClickListener(view -> {
            if (newsFeedNavigator != null) {
                newsFeedNavigator.onClickCloseExpandedView();
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsFeedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterNewsFeedBinding newsFeedBinding;

        public ViewHolder(@NonNull AdapterNewsFeedBinding newsFeedBinding) {
            super(newsFeedBinding.getRoot());
            this.newsFeedBinding = newsFeedBinding;
        }
    }

    public static class NewsFeedModel {
        public String heading;
        public String time;
        public boolean isExpanded;

        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public boolean isExpanded() {
            return isExpanded;
        }

        public void setExpanded(boolean expanded) {
            isExpanded = expanded;
        }
    }

    private void spanableString(AdapterNewsFeedBinding adapterNewsFeedBinding) {
        final SpannableString text = new SpannableString("భ‌ద్రాద్రి కొత్త‌గూడెం: భ‌ద్రాద్రి కొత్త‌గూడెం జిల్లా మ‌ణుగూరు ప‌ట్ట‌ణంలో క‌రోనా పాజిటివ్ కేసులు రోజురోజుకూ పెరుగుతున్నాయి. దీంతో స్థానికుల్లో తీవ్ర భ‌యాందోళ‌న వ్య‌క్త‌మ‌వుతోంది. అన‌ధికారిక లెక్క‌ల ప్ర‌కారం... దాదాపు 500 మందికి క‌రోనా పాజిటివ్ ఉన్న‌ట్లు తెలిసింది. దీంతో స్థానికుల్లో తీవ్ర భ‌యాందోళ‌న వ్య‌క్త‌మ‌వుతోంది. ప్ర‌భుత్వం నిత్యావస‌రాల కోసం కొన్ని స‌డ‌లింపులు ఇవ్వ‌డంతో దీన్ని అదునుగా చేసుకున్న కొంద‌రు రోడ్లపై బాహ‌టంగా తిరుగుతున్నారు. అంతేగాక ఎక్క‌డ‌ప‌డితే అక్క‌డ గుంపులు గుంపులుగా తిరుగుతున్నారు. దీంతో కరోనా వ్యాప్తి పెరిగిపోతోంది. కాగా ప్ర‌జ‌లెవ‌రూ రోడ్ల‌పైకి రావ‌ద్దంటూ మైకు ద్వారా ప్ర‌చారం చేస్తున్నా ప్ర‌జ‌లు పెద్ద‌గా ప‌ట్టించుకున్న దాఖ‌లాలు లేవు. అలాగే ప‌ట్ట‌ణంలో క‌రోనాతో  చ‌నిపోతున్న వారి సంఖ్య రోజురోజుకు పెరుగుతోంది‌. ఈ విష‌యాల‌ను కుటుంబ స‌భ్యులు బ‌య‌ట‌కు వెల్ల‌డించ‌న‌ప్ప‌టికీ ఇక్క‌డి ప్ర‌జ‌లు మాత్రం ఎటువంటి భ‌యం లేకుండానే రోడ్ల‌పై సంచ‌రిస్తున్నారు");
//        text.setSpan(new RelativeSizeSpan(1.5f), text.length() - "భ‌ద్రాద్రి కొత్త‌గూడెంః".length(), text.length(),
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setSpan(new ForegroundColorSpan(Color.BLACK), 0, text.toString().indexOf(":"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, text.toString().indexOf(":"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        adapterNewsFeedBinding.newsDetatial.setText(text);
    }
}
