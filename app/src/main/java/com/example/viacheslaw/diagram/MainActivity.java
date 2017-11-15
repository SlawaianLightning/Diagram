package com.example.viacheslaw.diagram;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.GridStyle;
import com.mindfusion.diagramming.Shape;
import com.mindfusion.diagramming.ShapeNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mindfusion.diagramming.Behavior.DrawLinks;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.diag_view) DiagramView diag_view;
    @BindView(R.id.bMagneetafsluiter) Button bMagneetafsluiter;
    @BindView(R.id.bTrimpomp) Button bTrimpomp;
    @BindView(R.id.bManometer) Button bManometer;
    @BindView(R.id.bAntiHevelklep) Button bAntiHevelklep;
    @BindView(R.id.bLeding) Button bLeding;
    @BindView(R.id.bVerticalLeding) Button bVerticalLeding;
    @BindView(R.id.bClear) Button bClear;
    @BindView(R.id.bRotation) Button bRotation;
    @BindView(R.id.bSave) Button bSave;
    @BindView(R.id.bLoad) Button bLoad;
    @BindView(R.id.bFilter) Button bFilter;
    @BindView(R.id.bBulktank) Button bBulktank;
    @BindView(R.id.bCustomShade) Button bCustomShade;
    @BindView(R.id.bDoorvoer) Button bDoorvoer;
    String data;
    SharedPreferences sPref;
    public static final String daiagramData="daiagramData";
    int x=50;
    int y=50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sPref = getSharedPreferences(daiagramData,MODE_PRIVATE);
        diag_view.getDiagram().setGridStyle(GridStyle.Lines);
        diag_view.getDiagram().setShowGrid(true);
        diag_view.setBehavior(DrawLinks);
        createBackground();
        bMagneetafsluiter.setOnClickListener(l->{
            createShape(ShapeBuild.getMagneetafsluiter(),20,20);
        });
        bTrimpomp.setOnClickListener(l->{
            createShape(ShapeBuild.getTrimpomp(),15,15);
        });
        bManometer.setOnClickListener(l->{
            createShape(ShapeBuild.getManometer(),20,20);
        });
        bAntiHevelklep.setOnClickListener(l->{
            createShape(ShapeBuild.getbAntiHevelklep(),20,20);
        });
        bFilter.setOnClickListener(l->{
            createShape(ShapeBuild.getFilter(),20,20);
        });
        bCustomShade.setOnClickListener(l->{
            createShape(ShapeBuild.getCustomShape(),25,25);
        });
        bClear.setOnClickListener(l->{
            diag_view.getDiagram().clearAll();
            createBackground();
        });
        bRotation.setOnClickListener(l->{
            if(((ShapeNode)diag_view.getDiagram().getActiveItem())!=null)
                ((ShapeNode)diag_view.getDiagram().getActiveItem()).setRotationAngle(((ShapeNode)diag_view.getDiagram().getActiveItem()).getRotationAngle()+1);
        });
        bBulktank.setOnClickListener(l->{
            createShape(ShapeBuild.getBulktank(),20,20);
        });
        bDoorvoer.setOnClickListener(l->{
            createShape(ShapeBuild.getDoorvoer(),20,20);
        });
        bSave.setOnClickListener(l->{
            data=diag_view.saveToString();
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString("data", data);
            ed.commit();
        });
        bLeding.setOnClickListener(l->{
            createShape(ShapeBuild.getLeding(),20,20);
        });
        bVerticalLeding.setOnClickListener(l->{
            createShape(ShapeBuild.getVirticalLeding(),20,20);
        });
        bLoad.setOnClickListener(l->{
            createShape(ShapeBuild.getbAntiHevelklep(),20,20);
            createShape(ShapeBuild.getMagneetafsluiter(),20,20);
            createShape(ShapeBuild.getTrimpomp(),20,20);
            createShape(ShapeBuild.getManometer(),20,20);
            createShape(ShapeBuild.getBulktank(),20,20);
            createShape(ShapeBuild.getLeding(),20,20);
            createShape(ShapeBuild.getLeding(),20,20);
            createShape(ShapeBuild.getLeding(),20,20);
            createShape(ShapeBuild.getVirticalLeding(),20,20);
            createShape(ShapeBuild.getDoorvoer(),20,20);
            diag_view.getDiagram().clearAll();
            createBackground();
            data=sPref.getString("data","");
            diag_view.loadFromString(data);
        });
        diag_view.getDiagram().setAlignToGrid(false);

    }

    public void createShape(Shape shape,float w,float h){
        ShapeNode node=new ShapeNode();
        node.setShape(shape);
        node.setBounds(x,y,w,h);
        diag_view.getDiagram().add(node);
    }

    public void createBackground(){
        ShapeNode node=new ShapeNode();
        node.setShape(ShapeBuild.getBackgroung());
        diag_view.getDiagram().add(node);
    }


}
