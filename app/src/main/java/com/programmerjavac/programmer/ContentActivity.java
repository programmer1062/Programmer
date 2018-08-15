package com.programmerjavac.programmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ContentActivity extends AppCompatActivity {

    CardView videoscardview,coursecardview,helpcardview,blogscardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        videoscardview=findViewById(R.id.videocard_view);
        coursecardview=findViewById(R.id.coursecard_view);
        helpcardview=findViewById(R.id.helpcard_view);
        blogscardview=findViewById(R.id.blogscard_view);

    }

    public void Videos(View view)
    {
        Intent intent=new Intent(ContentActivity.this,VideoActivity.class);
        startActivity(intent);
    }

    public void Course(View view)
    {
        Intent intent=new Intent(ContentActivity.this,CourseActivity.class);
        startActivity(intent);
    }

    public void Help(View view)
    {
        Intent intent=new Intent(ContentActivity.this,HelpActivity.class);
        startActivity(intent);
    }

    public void Blogs(View view)
    {
        Intent intent=new Intent(ContentActivity.this,BlogsActivity.class);
        startActivity(intent);
    }
}
