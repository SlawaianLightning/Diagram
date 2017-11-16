package com.example.viacheslaw.diagram;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.GridStyle;
import com.mindfusion.diagramming.Shape;
import com.mindfusion.diagramming.ShapeNode;
import com.mindfusion.drawing.Color;
import com.mindfusion.drawing.GradientBrush;
import com.mindfusion.drawing.SolidBrush;
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
    @BindView(R.id.bFlexibel) Button bFlexibel;
    @BindView(R.id.bBulktank) Button bBulktank;
    @BindView(R.id.bDriewegkraan) Button bDriewegkraan;
    @BindView(R.id.bCustomShade) Button bCustomShade;
    @BindView(R.id.bDoorvoer) Button bDoorvoer;
    @BindView(R.id.bDagtank) Button bDagtank;
    @BindView(R.id.bHandafsluiter) Button bHandafsluiter;
    @BindView(R.id.bNisa) Button bNisa;
    @BindView(R.id.bAddText) Button bAddText;
    @BindView(R.id.bDeleteActivItem) Button bDeleteActivItem;
    @BindView(R.id.bRotationBy90) Button bRotationBy90;
    @BindView(R.id.etText) EditText etText;
    private Diagram diagram;
    String data;
    SharedPreferences sPref;
    public static final String DIAGRAMDATA="DIAGRAMDATA";
    public static final String SAVEDIAGRAM="SAVEDIAGRAM";
    float defaultX=50;
    float defaultY=50;
    float defaultW=20;
    float defaultH=20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sPref = getSharedPreferences(DIAGRAMDATA,MODE_PRIVATE);
        diagram=new Diagram();
        diagram.setBackBrush(new GradientBrush());
        diag_view.setBehavior(DrawLinks);
        diag_view.setDiagram(diagram);
        load();
        bMagneetafsluiter.setOnClickListener(l->{
            createShape(ShapeBuild.getMagneetafsluiter());
        });
        bTrimpomp.setOnClickListener(l->{
            createShapeWithSize(ShapeBuild.getTrimpomp(),15,15);
        });
        bManometer.setOnClickListener(l->{
            createShape(ShapeBuild.getManometer());
        });
        bAntiHevelklep.setOnClickListener(l->{
            createShape(ShapeBuild.getAntiHevelklep());
        });
        bFilter.setOnClickListener(l->{
            createShape(ShapeBuild.getFilter());
        });
        bHandafsluiter.setOnClickListener(l->{
            createShape(ShapeBuild.getHandafsluiter());
        });
        bFlexibel.setOnClickListener(l->{
            createShape(ShapeBuild.getFlexibel());
        });
        bCustomShade.setOnClickListener(l->{
            createShapeWithSize(ShapeBuild.getCustomShape(),25,25);
        });
        bClear.setOnClickListener(l->{
            diagram.clearAll();
        });
        bDeleteActivItem.setOnClickListener(l->{
            if(diagram.getActiveItem()!=null){
            diagram.getItems().remove((ShapeNode)diagram.getActiveItem());}
        });
        bRotation.setOnClickListener(l->{
            if(((ShapeNode)diagram.getActiveItem())!=null)
                ((ShapeNode)diagram.getActiveItem()).setRotationAngle(((ShapeNode)diagram.getActiveItem()).getRotationAngle()+1);
        });
        bRotationBy90.setOnClickListener(l->{
            if(((ShapeNode)diagram.getActiveItem())!=null)
                ((ShapeNode)diagram.getActiveItem()).setRotationAngle(((ShapeNode)diagram.getActiveItem()).getRotationAngle()+90);
        });
        bBulktank.setOnClickListener(l->{
            createShape(ShapeBuild.getBulktank());
        });
        bDriewegkraan.setOnClickListener(l->{
            createShape(ShapeBuild.getDriewegkraan());
        });
        bDoorvoer.setOnClickListener(l->{
            createShape(ShapeBuild.getDoorvoer());
        });
        bDagtank.setOnClickListener(l->{
            createShape(ShapeBuild.getDagtank());
        });
        bNisa.setOnClickListener(l->{
            createShape(ShapeBuild.getDagtank(),"Nisa");
        });
        bSave.setOnClickListener(l->{
            save();
        });
        bLeding.setOnClickListener(l->{
            createShape(ShapeBuild.getLeding());
        });
        bVerticalLeding.setOnClickListener(l->{
            createShape(ShapeBuild.getVirticalLeding());
        });
        bLoad.setOnClickListener(l->{
            load();
        });
        bAddText.setOnClickListener(l->{
            String text=etText.getText().toString();
            float w=text.length()/3;
            float h=text.length()-w;
            String[] words=text.split(" ");
            int max=0;
            for(String str:words){
                if(str.length()>max){
                    max=str.length();
                }
            }
            if(max>w){
                w=max+10;
            }
            createShapeWithSize(ShapeBuild.getShapeText(),text,w*2,h);
        });
        diagram.setAlignToGrid(false);
    }

    public void createShape(Shape shape){
        createShape(shape,defaultX,defaultY,defaultW,defaultH);
    }

    public void createShape(Shape shape,String text){
        createShape(shape,text,defaultX,defaultY,defaultW,defaultH);
    }

    public void createShape(Shape shape,float x,float y){
        createShape(shape,x,y,defaultH,defaultW);
    }

    public void createShape(Shape shape,String text,float x,float y){
        createShape(shape,text,x,y,defaultH,defaultW);
    }

    public void createShapeWithSize(Shape shape,float w,float h){
        createShape(shape,defaultX,defaultY,w,h);
    }

    public void createShapeWithSize(Shape shape,String text,float w,float h){
        createShape(shape,text,defaultX,defaultY,w,h);
    }

    public void createShape(Shape shape,float x,float y,float w,float h){
        createShape(shape,null,x,y,w,h);
    }

    public void createShape(Shape shape,String text,float x,float y,float w,float h){
        ShapeNode node=new ShapeNode();
        node.setShape(shape);
        node.setShadowBrush(new GradientBrush());
        node.setBrush(new GradientBrush());
        node.setBounds(x,y,w,h);
        diagram.add(node);
        if(text!=null){
            node.setText(text);
            save();
            diagram.clearAll();
            load();
        }
    }

    public void loadShape(){
        createShape(ShapeBuild.getAntiHevelklep());
        createShape(ShapeBuild.getMagneetafsluiter());
        createShape(ShapeBuild.getTrimpomp());
        createShape(ShapeBuild.getManometer());
        createShape(ShapeBuild.getBulktank());
        createShape(ShapeBuild.getLeding());
        createShape(ShapeBuild.getVirticalLeding());
        createShape(ShapeBuild.getDoorvoer());
        createShape(ShapeBuild.getDriewegkraan());
        createShape(ShapeBuild.getHandafsluiter());
        createShape(ShapeBuild.getFlexibel());
        createShape(ShapeBuild.getDagtank());
        ShapeNode node=new ShapeNode();
        node.setShape(ShapeBuild.getShapeText());
        diagram.add(node);
        diagram.clearAll();
    }

    public void save(){
        data=diag_view.saveToString();
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVEDIAGRAM, data);
        ed.commit();
    }

    public void load(){
        loadShape();
        data=sPref.getString(SAVEDIAGRAM,"");
        if(!data.equals(""))
        diag_view.loadFromString(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }

}
