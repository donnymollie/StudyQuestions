package com.example.mollie.bookofmormonstudyquestions.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mollie.bookofmormonstudyquestions.R;
import com.example.mollie.bookofmormonstudyquestions.database.DatabaseHelper;
import com.example.mollie.bookofmormonstudyquestions.model.QuestionAnswer;

import java.util.List;

public class FirstNephi1Adapter extends BaseAdapter {
    private Context context;
    private List<QuestionAnswer> mQuestionAnswerList;
    private IsaveQuestionAnswer saveQuestionAnswerListener;
    DatabaseHelper myDbHelper;

    public FirstNephi1Adapter(Context context, List<QuestionAnswer> mQuestionAnswerList,
                              IsaveQuestionAnswer saveQuestionAnswerListener) {
        this.context = context;
        this.mQuestionAnswerList = mQuestionAnswerList;
        this.saveQuestionAnswerListener = saveQuestionAnswerListener;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return mQuestionAnswerList.size();
    }

    @Override
    public Object getItem(int position) {
        return mQuestionAnswerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mQuestionAnswerList.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null, true);
            holder.questions = (TextView) convertView.findViewById(R.id.firstNephi1_questions);
            holder.editText = (EditText) convertView.findViewById(R.id.firstNephi1_answers);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.questions.setText(mQuestionAnswerList.get(position).getQuestion());
        holder.editText.setText(mQuestionAnswerList.get(position).getAnswer());
        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                saveQuestionAnswerListener.saveData(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return convertView;
    }

    private class ViewHolder {

        protected EditText editText;
        protected TextView questions;

    }

}