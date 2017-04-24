package eu.dominguezlucas.relismoi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by lucas on 24-Apr-17.
 */

public class Ocr extends AppCompatActivity implements IOCRCallBack {


    private String mCurrentPhotoPath;
    private String mAPiKey = "CLEAPI";
    private boolean isOverlayRequired;
    private String mImagePath;
    private String mLanguage;
    private TextView mTxtResult;
    private IOCRCallBack mIOCRCallBack;

    @Override
    public void getOCRCallBackResult(String response) {
        Log.d("transcription", response);
    }
    
    public Ocr() {
        mIOCRCallBack = this;
        mImagePath = MainActivity.mCurrentPhotoPath; // Image url to apply OCR API
        mLanguage = "fre"; //Language
        isOverlayRequired = true; //TODO Montrer l'image avec la correction imprime par dessus
        //Log.d("getExternalFileDDir", String.valueOf(getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
        OCRAsyncTask oCRAsyncTask = new OCRAsyncTask(Ocr.this, mAPiKey, isOverlayRequired, mImagePath, mLanguage,mIOCRCallBack);
        oCRAsyncTask.execute();
    }
}
